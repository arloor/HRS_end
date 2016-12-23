package businesslogic.promotionbl.HotelPromotion;

import util.HotelPromotionType;
import vo.HotelPromotionVO.HotelSpecialTimePromotionVO;
import vo.OrderVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class HotelSpecialTimePromotion extends HotelPromotion {

    private OrderVO orderVO;

    private HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO;

    private HotelPromotionType hotelPromotionType = HotelPromotionType.SpecialTime;

    public HotelSpecialTimePromotion(OrderVO orderVO, HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO) {
        this.orderVO = (OrderVO) orderVO.clone();
        this.hotelSpecialTimePromotionVO = hotelSpecialTimePromotionVO;
    }

    @Override
    public OrderVO calculatePrice() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar startDateCalendar = Calendar.getInstance();
        Calendar endDateCalendar = Calendar.getInstance();
        Calendar checkInTimeCalendar = Calendar.getInstance();
        try {
            startDateCalendar.setTime(sdf.parse(hotelSpecialTimePromotionVO.getStartDate()));
            endDateCalendar.setTime(sdf.parse(hotelSpecialTimePromotionVO.getEndDate()));
            checkInTimeCalendar.setTime(sdf.parse(orderVO.getLastCheckInTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(checkInTimeCalendar.compareTo(startDateCalendar) == 1 && endDateCalendar.compareTo(checkInTimeCalendar) == 1) {
            orderVO.setPrice(orderVO.getPrice() * hotelSpecialTimePromotionVO.getDiscount());
        }

        return this.orderVO;
    }

    @Override
    public HotelPromotionType getHotelPromotionType() {
        return this.hotelPromotionType;
    }

}
