package presentation.customer.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by 啊 on 2016/12/3.
 */
public class ViewRoomAndPriceObjects {
    private StringProperty roomType;
    private StringProperty originPrice;
    public ViewRoomAndPriceObjects(String roomType,String originPrice){
        this.roomType = new SimpleStringProperty(roomType);
        this.originPrice=new SimpleStringProperty(originPrice);
    }

    public StringProperty originPriceProperty() {
        return originPrice;
    }

    public StringProperty roomTypeProperty() {
        return roomType;
    }

    public String getOriginPrice() {
        return originPrice.get();
    }

    public String getRoomType() {
        return roomType.get();
    }
}
