package businesslogic.promotionbl.WebPromotion;

import util.WebPromotionType;
import vo.OrderVO;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class WebPromotion {

    public OrderVO orderVO;

    private WebPromotionType webPromotionType = null;

    public OrderVO calculatePrice() {
        return orderVO;
    }

    public WebPromotionType getWebPromotionType() {
        return webPromotionType;
    }
}
