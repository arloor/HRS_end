package presentation.customer.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by 啊 on 2016/12/1.
 */
public class ViewCreditObjects {
    private StringProperty time;
    private StringProperty orderID;
    private StringProperty creditChangeType;
    private StringProperty creditChange;
    public ViewCreditObjects(String time,int orderID,String creditChangeType,double creditChange){
        this.time=new SimpleStringProperty(time);
        this.orderID=new SimpleStringProperty(String.valueOf(orderID));
        this.creditChangeType=new SimpleStringProperty(creditChangeType);
        this.creditChange=new SimpleStringProperty(String.valueOf(creditChange));
    }

    public StringProperty creditChangeProperty() {
        return creditChange;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public StringProperty creditChangeTypeProperty() {
        return creditChangeType;
    }

    public StringProperty orderIDProperty() {
        return orderID;
    }

    public String getCreditChange() {
        return creditChange.get();
    }

    public String getOrderID() {
        return orderID.get();
    }

    public String getTime() {
        return time.get();
    }

    public String getCreditChangeType() {
        return creditChangeType.get();
    }
}
