package businesslogic.hotelbl;


import businesslogic.orderbl.OrderImpl;
import businesslogic.roombl.Room;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import businesslogicservice.roomblservice.RoomBLService;
import dataService.hoteldataservice.HotelDataService;
import po.HotelInfoPO;
import util.RMIcontroller;
import util.ResultMessage;
import util.SortType;
import util.SortWay;
import vo.AvailableRoomVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.SearchInfoVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Qin Liu on 2016/11/6.
 */
public class Hotel implements HotelBLService {

    private HotelDataService hotelDao;

    private RoomBLService roomBLService;

    private OrderBLservice orderBLservice;

    public Hotel() {
        //hotelDao = HotelDataServiceImpl.getInstance();
        //使用rmi
        try {
            hotelDao = (HotelDataService) Naming.lookup(
                    "rmi://" + RMIcontroller.getHostIP() + ":" + RMIcontroller.getPort() + "/HotelDataService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        roomBLService = new Room();
    }

    @Override
    public HotelInfoVO getHotelInfo(String hotelName) {
        HotelInfoPO hipo = null;
        try {
            hipo = hotelDao.findHotelInfo(hotelName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //遍历该酒店下的所有客房，得到lowestPrice
        ArrayList<AvailableRoomVO> roomVOList = roomBLService.getAvailableRoomList(hotelName, null, null);
        double lowestPrice = 9999;  //如果酒店客房为空，则最低价格即为9999
        Iterator<AvailableRoomVO> roomVOIterator = roomVOList.iterator();
        while(roomVOIterator.hasNext()) {
            AvailableRoomVO arvo = roomVOIterator.next();
            if(lowestPrice > arvo.getPrice()) {
                lowestPrice = arvo.getPrice();
            }
        }

        // 如果hipo不为null，即酒店存在，则根据hipo构造hivo，并返回；
        // 如果hipo为null，即酒店不存在，则返回空的hivo
        HotelInfoVO hivo;
        if(hipo != null) {
            hivo = new HotelInfoVO(hipo.getHotelName(), hipo.getCity(), hipo.getBusinessCircle(), hipo.getAddress(), hipo.getIntroduction(),
                    hipo.getFacility(), hipo.getStarLevel(), hipo.getCooperCompany(), hipo.getScore(), false, lowestPrice);
            return hivo;
        }else {
            hivo = null;
            return hivo;
        }
    }

    @Override
    public ResultMessage modifyHotelInfo(HotelInfoVO hivo) {
        HotelInfoPO hipo = new HotelInfoPO(hivo.getHotelName(), hivo.getCity(), hivo.getBusinessCircle(), hivo.getAddress(), hivo.getIntroduction(),
                hivo.getFacility(),hivo.getStarLevel(),hivo.getCooperCompany(),hivo.getScore());

        boolean result = false;
        try {
            result = hotelDao.updateHotelInfo(hipo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(result) {
            return ResultMessage.SUCCESS;   //修改酒店基本信息成功
        }else {
            return ResultMessage.FAILED;    //酒店不存在，修改酒店基本信息失败
        }
    }

    @Override
    public ArrayList<HotelInfoVO> getHistoryHotelList(String customerID) {
        //将Set转化为ArrayList
        ArrayList<String> historyHotel = new ArrayList<String>(this.getHistoryHotel(customerID));

        //遍历预订过的酒店名称，作为参数获取预订过的酒店列表
        ArrayList<HotelInfoVO> historyHotelList = new ArrayList<HotelInfoVO>();
        Iterator<String> historyHotelIterator = historyHotel.iterator();
        while(historyHotelIterator.hasNext()) {
            String hotelName = historyHotelIterator.next();
            HotelInfoVO hivo = this.getHotelInfo(hotelName);
            historyHotelList.add(hivo);
        }
        return historyHotelList;
    }

    @Override
    public Set<String> getHistoryHotel(String customerID) {
        Set<String> historyHotelSet = new HashSet<String>();    //创建包含预订过的酒店名称的一个Set，酒店名不能重复

        //遍历用户订单，将其中出现的酒店名添加到historyHotelSet中
        orderBLservice = OrderImpl.getMemberOrderInstance(customerID);
        ArrayList<OrderVO> customerOrderList = new ArrayList<OrderVO>(orderBLservice.getOrderVOList().values());    //用户所有订单
        Iterator<OrderVO> orderVOIterator = customerOrderList.iterator();
        while(orderVOIterator.hasNext()) {
            OrderVO orderVO = orderVOIterator.next();
            historyHotelSet.add(orderVO.getHotel());
        }

        return historyHotelSet;
    }

    @Override
    public ArrayList<HotelInfoVO> getHotelList(SearchInfoVO sivo) {
        ArrayList<HotelInfoPO> hotelInfoPOList = null;
        try {
            hotelInfoPOList = hotelDao.findHotels();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        ArrayList<HotelInfoVO> hotelInfoVOList = new ArrayList<HotelInfoVO>();
        Set<String> historyHotel = this.getHistoryHotel(sivo.getCustomerID());

        //遍历所有酒店PO，将其转化成酒店VO,添加到hotelInfoList中去
        Iterator<HotelInfoPO> hotelInfoPOIterator = hotelInfoPOList.iterator();
        while(hotelInfoPOIterator.hasNext()) {
            HotelInfoPO hipo = hotelInfoPOIterator.next();
            hotelInfoVOList.add(this.getHotelInfo(hipo.getHotelName()));
        }

        ArrayList<HotelInfoVO> finalHotelList = new ArrayList<HotelInfoVO>();   //最终的酒店列表

        //根据搜索条件，遍历所有酒店VO，得到最终的酒店列表
        for(int index = 0; index < hotelInfoVOList.size(); index++) {
            HotelInfoVO hivo = hotelInfoVOList.get(index);

            //如果搜索条件中城市不为空，则进行判断；
            //否则进入循环下一步
            if(sivo.getCity() != null) {
                //如果当前酒店所在城市与搜索条件中的城市不同，则进入循环下一步
                if(!hivo.getCity().equals(sivo.getCity())) {
                    continue;
                }
            }else {
                continue;
            }

            //如果搜索条件中商圈不为空，则进行判断；
            //否则进入循环下一步
            if(sivo.getBusinessCircle() != null) {
                //如果当前酒店所属商圈与搜索条件中的商圈不同，则进入循环下一步；
                if(!hivo.getBusinessCircle().equals(sivo.getBusinessCircle())) {
                    continue;
                }
            }else {
                continue;
            }

            //如果搜索条件中酒店名关键字不为空，则进行判断；
            if(sivo.getHotelName() != null) {
                //如果当前酒店的酒店名不包含搜索条件中的酒店名关键字，则进入循环下一步；
                if(!hivo.getHotelName().contains(sivo.getHotelName())) {
                    continue;
                }
            }

            //如果搜索条件中星级不为空(即-1)，则进行判断；
            if(sivo.getStarLevel() != -1) {
                //如果当前酒店得的星级与搜索条件中的星级不同，则进入循环下一步；
                if(hivo.getStarLevel() != sivo.getStarLevel()) {
                    continue;
                }
            }

            //如果搜索条件中评分下限不为空(即-1)，则进行判断；
            if(sivo.getLowerScore() != -1) {
                //如果当前酒店的评分小于搜索条件中的评分下限，则进入循环下一步；
                if(hivo.getScore() < sivo.getLowerScore()) {
                    continue;
                }
            }

            //如果搜索条件中评分上限不为空(即-1)，则进行判断；
            if(sivo.getUpperScore() != -1) {
                //如果当前酒店的评分大于搜索条件中的评分上限，则进入循环下一步；
                if(hivo.getScore() > sivo.getUpperScore()) {
                    continue;
                }
            }

            //如果房间类型不为空，则进行是否存在可用客房的判断
            if(sivo.getRoomType() != null) {
                ArrayList<AvailableRoomVO> roomVOList= roomBLService.getAvailableRoomList(hivo.getHotelName(), null, null);
                AvailableRoomVO thisRoomTypeVO = null;

                //遍历得到该酒店下该类型客房的VO，进行下一步判断
                Iterator<AvailableRoomVO> roomVOIterator = roomVOList.iterator();
                while(roomVOIterator.hasNext()) {
                    AvailableRoomVO arvo = roomVOIterator.next();
                    if(sivo.getRoomType().equals(arvo.getRoomType())) {
                        thisRoomTypeVO = arvo;
                    }
                }

                //如果该类型客房存在，则进行下一步判断；
                //否则进入循环下一步
                if(thisRoomTypeVO != null) {
                    //如果搜索条件中价格下限不为空(即-1)，则进行判断；
                    if(sivo.getLowerPrice() != -1) {
                        //如果该类型客房的价格小于搜索条件中的价格下限，则进入循环下一步；
                        if(thisRoomTypeVO.getPrice() < sivo.getLowerPrice()) {
                            continue;
                        }
                    }

                    //如果搜索条件中价格上限不为空(即-1)，则进行判断；
                    if(sivo.getUpperPrice() != -1) {
                        //如果该类型客房的价格大于搜索条件中的价格上限，则进入循环下一步；
                        if(thisRoomTypeVO.getPrice() > sivo.getUpperPrice()) {
                            continue;
                        }
                    }

                    //如果有空房期间条件不为空，则进行该时段内可用客房的判断
                    if(sivo.getCheckInDate() != null && sivo.getCheckOutDate() != null && sivo.getRoomNum() != -1) {
                        ArrayList<AvailableRoomVO> newRoomVOList= roomBLService.getAvailableRoomList(hivo.getHotelName(), sivo.getCheckInDate(), sivo.getCheckOutDate());
                        AvailableRoomVO thisNewRoomTypeVO = null;

                        //遍历得到该酒店下该时段内该类型客房的VO，进行下一步判断
                        Iterator<AvailableRoomVO> newRoomVOIterator1 = newRoomVOList.iterator();
                        while(newRoomVOIterator1.hasNext()) {
                            AvailableRoomVO newArvo = newRoomVOIterator1.next();
                            if(thisRoomTypeVO.getRoomType().equals(newArvo.getRoomType())) {
                                thisNewRoomTypeVO = newArvo;
                            }
                        }

                        //如果该时段内该类型客房不为空，则进行下一步判断；
                        //否则进入循环下一步
                        if(thisNewRoomTypeVO != null) {
                            //如果该时段内该类型客房数量小于搜索条件中的客房数量，则进入循环下一步
                            if(thisNewRoomTypeVO.getRoomNum() < sivo.getRoomNum()) {
                                continue;
                            }
                        }else {
                            continue;
                        }
                    }

                }else {
                    continue;
                }

            }

            //最后判断该酒店是否被预定过
            if(historyHotel.contains(hivo.getHotelName())) {
                hivo.setReserve(true);
            }

            finalHotelList.add(hivo);   //将满足所有条件的酒店添加到最终的酒店列表中去
        }

        return finalHotelList;
    }

    @Override
    public ResultMessage addHotel(HotelInfoVO hivo) {
        HotelInfoPO hipo = new HotelInfoPO(hivo.getHotelName(), hivo.getCity(), hivo.getBusinessCircle(), hivo.getAddress(), hivo.getIntroduction(),
                hivo.getFacility(),hivo.getStarLevel(),hivo.getCooperCompany(),hivo.getScore());

        boolean result = false;
        try {
            result = hotelDao.insertHotel(hipo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(result) {
            return ResultMessage.SUCCESS;   //添加酒店成功
        }else{
            return ResultMessage.FAILED;    //酒店名称已存在，添加酒店失败
        }
    }

    @Override
    public ArrayList<HotelInfoVO> sort(ArrayList<HotelInfoVO> hotelList, SortType sortType, SortWay sortWay) {
        ArrayList<HotelInfoVO> newHotelList = new ArrayList<HotelInfoVO>();
        for(int i = hotelList.size(); i > 0; i--) {
            HotelInfoVO hivo = hotelList.get(i - 1);
            int index = i - 1;
            for(int j = 0; j < hotelList.size(); j++) {
                HotelInfoVO newHivo = hotelList.get(j);

                boolean result = (sortWay == SortWay.Ascend) ?
                        keyValue(sortType, newHivo) < keyValue(sortType, hivo) :
                        keyValue(sortType, newHivo) > keyValue(sortType, hivo);
                if(result) {
                    hivo = newHivo;
                    index = j;
                }
            }
            newHotelList.add(hivo);
            hotelList.remove(index);
        }
        return newHotelList;
    }

    @Override
    public ResultMessage updateHotelScore(String hotelName, double score) {
        boolean result = false;
        try {
            result = hotelDao.updateHotelScore(hotelName, score);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(result) {
            return ResultMessage.SUCCESS;   //更新酒店评分成功
        }else {
            return ResultMessage.FAILED;    //酒店不存在，更新酒店评分失败
        }
    }

    public double keyValue(SortType sortType, HotelInfoVO hivo) {
        switch(sortType) {
            case Price:
                return hivo.getLowestPrice();

            case StarLevel:
                return hivo.getStarLevel();

            case Score:
                return hivo.getScore();

            default: return -1;
        }
    }
}
