package dataFactory;

import po.AvailableRoomPO;

import java.util.Map;

/**
 * Created by Qin Liu on 2016/11/25.
 */
public interface RoomDataHelper {

    /**
     * @param hotelName
     * @return 从数据库中读取可用客房数据
     */
    public Map<String, AvailableRoomPO> getAvailableRoomData(String hotelName);

    /**
     * 向数据库中写入可用客房数据
     * @param arpo
     */
    public void updateAvailableRoomData(AvailableRoomPO arpo);

    /**
     * 向数据库中插入可用客房
     * @param arpo
     */
    public void insertAvailableRoom(AvailableRoomPO arpo);

}
