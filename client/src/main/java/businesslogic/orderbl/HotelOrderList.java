package businesslogic.orderbl;

import po.OrderEvaluationPO;
import po.OrderPO;
import util.OrderType;
import util.ResultMessage;
import vo.OrderEvaluationVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by njulgh on 16-11-27.
 */
public class HotelOrderList extends OrderList {
    private String hotelName;

    public HotelOrderList(String name) {
        super();

        hotelName=name;


        setOrderVOlist(name);
        setOrderEvaluationVOList(name);

    }

    @Override
    public void setOrderVOlist(String name) {
        Map<Integer,OrderVO> map=new HashMap<>();
        Map<Integer, OrderPO> orderPOMap= null;
        try {
            orderPOMap = orderDao.getHotelOrderList(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //System.out.println("OrderPO有"+orderPOMap.entrySet().size());
        Iterator<Map.Entry<Integer, OrderPO>> orderIterator = orderPOMap.entrySet().iterator();
        while(orderIterator.hasNext()){
            Map.Entry<Integer, OrderPO> entry = orderIterator.next();
            OrderPO orderPo = entry.getValue();
            OrderVO orderVO=new OrderVO(orderPo);
            map.put(orderVO.getOrderID(),orderVO);

        }
        orderVOList=map;
    }

    @Override
    public void setOrderEvaluationVOList(String name) {
        Map<Integer,OrderEvaluationVO> map=new HashMap<>();
        Map<Integer, OrderEvaluationPO> orderEvaluationPOMap= null;
        try {
            orderEvaluationPOMap = orderDao.getHotelEvalvation(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Iterator<Map.Entry<Integer, OrderEvaluationPO>> evaluationIterator = orderEvaluationPOMap.entrySet().iterator();
        while(evaluationIterator.hasNext()){
            Map.Entry<Integer, OrderEvaluationPO> entry = evaluationIterator.next();
            OrderEvaluationPO orderEvaluationPo = entry.getValue();
            OrderEvaluationVO orderEvaluationVO=new OrderEvaluationVO(orderEvaluationPo);
            map.put(orderEvaluationVO.getOrderID(),orderEvaluationVO);
        }
        this.orderEvaluationVOList=map;
    }

    @Override
    public Map<Integer, OrderVO> getOrderVOlist() {
        //首先更新一下现在的orderMap
        setOrderVOlist(hotelName);
        return orderVOList;
    }

    @Override
    public Map<Integer, OrderEvaluationVO> getOrderEvaluationVOList() {
        setOrderEvaluationVOList(hotelName);
        return orderEvaluationVOList;
    }

    @Override
    public OrderLineItem getOrder(int OrderID) {
        return super.getOrder(OrderID);
    }

    @Override
    public void newOrder(OrderVO ovo) {
        super.newOrder(ovo);
        setOrderVOlist(hotelName);
    }

    /**
     * tag为用户名
     * @param tag
     * @return
     */
    @Override
    public Map<Integer, OrderVO> getSpecificOrderVoList(String tag) {
        Map<Integer,OrderVO> map=new HashMap<>();
        Iterator<Map.Entry<Integer,OrderVO>> iterator =orderVOList.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,OrderVO> orderVOEntry=iterator.next();
            OrderVO ovo=orderVOEntry.getValue();
            if(ovo.getCustomerID().equals(tag)){
                map.put(ovo.getOrderID(),ovo);
            }
        }
        return map;
    }

    @Override
    public void updateCheckinInfo(int orderID, String time) {
        super.updateCheckinInfo(orderID, time);
        setOrderVOlist(hotelName);
    }

    @Override
    public ResultMessage cancelOrder(int orderID) {
        oListItem=getOrder(orderID);
        if(oListItem.ovo.getStatus().equals("异常"))
            return ResultMessage.ORDER_ABNORMAL;
        else{
            ResultMessage resultMessage=oListItem.cancelOrder(oListItem.ovo);
            setOrderVOlist(hotelName);
            return resultMessage;
        }
    }

    @Override
    public void updateCheckoutInfo(int orderID, String time) {
        super.updateCheckoutInfo(orderID, time);
        setOrderVOlist(hotelName);
    }

    @Override
    public void evaluateOrder(OrderEvaluationPO oepo) {
        super.evaluateOrder(oepo);
        setOrderEvaluationVOList(hotelName);
    }

    @Override
    public Map<Integer, OrderVO> getSpecificOrderListByType(OrderType type,String name) {
        Map<Integer,OrderVO> map=getSpecificOrderVoList(name);
        Map<Integer,OrderVO> mapByType=getSomeTypeOrderList(type,map);
        return mapByType;
    }
}
