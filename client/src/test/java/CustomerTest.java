import businesslogic.customerbl.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.CustomerType;
import util.ResultMessage;
import vo.CustomerVO;

/** 
* Customer Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 8, 2016</pre> 
* @version 1.0 
*/ 
public class CustomerTest {
    Customer customer=new Customer();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getCustomerInfo(String userName) 
* 
*/ 
@Test
public void testGetCustomerInfo() throws Exception {
    CustomerVO cvo=customer.getCustomerInfo("123456");
    Assert.assertEquals("15465461156",cvo.getPhoneNumber());
    Assert.assertEquals("测试",cvo.getCustomerName());
    Assert.assertEquals("newPassword2",cvo.getPassword());
} 

/** 
* 
* Method: login(String userName, String password) 
* 
*/ 
@Test
public void testLogin() throws Exception {
    ResultMessage resultMessage=customer.login("aser","www.arloor.com");
    System.out.println(resultMessage);
} 

/** 
* 
* Method: successLog(String userName) 
* 
*/ 
@Test
public void testSuccessLog() throws Exception {
    CustomerVO cvo=customer.getCustomerInfo("123456");
    Assert.assertEquals("newPassword2",cvo.getPassword());
} 

/** 
* 
* Method: addCustomer(CustomerVO vo) 
* 
*/ 
@Test
public void testAddCustomer() throws Exception {
    ResultMessage resultMessage=customer.addCustomer(new CustomerVO("aser","www.arloor.com",
            "15050528280","李方悦", CustomerType.PERSONAL,"1997-05-23","792534691@qq.com"));
    Assert.assertEquals(ResultMessage.USER_EXIST,resultMessage);
}

/** 
* 
* Method: changeCustomerInfo(CustomerVO vo) 
* 
*/ 
@Test
public void testChangeCustomerInfo() throws Exception {
    CustomerVO cvo1=new CustomerVO("a1565","123456789","18700000000","刘", CustomerType.PERSONAL,"1995","1335@49489");
    ResultMessage resultMessage1=customer.changeCustomerInfo(cvo1);
    Assert.assertEquals(ResultMessage.USER_NOT_EXIST,resultMessage1);

    CustomerVO cvo2=new CustomerVO("123456","newPassword2","15465461156","测试", CustomerType.PERSONAL,"1995-05-25","1335@49489");
    ResultMessage resultMessage2=customer.changeCustomerInfo(cvo2);
    Assert.assertEquals(ResultMessage.SUCCESS,resultMessage2);
}


}
