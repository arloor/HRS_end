package po;

/**
 * Created by Qin Liu on 2016/11/18.
 */

import java.io.Serializable;

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

public class SearchInfoPO implements Serializable {

    private String customerID;
    private String city;
    private String businessCircle;
    private String hotelName;
    private int starLevel;
    private double lowerScore;
    private double upperScore;
    private String roomType;
    private double lowerPrice;
    private double upperPrice;
    private String checkInDate;
    private String checkOutDate;
    private int roomNum;

    public SearchInfoPO(String customerID, String city, String businessCircle, String hotelName, int starLevel,
                        double lowerScore, double upperScore, String roomType, double lowerPrice, double upperPrice,
                        String checkInDate, String checkOutDate, int roomNum) {
        this.customerID = customerID;
        this.city = city;
        this.businessCircle = businessCircle;
        this.hotelName = hotelName;
        this.starLevel = starLevel;
        this.lowerScore = lowerScore;
        this.upperScore = upperScore;
        this.roomType = roomType;
        this.lowerPrice = lowerPrice;
        this.upperPrice = upperPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomNum = roomNum;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCity() {
        return city;
    }

    public String getBusinessCircle() {
        return businessCircle;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public double getLowerScore() {
        return lowerScore;
    }

    public double getUpperScore() {
        return upperScore;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getLowerPrice() {
        return lowerPrice;
    }

    public double getUpperPrice() {
        return upperPrice;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public int getRoomNum() {
        return roomNum;
    }
    
}
