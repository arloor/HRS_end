package businesslogic.roombl;

import businesslogic.orderbl.OrderImpl;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import businesslogicservice.roomblservice.RoomBLService;
import dataService.roomdataservice.RoomDataService;
import dataServiceImpl.RoomDataServiceImpl;
import po.AvailableRoomPO;
import util.ResultMessage;
import vo.AvailableRoomVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Qin Liu on 2016/11/21.
 */
public class Room implements RoomBLService {

    private RoomDataService roomDao;

    private OrderBLservice orderBLservice;

    public Room() {
        roomDao = RoomDataServiceImpl.getInstance();
    }

    @Override
    public ArrayList<AvailableRoomVO> getAvailableRoomList(String hotelName, String startDate, String endDate) {
        ArrayList<AvailableRoomVO> roomVOList = new ArrayList<AvailableRoomVO>();
        ArrayList<AvailableRoomPO> roomPOList = null;
        try {
            roomPOList = roomDao.findAvailableRooms(hotelName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Iterator<AvailableRoomPO> roomPOIterator = roomPOList.iterator();
        while(roomPOIterator.hasNext()){
            AvailableRoomPO arpo = roomPOIterator.next();
            AvailableRoomVO arvo = new AvailableRoomVO(arpo.getHotelName(), arpo.getRoomType(), arpo.getRoomNum(), arpo.getPrice());
            roomVOList.add(arvo);
        }

        // 如果startDate和endDate不为null，则返回对应时间段的可用客房列表；
        // 否则返回酒店所用客房列表
        if(startDate != null && endDate != null) {
            //将开始时间、结束时间格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar startDateCalendar = Calendar.getInstance();
            Calendar endDateCalendar = Calendar.getInstance();
            try {
                startDateCalendar.setTime(sdf.parse(startDate));
                endDateCalendar.setTime(sdf.parse(endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            orderBLservice = OrderImpl.getHotelOrderInstance(hotelName);
            ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>(orderBLservice.getOrderVOList().values());  //酒店所有订单
            Map<String, Integer> bookedRoomMap = new HashMap<String, Integer>();    //该时段已被预定的客房类型及对应数量

            //遍历orderVOList，将在该时段内的酒店订单的客房类型及数量插入到bookedRoomMap中
            Iterator<OrderVO> orderVOIterator = orderVOList.iterator();
            while(orderVOIterator.hasNext()){
                OrderVO orderVO = orderVOIterator.next();
                String checkInTime = orderVO.getLastCheckInTime();
                String checkOutTime = orderVO.getLastCheckoutTime();
                String roomType = orderVO.getRoomID();
                int roomNum = orderVO.getRoomNum();

                //将订单预计入住时间、预计离开时间格式化
                Calendar checkInTimeCalendar = Calendar.getInstance();
                Calendar checkOutTimeCalendar = Calendar.getInstance();
                try {
                    checkInTimeCalendar.setTime(sdf.parse(checkInTime));
                    checkOutTimeCalendar.setTime(sdf.parse(checkOutTime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //如果预计入住时间或者预计离开时间在该时间段内，则将该订单客房类型及数量插入到bookedRoomMap中
                if((checkInTimeCalendar.compareTo(startDateCalendar) == 1 && endDateCalendar.compareTo(checkInTimeCalendar) == 1)
                        || (checkOutTimeCalendar.compareTo(startDateCalendar) == 1 && endDateCalendar.compareTo(checkOutTimeCalendar) == 1)) {
                    //如果该类客房不存在于bookedRoomMap中，则直接插入客房数量；
                    //否则计算客房数量之和，再进行插入
                    if(bookedRoomMap.get(roomType) == null) {
                        bookedRoomMap.put(roomType, roomNum);
                    }else {
                        int tempRoomNum = bookedRoomMap.get(roomType);
                        bookedRoomMap.put(roomType, tempRoomNum + roomNum);
                    }
                }
            }

            ArrayList<AvailableRoomVO> newRoomVOList = new ArrayList<AvailableRoomVO>();    //该时间段内的可用客房

            //遍历roomVOList，将各类型客房总的客房数量减去被预定的客房数量，即得到该时间段内的可用客房数量
            Iterator<AvailableRoomVO> roomVOIterator = roomVOList.iterator();
            while(roomVOIterator.hasNext()) {
                AvailableRoomVO arvo = roomVOIterator.next();
                String roomType = arvo.getRoomType();
                int roomNum = arvo.getRoomNum();

                //如果该类型客房部分被占用，则用总的客房数量减去该部分客房数量；
                //否则不做修改
                if(bookedRoomMap.get(roomType) != null) {
                    int tempRoomNum = bookedRoomMap.get(roomType);
                    roomNum = roomNum - tempRoomNum;
                    arvo.setRoomNum(roomNum);
                    if(roomNum > 0) {
                        newRoomVOList.add(arvo);
                    }
                }else {
                    newRoomVOList.add(arvo);
                }
            }

            return newRoomVOList;   //返回该时间段的可用客房列表

        }else {
            return roomVOList;  //返回总的客房列表
        }
    }

    @Override
    public ResultMessage addAvailableRooms(AvailableRoomVO arvo) {
        AvailableRoomPO arpo = new AvailableRoomPO(arvo.getHotelName(), arvo.getRoomType(), arvo.getRoomNum(), arvo.getPrice());
        // 如果arvo中原始价格为空（用-1表示），调用数据层updateAvailableRooms接口；
        // 否则调用insertAvailableRooms接口
        if(arvo.getPrice() == -1) {
            boolean result = false;
            try {
                result = roomDao.updateAvailableRooms(arpo);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if(result) {
                return ResultMessage.SUCCESS;   //添加可用客房成功
            }else {
                return ResultMessage.FAILED;    //添加可用客房失败
            }
        }else {
            boolean result = false;
            try {
                result = roomDao.insertAvailableRooms(arpo);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if(result) {
                return ResultMessage.SUCCESS;   //插入可用客房成功
            }else {
                return ResultMessage.FAILED;    //插入可用客房失败
            }
        }
    }

    @Override
    public ResultMessage deleteAvailableRooms(AvailableRoomVO arvo) {
        AvailableRoomPO arpo = new AvailableRoomPO(arvo.getHotelName(), arvo.getRoomType(), -1*arvo.getRoomNum(), arvo.getPrice());

        boolean result = false;
        try {
            result = roomDao.updateAvailableRooms(arpo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(result) {
            return ResultMessage.SUCCESS;   //减少可用客房成功
        }else {
            return ResultMessage.FAILED;    //减少可用客房失败
        }
    }

}
