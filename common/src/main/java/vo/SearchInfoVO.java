package vo;

import java.util.Vector;

/**
 * Created by Qin Liu on 2016/10/16 17:17.
 */

/**
 * customerID       0会员编号
 * city             1所在城市
 * businessCircle   2所属商圈
 * hotelName        3酒店名称
 * starLevel        4星级
 * lowerScore       5评分下限
 * upperScore       6评分上限
 * roomType         7房间类型
 * lowerPrice       8原始价格下限
 * upperPrice       9原始价格上限
 * checkInDate      10入住时间
 * checkOutDate     11退房时间
 * roomNum          12房间数量
 * @author Qin Liu
 */

public class SearchInfoVO extends Vector<String > {

    public SearchInfoVO(String customerID, String city, String businessCircle, String hotelName, int starLevel,
                        double lowerScore, double upperScore, String roomType, double lowerPrice, double upperPrice,
                                    String checkInDate, String checkOutDate, int roomNum) {
        this.add(customerID);
        this.add(city);
        this.add(businessCircle);
        this.add(hotelName);
        this.add(String.valueOf(starLevel));
        this.add(String.valueOf(lowerScore));
        this.add(String.valueOf(upperScore));
        this.add(roomType);
        this.add(String .valueOf(lowerPrice));
        this.add(String .valueOf(upperPrice));
        this.add(checkInDate);
        this.add(checkOutDate);
        this.add(String.valueOf(roomNum));
    }
    public  String getCustomerID(){
        return this.get(0);
    }

    public String getCity() {
        return this.get(1);
    }

    public String getBusinessCircle() {
        return this.get(2);
    }

    public String getHotelName() {
        return this.get(3);
    }

    public int getStarLevel() {
        return Integer.parseInt(this.get(4));
    }

    public double getLowerScore() {
        return Double.parseDouble(this.get(5));
    }

    public double getUpperScore() {
        return Double.parseDouble(this.get(6));
    }

    public String getRoomType() {
        return this.get(7);
    }

    public double getLowerPrice() {
        return Double.parseDouble(this.get(8));
    }

    public double getUpperPrice() {
        return Double.parseDouble(this.get(9));
    }

    public String getCheckInDate() {
        return this.get(10);
    }

    public String getCheckOutDate() {
        return this.get(11);
    }

    public int getRoomNum() {
        return Integer.parseInt(this.get(12));
    }

}
