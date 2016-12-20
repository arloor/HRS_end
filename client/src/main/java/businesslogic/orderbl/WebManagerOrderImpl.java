package businesslogic.orderbl;

import businesslogic.creditbl.Credit;
import businesslogicservice.creditblservice.CreditBLservice;
import businesslogicservice.orderbusinesslogicservice.WebManagerOrderBLService;
import dataService.customerdataservice.CustomerDataservice;
import dataService.orderdataservice.OrderDataService;
import po.CreditInfoPO;
import po.CustomerPO;
import po.OrderPO;
import util.JavaMail;
import util.RMIcontroller;
import util.RecoveryType;
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
 * Created by njulgh on 16-12-6.
 */
public class WebManagerOrderImpl implements WebManagerOrderBLService {
    private OrderDataService orderDao;

    public WebManagerOrderImpl(){

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
    }

    @Override
    public ArrayList<OrderVO> getUnexcutedOrderList() {
        ArrayList<OrderVO> voArrayList=new ArrayList<>();
        ArrayList<OrderPO> list= null;
        try {
            list = orderDao.getUnexcutedOrderList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        for (OrderPO cell:list
             ) {
            OrderVO vo=new OrderVO(cell);
            voArrayList.add(vo);
        }
        return voArrayList;
    }

    @Override
    public ArrayList<OrderVO> getAbnormalOrderList() {
        ArrayList<OrderVO> voArrayList=new ArrayList<>();
        ArrayList<OrderPO> list= null;
        try {
            list = orderDao.getAbnormalOrderList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        for (OrderPO cell:list
                ) {
            OrderVO vo=new OrderVO(cell);
            voArrayList.add(vo);
        }
        return voArrayList;
    }

    @Override
    public void cancelAbnormalOrder(int orderID, RecoveryType recoveryType) {
        OrderPO opo= null;
        try {
            opo = orderDao.getOrderInfo(orderID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        opo.setStatus("已撤销");
        String cancelTime= Time.getCurrentTIme();

        opo.setCancelTime(cancelTime);
        try {
            orderDao.updateOrder(opo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        double change=0;
        if(recoveryType.equals(RecoveryType.HALF)){
            change=opo.getCharge()*0.5;
        }else change=opo.getCharge();
        CreditBLservice creditBLservice=new Credit(opo.getCustomerID());
        CreditInfoPO creditInfoPO=new CreditInfoPO(opo.getCustomerID(),change,cancelTime,5,opo.getOrderID(),
                creditBLservice.getNumCredit(opo.getCustomerID())+change);
        CreditVO cvo= new CreditVO(creditInfoPO);
        creditBLservice.updateCustomerCreditInfo(opo.getCustomerID(),cvo,new OrderVO(opo));

        try {
            CustomerDataservice customerDao=(CustomerDataservice) Naming.lookup("rmi://" + RMIcontroller.getHostIP() + ":" + RMIcontroller.getPort() + "/CustomerDataservice");
            CustomerPO cpo= customerDao.getCustomer(opo.getCustomerID());
            if(opo==null)
                System.out.println("opo null");
            if(cpo==null)
                System.out.println("cpo null");
            JavaMail.sendEmail(cpo.getEmail(),"订单撤销成功","订单号： "+opo.getOrderID()+"  撤销时间: "
                    +opo.getCancelTime());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderVO getAbnomalOrder(int orderID) {
        List<OrderVO> orderVOList=getAbnormalOrderList();
        for (OrderVO cell:orderVOList
             ) {
            if(cell.getOrderID()==orderID)
                return cell;
        }
        return null;
    }
}
