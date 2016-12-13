package vo;

import java.util.Vector;

/**
 * Created by Qin Liu on 2016/10/16 17:16.
 */

/**
 * hotelName        0酒店名称
 * city             1所在城市
 * businessCircle   2所属商圈
 * address          3地址
 * introduction     4简介
 * facility         5设施服务
 * starLevel        6星级
 * cooperCompany    7合作企业
 * score            8评分
 * reserve          9是否预订过（默认值为false）
 * lowestPrice      10最低价格（默认值为9999）
 * @author Qin Liu
 */

public class HotelInfoVO extends Vector<String> {

    public HotelInfoVO(String hotelName, String city, String businessCircle, String address, String introduction,
                       String facility, int starLevel, String cooperCompany, double score,boolean reserve, double lowestPrice) {
        this.add(hotelName);
        this.add(city);
        this.add(businessCircle);
        this.add(address);
        this.add(introduction);
        this.add(facility);
        this.add(String.valueOf(starLevel));
        this.add(cooperCompany);
        this.add(String.valueOf(score));
        this.add(String.valueOf(reserve));
        this.add(String.valueOf(lowestPrice));
    }

    public String getHotelName() {
        return this.get(0);
    }

    public String getCity() {
        return this.get(1);
    }

    public String getBusinessCircle() {
        return this.get(2);
    }

    public String getAddress() {
        return this.get(3);
    }

    public String getIntroduction() {
        return this.get(4);
    }

    public String getFacility() {
        return this.get(5);
    }

    public int getStarLevel() {
        return Integer.parseInt(this.get(6));
    }

    public String getCooperCompany() {
        return this.get(7);
    }

    public double getScore() {
        return Double.parseDouble(this.get(8));
    }

    public boolean getReserve() {
        return Boolean.parseBoolean(this.get(9));
    }

    public double getLowestPrice() {
        return Double.parseDouble(this.get(10));
    }

    public void setReserve(boolean reserve) {
        this.set(9, String.valueOf(reserve));
    }
}
