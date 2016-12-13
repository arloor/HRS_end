package businesslogicservice.orderbusinesslogicservice;

import util.RecoveryType;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by njulgh on 16-12-6.
 */
public interface WebManagerOrderBLService {
    /**
     * 网站营销人员获取所有未执行订单
     * @return
     */
    public ArrayList<OrderVO> getUnexcutedOrderList();

    /**
     * 网站营销人员获取所有异常订单
     * @return
     */
    public ArrayList<OrderVO> getAbnormalOrderList();


    /**
     * 线下申诉成功后，网站营销人员恢复信用值的全部或者一半
     * 调用credit模块
     * @param orderID
     * @param recoveryType
     */
    public void cancelAbnormalOrder(int orderID, RecoveryType recoveryType);

    /**
     * 获得异常订单，如果存在则返回orderVO否则返回null
     * @param orderID
     * @return
     */
    public OrderVO getAbnomalOrder(int orderID);
}
