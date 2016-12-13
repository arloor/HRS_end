package businesslogicservice.customerblservice;

import util.ResultMessage;
import vo.CustomerVO;

/**
 * Created by njulgh on 16-11-24.
 */
public interface CustomerBLService {
    public CustomerVO getCustomerInfo(String userName);

    /**
     * 用户登录的判断逻辑
     * @param userName
     * @param password
     * @return 用户名和密码对应则返回ResultMessage.SUCCESS
     * @return 用户不存在返回 USER_NOT_EXIST
     * @return 用户存在但密码错误返回 WRONG_PASSWORD
     */
    public ResultMessage login(String userName, String password);

    /**
     * login方法（就是上面的那个）的后续步骤，用于得到CustomerVO
     * @param userName
     * @return CustomerVO
     */
    public CustomerVO successLog(String userName);


    /**
     * 新增一个用户
     * 为了在以后调用Credit模块时有credit初始值，在此逻辑中将新用户的信用值设置为100
     * @param vo
     * @return  插入失败说明用户名已经存在，返回ResultMessage.USER_EXIT
     * @return 插入成功返回ResultMessage.SUCCESS
     */
    public ResultMessage addCustomer(CustomerVO vo);

    /**
     * 修改用户信息
     * @param vo
     * @return 用户不存在返回ResultMessage.USER_NOT_EXIT 这种情况应该不存在
     * @return ResultMessage.SUCCESS 或者ResultMessage.FAILED
     */
    public ResultMessage changeCustomerInfo(CustomerVO vo);
}
