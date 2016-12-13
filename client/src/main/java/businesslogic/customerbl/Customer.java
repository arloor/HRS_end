package businesslogic.customerbl;


import businesslogic.creditbl.Credit;
import businesslogicservice.creditblservice.CreditBLservice;
import businesslogicservice.customerblservice.CustomerBLService;
import dataService.customerdataservice.CustomerDataservice;
import po.CreditInfoPO;
import po.CustomerPO;
import util.CustomerType;
import util.RMIcontroller;
import util.ResultMessage;
import util.Time;
import vo.CreditVO;
import vo.CustomerVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by 段梦洋 on 2016/11/7
 */
public class Customer implements CustomerBLService {
    private CustomerDataservice customerDataservice;

    public Customer () {
        //customerDataservice= CustomerDataServiceImpl.getInstance();

        //使用rmi
        try {
            customerDataservice = (CustomerDataservice) Naming.lookup("rmi://" + RMIcontroller.getHostIP() + ":" + RMIcontroller.getPort() + "/CustomerDataservice");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomerVO getCustomerInfo(String userName) {
        try {
            CustomerPO po=customerDataservice.getCustomer(userName);
            if(po==null){
                return null;
            }
            CustomerVO vo=new CustomerVO(po);
            return vo;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ResultMessage login(String userName, String password) {
        ResultMessage resultMessage= null;
        try {
            resultMessage = customerDataservice.find(userName,password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return resultMessage;
    }

    @Override
    public CustomerVO successLog(String userName) {
        CustomerVO customerVO;

        try {
            customerVO=new CustomerVO(customerDataservice.getCustomer(userName));
            return customerVO;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMessage addCustomer(CustomerVO vo) {
        String userName=vo.getUserName();
        String password =vo.getPassword();
        String phone=vo.getPhoneNumber();
        String customerName=vo.getCustomerName();
        CustomerType customerType=vo.getCustomerType();
        String uniqueInfo =vo.getUniqueInformation();
        String email=vo.getEmail();


        CustomerPO po=new CustomerPO(userName,password,phone,customerName,customerType,uniqueInfo,email);
        try {
            ResultMessage resultMessage=customerDataservice.insert(po);
            if(resultMessage==ResultMessage.SUCCESS){
                /**
                 * 初始化会员信用值
                 * 新会员注册赠送100信用值
                 */
                CreditBLservice credit=new Credit(vo.getUserName());
                CreditInfoPO cipo=new CreditInfoPO(vo.getCustomerName(),100, Time.getCurrentTIme(),7,-1,100);
                CreditVO cvo=new CreditVO(cipo);
                credit.updateCustomerCreditInfo(vo.getUserName(),cvo,null);
            }
            return resultMessage;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage changeCustomerInfo(CustomerVO vo) {
        try {
            /*
            CustomerPO po=customerDataservice.getCustomer(vo.getUserName());
            if(po==null){
                System.out.print("null");
            }
            po.setPassword(vo.getPassword());
            po.setPhoneNumber(vo.getPhoneNumber());
            po.setCustomerName(vo.getCustomerName());
            po.setEmail(vo.getEmail());
            return customerDataservice.update(po);*/
            CustomerVO cvo=this.getCustomerInfo(vo.getUserName());

            if(cvo==null){
                return ResultMessage.USER_NOT_EXIST;
            }
            cvo.setPassword(vo.getPassword());
            cvo.setPhoneNumber(vo.getPhoneNumber());
            cvo.setCustomerName(vo.getCustomerName());
            cvo.setEmail(vo.getEmail());
            CustomerPO cpo=new CustomerPO(cvo);
            ResultMessage resultMessage=customerDataservice.update(cpo);
            return resultMessage;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

}