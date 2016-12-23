package vo.HotelPromotionVO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import util.HotelPromotionType;

/**
 * hotelName   0酒店名称
 * startDate   1开始时间
 * endDate     2结束时间
 * discount    3折扣
 * @author Qin Liu
 */
public class HotelSpecialTimePromotionVO extends HotelPromotionVO {

    public HotelPromotionType hotelPromotionType = HotelPromotionType.SpecialTime;

    public HotelSpecialTimePromotionVO(String hotelName, String startDate, String endDate, double discount) {
        this.add(hotelName);
        this.add(startDate);
        this.add(endDate);
        this.add(String.valueOf(discount));
    }

    public String getHotelName() {
        return this.get(0);
    }

    public String getStartDate() {
        return this.get(1);
    }

    public String getEndDate() {
        return this.get(2);
    }

    public double getDiscount() {
        return Double.parseDouble(this.get(3));
    }

}
