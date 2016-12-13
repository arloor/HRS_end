import dataFactory.impl.ManagerMysqlDataHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.ManagerPO;
import util.ManagerType;

import java.util.ArrayList;
import java.util.Map;

/** 
* ManagerMysqlDataHelper Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 7, 2016</pre> 
* @version 1.0 
*/ 
public class ManagerMysqlDataHelperTest {

    private Map<String, ManagerPO> hotelWorkerPOMap;

    private Map<String, ManagerPO> webSalesManPOMap;

    private Map<String, ManagerPO> webManagerPOMap;

    private ManagerMysqlDataHelper managerMysqlDataHelper = new ManagerMysqlDataHelper();

    @Before
    public void setUp() throws Exception {
        hotelWorkerPOMap = managerMysqlDataHelper.findManagerInfo(ManagerType.HotelWorker);
        webSalesManPOMap = managerMysqlDataHelper.findManagerInfo(ManagerType.WebSalesMan);
        webManagerPOMap = managerMysqlDataHelper.findManagerInfo(ManagerType.WebManager);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test
    public void testInsertManager() {
        /*
        ManagerPO mpo = new ManagerPO(ManagerType.HotelWorker, "worker02", "123456", "15050586168", "南京英尊假日酒店");
        managerMysqlDataHelper.insertManager(mpo);
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateManagerInfo() {
        /*
        ManagerPO mpo = new ManagerPO(ManagerType.WebSalesMan, "salesMan02", "1234567890", "15050586180", null);
        managerMysqlDataHelper.updateManagerInfo(mpo);
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindManagerInfo() {
        /*
        Map<String, ManagerPO> managerPOMap = managerMysqlDataHelper.findManagerInfo(ManagerType.WebSalesMan);
        ArrayList<ManagerPO> managerPOList = new ArrayList<ManagerPO>(managerPOMap.values());
        for(int i = 0; i < managerPOList.size(); i++) {
            ManagerPO mpo = managerPOList.get(i);
            System.out.println(mpo.getUsername() + " " + mpo.getPassword() + " " + mpo.getPhoneNumber() + " " + mpo.getHotelName());
        }
        */
    }

} 
