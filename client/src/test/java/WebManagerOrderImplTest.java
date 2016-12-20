import businesslogic.orderbl.WebManagerOrderImpl;
import businesslogicservice.orderbusinesslogicservice.WebManagerOrderBLService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import util.RecoveryType;
import vo.OrderVO;

import java.util.ArrayList;

/** 
* WebManagerOrderImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 7, 2016</pre> 
* @version 1.0 
*/ 
public class WebManagerOrderImplTest {
    WebManagerOrderBLService order =new WebManagerOrderImpl();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUnexcutedOrderList() 
* 
*/ 
@Test@Ignore
public void testGetUnexcutedOrderList() throws Exception { 
//TODO: Test goes here...
    ArrayList<OrderVO> list=order.getUnexcutedOrderList();
    for (OrderVO ovo:list
         ) {
        System.out.println(ovo.getOrderID()+ovo.getCustomerID()+ovo.getStatus());
    }
} 

/** 
* 
* Method: getAbnormalOrderList() 
* 
*/ 
@Test@Ignore
public void testGetAbnormalOrderList() throws Exception { 
//TODO: Test goes here...
    ArrayList<OrderVO> list=order.getAbnormalOrderList();
    for (OrderVO ovo:list
            ) {
        System.out.println(ovo.getOrderID()+ovo.getCustomerID()+ovo.getStatus());
    }
} 

/** 
* 
* Method: cancelAbnormalOrder(int orderID, RecoveryType recoveryType) 
* 
*/ 
@Test@Ignore
public void testCancelAbnormalOrder() throws Exception {
    order.cancelAbnormalOrder(6, RecoveryType.HALF);
} 


} 
