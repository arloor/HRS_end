package dataServiceImpl;


import dataFactory.DataFactory;
import dataFactory.ManagerDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataService.managerdataservice.ManagerDataService;
import po.ManagerPO;
import util.ManagerType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/12/7.
 */
public class ManagerDataServiceImpl extends UnicastRemoteObject implements ManagerDataService {

    private Map<String, ManagerPO> hotelWorkerPOMap;

    private Map<String, ManagerPO> webSalesManPOMap;

    private Map<String, ManagerPO> webManagerPOMap;

    private ManagerDataHelper managerDataHelper;

    private DataFactory dataFactory;

    private static ManagerDataServiceImpl managerDao;

    public static ManagerDataServiceImpl getInstance() {
        if(managerDao == null) {
            try {
                managerDao = new ManagerDataServiceImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return managerDao;
    }

    public ManagerDataServiceImpl() throws RemoteException {
        super();
        dataFactory = new DataFactoryImpl();
        managerDataHelper = dataFactory.getManagerDataHelper();
        hotelWorkerPOMap = managerDataHelper.findManagerInfo(ManagerType.HotelWorker);
        webSalesManPOMap = managerDataHelper.findManagerInfo(ManagerType.WebSalesMan);
        webManagerPOMap = managerDataHelper.findManagerInfo(ManagerType.WebManager);
    }

    @Override
    public ManagerPO findManagerInfo(ManagerType managerType, String username) {
        ManagerPO mpo;
        switch(managerType) {
            case /*ManagerType.*/HotelWorker:
                if(hotelWorkerPOMap.get(username) != null) {
                    mpo = hotelWorkerPOMap.get(username);
                }else {
                    mpo = null;
                }
                return mpo;

            case /*ManagerType.*/WebSalesMan:
                if(webSalesManPOMap.get(username) != null) {
                    mpo = webSalesManPOMap.get(username);
                }else {
                    mpo = null;
                }
                return mpo;

            case /*ManagerType.*/WebManager:
                if(webManagerPOMap.get(username) != null) {
                    mpo = webManagerPOMap.get(username);
                }else {
                    mpo = null;
                }
                return mpo;

            default:
                return null;
        }
    }

    @Override
    public boolean updateManagerInfo(ManagerPO mpo) {
        ManagerType managerType = mpo.getManagerType();
        switch(managerType) {
            case /*ManagerType.*/HotelWorker:
                if(hotelWorkerPOMap.get(mpo.getUsername()) != null) {
                    managerDataHelper.updateManagerInfo(mpo);
                    hotelWorkerPOMap = managerDataHelper.findManagerInfo(ManagerType.HotelWorker);
                    return true;
                }else {
                    return false;
                }

            case WebSalesMan:
                if(webSalesManPOMap.get(mpo.getUsername()) != null) {
                    managerDataHelper.updateManagerInfo(mpo);
                    webSalesManPOMap = managerDataHelper.findManagerInfo(ManagerType.WebSalesMan);
                    return true;
                }else {
                    return false;
                }

            default:
                return false;
        }
    }

    @Override
    public boolean insertManager(ManagerPO mpo) {
        ManagerType managerType = mpo.getManagerType();
        switch(managerType) {
            case /*ManagerType.*/HotelWorker:
                if(hotelWorkerPOMap.get(mpo.getUsername()) == null) {
                    Iterator<Map.Entry<String, ManagerPO>> iterator = hotelWorkerPOMap.entrySet().iterator();
                    while(iterator.hasNext()){
                        Map.Entry<String, ManagerPO> entry = iterator.next();
                        ManagerPO newMpo = entry.getValue();
                        if(newMpo.getHotelName().equals(mpo.getHotelName())) {
                            return false;
                        }
                    }
                    managerDataHelper.insertManager(mpo);
                    hotelWorkerPOMap = managerDataHelper.findManagerInfo(ManagerType.HotelWorker);
                    return true;
                }else {
                    return false;
                }

            case WebSalesMan:
                if(webSalesManPOMap.get(mpo.getUsername()) == null) {
                    managerDataHelper.insertManager(mpo);
                    webSalesManPOMap = managerDataHelper.findManagerInfo(ManagerType.WebSalesMan);
                    return true;
                }else {
                    return false;
                }

            default:
                return false;
        }
    }

    @Override
    public ResultMessage check(ManagerType managerType, String username, String password) {
        Map<String, ManagerPO> managerPOMap;
        switch(managerType) {
            case HotelWorker:
                managerPOMap = hotelWorkerPOMap;
                break;

            case WebSalesMan:
                managerPOMap = webSalesManPOMap;
                break;

            case WebManager:
                managerPOMap = webManagerPOMap;
                break;

            default:
                managerPOMap = null;
        }

        if(managerPOMap.get(username) != null) {
            if(managerPOMap.get(username).getPassword().equals(password)) {
                return ResultMessage.USER_EXIST;
            }else {
                return ResultMessage.WRONG_PASSWORD;
            }
        }else {
            return ResultMessage.USER_NOT_EXIST;
        }
    }

}
