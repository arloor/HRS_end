package presentation.customer.view;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.CustomerType;
import vo.CustomerVO;

/**
 * Created by 啊 on 2016/12/4.
 */
public class CustomerInfoModifyController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;

    @FXML
    private TextField trueNameField;
    @FXML
    private Label idtentifyField;
    @FXML
    private TextField idtentifyContextField;
    @FXML
    private TextField contactField;
    @FXML
    private PasswordField oldPasswordField;
    @FXML
    private PasswordField newPasswordField;

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        setIdtentifyField();
    }

    @FXML
    public void setConfirmButton() {
        if (trueNameField.getText() != "")
            customerVO.setCustomerName(trueNameField.getText());
        if (idtentifyContextField.getText() != "")
            customerVO.setUniqueInformation(idtentifyContextField.getText());
        if (contactField.getText() != "") {
            customerVO.setPhoneNumber(contactField.getText());
        }
        if (newPasswordField.getText() != "" ) {
            if(oldPasswordField.getText().equals(customerVO.getPassword()))
                customerVO.setPassword(newPasswordField.getText());
        }
        CustomerBLService customerBLService=new Customer();
        customerBLService.changeCustomerInfo(customerVO);
        //弹出对话框提示修改成功没有实现！！
    }
    @FXML
    public void setCancelButton(){
        mainAPP.showPersonalInformationView(customerVO);
    }

    private void setIdtentifyField(){
        if(customerVO.getCustomerType().equals(CustomerType.COMPANY))
            idtentifyField.setText("企业名");
        else
            idtentifyField.setText("生日");
    }
}
