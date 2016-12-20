package businesslogic.orderbl;

import dataService.orderdataservice.OrderDataService;
import po.OrderEvaluationPO;
import po.OrderPO;
import util.OrderType;
import util.RMIcontroller;
import util.ResultMessage;
import vo.OrderEvaluationVO;
import vo.OrderVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 在更新任务中，orderList类负责将更新任务分发给相应的orderLineItem对象
 * orderlist的子类（Hotel、Member）负责将自己保存的OrderlIst置为最新，即每次setOrder（Eval..）VOList();
 */

/**
 * Created by njulgh on 16-11-27.
 */
public abstract class OrderList {

    Map<Integer,OrderVO> orderVOList;
    Map<Integer, OrderEvaluationVO> orderEvaluationVOList;
    OrderLineItem oListItem;
    OrderDataService orderDao;

    public OrderList(){
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
        orderVOList=new HashMap<>();
        orderEvaluationVOList=new HashMap<>();
    }

    public abstract void setOrderVOlist(String name);

    public abstract void setOrderEvaluationVOList(String name);

    public abstract Map<Integer,OrderVO> getOrderVOlist();

    public abstract Map<Integer,OrderEvaluationVO> getOrderEvaluationVOList();

    public OrderLineItem getOrder(int OrderID){
        try {
            OrderLineItem orderLineItem = new OrderLineItem(orderVOList.get(OrderID), orderEvaluationVOList.get(OrderID));
            //System.out.println(orderEvaluationVOList.get(OrderID).getPingjia());
            return orderLineItem;
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("在getOrder的过程中出现空指针");
        }
        return null;
    };

    public  void newOrder(OrderVO ovo){
        OrderPO opo=new OrderPO(ovo);
        try {
            orderDao.insertOrder(opo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    };

    /**
     * 用于获取orderList中特定的订单列表
     * 酒店获取特定用户
     * 用户获取特定酒店
     * @param tag
     * @return
     */
    public abstract Map<Integer,OrderVO> getSpecificOrderVoList(String tag);

    public void updateCheckinInfo(int orderID, String time) {
        oListItem=getOrder(orderID);
        oListItem.updateCheckinInfo(time);
    }

    public abstract ResultMessage cancelOrder(int orderID);

    public void evaluateOrder(OrderEvaluationPO oepo) {
        oListItem=getOrder(oepo.getOrderID());
        oListItem.evaluateOrder(oepo);
    }

    public void updateCheckoutInfo(int orderID, String time) {
        oListItem=getOrder(orderID);
        oListItem.updateCheckoutInfo(time);
    }

    public Map<Integer,OrderVO> getOrderListByType(OrderType type){
        Map<Integer,OrderVO> map=getSomeTypeOrderList(type,orderVOList);
        return map;
    }

    public abstract Map<Integer,OrderVO> getSpecificOrderListByType(OrderType type,String name);


    protected  Map<Integer,OrderVO> getSomeTypeOrderList(OrderType type,Map<Integer,OrderVO> orderList){
        Map<Integer,OrderVO> map=new HashMap<>();
        Iterator<Map.Entry<Integer,OrderVO>> iterator =orderList.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,OrderVO> orderVOEntry=iterator.next();
            OrderVO ovo=orderVOEntry.getValue();
            if(ovo.getStatus().equals(type.toString())){
                map.put(ovo.getOrderID(),ovo);
            }
        }

        return map;
    }



}
