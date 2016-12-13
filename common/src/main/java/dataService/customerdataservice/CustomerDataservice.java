package dataService.customerdataservice;


import po.CustomerPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CustomerDataservice extends Remote {
    public ResultMessage find(String userName, String password) throws RemoteException;

    public ResultMessage insert(CustomerPO po) throws RemoteException;

    public ResultMessage update(CustomerPO po) throws RemoteException;

    public CustomerPO getCustomer(String userName) throws RemoteException;

}
