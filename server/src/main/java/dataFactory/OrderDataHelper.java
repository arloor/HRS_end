package dataFactory;

import po.OrderEvaluationPO;
import po.OrderPO;

import java.util.Map;

/**
 * Created by arloor on 16-11-18.
 */
public interface OrderDataHelper {

    public Map<Integer, OrderPO> getOrderData();
    public Map<Integer, OrderEvaluationPO> getEvaluation();



    /**
     *感觉不是Datahelper的东向西了
     * @param orderID
     * @return
     */
    //public OrderEvaluationPO getOrderEvaluationByID(int orderID);

    /**
     *
     * @param oepo
     * @return
     */
    public Map<Integer, OrderEvaluationPO> updateOrderEvaluation(OrderEvaluationPO oepo);
    //public ResultMessage insertOrderEvaluation(OrderEvaluationPO oepo);

    /**
     * 在数据库中插入一个opo
     * @param opo
     * @return
     */
    public Map<Integer, OrderPO>  insertOrder(OrderPO opo);
    /**
     * 撤销而不是真的删除
     * @param OrderID
     * @return
     */
    public Map<Integer, OrderPO> deleteOrderByID(int OrderID);
    public Map<Integer, OrderPO>  updateOrder(OrderPO opo);
    //public ResultMessage getOrderByID(int OrderID);
}
