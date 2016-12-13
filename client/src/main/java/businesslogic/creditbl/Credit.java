package businesslogic.creditbl;


import businesslogicservice.creditblservice.CreditBLservice;
import dataService.creditdataservice.CreditDataService;
import po.CreditInfoPO;
import util.RMIcontroller;
import util.ResultMessage;
import util.Time;
import vo.CreditVO;
import vo.OrderVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啊 on 2016/11/6.
 */
public class Credit implements CreditBLservice {
    private CreditDataService creditDataService;
    private List<CreditInfoPO> customerCreditList;



    public Credit(String userName){

        //creditDataService= CreditDataServiceImpl.getCreditDataServiceInstance();
        //使用rmi
        try {
            creditDataService = (CreditDataService) Naming.lookup("rmi://" + RMIcontroller.getHostIP() + ":" + RMIcontroller.getPort() + "/CreditDataService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            customerCreditList=creditDataService.getCustomerCredits(userName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CreditVO> getCustomerCreditInfo(String userName) {
        List<CreditVO>list=new ArrayList<CreditVO>();
        for(CreditInfoPO creditInfoPO:customerCreditList){
            CreditVO creditVO = new CreditVO(creditInfoPO);
            list.add(creditVO);
        }
        return list;
    }

    @Override
    public double getNumCredit(String userName) {
        //System.out.println("userName is"+userName);
        try {
            customerCreditList=creditDataService.getCustomerCredits(userName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        String latestTime=customerCreditList.get(0).getTime();
        double numCredit=customerCreditList.get(0).getNumCredit();

        for (CreditInfoPO cell:customerCreditList
             ) {
            String time=cell.getTime();
            ResultMessage resultMessage= Time.timeComapre(latestTime,time);
            if(resultMessage.equals(ResultMessage.SECOND_LATER)) {
                latestTime=time;
                numCredit=cell.getNumCredit();
            }
        }

        return numCredit;
    }

    @Override
    public ResultMessage updateCustomerCreditInfo(String userName, CreditVO creditVO, OrderVO orderVO) {
        String s = creditVO.getCreditChangeType();
        int creditChangeType=-1;
        if (s.equals("注册")) {
            creditChangeType=0;

        } else if (s.equals("执行订单")) {
            creditChangeType=1;

        } else if (s.equals("充值")) {
            creditChangeType=2;

        } else if (s.equals("订单异常")) {
            creditChangeType=3;

        } else if (s.equals("延迟入住成功")) {
            creditChangeType=4;

        } else if (s.equals("线下申诉成功")) {
            creditChangeType=5;
        }
        CreditInfoPO creditInfoPO;
        if(orderVO!=null)
            creditInfoPO=new CreditInfoPO(userName,creditVO.getChange(),creditVO.getTime(),creditChangeType,
                    orderVO.getOrderID() ,creditVO.getNumCredit());
        else
            creditInfoPO=new CreditInfoPO(userName,creditVO.getChange(),creditVO.getTime(),creditChangeType,
                    -1 ,creditVO.getNumCredit());       //如果orderid为-1，代表这是充值信用没有orderid!!!
        try {
            creditDataService.insert(creditInfoPO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return ResultMessage.SUCCESS;
    }

    @Override
    public void increaseCredit(String userName, int creditChange) {
        double creditNum=new Credit(userName).getNumCredit(userName);
        CreditInfoPO creditInfoPO=new CreditInfoPO(userName,creditChange, Time.getCurrentTIme(),2,-1,creditNum+creditChange);
        try {
            creditDataService.insert(creditInfoPO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
