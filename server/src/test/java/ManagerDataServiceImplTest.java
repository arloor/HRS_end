import dataFactory.DataFactory;
import dataFactory.ManagerDataHelper;
import dataServiceImpl.ManagerDataServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* ManagerDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 7, 2016</pre> 
* @version 1.0 
*/ 
public class ManagerDataServiceImplTest {

    private static ManagerDataServiceImpl managerDao;
    private DataFactory dataFactory;
    private ManagerDataHelper managerDataHelper;

    @Before
    public void setUp() throws Exception {
        managerDao = ManagerDataServiceImpl.getInstance();
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
        ManagerPO mpo = new ManagerPO(ManagerType.WebSalesMan, "test01", "abc123", "15058586190", null);
        boolean result = managerDao.insertManager(mpo);
        if(result == true) {
            System.out.println("添加管理人员成功！");
        }else {
            System.out.println("添加管理人员失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateManagerInfo() {
        /*
        ManagerPO mpo = new ManagerPO(ManagerType.HotelWorker, "abc456", "abc", "15058586100", null);
        boolean result = managerDao.updateManagerInfo(mpo);
        if(result == true) {
            System.out.println("修改管理人员信息成功！");
        }else {
            System.out.println("修改管理人员信息失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindManagerInfo() {
        /*
        ManagerPO mpo = managerDao.findManagerInfo(ManagerType.WebManager, "manager");
        System.out.println(mpo.getManagerType().toString() + " " + mpo.getUsername() + " " + mpo.getPassword() + " " + mpo.getPhoneNumber() + " " + mpo.getHotelName());
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testCheck() {
        /*
        ResultMessage resultMessage = managerDao.check(ManagerType.WebManager, "manager", "123456");
        if(resultMessage == ResultMessage.USER_NOT_EXIST) {
            System.out.println("用户名不存在！");
        }else if(resultMessage == ResultMessage.WRONG_PASSWORD) {
            System.out.println("密码错误！");
        }else if(resultMessage == ResultMessage.USER_EXIST) {
            System.out.println("登陆成功！");
        }
        */
    }

} 
