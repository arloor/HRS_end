package businesslogic.managerbl;


import businesslogicservice.managerblservice.ManagerBLService;
import dataService.managerdataservice.ManagerDataService;
import po.ManagerPO;
import util.ManagerType;
import util.RMIcontroller;
import util.ResultMessage;
import vo.ManagerVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Qin Liu on 2016/12/7.
 */
public class Manager implements ManagerBLService {

    private ManagerDataService managerDao;

    public Manager() {

        //managerDao = ManagerDataServiceImpl.getInstance();
        //使用rmi
        try {
            managerDao = (ManagerDataService) Naming.lookup("rmi://" + RMIcontroller.getHostIP() + ":" + RMIcontroller.getPort() + "/ManagerDataService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ManagerVO getManagerInfo(ManagerType managerType, String username) {
        ManagerPO mpo = null;
        try {
            mpo = managerDao.findManagerInfo(managerType, username);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(mpo != null) {
            ManagerVO mvo = new ManagerVO(mpo.getManagerType(), mpo.getUsername(), mpo.getPassword(), mpo.getPhoneNumber(), mpo.getHotelName());
            return mvo;
        }else {
            return null;
        }
    }

    @Override
    public ResultMessage addManager(ManagerVO mvo) {
        ManagerPO mpo = new ManagerPO(mvo.getManagerType(), mvo.getUsername(), mvo.getPassword(), mvo.getPhoneNumber(), mvo.getHotelName());
        boolean result = false;
        try {
            result = managerDao.insertManager(mpo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(result) {
            return ResultMessage.SUCCESS;   //添加管理人员成功
        }else {
            return ResultMessage.FAILED;    //管理人员已存在，添加管理人员失败
        }
    }

    @Override
    public ResultMessage changeManagerInfo(ManagerVO mvo) {
        ManagerPO mpo = new ManagerPO(mvo.getManagerType(), mvo.getUsername(), mvo.getPassword(), mvo.getPhoneNumber(), mvo.getHotelName());
        boolean result = false;
        try {
            result = managerDao.updateManagerInfo(mpo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(result) {
            return ResultMessage.SUCCESS;   //修改管理人员信息成功
        }else {
            return ResultMessage.FAILED;    //管理人员不存在，修改管理人员信息失败
        }
    }

    @Override
    public ResultMessage login(ManagerType managerType, String username, String password) {
        ResultMessage resultMessage = null;
        try {
            resultMessage = managerDao.check(managerType, username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return resultMessage;
    }

}
