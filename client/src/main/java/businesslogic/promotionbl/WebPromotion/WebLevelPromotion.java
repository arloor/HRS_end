package businesslogic.promotionbl.WebPromotion;

import businesslogic.creditbl.Credit;
import businesslogic.promotionbl.Promotion;
import businesslogicservice.creditblservice.CreditBLservice;
import businesslogicservice.promotionblservice.PromotionBLService;
import util.WebPromotionType;
import vo.OrderVO;
import vo.WebPromotionVO.LevelVO;
import vo.WebPromotionVO.WebLevelPromotionVO;

import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class WebLevelPromotion extends WebPromotion {

    private OrderVO orderVO;

    private WebLevelPromotionVO webLevelPromotionVO;

    private WebPromotionType webPromotionType = WebPromotionType.Level;

    public WebLevelPromotion(OrderVO orderVO, WebLevelPromotionVO webLevelPromotionVO) {
        this.orderVO = (OrderVO) orderVO.clone();
        this.webLevelPromotionVO = webLevelPromotionVO;
    }

    @Override
    public OrderVO calculatePrice() {
        CreditBLservice creditBLservice = new Credit(orderVO.getCustomerID());
        double credit = creditBLservice.getNumCredit(orderVO.getCustomerID());

        PromotionBLService promotionBLService = new Promotion();
        int level = promotionBLService.calculateLevel(credit);

        ArrayList<LevelVO> levelVOList = webLevelPromotionVO.getLevelList();
        for(int i = 0; i < levelVOList.size(); i++) {
            if(level == levelVOList.get(i).getLevel()) {
                orderVO.setPrice(orderVO.getPrice() * levelVOList.get(i).getDiscount());
            }
        }
        return orderVO;
    }

    @Override
    public WebPromotionType getWebPromotionType() {
        return this.webPromotionType;
    }

}
