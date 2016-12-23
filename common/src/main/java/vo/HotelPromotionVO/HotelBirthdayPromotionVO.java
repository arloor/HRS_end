package vo.HotelPromotionVO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import util.HotelPromotionType;

/**
 * hotelName   0酒店名称
 * discount    1折扣
 * @author Qin Liu
 */
public class HotelBirthdayPromotionVO extends HotelPromotionVO {

    public HotelPromotionType hotelPromotionType = HotelPromotionType.Birthday;

    public HotelBirthdayPromotionVO(String hotelName, double discount) {
        this.add(hotelName);
        this.add(String.valueOf(discount));
    }

    public String getHotelName() {
        return this.get(0);
    }

    public double getDiscount() {
        return Double.parseDouble(this.get(1));
    }

}
