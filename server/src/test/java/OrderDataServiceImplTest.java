import dataFactory.DataFactory;
import dataFactory.OrderDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataServiceImpl.OrderDataServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import po.OrderEvaluationPO;
import po.OrderPO;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
* OrderDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 26, 2016</pre> 
* @version 1.0 
*/ 
public class OrderDataServiceImplTest {
    private Map<Integer, OrderPO> map;
    private Map<Integer, OrderEvaluationPO> evaluationPOMap;
    private static OrderDataServiceImpl orderDao;
    private DataFactory dataFactory;
    private OrderDataHelper orderDataHelper;




@Before
public  void before() throws Exception {
    orderDao= OrderDataServiceImpl.getInstance();
    if(map==null){
        dataFactory=new DataFactoryImpl() ;
        orderDataHelper=dataFactory.getOrderDataHelper();
        map=orderDataHelper.getOrderData();
        evaluationPOMap=orderDataHelper.getEvaluation();
    }
} 

@After
public void after() throws Exception { 
} 



/** 
* 
* Method: getOrderInfo(int orderID) 
* 
*/ 
@Test@Ignore

public void testGetOrderInfo() throws Exception { 

    OrderPO opo=orderDao.getOrderInfo(1);
    assertEquals("1970-01-01 00:00:01",opo.getCheckInTime());
} 

/** 
* 
* Method: getHotelEvalvation(String hotel) 
* 
*/ 
@Test@Ignore
public void testGetHotelEvalvation() throws Exception { 

    Map<Integer, OrderEvaluationPO> evaluationPOMap=orderDao.getHotelEvalvation("汉廷");
    assertEquals("very good",evaluationPOMap.get(1).getPingjia());
    assertNull(evaluationPOMap.get(7));//评价为空
    assertNull(evaluationPOMap.get(6));//不是此酒店
} 

/** 
* 
* Method: getCustomerOrderList(int customerID) 
* 
*/ 
@Test@Ignore
public void testGetCustomerOrderList() throws Exception {
    Map<Integer, OrderPO> map=orderDao.getCustomerOrderList("arloor");
    assertEquals("未执行",map.get(1).getStatus());
    assertEquals("汉廷",map.get(3).getHotel());
    assertNull(map.get(2));//不是此用户
} 

/** 
* 
* Method: getHotelOrderList(String hotel) 
* 
*/ 
@Test@Ignore
public void testGetHotelOrderList() throws Exception {
    Map<Integer, OrderPO> map=orderDao.getHotelOrderList("如家" );
    assertEquals("已撤销",map.get(6).getStatus());
    assertNull(map.get(7));//不是此用户
}

/**
*
* Method: getOrderEvaluation(String orderID)
* 
*/ 
@Test@Ignore
public void testGetOrderEvaluation() throws Exception { 
    OrderEvaluationPO orderEvaluationPO=orderDao.getOrderEvaluation(1);
    assertEquals("very good",orderEvaluationPO.getPingjia());
} 

/** 
* 
* Method: updateOrderEvaluation(OrderEvaluationPO oepo) 
* 
*/ 
@Test@Ignore
public void testUpdateOrderEvaluation() throws Exception {
    OrderEvaluationPO oepo =evaluationPOMap.get(1);
    OrderEvaluationPO newoepo=new OrderEvaluationPO(1,oepo.getPingfen(),"very good");
    orderDao.updateOrderEvaluation(newoepo);
    assertEquals(orderDao.getOrderEvaluation(1).getPingjia(),"very good");

    //恢复数据库
    orderDao.updateOrderEvaluation(oepo);
} 

/** 
* 
* Method: insertOrder(OrderPO opo) 
* 
*/ 
@Test@Ignore
public void testInsertOrder() throws Exception {
    int OrderID= MockOrderProcesser.getOrderID();
    OrderPO opo=new OrderPO(OrderID,"aser","莱阳老店","未执行","大床房",6,6,"no","2016-11-30 10:11:12",null,"2016-12-30 12:00:00","2016-12-30 10:11:12",380,300,3000);
    map=orderDao.insertOrder(opo);
    assertEquals("aser",map.get(OrderID).getCustomerID());
} 

/** 
* 
* Method: deleteOrder(OrderPO opo) 
* 简单委托就不测试了
*/ 
@Test
@Ignore
public void testDeleteOrder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateOrder(OrderPO opo) 
* 简单委托就不测试了
*/ 
@Test@Ignore
public void testUpdateOrder() throws Exception { 
//TODO: Test goes here...
    OrderPO opo =orderDao.getOrderInfo(4);

    opo.setCheckInTime("1997-04-21 12:00:00");
    opo.setCheckOutTime("1997-04-21 12:00:00");
    opo.setLastCheckInTime("1997-04-21 12:00:00");
    opo.setLastCheckoutTime("1997-04-21 12:00:00");
    orderDao.updateOrder(opo);
} 


} 
