import dataFactory.impl.OrderMysqlDataHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import po.OrderEvaluationPO;
import po.OrderPO;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/** 
* OrderMysqlDataHelper Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 25, 2016</pre> 
* @version 1.0 
*/ 
public class OrderMysqlDataHelperTest {
    Map<Integer, OrderPO> map;
    Map<Integer, OrderEvaluationPO> orderEvaluationPOMap;
    OrderMysqlDataHelper orderMysqlDataHelper=new OrderMysqlDataHelper();



@Before
public void setUp(){
    map=orderMysqlDataHelper.getOrderData();
    orderEvaluationPOMap=orderMysqlDataHelper.getEvaluation();
}

@After
public void after() throws Exception { 
}





/** 
* 
* Method: updateOrderEvaluation(OrderEvaluationPO oepo) 
* 
*/ 
@Test@Ignore
public void testUpdateOrderEvaluation() throws Exception { 
//TODO: Test goes here...
    OrderEvaluationPO oepo=new OrderEvaluationPO(2,4.0,"天啦");
    OrderEvaluationPO oldOepo1=orderEvaluationPOMap.get(2);

    orderEvaluationPOMap=orderMysqlDataHelper.updateOrderEvaluation(oepo);
    assertEquals("天啦",orderEvaluationPOMap.get(2).getPingjia());
    assertEquals(4.0,orderEvaluationPOMap.get(2).getPingfen(),0);


    //还原数据库
    orderEvaluationPOMap=orderMysqlDataHelper.updateOrderEvaluation(oldOepo1);
}


/** 
* 
* Method: insertOrder(OrderPO opo) 
* 
*/ 
@Test@Ignore
public void testInsertOrder() throws Exception { 
//TODO: Test goes here...
    int OrderID= MockOrderProcesser.getOrderID();
    //System.out.println(OrderID);
    OrderPO opo=new OrderPO(OrderID,"arlo","如家","未执行","大床房",4,5,"no","2016-11-30 10:11:12",null,"2016-12-30 12:00:00",null,380,300,3000);

    /*OrderPO opo=map.get(6);
    opo.setOrderID(OrderID);
    opo.setCheckOutTime(null);
    */
    map=orderMysqlDataHelper.insertOrder(opo);

    OrderPO newopo=map.get(OrderID);


    //System.out.println(newopo.getOrderID());
    //assertEquals(OrderID,newopo.getOrderID(),0);
    assertEquals(opo.getStatus(),newopo.getStatus());
    assertEquals(opo.getRoomID(),newopo.getRoomID());
    assertEquals(opo.getRoomNum(),newopo.getRoomNum(),0);
    assertEquals("1970-01-01 00:00:01",newopo.getCheckOutTime());


} 

/** 
* 
* Method: deleteOrderByID(int OrderID) 
* 
*/ 
@Test@Ignore
public void testDeleteOrderByID() throws Exception {
//TODO: Test goes here...
    OrderPO oldopo=map.get(2);
    map=orderMysqlDataHelper.deleteOrderByID(2);
    assertEquals("已撤销",map.get(2).getStatus());

    //恢复数据库,顺便测试updateOrder
    map=orderMysqlDataHelper.updateOrder(oldopo);
    assertEquals("已执行",map.get(2).getStatus());
} 

/** 
* 
* Method: updateOrder(OrderPO opo) 
* 
*/

@Test@Ignore
public void testUpdateOrder() throws Exception { 
//TODO: Test goes here...
    OrderPO oldpo=map.get(3);
    OrderPO newpo=new OrderPO(3,"arloo","如家","未执行","标间",4,5,"no","2016-11-30 10:11:12","2016-11-30 10:11:12","2016-12-30 12:00:00","2000-04-21 12:00:00",380,300,3000);
    map=orderMysqlDataHelper.updateOrder(newpo);
    newpo=map.get(3);
    assertEquals("arloor",newpo.getCustomerID());
    assertEquals("汉廷",newpo.getHotel());
    assertEquals("未执行",newpo.getStatus());
    assertEquals("大床房",newpo.getRoomID());
    assertEquals("2016-11-30 10:11:12",newpo.getLastCheckInTime());
    assertEquals("2000-04-21 12:00:00",newpo.getCheckOutTime());
} 


} 
