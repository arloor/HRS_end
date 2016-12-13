import dataServiceImpl.CreditDataServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import po.CreditInfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
* CreditDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 7, 2016</pre> 
* @version 1.0 
*/ 
public class CreditDataServiceImplTest {
    CreditDataServiceImpl creditDao= CreditDataServiceImpl.getCreditDataServiceInstance();

    public CreditDataServiceImplTest() throws RemoteException {
    }

    @Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/** 
* 
* Method: getCustomerCredits() 
* 
*/ 
@Test
public void testGetCustomerCredits() throws Exception { 
//TODO: Test goes here...
    ArrayList<CreditInfoPO> list=creditDao.getCustomerCredits("arloor");
    for (CreditInfoPO cell:list
         ) {
        System.out.println(cell.getCreditChangeType()+" "+cell.getUserName()+" "+cell.getChange()+" "+cell.getTime()+" "+cell.getOrderID()+" "+cell.getNumCredit());
    }
} 

/** 
* 
* Method: insert(CreditInfoPO creditInfoPO) 
* 
*/ 
@Test
@Ignore
public void testInsert() throws Exception { 
//TODO: Test goes here...
    ArrayList<CreditInfoPO> list=creditDao.getCustomerCredits("arloor");
    CreditInfoPO creditInfoPO=list.get(0);
    creditInfoPO.setTime("1997-04-21 12:00:00");
    creditDao.insert(creditInfoPO);
} 


} 
