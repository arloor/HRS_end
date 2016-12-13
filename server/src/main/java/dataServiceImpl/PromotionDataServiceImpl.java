package dataServiceImpl;

import dataFactory.DataFactory;
import dataFactory.PromotionDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataService.promotiondataservice.PromotionDataService;
import po.HotelPromotionPO.HotelPromotionPO;
import po.WebPromotionPO.WebPromotionPO;
import util.HotelPromotionType;
import util.WebPromotionType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/12/8.
 */
public class PromotionDataServiceImpl extends UnicastRemoteObject implements PromotionDataService {

    private Map<HotelPromotionType, HotelPromotionPO> hotelPromotionPOMap;

    private Map<WebPromotionType, WebPromotionPO> webPromotionPOMap;

    private PromotionDataHelper promotionDataHelper;

    private DataFactory dataFactory;

    private static PromotionDataServiceImpl promotionDao;

    public static PromotionDataServiceImpl getInstance() {
        if(promotionDao == null) {
            try {
                promotionDao = new PromotionDataServiceImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return promotionDao;
    }

    public PromotionDataServiceImpl() throws RemoteException {
        super();
        dataFactory = new DataFactoryImpl();
        promotionDataHelper = dataFactory.getPromotionDataHelper();
        webPromotionPOMap = promotionDataHelper.findWebPromotions();
    }

    @Override
    public HotelPromotionPO findHotelPromotion(HotelPromotionType hotelPromotionType, String hotelName) {
        hotelPromotionPOMap = promotionDataHelper.findHotelPromotions(hotelName);
        HotelPromotionPO hotelPromotionPO = null;
        switch(hotelPromotionType) {
            case /*HotelPromotionType.*/Birthday:
                hotelPromotionPO = hotelPromotionPOMap.get(HotelPromotionType.Birthday);
                break;

            case /*HotelPromotionType.*/Company:
                hotelPromotionPO = hotelPromotionPOMap.get(HotelPromotionType.Company);
                break;

            case /*HotelPromotionType.*/MultiRooms:
                hotelPromotionPO = hotelPromotionPOMap.get(HotelPromotionType.MultiRooms);
                break;

            case /*HotelPromotionType.*/SpecialTime:
                hotelPromotionPO = hotelPromotionPOMap.get(HotelPromotionType.SpecialTime);
                break;

            default:
                hotelPromotionPO = null;
        }
        return hotelPromotionPO;
    }

    @Override
    public boolean updateHotelPromotion(HotelPromotionType hotelPromotionType, HotelPromotionPO hppo) {
        switch(hotelPromotionType) {
            case /*HotelPromotionType.*/Birthday:
                promotionDataHelper.updateHotelPromotion(HotelPromotionType.Birthday, hppo);
                return true;

            case /*HotelPromotionType.*/Company:
                promotionDataHelper.updateHotelPromotion(HotelPromotionType.Company, hppo);
                return true;

            case /*HotelPromotionType.*/MultiRooms:
                promotionDataHelper.updateHotelPromotion(HotelPromotionType.MultiRooms, hppo);
                return true;

            case /*HotelPromotionType.*/SpecialTime:
                promotionDataHelper.updateHotelPromotion(HotelPromotionType.SpecialTime, hppo);

            default:
                return false;
        }
    }

    @Override
    public WebPromotionPO findWebPromotion(WebPromotionType webPromotionType) {
        WebPromotionPO webPromotionPO = null;
        switch(webPromotionType) {
            case /*WebPromotionType.*/SpecialTime:
                webPromotionPO = webPromotionPOMap.get(WebPromotionType.SpecialTime);
                break;

            case /*WebPromotionType.*/Circle:
                webPromotionPO = webPromotionPOMap.get(WebPromotionType.Circle);
                break;

            case /*WebPromotionType.*/Level:
                webPromotionPO = webPromotionPOMap.get(WebPromotionType.Level);
                break;

            default:
                webPromotionPO = null;
        }
        return webPromotionPO;
    }

    @Override
    public boolean updateWebPromotion(WebPromotionType webPromotionType, WebPromotionPO wppo) {
        switch(webPromotionType) {
            case /*WebPromotionType.*/SpecialTime:
                promotionDataHelper.updateWebPromotion(WebPromotionType.SpecialTime, wppo);
                webPromotionPOMap = promotionDataHelper.findWebPromotions();
                return true;

            case /*WebPromotionType.*/Circle:
                promotionDataHelper.updateWebPromotion(WebPromotionType.Circle, wppo);
                webPromotionPOMap = promotionDataHelper.findWebPromotions();
                return true;

            case /*WebPromotionType.*/Level:
                promotionDataHelper.updateWebPromotion(WebPromotionType.Level, wppo);
                webPromotionPOMap = promotionDataHelper.findWebPromotions();
                return true;

            default:
                return false;
        }
    }

}
