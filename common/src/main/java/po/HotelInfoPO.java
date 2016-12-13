package po;

/**
 * Created by 曹利航 on 2016/10/16 17:16.
 */

import java.io.Serializable;

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
 * @author Qin Liu
 */

public class HotelInfoPO implements Serializable {

    private String hotelName;
    private String city;
    private String businessCircle;
    private String address;
    private String introduction;
    private String facility;
    private int starLevel;
    private String cooperCompany;
    private double score;

    public HotelInfoPO(String hotelName, String city, String businessCircle, String address,
                       String introduction, String facility, int starLevel, String cooperCompany, double score) {
        this.hotelName = hotelName;
        this.city = city;
        this.businessCircle = businessCircle;
        this.address = address;
        this.introduction = introduction;
        this.facility = facility;
        this.starLevel = starLevel;
        this.cooperCompany = cooperCompany;
        this.score = score;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCity() {
        return city;
    }

    public String getBusinessCircle() {
        return businessCircle;
    }

    public String getAddress() {
        return address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getFacility() {
        return facility;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public String getCooperCompany() {
        return cooperCompany;
    }

    public double getScore() {
        return score;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

}
