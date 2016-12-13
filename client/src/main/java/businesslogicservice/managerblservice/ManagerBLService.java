package businesslogicservice.managerblservice;


import util.ManagerType;
import util.ResultMessage;
import vo.ManagerVO;

/**
 * Created by 曹利航 on 2016/10/16 15:46.
 */
public interface ManagerBLService {

    /**
     * 获得管理人员信息
     * @param managerType
     * @param username
     * @return ManagerVO
     */
    public ManagerVO getManagerInfo(ManagerType managerType, String username);

    /**
     * 添加管理人员
     * @param mvo
     * @return
     */
    public ResultMessage addManager(ManagerVO mvo);

    /**
     * 修改管理人员信息
     * @param mvo
     * @return
     */
    public ResultMessage changeManagerInfo(ManagerVO mvo);

    /**
     * 管理人员登录
     * @param managerType
     * @param username
     * @param password
     * @return
     */
    public ResultMessage login(ManagerType managerType, String username, String password);

}
