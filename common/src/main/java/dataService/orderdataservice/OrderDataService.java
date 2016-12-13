package dataService.orderdataservice;


import po.OrderEvaluationPO;
import po.OrderPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ganghuan liu on 2016/10/16.
 */
public interface OrderDataService extends Remote{
    /**
     * 获取订单信息
     * @param orderID
     * @return orderPO 订单PO
     */
    public OrderPO getOrderInfo(int orderID)  throws RemoteException;

    /**
     * 获取用户订单列表
     * @param customerID
     * @return 用户订单的map
     */
    public Map<Integer, OrderPO> getCustomerOrderList(String customerID) throws RemoteException;

    /**
     * 获取酒店订单列表
     * @param hotel
     * @return 酒店订单的map
      */
    public Map<Integer, OrderPO> getHotelOrderList(String hotel) throws RemoteException;

    public ArrayList<OrderPO> getUnexcutedOrderList() throws RemoteException;

    public ArrayList<OrderPO> getAbnormalOrderList() throws RemoteException;

    /**
     * 获取订单评价
     * @param orderID
     * @return 订单评价的PO
     */
    public OrderEvaluationPO getOrderEvaluation(int orderID) throws RemoteException;


    /**
     * 更新订单评价
     * @param oepo
     * @return 订单评价PO的map
     */
    public Map<Integer, OrderEvaluationPO> updateOrderEvaluation(OrderEvaluationPO oepo) throws RemoteException;


    /**
     * 获取酒店所有订单的评价
     * @param hotel
     * @return 订单评价po的map
     */
    public Map<Integer, OrderEvaluationPO> getHotelEvalvation(String hotel) throws RemoteException;


    /**
     * 获取用户所有订单的评价
     * @param CustommerID
     * @return 订单评价Po的map
     */
    public Map<Integer, OrderEvaluationPO> getCustomerEvaluation(String CustommerID) throws RemoteException;


    /**
     * 插入一个订单
     * @param opo
     * @return 订单Po的map
     */
    public Map<Integer, OrderPO> insertOrder(OrderPO opo) throws RemoteException;


    /**
     * 撤销一个订单
     * @param opo
     * @return 订单PO的map
     */
    public Map<Integer, OrderPO> deleteOrder(OrderPO opo) throws RemoteException;


    /**
     * 更新一个订单
     * @param opo
     * @return
     */
    public Map<Integer, OrderPO> updateOrder(OrderPO opo) throws RemoteException;

}
