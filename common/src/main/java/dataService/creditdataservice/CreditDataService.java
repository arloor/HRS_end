package dataService.creditdataservice;

import po.CreditInfoPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by 啊 on 2016/11/22.
 */
public interface CreditDataService extends Remote {
    /**
     * 获取信用值变化记录
     * 参见CreditInfoPO
     * @param userName 用户名
     * @return ArrayList<CreditInfoPO>
     * @throws RemoteException
     */
    public ArrayList<CreditInfoPO> getCustomerCredits(String userName)throws RemoteException;

    /**
     * 增加一条信用值记录
     * @param creditInfoPO
     * @return ResultMessage.SUCCESS
     * @throws RemoteException
     */
    public ResultMessage insert(CreditInfoPO creditInfoPO)throws RemoteException;


}
