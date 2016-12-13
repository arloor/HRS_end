package dataServiceImpl;

import dataFactory.DataFactory;
import dataFactory.HotelDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataService.hoteldataservice.HotelDataService;
import po.HotelInfoPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/11/25.
 */

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService {

    private Map<String, HotelInfoPO> hotelInfoPOMap;

    private HotelDataHelper hotelDataHelper;

    private DataFactory dataFactory;

    private static HotelDataServiceImpl hotelDao;

    public static HotelDataServiceImpl getInstance() throws RemoteException{
        if(hotelDao == null) {
            try {
                hotelDao = new HotelDataServiceImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return hotelDao;
    }

    public HotelDataServiceImpl() throws RemoteException {
        //super();
        if(hotelInfoPOMap == null) {
            dataFactory = new DataFactoryImpl();
            hotelDataHelper = dataFactory.getHotelDataHelper();
            hotelInfoPOMap = hotelDataHelper.getHotelInfoData();
        }
    }

    @Override
    public HotelInfoPO findHotelInfo(String hotelName)  throws RemoteException{
        HotelInfoPO hotelInfoPO;
        // 如果酒店信息存在，则返回该酒店信息;
        // 否则返回null
        if(hotelInfoPOMap.get(hotelName) != null) {
            hotelInfoPO = hotelInfoPOMap.get(hotelName);
        }else {
            hotelInfoPO = null;
        }
        return hotelInfoPO;
    }

    @Override
    public boolean updateHotelInfo(HotelInfoPO hipo) {
        String hotelName = hipo.getHotelName();
        if(hotelInfoPOMap.get(hotelName) != null) {
            hotelDataHelper.updateHotelInfoData(hipo);
            hotelInfoPOMap = hotelDataHelper.getHotelInfoData();
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<HotelInfoPO> findHotels() {
        ArrayList<HotelInfoPO> hotelList = new ArrayList<HotelInfoPO>();
        Iterator<Map.Entry<String, HotelInfoPO>> iterator = hotelInfoPOMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, HotelInfoPO> entry = iterator.next();
            HotelInfoPO hotelInfoPO = entry.getValue();
            hotelList.add(hotelInfoPO);
        }
        return hotelList;
    }

    @Override
    public boolean insertHotel(HotelInfoPO hipo) {
        String hotelName = hipo.getHotelName();
        if(hotelInfoPOMap.get(hotelName) == null) {
            hotelDataHelper.insertHotel(hipo);
            hotelInfoPOMap = hotelDataHelper.getHotelInfoData();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateHotelScore(String hotelName, double score) {
        if(hotelInfoPOMap.get(hotelName) != null) {
            double oldScore = hotelInfoPOMap.get(hotelName).getScore();
            double newScore = (oldScore + score)/2;
            hotelDataHelper.updateHotelScore(hotelName, newScore);
            hotelInfoPOMap = hotelDataHelper.getHotelInfoData();
        }
        return false;
    }

}
