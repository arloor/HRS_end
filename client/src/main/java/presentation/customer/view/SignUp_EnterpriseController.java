package presentation.customer.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
        mainAPP.showHomeView(customerVO);
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
}