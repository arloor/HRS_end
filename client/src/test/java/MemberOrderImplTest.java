import businesslogic.creditbl.Credit;
import businesslogic.customerbl.Customer;
import businesslogic.orderbl.OrderImpl;
import businesslogic.orderbl.OrderProcesser;
import org.junit.*;
import vo.CustomerVO;
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
public class MemberOrderImplTest {
    OrderImpl order = OrderImpl.getMemberOrderInstance("arloor");

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
@Test@Ignore
public void testGetOrderVOList() throws Exception {
    Map<Integer, OrderVO> map=order.getOrderVOList();
    Assert.assertNull(map.get(2));
    Assert.assertEquals("2016-11-30 10:11:12",map.get(1).getLastCheckInTime());
} 

/** 
* 
* Method: getOrderEvaluationVOList() 
* 
*/ 
@Test@Ignore
public void testGetOrderEvaluationVOList() throws Exception {
    Map<Integer, OrderVO> map=order.getOrderVOList();

    Assert.assertNull(map.get(2));
    Assert.assertNull(map.get(8));

    Assert.assertEquals("1997-04-21 12:00:00",map.get(4).getLastCheckInTime());

} 

/** 
* 
* Method: getOrderEvaluationByID(int OrderID) 
* 
*/ 
@Test@Ignore
public void testGetOrderEvaluationByID() throws Exception {

    OrderEvaluationVO oevo = order.getOrderEvaluationByID(2);
    Assert.assertNull(oevo);
    OrderEvaluationVO oevo1 = order.getOrderEvaluationByID(3);
    Assert.assertEquals("嘻", oevo1.getPingjia());
}

/** 
* 
* Method: getSpecificHotelOrderList(String hotelName) 
* 
*/ 
@Test@Ignore
public void testGetSpecificHotelOrderList() throws Exception { 

    Map<Integer, OrderVO> map=order.getSpecificHotelOrderList("如家");
    Assert.assertNull(map.get(7));
    Assert.assertNull(map.get(2));
} 

/** 
* 
* Method: getOrderInfo(int orderID) 
* 
*/ 
@Test@Ignore
public void testGetOrderInfo() throws Exception { 

    OrderVO ovo=order.getOrderInfo(1);
    Assert.assertEquals("未执行",ovo.getStatus());
}

    /**
     *
     * Method: cancelOrder(int orderID)
     *
     */
    @Test
    public void testCancelOrder1() throws Exception {
//TODO: Test goes here...
        order.cancelOrder(3);
        Credit credit=new Credit("arloor");
        double oldCreditNum=credit.getNumCredit("arloor");

        //判断是否将状态设为已撤销状态
        Assert.assertEquals(order.getOrderInfo(3).getStatus(),"已撤销");
        double newCredit=credit.getNumCredit("arloor");
        //判断信用值变化（应该不发生变化）
        Assert.assertEquals(oldCreditNum,newCredit);
    }

    /**
     *
     * Method: cancelOrder(int orderID)
     *
     */
    @Test
    public void testCancelOrder2() throws Exception {
//TODO: Test goes here...
        order.cancelOrder(4);
        Credit credit=new Credit("arloor");
        double oldCreditNum=credit.getNumCredit("arloor");

        //判断是否将状态设为已撤销状态
        Assert.assertEquals(order.getOrderInfo(4).getStatus(),"已撤销");
        double newCredit=credit.getNumCredit("arloor");
        //判断信用值变化（应该发生变化）
        Assert.assertEquals(oldCreditNum,newCredit-order.getOrderInfo(4).getCharge()*0.5);
    }

    /**
* 
* Method: newOrder(OrderVO ovo) 
* 
*/ 
@Test@Ignore
public void testNewOrder() throws Exception { 
    order.newOrder(new OrderVO(OrderProcesser.getOrderID(),"aser","汉廷","未执行","大床房",1,1,"yes","2016-12-12 12:12:12",
            "546","2016-12-13 13:13:13","4564",250,200,200));

} 

/** 
* 
* Method: evaluateOrder(OrderEvaluationVO oevo) 
* 
*/ 
@Test@Ignore
public void testEvaluateOrder() throws Exception { 
//TODO: Test goes here...
    OrderEvaluationVO oevo =new OrderEvaluationVO(9,5,"buaaaaaacuo");
    order.evaluateOrder(oevo);

} 

/** 
* 
* Method: updateCheckinInfo(int orderID, String time) 
* 
*/ 
@Test@Ignore
public void testUpdateCheckinInfo() throws Exception { 
//TODO: Test goes here...
    order.updateCheckinInfo(4, "2100-04-21 12:00:00");
} 

/** 
* 
* Method: updateCheckoutInfo(int orderID, String time) 
* 
*/ 
@Test@Ignore
public void testUpdateCheckoutInfo() throws Exception { 
//TODO: Test goes here...
    order.updateCheckoutInfo(4, "2000-04-21 12:00:00");
} 

/** 
* 
* Method: getOrderListByType(OrderType type) 
* 
*/ 
@Test@Ignore
public void testGetOrderListByType() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSpecificOrderListByType(OrderType type) 
* 
*/ 
@Test@Ignore
public void testGetSpecificOrderListByType() throws Exception { 
//TODO: Test goes here... 
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
    order.executeOrder(4);
} 




} 
