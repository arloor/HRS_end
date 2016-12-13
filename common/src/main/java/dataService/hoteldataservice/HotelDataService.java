package dataService.hoteldataservice;

import po.HotelInfoPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/11/21.
 */

public interface HotelDataService extends Remote {

    /**
     * @param hotelName
     * @return 获取酒店基本信息
     */
    public HotelInfoPO findHotelInfo(String hotelName) throws RemoteException;

    /**
     * @param hipo
     * @return 更新酒店基本信息
     */
    public boolean updateHotelInfo(HotelInfoPO hipo) throws RemoteException;

    /**
     *@return 获取所有酒店列表
     */
    public ArrayList<HotelInfoPO> findHotels() throws RemoteException;

    /**
     * @param hipo
     * @return 添加酒店
     */
    public boolean insertHotel(HotelInfoPO hipo) throws RemoteException;

    /**
     * @param hotelName
     * @param score
     * @return 更新酒店评分
     */
    public boolean updateHotelScore(String hotelName, double score) throws RemoteException;

}
