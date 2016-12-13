package po.HotelPromotionPO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import java.io.Serializable;

/**
 * hotelName    0酒店名称
 * startDate    1开始时间
 * endDate      2结束时间
 * discount     3折扣
 * @author Qin Liu
 */
public class HotelSpecialTimePromotionPO extends HotelPromotionPO implements Serializable {

    private String hotelName;

    private String startDate;

    private String endDate;

    private double discount;

    public HotelSpecialTimePromotionPO(String hotelName, String startDate, String endDate, double discount) {
        this.hotelName = hotelName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getDiscount() {
        return discount;
    }

}
