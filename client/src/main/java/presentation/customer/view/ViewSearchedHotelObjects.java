package presentation.customer.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by 啊 on 2016/12/7.
 */
public class ViewSearchedHotelObjects {
    private StringProperty hotelName;
    private StringProperty hotelLevel;
    private StringProperty grades;
    private StringProperty lowestPrice;
    private StringProperty address;
    public ViewSearchedHotelObjects(String hotelName,String hotelLevel,String grades,String lowestPrice,String address){
        this.hotelName=new SimpleStringProperty(hotelName);
        this.hotelLevel=new SimpleStringProperty(hotelLevel);
        this.grades=new SimpleStringProperty(grades);
        this.lowestPrice=new SimpleStringProperty(lowestPrice);
        this.address=new SimpleStringProperty(address);
    }

    public StringProperty gradesProperty() {
        return grades;
    }

    public StringProperty hotelLevelProperty() {
        return hotelLevel;
    }

    public StringProperty hotelNameProperty() {
        return hotelName;
    }

    public StringProperty lowestPriceProperty() {
        return lowestPrice;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getHotelName() {
        return hotelName.get();
    }

    public String getGrades() {
        return grades.get();
    }

    public String getHotelLevel() {
        return hotelLevel.get();
    }

    public String getLowestPrice() {
        return lowestPrice.get();
    }

    public String getAddress() {
        return address.get();
    }
}
