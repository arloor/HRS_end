package presentation.customer.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by 啊 on 2016/12/8.
 */
public class ViewHotel extends ViewSearchedHotelObjects{
    private StringProperty city;
    private StringProperty area;

    public ViewHotel(String city,String area,String hotelName, String hotelLevel, String grades, String lowestPrice,String address) {
        super(hotelName, hotelLevel, grades, lowestPrice,address);
        this.city=new SimpleStringProperty(city);
        this.area=new SimpleStringProperty(area);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public StringProperty areaProperty() {
        return area;
    }

    public String getCity() {
        return city.get();
    }

    public String getArea() {
        return area.get();
    }
}
