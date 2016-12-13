package businesslogic.orderbl;

import businesslogic.creditbl.Credit;
import businesslogic.roombl.Room;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import po.OrderEvaluationPO;
import util.OrderType;
import util.ResultMessage;
import vo.AvailableRoomVO;
import vo.OrderEvaluationVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Map;

/**
 * OrderIMPL的更新（增加，删除，修改）都将所有orderList中的orderVOlist，orderEvaluationList更新了一下
 * 但是没有使用返回值
 * 即，每次界面值发布更新任务后，orderBL的处理都将自己保留持久话对象更新了（保持最新）
 * 只是界面需要手动getOrderList，才能更新界面保留的VOList
 *
 * @段梦样@曹利航
 */

/**
 * Created by arloor on 16-11-18.
 */
public class OrderImpl implements OrderBLservice {
    //更新以后不立即更新类中的orderlist，等需要的getOrderlist的时候再更新（new）
    //OrderDataService orderDao;

    OrderList orderList;
    OrderLineItem orderLineItem;
    private static String tag;
    private static OrderImpl order;


    private OrderImpl(String tag,String name){
        if(tag.equals("hotel")){
            System.out.println("为酒店"+name+"创建orderList对象");
            orderList=new HotelOrderList(name);
        }
        else {
            System.out.println("为用户"+name+"创建orderList对象");
            orderList = new MemberOrderList(name);
        }
        this.tag=tag;
    }



    public static OrderImpl getHotelOrderInstance(String hotelName){
        order = new OrderImpl("hotel",hotelName);
        return order;
    }

    public static OrderImpl getMemberOrderInstance(String memberID){
        order = new OrderImpl("member",memberID);
        return order;
    }

    @Override
    public Map<Integer, OrderVO> getOrderVOList() {
        return orderList.getOrderVOlist();
    }

    @Override
    public Map<Integer, OrderEvaluationVO> getOrderEvaluationVOList() {
        return orderList.getOrderEvaluationVOList();
    }

    /**
     * 1.0
     * @param OrderID
     * @return
     */
    @Override
    public OrderEvaluationVO getOrderEvaluationByID(int OrderID) {
        try {
            orderLineItem = orderList.getOrder(OrderID);
            OrderEvaluationVO oevo = orderLineItem.getOevo();
            return oevo;
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("orderLineItem空指针");
        }
        return null;
    }

    /*
    @Override
    public double getOrderPrice(OrderVO ovo) {
        double price =OrderLineItem.calPrice(ovo);

        return 0;
    }*/

    @Override
    public Map<Integer,OrderVO> getSpecificCustomerOrderList(String customerID) {
        return orderList.getSpecificOrderVoList(customerID);
    }

    @Override
    public Map<Integer,OrderVO> getSpecificHotelOrderList(String hotelName) {

        return orderList.getSpecificOrderVoList(hotelName);
    }

    @Override
    public OrderVO getOrderInfo(int orderID) {

        orderLineItem = orderList.getOrder(orderID);
        OrderVO ovo = orderLineItem.getOvo();
        return ovo;
    }



    @Override
    public ResultMessage newOrder(OrderVO ovo) {
        ArrayList<AvailableRoomVO> list=new Room().getAvailableRoomList(ovo.getHotel(),ovo.getLastCheckInTime(),ovo.getLastCheckoutTime());
        double creditNum =new Credit(ovo.getCustomerID()).getNumCredit(ovo.getCustomerID());
        if(creditNum<0){
            return ResultMessage.CREDIT_LT_ZERO;
        }
        boolean roomEnough=false;
        for (AvailableRoomVO room:list
             ) {
            if(room.getRoomType().equals(ovo.getRoomID())&&room.getRoomNum()>=ovo.getRoomNum()){
                roomEnough=true;
                break;
            }
        }
        if(roomEnough==false){
            return ResultMessage.NO_ENOUGH_ROOM;
        }
        orderList.newOrder(ovo);
        return ResultMessage.SUCCESS;
    }


    @Override
    public ResultMessage evaluateOrder(OrderEvaluationVO oevo) {
        OrderEvaluationPO oepo =new OrderEvaluationPO(oevo);
        orderList.evaluateOrder(oepo);
        return null;
    }

    @Override
    public boolean updateCheckinInfo(int orderID, String time) {
        orderList.updateCheckinInfo(orderID,time);
        return true;
    }


    @Override
    public boolean updateCheckoutInfo(int orderID, String time) {
        orderList.updateCheckoutInfo(orderID,time);
        return true;
    }

    @Override
    public Map<Integer, OrderVO> getOrderListByType(OrderType type) {
        return orderList.getOrderListByType(type);
    }

    @Override
    public Map<Integer, OrderVO> getSpecificOrderListByType(OrderType type,String name) {
        return orderList.getSpecificOrderListByType(type,name);
    }

    @Override
    public boolean executeOrder(int orderID) {
        OrderLineItem orderLineItem=orderList.getOrder(orderID);
        orderLineItem.excuteOrder();
        return true;
    }

    @Override
    public boolean cancelOrder(int orderID) {
        return orderList.cancelOrder(orderID);
    }


}
