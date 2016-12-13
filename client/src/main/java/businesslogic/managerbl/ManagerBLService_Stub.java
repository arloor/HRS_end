package businesslogic.managerbl;


import businesslogicservice.managerblservice.ManagerBLService;
import util.ManagerType;
import util.ResultMessage;
import vo.ManagerVO;

/**
 * Created by 曹利航 on 2016/10/16 17:25.
 */
public class ManagerBLService_Stub implements ManagerBLService {

    @Override
    public ResultMessage addManager(ManagerVO vo) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage changeManagerInfo(ManagerVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * @param type
     * @param username
     * @param password
     * @return ResultMessage.FAILED when username is "DEY", ResultMessage.SUCCESS otherwise.
     */
    @Override
    public ResultMessage login(ManagerType type, String username, String password) {
        if (username.equals("DEY")) {
            return ResultMessage.FAILED;
        }
        return ResultMessage.SUCCESS;
    }

    @Override
    public ManagerVO getManagerInfo(ManagerType managerType, String username) {
        return null;
    }
}
