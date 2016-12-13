package presentation.customer.view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import vo.CustomerVO;

/**
 * Created by 曹利航 on 2016/11/26 12:26.
 */
public class SignUp_BirthdayController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    @FXML
    private DatePicker birthdayPicker;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    @FXML
    private void SignUp() {
        String time= birthdayPicker.getValue().toString();
        customerVO.setUniqueInformation(time);
        mainAPP.showHomeView(customerVO);
    }
    /***
    private void getTime(){
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern(pattern);
                @Override
                public String toString (LocalDate date){
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

                @Override
                public LocalDate fromString (String string){
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        birthdayPicker.setConverter(converter);

    }
     ***/

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
}
