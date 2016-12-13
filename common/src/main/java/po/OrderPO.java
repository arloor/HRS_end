package po;

import vo.OrderVO;

import java.io.Serializable;

/**
 * Created by 曹利航 on 2016/10/16 17:08.
 */

public class OrderPO implements Serializable {
    private int orderID;
    private String customerID;
    private String hotel;
    private String status;
    private String roomID;
    private int roomNum;
    private int peopleNum;
    private String hasChild;
    private String lastCheckInTime;
    private String checkInTime;
    private String lastCheckoutTime;
    private String checkOutTime;
    private double price;
    private double charge;
    private String cancelTime;

    public OrderPO(){ super();}


    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getLastCheckoutTime() {
        return lastCheckoutTime;
    }

    public void setLastCheckoutTime(String lastCheckoutTime) {
        this.lastCheckoutTime = lastCheckoutTime;
    }

    /**
     *
     * @param orderID
     * @param customerID
     * @param hotel
     * @param status
     * @param roomID
     * @param roomNum
     * @param peopleNum
     * @param hasChild
     * @param lastCheckInTime
     * @param checkOutTime
     * @param price
     * @param charge
     * @param creditChange
     */
    public OrderPO(int orderID, String customerID, String hotel, String status, String roomID,
                   int roomNum, int peopleNum, String hasChild, String lastCheckInTime,String CheckInTime, String lastCheckoutTime,String checkOutTime,
                   double price, double charge, double creditChange){

        super();
        this.orderID=orderID;
        this.customerID=customerID;
        this.hotel=hotel;
        this.status=status;
        this.roomID=roomID;
        this.roomNum=roomNum;
        this.peopleNum=peopleNum;
        this.hasChild=hasChild;
        this.lastCheckInTime=lastCheckInTime;
        if(CheckInTime==null||CheckInTime.equals("尚未入住")||CheckInTime.equals("")){
            this.checkInTime="";
        }else this.checkInTime=CheckInTime;
        this.lastCheckoutTime=lastCheckoutTime;

        if(checkOutTime==null||checkOutTime.equals("尚未退房")||checkOutTime.equals("")){
            this.checkOutTime="";
        }else this.checkOutTime=checkOutTime;
        this.price=price;
        this.charge=charge;
        this.cancelTime="1970-01-01 00:00:01.0";
    }
    public OrderPO(int orderID, String customerID, String hotel, String status, String roomID,
                   int roomNum, int peopleNum, String hasChild, String lastCheckInTime,String CheckInTime, String lastCheckoutTime,String checkOutTime,
                   double price, double charge, String cancelTime){

        super();
        this.orderID=orderID;
        this.customerID=customerID;
        this.hotel=hotel;
        this.status=status;
        this.roomID=roomID;
        this.roomNum=roomNum;
        this.peopleNum=peopleNum;
        this.hasChild=hasChild;
        this.lastCheckInTime=lastCheckInTime;
        if(CheckInTime==null||CheckInTime.equals("尚未入住")||CheckInTime.equals("")){
            this.checkInTime="";
        }else this.checkInTime=CheckInTime;
        this.lastCheckoutTime=lastCheckoutTime;

        if(checkOutTime==null||checkOutTime.equals("尚未退房")||checkOutTime.equals("")){
            this.checkOutTime="";
        }else this.checkOutTime=checkOutTime;
        this.price=price;
        this.charge=charge;
        this.cancelTime=cancelTime;
        this.cancelTime=cancelTime;
    }

    public OrderPO(OrderVO ovo){

        super();
        this.orderID=ovo.getOrderID();
        this.customerID=ovo.getCustomerID();
        this.hotel=ovo.getHotel();
        this.status=ovo.getStatus();
        this.roomID=ovo.getRoomID();
        this.roomNum=ovo.getRoomNum();
        this.peopleNum=ovo.getPeopleNum();
        this.hasChild=ovo.getHasChild();
        this.lastCheckInTime=ovo.getLastCheckInTime();
        this.checkInTime=ovo.getCheckInTime();
        this.checkOutTime=ovo.getCheckOutTime();
        this.lastCheckoutTime=ovo.getLastCheckoutTime();
        this.price=ovo.getPrice();
        this.charge=ovo.getCharge();
        this.cancelTime=ovo.getCancelTime();
    }
    public String getHotel() {
        return hotel;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public String getLastCheckInTime() {
        return lastCheckInTime;
    }

    public String getCheckInTime(){return checkInTime;}

    public void setLastCheckInTime(String lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
