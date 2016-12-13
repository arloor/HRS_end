package dataServiceImpl;

import dataFactory.CustomerDatahelper;
import dataFactory.DataFactory;
import dataFactory.impl.DataFactoryImpl;
import dataService.customerdataservice.CustomerDataservice;
import po.CustomerPO;
import util.JavaMail;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by njulgh on 16-12-6.
 */
public class CustomerDataServiceImpl extends UnicastRemoteObject implements CustomerDataservice {
    private static CustomerDataServiceImpl customerDao;
    private  CustomerDatahelper customerDatahelper;
    private DataFactory dataFactory;

    private CustomerDataServiceImpl() throws RemoteException {
        super();
        dataFactory=new DataFactoryImpl();
        this.customerDatahelper=dataFactory.getCustomerDataHelper();
    }

    public static CustomerDataServiceImpl getInstance(){
        if(customerDao==null){
            try {
                customerDao=new CustomerDataServiceImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return customerDao;
    }

    @Override
    public ResultMessage find(String userName, String password) throws RemoteException {
        CustomerPO cpo=customerDatahelper.getCustomer(userName);
        if(cpo==null){
            return ResultMessage.USER_NOT_EXIST;
        }
        if(cpo.getPassword().equals(password)){
            return ResultMessage.SUCCESS;
        }else return ResultMessage.WRONG_PASSWORD;
    }

    @Override
    public ResultMessage insert(CustomerPO po) throws RemoteException {
        JavaMail.sendEmail(po.getEmail(),"用户注册成功通知",po.getUserName()+" 先生/女士，您已成功注册。用户名： "+po.getUserName());
        return customerDatahelper.insert(po);

    }

    @Override
    public ResultMessage update(CustomerPO po) throws RemoteException {
        return customerDatahelper.update(po);
    }

    @Override
    public CustomerPO getCustomer(String userName) throws RemoteException {
        return customerDatahelper.getCustomer(userName);
    }
}
