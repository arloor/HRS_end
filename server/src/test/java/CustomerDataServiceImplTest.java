import dataService.customerdataservice.CustomerDataservice;
import dataServiceImpl.CustomerDataServiceImpl;
import org.junit.*;
import po.CustomerPO;
import util.ResultMessage;

/**
* CustomerDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 8, 2016</pre> 
* @version 1.0 
*/ 
public class CustomerDataServiceImplTest {
    CustomerDataservice customerDataservice= CustomerDataServiceImpl.getInstance();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/** 
* 
* Method: find(String userName, String password) 
* 
*/ 
@Test
@Ignore
public void testFind() throws Exception { 
//TODO: Test goes here...
    ResultMessage resultMessage=customerDataservice.find("123456","18762832143");
    Assert.assertEquals(ResultMessage.USER_EXIST,resultMessage);
} 

/** 
* 
* Method: insert(CustomerPO po) 
* 
*/ 
@Test
@Ignore
public void testInsert() throws Exception {
    CustomerPO cpo=customerDataservice.getCustomer("arloor");
    cpo.setUserName("arloor1");
    customerDataservice.insert(cpo);
//TODO: Test goes here... 
} 

/** 
* 
* Method: update(CustomerPO po) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here...
    CustomerPO cpo=customerDataservice.getCustomer("123456");
    cpo.setPassword("123456");
    customerDataservice.update(cpo);
    cpo=customerDataservice.getCustomer("123456");
    System.out.println("密码是"+cpo.getPassword());
} 

/** 
* 
* Method: getCustomer(String userName) 
* 
*/ 
@Test
public void testGetCustomer() throws Exception { 
//TODO: Test goes here...
    CustomerPO cpo=customerDataservice.getCustomer("123456");
    Assert.assertEquals("15465461156",cpo.getPhoneNumber());
    //Assert.assertEquals("刘港欢",cpo.getCustomerName());
} 


} 
