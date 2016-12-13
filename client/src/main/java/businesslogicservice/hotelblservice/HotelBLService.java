package businesslogicservice.hotelblservice;


import util.ResultMessage;
import util.SortType;
import util.SortWay;
import vo.HotelInfoVO;
import vo.SearchInfoVO;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Qin Liu on 2016/11/6.
 */
public interface HotelBLService {

    /**
     * 得到酒店基本信息
     * @param hotelName
     * @return HotelInfoVO
     */
    public HotelInfoVO getHotelInfo(String hotelName);

    /**
     * 修改酒店基本信息
     * @param hivo
     * @return ResultMessage
     */
    public ResultMessage modifyHotelInfo(HotelInfoVO hivo);

    /**
     * 得到预订过的酒店列表
     * @param customerID
     * @return ArrayList<HotelInfoVO>
     */
    public ArrayList<HotelInfoVO> getHistoryHotelList(String customerID);

    /**
     *得到所有预订过的酒店的酒店名称
     * @param customerID
     * @return Set<Integer>
     */
    public Set<String> getHistoryHotel(String customerID);

    /**
     * 根据搜索信息得到酒店列表
     * @param sivo
     * @return ArrayList<HotelInfoVO>
     */
    public ArrayList<HotelInfoVO> getHotelList(SearchInfoVO sivo);

    /**
     * 添加酒店
     * @param hivo
     * @return ResultMessage
     */
    public ResultMessage addHotel(HotelInfoVO hivo);

    /**
     * 对酒店列表进行排序
     * @param hotelList 待排序的酒店列表
     * @param sortType 排序类型（1.按价格 2.按星级排序 3.按评分排序）
     * @param sortWay 排序方式（1.升序 2.降序）
     */
    public ArrayList<HotelInfoVO> sort(ArrayList<HotelInfoVO> hotelList, SortType sortType, SortWay sortWay);

    /**
     * 更新酒店评分
     * @param hotelName
     * @return ResultMessage
     */
    public ResultMessage updateHotelScore(String hotelName, double score);

}
