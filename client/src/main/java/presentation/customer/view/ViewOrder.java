package presentation.customer.view;

import javafx.beans.property.*;

/**
 * Created by 啊 on 2016/12/7.
 */
public class ViewOrder {
    private StringProperty orderID;
    private StringProperty hotelName;
    private StringProperty roomType;
    private StringProperty roomNum;
    private StringProperty peopleNum;
    private StringProperty hasChild;
    private StringProperty originPrice;
    private StringProperty actualPrice;
    private StringProperty unique;
    public ViewOrder(int orderID,String hotelName,String roomType,int roomNum,int peopleNum,String hasChild,double originPrice,double actualPrice,String time){
        this.orderID=new SimpleStringProperty(String.valueOf(orderID));
        this.hotelName=new SimpleStringProperty(hotelName);
        this.roomType=new SimpleStringProperty(roomType);
        this.roomNum=new SimpleStringProperty(String.valueOf(roomNum));
        this.peopleNum=new SimpleStringProperty(String.valueOf(peopleNum));
        this.hasChild=new SimpleStringProperty(hasChild);
        this.originPrice=new SimpleStringProperty(String.valueOf(originPrice));
        this.actualPrice=new SimpleStringProperty(String.valueOf(actualPrice));
        this.unique=new SimpleStringProperty(String.valueOf(time));
    }

    public StringProperty orderIDProperty() {
        return orderID;
    }

    public StringProperty hotelNameProperty() {
        return hotelName;
    }

    public StringProperty roomTypeProperty() {
        return roomType;
    }

    public StringProperty roomNumProperty() {
        return roomNum;
    }

    public StringProperty peopleNumProperty() {
        return peopleNum;
    }

    public StringProperty hasChildProperty() {
        return hasChild;
    }

    public StringProperty originPriceProperty() {
        return originPrice;
    }

    public StringProperty actualPriceProperty() {
        return actualPrice;
    }

    public StringProperty uniqueProperty() {
        return unique;
    }

    public String getRoomType() {
        return roomType.get();
    }

    public String getOriginPrice() {
        return originPrice.get();
    }

    public String getActualPrice() {
        return actualPrice.get();
    }

    public String getHasChild() {
        return hasChild.get();
    }

    public String getHotelName() {
        return hotelName.get();
    }

    public String getOrderID() {
        return orderID.get();
    }

    public String getPeopleNum() {
        return peopleNum.get();
    }

    public String getRoomNum() {
        return roomNum.get();
    }

    public String getUnique() {
        return unique.get();
    }
}
