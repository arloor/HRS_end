package presentation.hotelworker.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.OrderVO;

/**
 * Created by 曹利航 on 2016/12/10 19:54.
 */
public class Order {
    final private StringProperty orderID;
    final private StringProperty customerID;
    final private StringProperty hotel;
    final private StringProperty status;
    final private StringProperty roomType;
    final private StringProperty roomNumber;
    final private StringProperty peopleNumber;
    final private StringProperty hasChild;
    final private StringProperty expectCheckInTime;
    final private StringProperty actualCheckInTime;
    final private StringProperty expectCheckOutTime;
    final private StringProperty actualCheckOutTime;
    final private StringProperty cancelTime;
    final private StringProperty price;
    final private StringProperty charge;

    public Order(OrderVO orderVO) {
        orderID = new SimpleStringProperty(Integer.toString(orderVO.getOrderID()));
        customerID = new SimpleStringProperty(orderVO.getCustomerID());
        hotel = new SimpleStringProperty(orderVO.getHotel());
        status = new SimpleStringProperty(orderVO.getStatus());
        roomType = new SimpleStringProperty(orderVO.getRoomID());
        roomNumber = new SimpleStringProperty(Integer.toString(orderVO.getRoomNum()));
        peopleNumber = new SimpleStringProperty(Integer.toString(orderVO.getPeopleNum()));
        hasChild = new SimpleStringProperty(orderVO.getHasChild());
        expectCheckInTime = new SimpleStringProperty(orderVO.getLastCheckInTime());
        actualCheckInTime = new SimpleStringProperty(orderVO.getCheckInTime());
        expectCheckOutTime = new SimpleStringProperty(orderVO.getLastCheckoutTime());
        if (orderVO.getCheckOutTime().equals("1970-01-01 00:00:01")) {
            actualCheckOutTime = new SimpleStringProperty("未退房");
        } else {
            actualCheckOutTime = new SimpleStringProperty(orderVO.getCheckOutTime());
        }
        cancelTime = new SimpleStringProperty(orderVO.getCancelTime());
        price = new SimpleStringProperty(Double.toString(orderVO.getPrice()));
        charge = new SimpleStringProperty(Double.toString(orderVO.getCharge()));
    }

    public String getOrderID() {
        return orderID.get();
    }

    public StringProperty orderIDProperty() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }

    public String getCustomerID() {
        return customerID.get();
    }

    public StringProperty customerIDProperty() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID.set(customerID);
    }

    public String getHotel() {
        return hotel.get();
    }

    public StringProperty hotelProperty() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel.set(hotel);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getRoomType() {
        return roomType.get();
    }

    public StringProperty roomTypeProperty() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType.set(roomType);
    }

    public String getRoomNumber() {
        return roomNumber.get();
    }

    public StringProperty roomNumberProperty() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber.set(roomNumber);
    }

    public String getPeopleNumber() {
        return peopleNumber.get();
    }

    public StringProperty peopleNumberProperty() {
        return peopleNumber;
    }

    public void setPeopleNumber(String peopleNumber) {
        this.peopleNumber.set(peopleNumber);
    }

    public String getHasChild() {
        return hasChild.get();
    }

    public StringProperty hasChildProperty() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild.set(hasChild);
    }

    public String getExpectCheckInTime() {
        return expectCheckInTime.get();
    }

    public StringProperty expectCheckInTimeProperty() {
        return expectCheckInTime;
    }

    public void setExpectCheckInTime(String expectCheckInTime) {
        this.expectCheckInTime.set(expectCheckInTime);
    }

    public String getActualCheckInTime() {
        return actualCheckInTime.get();
    }

    public StringProperty actualCheckInTimeProperty() {
        return actualCheckInTime;
    }

    public void setActualCheckInTime(String actualCheckInTime) {
        this.actualCheckInTime.set(actualCheckInTime);
    }

    public String getExpectCheckOutTime() {
        return expectCheckOutTime.get();
    }

    public StringProperty expectCheckOutTimeProperty() {
        return expectCheckOutTime;
    }

    public void setExpectCheckOutTime(String expectCheckOutTime) {
        this.expectCheckOutTime.set(expectCheckOutTime);
    }

    public String getActualCheckOutTime() {
        return actualCheckOutTime.get();
    }

    public StringProperty actualCheckOutTimeProperty() {
        return actualCheckOutTime;
    }

    public void setActualCheckOutTime(String actualCheckOutTime) {
        this.actualCheckOutTime.set(actualCheckOutTime);
    }

    public String getCancelTime() {
        return cancelTime.get();
    }

    public StringProperty cancelTimeProperty() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime.set(cancelTime);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getCharge() {
        return charge.get();
    }

    public StringProperty chargeProperty() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge.set(charge);
    }
}
