package businesslogic.orderbl;


import businesslogic.creditbl.Credit;
import businesslogicservice.creditblservice.CreditBLservice;
import dataService.orderdataservice.OrderDataService;
import po.CreditInfoPO;
import po.OrderEvaluationPO;
import po.OrderPO;
import util.RMIcontroller;
import util.ResultMessage;
import util.Time;
import vo.CreditVO;
import vo.OrderEvaluationVO;
import vo.OrderVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by arloor on 2016/11/6.
 */
public class OrderLineItem {
    OrderVO ovo;
    OrderEvaluationVO oevo;
    OrderDataService orderDao;

    public OrderLineItem(OrderVO ovo,OrderEvaluationVO oevo){
        //orderDao= OrderDataServiceImpl.getInstance();
        //使用rmi
        try {
            orderDao = (OrderDataService) Naming.lookup("rmi://" + RMIcontroller.getHostIP() + ":" + RMIcontroller.getPort() + "/OrderDataService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.ovo=ovo;
        this.oevo=oevo;
    }



    public ResultMessage evaluateOrder(OrderEvaluationPO oepo) {
        try {
            orderDao.updateOrderEvaluation(oepo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCheckinInfo(String time){
        OrderPO opo=new OrderPO(this.ovo);
        opo.setCheckInTime(time);
        try {
            orderDao.updateOrder(opo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //System.out.println("成功");
    }

    public void cancelOrder(OrderVO ovo) {
        try {
            orderDao.deleteOrder(new OrderPO(ovo));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        String lastCheckinTime=ovo.getLastCheckInTime();
       String currentTime= Time.getCurrentTIme();
       long diffHour=Time.getDiffHours(lastCheckinTime,currentTime);
       System.out.print("还剩几小时："+diffHour);
       if(diffHour<=6){
           CreditBLservice credit=new Credit(ovo.getCustomerID());
           System.out.println("现在的信用值"+credit.getNumCredit(ovo.getCustomerID()));
           CreditInfoPO cipo=new CreditInfoPO(ovo.getCustomerID(),0-ovo.getCharge()/2,currentTime,6,ovo.getOrderID(),
                   credit.getNumCredit(ovo.getCustomerID())-ovo.getCharge()/2);
           credit.updateCustomerCreditInfo(ovo.getCustomerID(),new CreditVO(cipo),ovo);
       }
    }

    public OrderEvaluationVO getOevo(){
        return oevo;
    }

    public OrderVO getOvo() {
        return ovo;
    }

    public void excuteOrder(){
        ovo.setStatus("已执行");
        String time=Time.getCurrentTIme();
        OrderPO opo=new OrderPO(ovo);
        opo.setCheckInTime(time);
        opo.setStatus("已执行");
        try {
            orderDao.updateOrder(opo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        CreditBLservice credit=new Credit(opo.getCustomerID());
        //System.out.println("现在的信用值为"+credit.getNumCredit(opo.getCustomerID())+"将变为"+credit.getNumCredit(opo.getCustomerID())+"+"+opo.getCharge());
        CreditInfoPO cipo=new CreditInfoPO(opo.getCustomerID(),opo.getCharge(),time,1,opo.getOrderID(),credit.getNumCredit(opo.getCustomerID())+opo.getCharge());
        credit.updateCustomerCreditInfo(opo.getCustomerID(),new CreditVO(cipo),ovo);
    }

    /*j计算价格的逻辑放到salepromotion
    public static double calPrice(OrderVO ovo) {
        return 0;
    }*/

    public void updateCheckoutInfo(String time) {
        OrderPO opo=new OrderPO(this.ovo);
        opo.setCheckOutTime(time);
        try {
            orderDao.updateOrder(opo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
