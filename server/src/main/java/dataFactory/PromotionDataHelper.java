package dataFactory;

import po.HotelPromotionPO.HotelPromotionPO;
import po.WebPromotionPO.WebPromotionPO;
import util.HotelPromotionType;
import util.WebPromotionType;

import java.util.Map;

/**
 * Created by arloor on 16-11-22.
 */
public interface PromotionDataHelper {

    /**
     * 向数据库读取酒店所有促销策略
     * @param hotelName
     * @return
     */
    public Map<HotelPromotionType, HotelPromotionPO> findHotelPromotions(String hotelName);

    /**
     * 向数据库写入酒店的一种促销策略
     * @param hotelPromotionType
     * @param hppo
     */
    public void updateHotelPromotion(HotelPromotionType hotelPromotionType, HotelPromotionPO hppo);

    /**
     * 向数据库读取网站所有促销策略
     * @return
     */
    public Map<WebPromotionType, WebPromotionPO> findWebPromotions();

    /**
     * 向数据库写入网站的一种促销策略
     * @param webPromotionType
     * @param wppo
     */
    public void updateWebPromotion(WebPromotionType webPromotionType, WebPromotionPO wppo);

}
