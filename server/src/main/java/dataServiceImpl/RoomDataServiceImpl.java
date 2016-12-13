package dataServiceImpl;

import dataFactory.DataFactory;
import dataFactory.RoomDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataService.roomdataservice.RoomDataService;
import po.AvailableRoomPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/11/25.
 */
public class RoomDataServiceImpl extends UnicastRemoteObject implements RoomDataService {

    private Map<String, AvailableRoomPO> availableRoomPOMap;

    private RoomDataHelper roomDataHelper;

    private DataFactory dataFactory;

    private static RoomDataServiceImpl roomDao;

    public static RoomDataServiceImpl getInstance() {
        if(roomDao == null) {
            try {
                roomDao = new RoomDataServiceImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return roomDao;
    }

    public RoomDataServiceImpl() throws RemoteException {
        super();
        dataFactory = new DataFactoryImpl();
        roomDataHelper = dataFactory.getRoomDataHelper();
    }

    @Override
    public ArrayList<AvailableRoomPO> findAvailableRooms(String hotelName) {
        availableRoomPOMap = roomDataHelper.getAvailableRoomData(hotelName);
        ArrayList<AvailableRoomPO> availableRoomList = new ArrayList<AvailableRoomPO>();
        Iterator<Map.Entry<String, AvailableRoomPO>> iterator = availableRoomPOMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, AvailableRoomPO> entry = iterator.next();
            AvailableRoomPO availableRoomPO = entry.getValue();
            availableRoomList.add(availableRoomPO);
        }
        return availableRoomList;
    }

    @Override
    public boolean updateAvailableRooms(AvailableRoomPO arpo) {
        String hotelName = arpo.getHotelName();
        String roomType = arpo.getRoomType();
        availableRoomPOMap = roomDataHelper.getAvailableRoomData(hotelName);
        if(availableRoomPOMap.get(roomType) != null) {
            roomDataHelper.updateAvailableRoomData(arpo);
            availableRoomPOMap = roomDataHelper.getAvailableRoomData(hotelName);
            return true;
        }
        return false;
    }

    @Override
    public boolean insertAvailableRooms(AvailableRoomPO arpo) {
        String hotelName = arpo.getHotelName();
        String roomType = arpo.getRoomType();
        availableRoomPOMap = roomDataHelper.getAvailableRoomData(hotelName);
        if(availableRoomPOMap.get(roomType) == null) {
            roomDataHelper.insertAvailableRoom(arpo);
            availableRoomPOMap = roomDataHelper.getAvailableRoomData(hotelName);
            return true;
        }
        return false;
    }

}
