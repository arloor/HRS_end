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
    public ArrayList<CreditInfoPO> getCustomerCredits(String userName)throws RemoteException;

    public ResultMessage insert(CreditInfoPO creditInfoPO)throws RemoteException;


}
