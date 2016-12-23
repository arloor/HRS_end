package vo;

import po.OrderPO;

import java.util.Vector;

/**
 * Created by arloor on 2016/11/6.
 */


/**
 * orderID          0订单编号
 * customerID       1会员编号
 * hotel            2酒店名称
 * status           3订单状态
 * roomID           4房间类型
 * roomNum          5房间数量
 * peopleNum        6入住人数
 * hasChild         7有无小孩
 * lastCheckInTime  8预计入住时间
 * checkOutTime     9实际退房时间
 * price            10原价
 * charge           11实际收费
 * creditChange     12信用值变化
 * checkInTime      13实际入住时间
 * lastCheckOutTime 14预计退房时间
 * promotionType    15促销策略类型
 * @author arloor
 */

public class OrderVO extends Vector<String> {

    String promotionType = null;

    /**
     * 构造函数：从一个个参数中构造order
     * @param orderID   0
     * @param customerID  1
     * @param hotel     2
     * @param status    3
     * @param roomID    4
     * @param roomNum   5
     * @param peopleNum 6
     * @param hasChild  7
     * @param lastCheckInTime   8
     * @param checkinTime   9
     * @param lastCheckoutTime  10
     * @param checkOutTime   11
     * @param price     12
     * @param charge    13
     * @param creditChange  14
     */
    public OrderVO(int orderID, String customerID, String hotel, String status, String roomID,
                   int roomNum, int peopleNum, String hasChild, String lastCheckInTime, String checkinTime,String lastCheckoutTime,String checkOutTime,
                   double price, double charge, double creditChange){

        this.add(String.valueOf(orderID));
        this.add(customerID);
        this.add(hotel);
        this.add(status);
        this.add(roomID);
        this.add(String.valueOf(roomNum));
        this.add(String.valueOf(peopleNum));
        this.add(hasChild);
        this.add(lastCheckInTime);
        this.add(checkOutTime);
        this.add(String.valueOf(price));
        this.add(String.valueOf(charge));
        this.add("1970-01-01 00:00:01.0");
        this.add(checkinTime);
        this.add(lastCheckoutTime);
    }

    public OrderVO(int orderID, String customerID, String hotel, String status, String roomID,
                   int roomNum, int peopleNum, String hasChild, String lastCheckInTime, String checkinTime,String lastCheckoutTime,String checkOutTime,
                   double price, double charge, String cancelTime){

        this.add(String.valueOf(orderID));
        this.add(customerID);
        this.add(hotel);
        this.add(status);
        this.add(roomID);
        this.add(String.valueOf(roomNum));
        this.add(String.valueOf(peopleNum));
        this.add(hasChild);
        this.add(lastCheckInTime);
        this.add(checkOutTime);
        this.add(String.valueOf(price));
        this.add(String.valueOf(charge));
        this.add(cancelTime);
        this.add(checkinTime);
        this.add(lastCheckoutTime);
    }

    public OrderVO(OrderPO opo){
        int orderID=opo.getOrderID();
        String customerID=opo.getCustomerID();
        String hotel=opo.getHotel();

        String status=opo.getStatus();
        String roomID=opo.getRoomID();
        int roomNum=opo.getRoomNum();
        int peopleNum=opo.getPeopleNum();
        String hasChild=opo.getHasChild();
        String lastCheckInTime=opo.getLastCheckInTime();
        String checkinTime=opo.getCheckInTime();
        String lastCheckoutTime =opo.getLastCheckoutTime();
        String checkOutTime=opo.getCheckOutTime();
        double price=opo.getPrice();
        double charge=opo.getCharge();
        String cancelTime=opo.getCancelTime();


        this.add(String.valueOf(orderID));
        this.add(customerID);
        this.add(hotel);
        this.add(status);
        this.add(roomID);
        this.add(String.valueOf(roomNum));
        this.add(String.valueOf(peopleNum));
        this.add(hasChild);
        this.add(lastCheckInTime);
        this.add(checkOutTime);
        this.add(String.valueOf(price));
        this.add(String.valueOf(charge));
        this.add(cancelTime);
        this.add(checkinTime);
        this.add(lastCheckoutTime);
    }

    public int getOrderID(){return Integer.parseInt(this.get(0));}

    public String getCustomerID(){return this.get(1);}

    public String getHotel(){return this.get(2);}

    public String getStatus(){return this.get(3);}

    public String getRoomID(){return this.get(4);}

    public int getRoomNum(){return Integer.parseInt(this.get(5));}

    public int getPeopleNum(){return Integer.parseInt(this.get(6));}

    public String getHasChild(){return this.get(7);}

    public String getLastCheckInTime(){return this.get(8);}

    public String getCheckOutTime(){return this.get(9);}

    public double getPrice(){return Double.parseDouble(this.get(10));}

    public double getCharge(){return Double.parseDouble(this.get(11));}

    public String  getCancelTime(){return this.get(12);}

    public String getCheckInTime(){return this.get(13);}

    public void setStatus(String status){
        //OrderVO ovo=new OrderVO(this.getOrderID(),this.getMemberID(),this.getHotel(),status,this.getRoomType(),this.getRoomNum(),this.getPeopleNum(),this.getHasChild(),this.getLastCheckinTime(),this.getCheckouTime(),this.getPrice(),this.getCharge(),this.getCreditChange());
        this.set(3,status);
    }

    public void setCancelTime(String s) {
        this.set(12,s);
    }

    public void setCharge(double charge) {
        this.set(11,String.valueOf(charge));
    }

    public String getLastCheckoutTime() {
        return this.get(14);
    }
    //后面是我加的
    //好的我看到了@段梦洋
     public void setOrderID(int orderID){
         this.set(0,String.valueOf(orderID));
     }
     public void setPrice(double price){
         this.set(10,String.valueOf(price));
     }

     public String getPromotionType() {
         return promotionType;
     }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

}
