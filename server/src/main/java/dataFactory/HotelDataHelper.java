package dataFactory;

import po.HotelInfoPO;

import java.util.Map;

/**
 * Created by arloor on 16-11-22.
 */
public interface HotelDataHelper {

    /**
     * @return 从数据库中读取酒店基本信息数据
     */
    public Map<String, HotelInfoPO> getHotelInfoData();

    /**
     * 向数据库中写入酒店基本信息数据
     * @param hipo
     */
    public void updateHotelInfoData(HotelInfoPO hipo);

    /**
     * 向数据库中插入一项酒店基本信息
     * @param hipo
     */
    public void insertHotel(HotelInfoPO hipo);

    /**
     * 向数据库写入新的酒店评分
     * @param hotelName
     * @param score
     */
    public void updateHotelScore(String hotelName, double score);
}
