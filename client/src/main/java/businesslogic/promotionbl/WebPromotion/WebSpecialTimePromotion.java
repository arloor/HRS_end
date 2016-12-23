package businesslogic.promotionbl.WebPromotion;


import util.WebPromotionType;
import vo.OrderVO;
import vo.WebPromotionVO.WebSpecialTimePromotionVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class WebSpecialTimePromotion extends WebPromotion {

    private OrderVO orderVO;

    private WebSpecialTimePromotionVO webSpecialTimePromotionVO;

    private WebPromotionType webPromotionType = WebPromotionType.SpecialTime;

    public WebSpecialTimePromotion(OrderVO orderVO, WebSpecialTimePromotionVO webSpecialTimePromotionVO) {
        this.orderVO = (OrderVO) orderVO.clone();
        this.webSpecialTimePromotionVO = webSpecialTimePromotionVO;
    }

    @Override
    public OrderVO calculatePrice() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar startDateCalendar = Calendar.getInstance();
        Calendar endDateCalendar = Calendar.getInstance();
        Calendar checkInTimeCalendar = Calendar.getInstance();
        try {
            checkInTimeCalendar.setTime(sdf.parse(orderVO.getLastCheckInTime()));
            startDateCalendar.setTime(sdf.parse(webSpecialTimePromotionVO.getStartDate()));
            endDateCalendar.setTime(sdf.parse(webSpecialTimePromotionVO.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(checkInTimeCalendar.compareTo(startDateCalendar) == 1 && endDateCalendar.compareTo(checkInTimeCalendar) == 1) {
            orderVO.setPrice(orderVO.getPrice() * webSpecialTimePromotionVO.getDiscount());
        }

        return this.orderVO;
    }

    @Override
    public WebPromotionType getWebPromotionType() {
        return this.webPromotionType;
    }

}
