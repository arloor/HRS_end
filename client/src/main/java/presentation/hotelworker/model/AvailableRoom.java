package presentation.hotelworker.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.AvailableRoomVO;

/**
 * Created by 曹利航 on 2016/12/08 19:15.
 */
public class AvailableRoom {
    private final StringProperty type;
    private final StringProperty price;
    private final StringProperty num;

    public AvailableRoom(AvailableRoomVO availableRoomVO) {
        this.type = new SimpleStringProperty(availableRoomVO.getRoomType());
        this.price = new SimpleStringProperty(Double.toString(availableRoomVO.getPrice()));
        this.num = new SimpleStringProperty(Integer.toString(availableRoomVO.getRoomNum()));
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
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

    public String getNum() {
        return num.get();
    }

    public StringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }
}
