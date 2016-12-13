package dataFactory;

import po.ManagerPO;
import util.ManagerType;

import java.util.Map;

/**
 * Created by arloor on 16-11-22.
 */
public interface ManagerDataHelper {

    /**
     * 向数据库读取一类管理人员信息
     * @param managerType
     * @return
     */
    public Map<String, ManagerPO> findManagerInfo(ManagerType managerType);

    /**
     * 向数据库写入管理人员信息
     * @param mpo
     */
    public void updateManagerInfo(ManagerPO mpo);

    /**
     * 向数据库插入管理人员信息
     * @param mpo
     */
    public void insertManager(ManagerPO mpo);

}
