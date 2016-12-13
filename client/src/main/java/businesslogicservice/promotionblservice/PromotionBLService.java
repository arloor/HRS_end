package businesslogicservice.promotionblservice;

import util.HotelPromotionType;
import util.ResultMessage;
import util.WebPromotionType;
import vo.HotelPromotionVO.HotelPromotionVO;
import vo.OrderVO;
import vo.WebPromotionVO.WebPromotionVO;

/**
 * Created by Qin Liu on 2016/12/8.
 */
public interface PromotionBLService {

    /**
     * 获得酒店一种类型的促销策略
     * @param hotelPromotionType
     * @param hotelName
     * @return
     */
    public HotelPromotionVO getHotelPromotion(HotelPromotionType hotelPromotionType, String hotelName);

    /**
     * 更新酒店一种类型的促销策略
     * @param hotelPromotionType
     * @param hpvo
     * @return
     */
    public ResultMessage updateHotelPromotion(HotelPromotionType hotelPromotionType, HotelPromotionVO hpvo);

    /**
     * 获得网站一种类型的促销策略
     * @param webPromotionType
     * @return
     */
    public WebPromotionVO getWebPromotion(WebPromotionType webPromotionType);

    /**
     * 更新网站一种类型的促销策略
     * @param webPromotionType
     * @param wpvo
     * @return
     */
    public ResultMessage updateWebPromotion(WebPromotionType webPromotionType, WebPromotionVO wpvo);

    /**
     * 计算会员等级
     * @param credit
     * @return
     */
    public int calculateLevel(double credit);

    /**
     * 计算订单总价值,返回最终的OrderVO
     * @param orderVO
     * @return OrderVO
     */
    public OrderVO calculatePrice(OrderVO orderVO);

}
