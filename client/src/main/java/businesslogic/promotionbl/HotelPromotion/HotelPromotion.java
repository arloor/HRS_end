package businesslogic.promotionbl.HotelPromotion;

import util.HotelPromotionType;
import vo.OrderVO;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class HotelPromotion {

    public OrderVO orderVO;

    private HotelPromotionType hotelPromotionType = null;

    public OrderVO calculatePrice() {
        return orderVO;
    }

    public HotelPromotionType getHotelPromotionType() {
        return hotelPromotionType;
    }

}
