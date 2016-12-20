import businesslogic.creditbl.Credit;
import businesslogic.orderbl.OrderImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import po.CreditInfoPO;
import vo.CreditVO;

import java.util.List;

/** 
* Credit Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 7, 2016</pre> 
* @version 1.0 
*/ 
public class CreditTest {
    Credit credit=new Credit("arloor");

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getCustomerCreditInfo(String userName) 
* 
*/ 
@Test@Ignore
public void testGetCustomerCreditInfo() throws Exception { 
//TODO: Test goes here...
    List<CreditVO> list=credit.getCustomerCreditInfo("arloor");
    for (CreditVO cell: list
         ) {
        System.out.println(cell.getCreditChangeType()+" "+cell.getTime()+" "+cell.getChange()+" "+cell.getNumCredit()+" "+cell.getOrderID());
    }
} 

/** 
* 
* Method: getCustomerLevel(String userName, ArrayList<String> levelPromotions) 
* 
*/ 
@Test
@Ignore
public void testGetCustomerLevel() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getNumCredit(String userName) 
* 
*/ 
@Test@Ignore
public void testGetNumCredit() throws Exception { 
//TODO: Test goes here...
    System.out.println("用户arloor的信用值是"+credit.getNumCredit("arloor"));
} 

/** 
* 
* Method: updateCustomerCreditInfo(String userName, CreditVO creditVO, OrderVO orderVO) 
* 
*/ 
@Test
@Ignore
public void testUpdateCustomerCreditInfo() throws Exception { 
//TODO: Test goes here...
    credit.updateCustomerCreditInfo("arloor",new CreditVO(new CreditInfoPO("arloor",600,"2017-01-01 12:00:00",1,4,1200)), OrderImpl.getMemberOrderInstance("arloor").getOrderInfo(4));
} 


} 
