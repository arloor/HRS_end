package dataServiceImpl;

import dataFactory.CustomerDatahelper;
import dataFactory.impl.CustomerMysqlDataHelper;
import dataService.orderdataservice.OrderDataService;
import po.CustomerPO;
import po.OrderPO;
import util.JavaMail;
import util.Time;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用于自动将未执行订单置为异常订单
 * Created by njulgh on 16-12-12.
 */
public class AbnormalOrderProcesser implements Runnable{
    private Thread t;
    private String threadName="自动将逾期订单置为异常进程";
    OrderDataService orderDao=OrderDataServiceImpl.getInstance();

    public AbnormalOrderProcesser(){
        System.out.println("创建自动将订单置为异常的线程");
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(Time.getCurrentTIme()+"  检查未执行订单的执行状态");
                changeToAbnormal();
                Thread.sleep(60000);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    /**
     * 检查时间并将一些未执行订单变为异常订单
     */
    public void changeToAbnormal(){
        CustomerDatahelper customerDatahelper=new CustomerMysqlDataHelper();
        ArrayList<OrderPO> list= null;
        try {
            list = orderDao.getUnexcutedOrderList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        for (OrderPO cell:list
                ) {
            boolean needToAbnormal=false;
            String lastCheckinTime=cell.getLastCheckInTime();
            needToAbnormal= Time.laterThanSomeTime(lastCheckinTime);
            if(needToAbnormal==true){
                //将订单置为异常
                cell.setStatus("异常");
                try {
                    orderDao.updateOrder(cell);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                //发送邮件通知
                System.out.println(cell.getOrderID()+"异常 正在邮件通知用户");
                CustomerPO cpo=customerDatahelper.getCustomer(cell.getCustomerID());
                JavaMail.sendEmail(cpo.getEmail(),"订单"+cell.getOrderID()+"过期尚未入住",cpo.getCustomerName()+"先生/女士，您的订单"+cell.getOrderID()+"被置为异常。你可以选择到店入住或者向网站申诉");
            }
        }
    }
}
