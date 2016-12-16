package presentation.customer.view;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
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
        CustomerBLService customerBLService=new Customer();
        customerBLService.addCustomer(customerVO);
        mainAPP.showSignInView();
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
}
