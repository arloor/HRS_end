package businesslogicservice.roomblservice;

import util.ResultMessage;
import vo.AvailableRoomVO;

import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/11/21.
 */

public interface RoomBLService {

    /**
     * 得到酒店特定时间段内的可用客房；若参数startDate，endDate为null，则返回酒店的所有可用客房
     * @param hotelName
     * @param startDate
     * @param endDate
     * @return ArrayList<AvailableRoomVO>
     */
    public ArrayList<AvailableRoomVO> getAvailableRoomList(String hotelName, String startDate, String endDate);

    /**
     * 添加可用客房
     * @param arvo
     * @return ResultMessage
     */
    public ResultMessage addAvailableRooms(AvailableRoomVO arvo);

    /**
     * 减少可用客房
     * @param arvo
     * @return ResultMessage
     */
    public ResultMessage deleteAvailableRooms(AvailableRoomVO arvo);

}
