package dataServiceImpl;

import dataFactory.CreditDataHelper;
import dataFactory.DataFactory;
import dataFactory.impl.DataFactoryImpl;
import dataService.creditdataservice.CreditDataService;
import po.CreditInfoPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by njulgh on 16-12-5.
 */
public class CreditDataServiceImpl extends UnicastRemoteObject implements CreditDataService {
    private ArrayList<CreditInfoPO> list;
    private static CreditDataServiceImpl creditDao;
    private DataFactory dataFactory;
    private CreditDataHelper creditDataHelper;
    //private String userName;

    /*
    private CreditDataServiceImpl(String userName){
        if(list==null){
            dataFactory=new DataFactoryImpl();
            this.userName=userName;
            creditDataHelper=dataFactory.getCreditDataHelper();
                list=getCustomerCredits();
        }
    }

    public static CreditDataServiceImpl getCreditDataServiceInstance(String userName)  {
        if(creditDao==null){
            creditDao=new CreditDataServiceImpl(userName);
        }
        return creditDao;
    }*/

    private CreditDataServiceImpl(/*String userName*/) throws RemoteException {
        super();
        if(list==null){
            dataFactory=new DataFactoryImpl();
            //this.userName=userName;
            creditDataHelper=dataFactory.getCreditDataHelper();
            //list=getCustomerCredits();
        }
    }

    public static CreditDataServiceImpl getCreditDataServiceInstance(/*String userName*/) throws RemoteException {
        if(creditDao==null){
            creditDao=new CreditDataServiceImpl(/*userName*/);
        }
        return creditDao;
    }

    @Override
    public ArrayList<CreditInfoPO> getCustomerCredits(String userName)  {
        return creditDataHelper.getCustomerCredits(userName);
    }



    @Override
    public ResultMessage insert(CreditInfoPO creditInfoPO) {
        creditDataHelper.insert(creditInfoPO);
        return ResultMessage.SUCCESS;
    }

}
