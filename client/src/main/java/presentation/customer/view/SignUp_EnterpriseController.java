package presentation.customer.view;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import util.ResultMessage;
import vo.CustomerVO;

/**
 * Created by 曹利航 on 2016/11/26 12:26.
 */
public class SignUp_EnterpriseController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    @FXML
    private TextField enterpriseNameField;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }

    @FXML
    private void SignUp() {
        customerVO.setUniqueInformation(enterpriseNameField.getText());
        CustomerBLService customerBLService = new Customer();
        ResultMessage resultMessage = customerBLService.addCustomer(customerVO);
        if (resultMessage.equals(ResultMessage.USER_NOT_EXIST))
            mainAPP.showSignInView();
        else if (resultMessage.equals(ResultMessage.USER_EXIST))
            mainAPP.errorAlert("该用户名已存在");
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
}
