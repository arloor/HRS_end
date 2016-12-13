import businesslogic.orderbl.OrderImpl;
import org.junit.*;
import util.OrderType;
import vo.OrderEvaluationVO;
import vo.OrderVO;

import java.util.Map;

/** 
* OrderImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 2, 2016</pre> 
* @version 1.0 
*/ 
public class HotelOrderImplTest {
    OrderImpl order= OrderImpl.getHotelOrderInstance("汉廷");

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getOrderVOList() 
* 
*/ 
    @Test
    public void testGetOrderVOList() throws Exception {
        Map<Integer, OrderVO> map=order.getOrderVOList();
        Assert.assertEquals("arlo",map.get(2).getCustomerID());
    }

    @Test
    public void testGetOrderEvaluationVOList() throws Exception {
        Map<Integer, OrderEvaluationVO> map=order.getOrderEvaluationVOList();
        Assert.assertEquals("为了测试",map.get(5).getPingjia());
    }




/** 
* 
* Method: getOrderEvaluationByID(int OrderID) 
* 
*/ 
@Test
public void testGetOrderEvaluationByID() throws Exception {
    OrderEvaluationVO oevo=order.getOrderEvaluationByID(4);
    Assert.assertEquals("啊",oevo.getPingjia());
}

/** 
* 
* Method: getSpecificCustomerOrderList(String customerID) 
* 
*/ 
@Test
public void testGetSpecificCustomerOrderList() throws Exception {
    Map<Integer, OrderVO> map=order.getSpecificCustomerOrderList("arloor");
    Assert.assertNull(map.get(2));
    Assert.assertEquals("大床房",map.get(1).getRoomID());
} 



/** 
* 
* Method: getOrderInfo(int orderID) 
* 
*/ 
@Test
public void testGetOrderInfo() throws Exception { 
//TODO: Test goes here...
    OrderVO ovo=order.getOrderInfo(1);
    Assert.assertEquals("未执行",ovo.getStatus());
    Assert.assertEquals("大床房",ovo.getRoomID());

    Assert.assertNull(order.getOrderInfo(6));
} 

/** 
* 
* Method: newOrder(OrderVO ovo) 
* 
*/ 
@Test
@Ignore
public void testNewOrder() throws Exception { 
//TODO: Test goes here... 
} 



/** 
* 
* Method: updateCheckinInfo(int orderID, String time) 
* 
*/ 
@Test

public void testUpdateCheckinInfo() throws Exception { 
//TODO: Test goes here...
    order.updateCheckinInfo(2, "2000-04-21 12:00:00");
} 

/** 
* 
* Method: updateCheckoutInfo(int orderID, String time) 
* 
*/ 
@Test
public void testUpdateCheckoutInfo() throws Exception {
    order.updateCheckoutInfo(3, "2019-04-21 12:00:00");
//TODO: Test goes here... 
} 

/** 
* 
* Method: getOrderListByType(OrderType type) 
* 
*/ 
@Test
public void testGetOrderListByType() throws Exception { 
//TODO: Test goes here...
    Map<Integer, OrderVO> map1 =order.getOrderListByType(OrderType.Executed);
    Assert.assertNull(map1.get(3));
    Map<Integer, OrderVO> map2 =order.getOrderListByType(OrderType.Unexecuted);
    Assert.assertNull(map2.get(2));
} 

/** 
* 
* Method: getSpecificOrderListByType(OrderType type) 
* 
*/ 
@Test
public void testGetSpecificOrderListByType() throws Exception { 
//TODO: Test goes here...
    Map<Integer, OrderVO> map1 =order.getOrderListByType(OrderType.Abnormol);
    Assert.assertNull(map1.get(6));
    Assert.assertEquals("2016-11-24 08:08:08",map1.get(7).getLastCheckInTime());
} 

/** 
* 
* Method: executeOrder(int orderID) 
* 
*/ 
@Test
@Ignore
public void testExecuteOrder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: cancelOrder(int orderID) 
* 
*/ 
@Test
@Ignore
public void testCancelOrder() throws Exception { 
//TODO: Test goes here... 
} 


} 
