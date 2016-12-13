package businesslogic.promotionbl.WebPromotion;

import businesslogic.hotelbl.Hotel;
import businesslogicservice.hotelblservice.HotelBLService;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.WebPromotionVO.CircleVO;
import vo.WebPromotionVO.WebCirclePromotionVO;

import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class WebCirclePromotion extends WebPromotion {

    private OrderVO orderVO;

    private WebCirclePromotionVO webCirclePromotionVO;

    public WebCirclePromotion(OrderVO orderVO, WebCirclePromotionVO webCirclePromotionVO) {
        this.orderVO = (OrderVO) orderVO.clone();
        this.webCirclePromotionVO = webCirclePromotionVO;
    }

    @Override
    public OrderVO calculatePrice() {
        HotelBLService hotelBLService = new Hotel();
        HotelInfoVO hivo = hotelBLService.getHotelInfo(orderVO.getHotel());
        String circle = hivo.getBusinessCircle();

        ArrayList<CircleVO> circleVOList = webCirclePromotionVO.getCircleList();
        for(int i = 0; i < circleVOList.size(); i++) {
            if(circle.equals(circleVOList.get(i).getCircle())) {
                orderVO.setPrice(orderVO.getPrice() * circleVOList.get(i).getDiscount());
            }
        }

        return orderVO;
    }
}
