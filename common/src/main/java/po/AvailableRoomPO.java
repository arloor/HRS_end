package po;

/**
 * Created by 曹利航 on 2016/10/16 17:16.
 */

import java.io.Serializable;

/**
 * hotelName    0酒店名称
 * roomType     1客房类型
 * roomNum      2客房数量
 * price        3原始价格
 */

public class AvailableRoomPO implements Serializable {

    private String hotelName;
    private String roomType;
    private int roomNum;
    private double price;

    public AvailableRoomPO(String hotelName, String roomType, int roomNum, double price) {
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.price = price;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public double getPrice() {
        return price;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
