package dataService.roomdataservice;

import po.AvailableRoomPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/11/21.
 */
public interface RoomDataService extends Remote {

    /**
     * @param hotelName
     * @return 获取可用客房列表
     */
    public ArrayList<AvailableRoomPO> findAvailableRooms(String hotelName) throws RemoteException;

    /**
     * @param arpo
     * @return 更新可用客房
     */
    public boolean updateAvailableRooms(AvailableRoomPO arpo) throws RemoteException;

    /**
     * @param arpo
     * @return 插入可用客房
     */
    public boolean insertAvailableRooms(AvailableRoomPO arpo) throws RemoteException;

}
