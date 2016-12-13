package vo;

import java.util.Vector;

/**
 * Created by Qin Liu on 2016/10/26.
 */

/**
 * hotelName    0酒店名称
 * roomType     1客房类型
 * roomNum      2客房数量
 * price        3原始价格
 * @author Qin Liu
 */

public class AvailableRoomVO extends Vector<String> {

    public AvailableRoomVO(String hotelName, String roomType, int roomNum, double price) {
        this.add(hotelName);
        this.add(roomType);
        this.add(String.valueOf(roomNum));
        this.add(String .valueOf(price));
    }

    public String getHotelName() {
        return this.get(0);
    }

    public String getRoomType() {
        return this.get(1);
    }

    public int getRoomNum() {
        return Integer.parseInt(this.get(2));
    }

    public double getPrice() {
        return Double.parseDouble(this.get(3));
    }

    public void setRoomNum(int roomNum) {
        this.set(2, String.valueOf(roomNum));
    }

}
