package dataServiceImpl;

import dataFactory.DataFactory;
import dataFactory.OrderDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataService.orderdataservice.OrderDataService;
import po.CustomerPO;
import po.OrderEvaluationPO;
import po.OrderPO;
import util.JavaMail;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by arloor on 16-11-22.
 */
public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService {
    private Map<Integer, OrderPO> map;
    private Map<Integer, OrderEvaluationPO> evaluationPOMap;
    private static OrderDataServiceImpl orderDao;
    private DataFactory dataFactory;
    private OrderDataHelper orderDataHelper;

    private OrderDataServiceImpl() throws RemoteException {
        super();
        if(map==null){
            dataFactory=new DataFactoryImpl() ;
            orderDataHelper=dataFactory.getOrderDataHelper();
            map=orderDataHelper.getOrderData();
            evaluationPOMap=orderDataHelper.getEvaluation();
        }
    }

    public static OrderDataServiceImpl getInstance(){
        if(orderDao == null){
            try {
                orderDao = new OrderDataServiceImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return orderDao;
    }

    @Override
    public OrderPO getOrderInfo(int orderID) {
        OrderPO orderPo = map.get(orderID);
        return orderPo;

    }

    @Override
    public Map<Integer, OrderEvaluationPO> getHotelEvalvation(String hotel) {
        Map<Integer, OrderEvaluationPO> hotelOrderEvaluationMap=new HashMap<>();
        Iterator<Map.Entry<Integer, OrderEvaluationPO>> iterator = evaluationPOMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, OrderEvaluationPO> entry = iterator.next();
            OrderEvaluationPO orderEvaluationPo = entry.getValue();
            if(map.get(orderEvaluationPo.getOrderID()).getHotel() .equals(hotel)){
               if(orderEvaluationPo.getPingjia()!=null) {
                   //System.out.println(orderEvaluationPo.getPingjia());
                   hotelOrderEvaluationMap.put(orderEvaluationPo.getOrderID(), orderEvaluationPo);
               }
            }
        }
        return hotelOrderEvaluationMap;
    }

    @Override
    public Map<Integer, OrderEvaluationPO> getCustomerEvaluation(String CustommerID) {
        Map<Integer, OrderEvaluationPO> CustomerOrderEvaluationMap=new HashMap<>();
        Iterator<Map.Entry<Integer, OrderEvaluationPO>> iterator = evaluationPOMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, OrderEvaluationPO> entry = iterator.next();
            OrderEvaluationPO orderEvaluationPo = entry.getValue();
            if(map.get(orderEvaluationPo.getOrderID()).getCustomerID() .equals(CustommerID)){
                if(orderEvaluationPo.getPingjia()!=null) {
                    //System.out.println(orderEvaluationPo.getPingjia());
                    CustomerOrderEvaluationMap.put(orderEvaluationPo.getOrderID(), orderEvaluationPo);
                }
            }
        }
        return CustomerOrderEvaluationMap;
    }

    @Override
    public Map<Integer, OrderPO> getCustomerOrderList(String customerID) {
        Map<Integer, OrderPO> customotOrderMap=new HashMap<>();
        Iterator<Map.Entry<Integer, OrderPO>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<Integer, OrderPO> entry = iterator.next();
            OrderPO orderPo = entry.getValue();
            if(orderPo.getCustomerID() .equals(customerID)){
                customotOrderMap.put(orderPo.getOrderID(),orderPo);
                //System.out.print(orderPo.getOrderID());
            }
        }



        return customotOrderMap;
    }

    @Override
    public Map<Integer, OrderPO> getHotelOrderList(String hotel) {
        Map<Integer, OrderPO> hotelOrderMap=new HashMap<>();
        Iterator<Map.Entry<Integer, OrderPO>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, OrderPO> entry = iterator.next();
            OrderPO orderPo = entry.getValue();
            if(orderPo.getHotel().equals(hotel)){
                hotelOrderMap.put(orderPo.getOrderID(),orderPo);
            }
        }
        return hotelOrderMap;
    }

    @Override
    public ArrayList<OrderPO> getUnexcutedOrderList() {
        map=orderDataHelper.getOrderData();
        ArrayList<OrderPO> list=new ArrayList<>();
        Iterator<Map.Entry<Integer, OrderPO>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, OrderPO> entry = iterator.next();
            OrderPO orderPo = entry.getValue();
            if(orderPo.getStatus().equals("未执行")){
                list.add(orderPo);
            }
        }
        return list;
    }
    @Override
    public ArrayList<OrderPO> getAbnormalOrderList() {
        map=orderDataHelper.getOrderData();
        ArrayList<OrderPO> list=new ArrayList<>();
        Iterator<Map.Entry<Integer, OrderPO>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, OrderPO> entry = iterator.next();
            OrderPO orderPo = entry.getValue();
            if(orderPo.getStatus().equals("异常")){
                list.add(orderPo);
            }
        }
        return list;
    }

    @Override
    public OrderEvaluationPO getOrderEvaluation(int orderID) {
        OrderEvaluationPO oepo=evaluationPOMap.get(orderID);
        return oepo;
    }

    @Override
    public Map<Integer, OrderEvaluationPO> updateOrderEvaluation(OrderEvaluationPO oepo) {
        evaluationPOMap=orderDataHelper.updateOrderEvaluation(oepo);
        return evaluationPOMap;
    }


    @Override
    public Map<Integer, OrderPO> insertOrder(OrderPO opo) {
        map=orderDataHelper.insertOrder(opo);
        try {
            CustomerPO cpo= CustomerDataServiceImpl.getInstance().getCustomer(opo.getCustomerID());
            JavaMail.sendEmail(cpo.getEmail(),"酒店预订成功","订单号： "+opo.getOrderID()+"  房间类型: "
                    +opo.getRoomID()+"  最晚入住时间: "+opo.getLastCheckInTime()+"  价格: "+opo.getCharge());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<Integer, OrderPO> deleteOrder(OrderPO opo) {
        map=orderDataHelper.deleteOrderByID(opo.getOrderID());
        return map;
    }

    @Override
    public Map<Integer, OrderPO> updateOrder(OrderPO opo) {
        map=orderDataHelper.updateOrder(opo);
        return map;
    }
}
