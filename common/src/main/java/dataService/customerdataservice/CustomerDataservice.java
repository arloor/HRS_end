package dataService.customerdataservice;


import po.CustomerPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CustomerDataservice extends Remote {
    /**
     * 判断登陆是否成功——用户名和密码是否符合
     * @param userName
     * @param password
     * @return ResultMessage.USER_NOT_EXIST;用户不存在
     * @return ResultMessage.WRONG_PASSWORD;密码错误
     * @return ResultMessage.SUCCESS;登陆成功
     * @throws RemoteException
     */
    public ResultMessage find(String userName, String password) throws RemoteException;

    /**
     * 增加一个用户
     * @param po
     * @return
     * @throws RemoteException
     */
    public ResultMessage insert(CustomerPO po) throws RemoteException;

    public ResultMessage update(CustomerPO po) throws RemoteException;

    /**
     * 根据用户名获取用户PO
     * @param userName
     * @return
     * @throws RemoteException
     */
    public CustomerPO getCustomer(String userName) throws RemoteException;

}
