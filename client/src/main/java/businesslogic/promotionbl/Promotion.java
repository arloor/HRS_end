package businesslogic.promotionbl;

import businesslogic.promotionbl.HotelPromotion.*;
import businesslogic.promotionbl.WebPromotion.WebCirclePromotion;
import businesslogic.promotionbl.WebPromotion.WebLevelPromotion;
import businesslogic.promotionbl.WebPromotion.WebPromotion;
import businesslogic.promotionbl.WebPromotion.WebSpecialTimePromotion;
import businesslogicservice.promotionblservice.PromotionBLService;
import dataService.promotiondataservice.PromotionDataService;
import po.HotelPromotionPO.*;
import po.WebPromotionPO.*;
import util.HotelPromotionType;
import util.RMIcontroller;
import util.ResultMessage;
import util.WebPromotionType;
import vo.HotelPromotionVO.*;
import vo.OrderVO;
import vo.WebPromotionVO.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Qin Liu on 2016/12/8.
 */
public class Promotion implements PromotionBLService {

    private PromotionDataService promotionDao;

    public Promotion() {

        //promotionDao = PromotionDataServiceImpl.getInstance();
        try {
            promotionDao = (PromotionDataService) Naming.lookup("rmi://" + RMIcontroller.getHostIP() + ":" + RMIcontroller.getPort() + "/PromotionDataService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HotelPromotionVO getHotelPromotion(HotelPromotionType hotelPromotionType, String hotelName) {
        HotelPromotionVO hotelPromotionVO = null;
        switch(hotelPromotionType) {
            case Birthday:
                HotelBirthdayPromotionPO hotelBirthdayPromotionPO = null;
                try {
                    hotelBirthdayPromotionPO = (HotelBirthdayPromotionPO) promotionDao.findHotelPromotion(HotelPromotionType.Birthday, hotelName);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if(hotelBirthdayPromotionPO != null) {
                    hotelPromotionVO = new HotelBirthdayPromotionVO(hotelBirthdayPromotionPO.getHotelName(), hotelBirthdayPromotionPO.getDiscount());
                }
                return hotelPromotionVO;

            case Company:
                HotelCompanyPromotionPO hotelCompanyPromotionPO = null;
                try {
                    hotelCompanyPromotionPO = (HotelCompanyPromotionPO) promotionDao.findHotelPromotion(HotelPromotionType.Company, hotelName);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if(hotelCompanyPromotionPO != null) {
                    hotelPromotionVO = new HotelCompanyPromotionVO(hotelCompanyPromotionPO.getHotelName(), hotelCompanyPromotionPO.getDiscount());
                }
                return hotelPromotionVO;

            case MultiRooms:
                HotelMultiRoomsPromotionPO hotelMultiRoomsPromotionPO = null;
                try {
                    hotelMultiRoomsPromotionPO = (HotelMultiRoomsPromotionPO) promotionDao.findHotelPromotion(HotelPromotionType.MultiRooms, hotelName);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if(hotelMultiRoomsPromotionPO != null) {
                    hotelPromotionVO = new HotelMultiRoomsPromotionVO(hotelMultiRoomsPromotionPO.getHotelName(), hotelMultiRoomsPromotionPO.getRoomNum(), hotelMultiRoomsPromotionPO.getDiscount());
                }
                return hotelPromotionVO;

            case SpecialTime:
                HotelSpecialTimePromotionPO hotelSpecialTimePromotionPO = null;
                try {
                    hotelSpecialTimePromotionPO = (HotelSpecialTimePromotionPO) promotionDao.findHotelPromotion(HotelPromotionType.SpecialTime, hotelName);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if(hotelSpecialTimePromotionPO != null) {
                    hotelPromotionVO = new HotelSpecialTimePromotionVO(hotelSpecialTimePromotionPO.getHotelName(), hotelSpecialTimePromotionPO.getStartDate(), hotelSpecialTimePromotionPO.getEndDate(), hotelSpecialTimePromotionPO.getDiscount());
                }
                return hotelPromotionVO;

            default:
                System.out.println("无该类型的酒店促销策略！");
                return hotelPromotionVO;
        }
    }

    @Override
    public ResultMessage updateHotelPromotion(HotelPromotionType hotelPromotionType, HotelPromotionVO hpvo) {
        boolean result;
        HotelPromotionPO hotelPromotionPO;
        switch(hotelPromotionType) {
            case Birthday:
                if(hpvo == null) {
                    return ResultMessage.FAILED;
                }
                HotelBirthdayPromotionVO hotelBirthdayPromotionVO = (HotelBirthdayPromotionVO) hpvo;
                hotelPromotionPO = new HotelBirthdayPromotionPO(hotelBirthdayPromotionVO.getHotelName(), hotelBirthdayPromotionVO.getDiscount());
                try {
                    result = promotionDao.updateHotelPromotion(HotelPromotionType.Birthday, hotelPromotionPO);
                    if(result) {
                        return ResultMessage.SUCCESS;   //更新酒店促销策略成功
                    }else {
                        return ResultMessage.FAILED;    //更新酒店促销策略失败
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            case Company:
                if(hpvo == null) {
                    return ResultMessage.FAILED;
                }
                HotelCompanyPromotionVO hotelCompanyPromotionVO = (HotelCompanyPromotionVO) hpvo;
                hotelPromotionPO = new HotelCompanyPromotionPO(hotelCompanyPromotionVO.getHotelName(), hotelCompanyPromotionVO.getDiscount());
                try {
                    result = promotionDao.updateHotelPromotion(HotelPromotionType.Company, hotelPromotionPO);
                    if(result) {
                        return ResultMessage.SUCCESS;   //更新酒店促销策略成功
                    }else {
                        return ResultMessage.FAILED;    //更新酒店促销策略失败
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            case MultiRooms:
                if(hpvo == null) {
                    return ResultMessage.FAILED;
                }
                HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO = (HotelMultiRoomsPromotionVO) hpvo;
                hotelPromotionPO = new HotelMultiRoomsPromotionPO(hotelMultiRoomsPromotionVO.getHotelName(), hotelMultiRoomsPromotionVO.getRoomNum(), hotelMultiRoomsPromotionVO.getDiscount());
                try {
                    result = promotionDao.updateHotelPromotion(HotelPromotionType.MultiRooms, hotelPromotionPO);
                    if(result) {
                        return ResultMessage.SUCCESS;   //更新酒店促销策略成功
                    }else {
                        return ResultMessage.FAILED;    //更新酒店促销策略失败
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            case SpecialTime:
                if(hpvo == null) {
                    return ResultMessage.FAILED;
                }
                HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO = (HotelSpecialTimePromotionVO) hpvo;
                hotelPromotionPO = new HotelSpecialTimePromotionPO(hotelSpecialTimePromotionVO.getHotelName(), hotelSpecialTimePromotionVO.getStartDate(), hotelSpecialTimePromotionVO.getEndDate(), hotelSpecialTimePromotionVO.getDiscount());
                try {
                    result = promotionDao.updateHotelPromotion(HotelPromotionType.SpecialTime, hotelPromotionPO);
                    if(result) {
                        return ResultMessage.SUCCESS;   //更新酒店促销策略成功
                    }else {
                        return ResultMessage.FAILED;    //更新酒店促销策略失败
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            default:
                System.out.println("无该类型的酒店促销策略！");
                return ResultMessage.FAILED;
        }
    }

    @Override
    public WebPromotionVO getWebPromotion(WebPromotionType webPromotionType) {
        WebPromotionVO webPromotionVO = null;
        switch(webPromotionType) {
            case SpecialTime:
                WebSpecialTimePromotionPO webSpecialTimePromotionPO = null;
                try {
                    webSpecialTimePromotionPO = (WebSpecialTimePromotionPO) promotionDao.findWebPromotion(WebPromotionType.SpecialTime);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if(webSpecialTimePromotionPO != null) {
                    webPromotionVO = new WebSpecialTimePromotionVO(webSpecialTimePromotionPO.getStartDate(), webSpecialTimePromotionPO.getEndDate(), webSpecialTimePromotionPO.getDiscount());

                }
                return webPromotionVO;

            case Circle:
                WebCirclePromotionPO webCirclePromotionPO = null;
                try {
                    webCirclePromotionPO = (WebCirclePromotionPO) promotionDao.findWebPromotion(WebPromotionType.Circle);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                ArrayList<CirclePO> circlePOList = webCirclePromotionPO.getCircleList();
                ArrayList<CircleVO> circleVOList = new ArrayList<CircleVO>();
                for(int i = 0; i < circlePOList.size(); i++) {
                    CircleVO circleVO = new CircleVO(circlePOList.get(i).getCircle(), circlePOList.get(i).getDiscount());
                    circleVOList.add(circleVO);
                }
                webPromotionVO = new WebCirclePromotionVO(circleVOList);
                return webPromotionVO;

            case Level:
                WebLevelPromotionPO webLevelPromotionPO = null;
                try {
                    webLevelPromotionPO = (WebLevelPromotionPO) promotionDao.findWebPromotion(WebPromotionType.Level);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                ArrayList<LevelPO> levelPOList = webLevelPromotionPO.getLevelList();
                ArrayList<LevelVO> levelVOList = new ArrayList<LevelVO>();
                for(int i = 0; i < levelPOList.size(); i++) {
                    LevelVO levelVO = new LevelVO(levelPOList.get(i).getLevel(), levelPOList.get(i).getCredit(), levelPOList.get(i).getDiscount());
                    levelVOList.add(levelVO);
                }
                webPromotionVO = new WebLevelPromotionVO(levelVOList);
                return webPromotionVO;

            default:
                return webPromotionVO;
        }
    }

    @Override
    public ResultMessage updateWebPromotion(WebPromotionType webPromotionType, WebPromotionVO wpvo) {
        boolean result;
        WebPromotionPO webPromotionPO;
        switch(webPromotionType) {
            case SpecialTime:
                if(wpvo == null) {
                    return ResultMessage.FAILED;
                }
                WebSpecialTimePromotionVO webSpecialTimePromotionVO = (WebSpecialTimePromotionVO) wpvo;
                webPromotionPO = new WebSpecialTimePromotionPO(webSpecialTimePromotionVO.getStartDate(), webSpecialTimePromotionVO.getEndDate(), webSpecialTimePromotionVO.getDiscount());
                try {
                    result = promotionDao.updateWebPromotion(WebPromotionType.SpecialTime, webPromotionPO);
                    if(result) {
                        return ResultMessage.SUCCESS;   //更新网站促销策略成功
                    }else {
                        return ResultMessage.FAILED;    //更新网站促销策略失败
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            case Circle:
                if(wpvo == null) {
                    return ResultMessage.FAILED;
                }
                WebCirclePromotionVO webCirclePromotionVO = (WebCirclePromotionVO) wpvo;
                ArrayList<CircleVO> circleVOList = webCirclePromotionVO.getCircleList();
                ArrayList<CirclePO> circlePOList = new ArrayList<CirclePO>();
                for(int i = 0; i < circleVOList.size(); i++) {
                    CircleVO circleVO = circleVOList.get(i);
                    CirclePO circlePO = new CirclePO(circleVO.getCircle(), circleVO.getDiscount());
                    circlePOList.add(circlePO);
                }
                webPromotionPO = new WebCirclePromotionPO(circlePOList);
                try {
                    result = promotionDao.updateWebPromotion(WebPromotionType.Circle, webPromotionPO);
                    if(result) {
                        return ResultMessage.SUCCESS;   //更新网站促销策略成功
                    }else {
                        return ResultMessage.FAILED;    //更新网站促销策略失败
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            case Level:
                if(wpvo == null) {
                    return ResultMessage.FAILED;
                }
                WebLevelPromotionVO webLevelPromotionVO = (WebLevelPromotionVO) wpvo;
                ArrayList<LevelVO> levelVOList = webLevelPromotionVO.getLevelList();
                ArrayList<LevelPO> levelPOList = new ArrayList<LevelPO>();
                for(int i = 0; i < levelVOList.size(); i++) {
                    LevelVO levelVO = levelVOList.get(i);
                    LevelPO levelPO = new LevelPO(levelVO.getLevel(), levelVO.getCredit(), levelVO.getDiscount());
                    levelPOList.add(levelPO);
                }
                webPromotionPO = new WebLevelPromotionPO(levelPOList);
                try {
                    result = promotionDao.updateWebPromotion(WebPromotionType.Level, webPromotionPO);
                    if(result) {
                        return ResultMessage.SUCCESS;   //更新网站促销策略成功
                    }else {
                        return ResultMessage.FAILED;    //更新网站促销策略失败
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            default:
                System.out.println("无该类型的网站促销策略！");
                return ResultMessage.FAILED;
        }
    }

    @Override
    public int calculateLevel(double credit) {
        int level = 0;
        WebLevelPromotionVO webLevelPromotionVO = (WebLevelPromotionVO) this.getWebPromotion(WebPromotionType.Level);
        ArrayList<LevelVO> levelVOList = new ArrayList<LevelVO>();
        levelVOList = webLevelPromotionVO.getLevelList();
        if(levelVOList.size() != 0) {
            for(int i = 0; i < levelVOList.size(); i++) {
                LevelVO levelVO = levelVOList.get(i);
                if(credit < levelVO.getCredit()) {
                    level = levelVO.getLevel() - 1;
                    break;
                }
                if(levelVO == levelVOList.get(levelVOList.size() - 1)) {
                    level = levelVO.getLevel();
                }
            }
            return level;
        }else {
            return 0;
        }
    }

    @Override
    public OrderVO calculatePrice(OrderVO orderVO) {
        //计算订单原始总价
        String checkInDate = orderVO.getLastCheckInTime().substring(0,10);
        String checkOutDate = orderVO.getLastCheckoutTime().substring(0,10);
        int roomNum = orderVO.getRoomNum();
        double unitPrice = orderVO.getPrice();
        long day = 1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(checkInDate);
            Date endDate = sdf.parse(checkOutDate);
            day = (endDate.getTime() - startDate.getTime()) / (24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double originalPrice = day * roomNum * unitPrice;
        orderVO.setPrice(originalPrice);

        //得到酒店所有促销策略
        ArrayList<HotelPromotion> hotelPromotionList = new ArrayList<HotelPromotion>();

        HotelBirthdayPromotionVO hotelBirthdayPromotionVO = (HotelBirthdayPromotionVO) this.getHotelPromotion(HotelPromotionType.Birthday, orderVO.getHotel());
        if(hotelBirthdayPromotionVO != null) {
            HotelPromotion hotelPromotion = new HotelBirthdayPromotion(orderVO, hotelBirthdayPromotionVO);
            hotelPromotionList.add(hotelPromotion);
        }

        HotelCompanyPromotionVO hotelCompanyPromotionVO = (HotelCompanyPromotionVO) this.getHotelPromotion(HotelPromotionType.Company, orderVO.getHotel());
        if(hotelCompanyPromotionVO != null) {
            HotelPromotion hotelPromotion = new HotelCompanyPromotion(orderVO, hotelCompanyPromotionVO);
            hotelPromotionList.add(hotelPromotion);
        }

        HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO = (HotelMultiRoomsPromotionVO) this.getHotelPromotion(HotelPromotionType.MultiRooms, orderVO.getHotel());
        if(hotelMultiRoomsPromotionVO != null) {
            HotelPromotion hotelPromotion = new HotelMultiRoomsPromotion(orderVO, hotelMultiRoomsPromotionVO);
            hotelPromotionList.add(hotelPromotion);
        }

        HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO = (HotelSpecialTimePromotionVO) this.getHotelPromotion(HotelPromotionType.SpecialTime, orderVO.getHotel());
        if(hotelSpecialTimePromotionVO != null) {
            HotelPromotion hotelPromotion = new HotelSpecialTimePromotion(orderVO, hotelSpecialTimePromotionVO);
            hotelPromotionList.add(hotelPromotion);
        }

        //得到网站所有促销策略
        ArrayList<WebPromotion> webPromotionList = new ArrayList<WebPromotion>();

        WebSpecialTimePromotionVO webSpecialTimePromotionVO = (WebSpecialTimePromotionVO) this.getWebPromotion(WebPromotionType.SpecialTime);
        if(webSpecialTimePromotionVO != null) {
            WebPromotion webPromotion = new WebSpecialTimePromotion(orderVO, webSpecialTimePromotionVO);
            webPromotionList.add(webPromotion);
        }

        WebCirclePromotionVO webCirclePromotionVO = (WebCirclePromotionVO) this.getWebPromotion(WebPromotionType.Circle);
        if(webCirclePromotionVO != null) {
            WebPromotion webPromotion = new WebCirclePromotion(orderVO, webCirclePromotionVO);
            webPromotionList.add(webPromotion);
        }

        //计算最终价格
        double discountPrice = orderVO.getPrice();

        for(int i = 0; i < hotelPromotionList.size(); i++) {
            OrderVO newOrderVO = hotelPromotionList.get(i).calculatePrice();
            if(newOrderVO.getPrice() < discountPrice) {
                discountPrice = newOrderVO.getPrice();
                orderVO.setPromotionType(hotelPromotionList.get(i).getHotelPromotionType().toString());
            }
        }

        for(int i = 0; i < webPromotionList.size(); i++) {
            OrderVO newOrderVO = webPromotionList.get(i).calculatePrice();
            if(newOrderVO.getPrice() < discountPrice) {
                discountPrice = newOrderVO.getPrice();
                orderVO.setPromotionType(webPromotionList.get(i).getWebPromotionType().toString());
            }
        }
        orderVO.setPrice(discountPrice);

        WebLevelPromotionVO webLevelPromotionVO = (WebLevelPromotionVO) this.getWebPromotion(WebPromotionType.Level);
        WebLevelPromotion webLevelPromotion = new WebLevelPromotion(orderVO, webLevelPromotionVO);
        OrderVO newOrderVO = webLevelPromotion.calculatePrice();
        if(newOrderVO.getPrice() < orderVO.getPrice()) {
            orderVO = newOrderVO;
        }

        discountPrice = orderVO.getPrice();
        orderVO.setPrice(originalPrice);
        orderVO.setCharge(discountPrice);
        return orderVO;

    }

}
