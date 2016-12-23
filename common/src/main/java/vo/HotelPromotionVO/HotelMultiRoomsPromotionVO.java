package vo.HotelPromotionVO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import util.HotelPromotionType;

/**
 * hotelName   0酒店名称
 * roomNum     1最少房间数量
 * discount    2折扣
 * @author Qin Liu
 */
public class HotelMultiRoomsPromotionVO extends HotelPromotionVO {

    public HotelPromotionType hotelPromotionType = HotelPromotionType.MultiRooms;

    public HotelMultiRoomsPromotionVO(String hotelName, int roomNum, double discount) {
        this.add(hotelName);
        this.add(String.valueOf(roomNum));
        this.add(String.valueOf(discount));
    }

    public String getHotelName() {
        return this.get(0);
    }

    public int getRoomNum() {
        return Integer.parseInt(this.get(1));
    }

    public double getDiscount() {
        return Double.parseDouble(this.get(2));
    }

}
