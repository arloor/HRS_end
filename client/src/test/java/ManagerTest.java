import businesslogic.managerbl.Manager;
import businesslogicservice.managerblservice.ManagerBLService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Manager Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 8, 2016</pre> 
* @version 1.0 
*/ 
public class ManagerTest {

    ManagerBLService managerBLService = new Manager();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test
    public void testAddManager() {
        /*
        ManagerVO mvo = new ManagerVO(ManagerType.WebSalesMan, "test", "abcde", "15050586100", null);
        ResultMessage resultMessage = managerBLService.addManager(mvo);
        if(resultMessage == ResultMessage.SUCCESS) {
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
    public void testChangeManagerInfo() {
        /*
        ManagerVO mvo = new ManagerVO(ManagerType.HotelWorker, "abc45", "abcde", "15050586108", null);
        ResultMessage resultMessage = managerBLService.changeManagerInfo(mvo);
        if(resultMessage == ResultMessage.SUCCESS) {
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
    public void testGetManagerInfo() {
        /*
        ManagerVO mvo = managerBLService.getManagerInfo(ManagerType.WebManager, "manager");
        System.out.println(mvo.getManagerType().toString() + " " + mvo.getUsername() + " " + mvo.getPassword() + " " + mvo.getPhoneNumber() + " " + mvo.getHotelName());
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testLogin() {
        /*
        ResultMessage resultMessage = managerBLService.login(ManagerType.WebManager, "manager", "123456");
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
