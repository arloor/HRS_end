package businesslogicservice.orderbusinesslogicservice;


import util.OrderType;
import util.ResultMessage;
import vo.OrderEvaluationVO;
import vo.OrderVO;

import java.util.Map;

/**
 * Created by ganghuan liu on 2016/10/16.
 */
public interface OrderBLservice {

    /**
     *新增一个订单
     * 前置条件：界面已经调用promotion的calculatePrice，把设定了charge的OrderVO传递给这个方法
     * 其中包含有判断客房数量是否足够和信用值大于零的逻辑分别调用room模块和cerdit模块
     * @param ovo
     * @return 如果房间数量不足 ResultMessage.NO_ENOUGH_ROOM
     * @return 如果信用值小于0 ResultMessage.CREDIT_LT_ZERO
     * @return ResultMessage.SUCCESS
     */
    public ResultMessage newOrder(OrderVO ovo);

    /**
     * 根据获得OrderBLService的不同Instance hotel/Customer
     * 获取酒店或者用户的订单列表
     * @return
     */
    public Map<Integer,OrderVO> getOrderVOList();

    /**
     * 根据获得OrderBLService的不同Instance hotel/Customer
     * 获取当前酒店或者用户的评价列表
     * @return
     */
    public Map<Integer,OrderEvaluationVO> getOrderEvaluationVOList();

    /**
     * 获取当前酒店的特定用户的订单列表，比如在汉廷酒店中获取属于arloor用户的订单列表
     * @param customerID
     * @return
     */
    public Map<Integer,OrderVO> getSpecificCustomerOrderList(String customerID);

    /**
     * 获取当前用户的特定酒店的订单列表，比如在arloor用户的订单中获取属于汉廷酒店的订单列表
     * @param hotelName
     * @return
     */
    public Map<Integer,OrderVO> getSpecificHotelOrderList(String hotelName);

    /**
     * 获取单个订单的信息
     * @param orderID
     * @return
     */
    public OrderVO getOrderInfo(int orderID);

    /**
     * 获取订单评价
     * @param OrderID
     * @return
     */
    public OrderEvaluationVO getOrderEvaluationByID(int OrderID);


    /**
     * 评价订单
     * @param oevo
     * @return
     */
    public ResultMessage evaluateOrder(OrderEvaluationVO oevo);

    /**
     * 执行订单
     * 包含调用cerdit模块的插入信用记录方法
     * @param orderID
     * @return
     */
    public boolean executeOrder(int orderID);

    /**
     * 可以取消未执行的异常订单，返回true
     * 当要取消的订单为异常订单时，返回false
     * @param orderID
     * @return ResultMessage.CREDIT_DECRESE(信用值被扣出的情况)
     *          ORDER_ABNORMAL(订单异常，不能被用户取消的情况，按理说这种情况是不可能出现的@段梦洋可以忽略这种)
     *          SUCCESS（不扣出信用值的情况）
     */
    public ResultMessage cancelOrder(int orderID);

    /**
     * 更新入住信息
     * @param orderID
     * @param time
     * @return
     */
    public boolean updateCheckinInfo(int orderID, String time);

    /**
     * 更新退房信息
     * @param orderID
     * @param time
     * @return
     */
    public boolean updateCheckoutInfo(int orderID, String time);

    /**
     * 获取当前酒店或者用户某一种类型的订单
     * @param type
     * @return
     */
    public Map<Integer,OrderVO> getOrderListByType(OrderType type);

    /**
     * 获取当前酒店（用户）的某一用户（某一酒店）的特定类型的订单
     * @param type
     * @return
     */
    public Map<Integer,OrderVO> getSpecificOrderListByType(OrderType type, String name);

}
