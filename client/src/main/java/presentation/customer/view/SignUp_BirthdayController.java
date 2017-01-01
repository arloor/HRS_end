package presentation.customer.view;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import util.ResultMessage;
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
        ResultMessage resultMessage=customerBLService.addCustomer(customerVO);
        System.out.print(resultMessage);
        if(resultMessage.equals(ResultMessage.SUCCESS))
            mainAPP.showSignInView();
        else if(resultMessage.equals(ResultMessage.USER_EXIST))
            mainAPP.errorAlert("该用户名已存在");
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
}
