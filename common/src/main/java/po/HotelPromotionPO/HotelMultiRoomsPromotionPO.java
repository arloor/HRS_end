package po.HotelPromotionPO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import java.io.Serializable;

/**
 * hotelName    0酒店名称
 * roomNum      1最少房间数量
 * discount     2折扣
 * @author Qin Liu
 */
public class HotelMultiRoomsPromotionPO extends HotelPromotionPO implements Serializable {

    private String hotelName;

    private int roomNum;

    private double discount;

    public HotelMultiRoomsPromotionPO(String hotelName, int roomNum, double discount) {
        this.hotelName = hotelName;
        this.roomNum = roomNum;
        this.discount = discount;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public double getDiscount() {
        return discount;
    }

}
