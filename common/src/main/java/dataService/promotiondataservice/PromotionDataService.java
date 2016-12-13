package dataService.promotiondataservice;

import po.HotelPromotionPO.HotelPromotionPO;
import po.WebPromotionPO.WebPromotionPO;
import util.HotelPromotionType;
import util.WebPromotionType;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Qin Liu on 2016/12/8.
 */
public interface PromotionDataService extends Remote {

    /**
     * 获得酒店一种类型的促销策略
     * @param hotelPromotionType
     * @param hotelName
     * @return
     */
    public HotelPromotionPO findHotelPromotion(HotelPromotionType hotelPromotionType, String hotelName) throws RemoteException;

    /**
     * 更新酒店一种类型的促销策略
     * @param hotelPromotionType
     * @param hppo
     * @return
     */
    public boolean updateHotelPromotion(HotelPromotionType hotelPromotionType, HotelPromotionPO hppo) throws RemoteException;

    /**
     * 获得网站一种类型的促销策略
     * @param webPromotionType
     * @return
     */
    public WebPromotionPO findWebPromotion(WebPromotionType webPromotionType) throws RemoteException;

    /**
     * 更新网站一种类型的促销策略
     * @param webPromotionType
     * @param wppo
     * @return
     */
    public boolean updateWebPromotion(WebPromotionType webPromotionType, WebPromotionPO wppo) throws RemoteException;

}
