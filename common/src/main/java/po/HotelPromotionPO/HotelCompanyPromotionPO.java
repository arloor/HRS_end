package po.HotelPromotionPO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import java.io.Serializable;

/**
 * hotelName    0酒店名称
 * discount     1折扣
 * @author Qin Liu
 */
public class HotelCompanyPromotionPO extends HotelPromotionPO implements Serializable {

    private String hotelName;

    private double discount;

    public HotelCompanyPromotionPO(String hotelName, double discount) {
        this.hotelName = hotelName;
        this.discount = discount;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getDiscount() {
        return discount;
    }

}
