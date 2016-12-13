package dataService.managerdataservice;


import po.ManagerPO;
import util.ManagerType;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by 曹利航 on 2016/10/16 18:03.
 */
public interface ManagerDataService extends Remote {

    /**
     * 获取管理人员信息
     * @param managerType
     * @param username
     * @return ManagerPO
     */
    public ManagerPO findManagerInfo(ManagerType managerType, String username) throws RemoteException;

    /**
     * 更新管理人员信息
     * @param mpo
     * @return boolean
     */
    public boolean updateManagerInfo(ManagerPO mpo) throws RemoteException;

    /**
     * 插入管理人员信息
     * @param mpo
     * @return boolean
     */
    public boolean insertManager(ManagerPO mpo) throws RemoteException;


    /**
     * 管理人员登录校验
     * @param managerType
     * @param username
     * @param password
     * @return ResultMessage
     */
    public ResultMessage check(ManagerType managerType, String username, String password) throws RemoteException;


}
