package presentation.customer.view;

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
        Boolean hasModified=false;
        if (trueNameField.getText().length()!=0) {
            hasModified=true;
            customerVO.setCustomerName(trueNameField.getText());
        }
        if (idtentifyContextField.getText().length()!=0) {
            hasModified=true;
            customerVO.setUniqueInformation(idtentifyContextField.getText());
        }
        if (contactField.getText().length()!=0) {
            if(mainAPP.check(contactField.getText())) {
                hasModified = true;
                customerVO.setPhoneNumber(contactField.getText());
            }
        }
        if (newPasswordField.getText().length()!=0) {
            if(oldPasswordField.getText().equals(customerVO.getPassword())) {
                hasModified=true;
                customerVO.setPassword(newPasswordField.getText());
            }
            else{
               mainAPP.errorAlert("原始密码错误");
                return;
            }
        }
        if(hasModified==true) {
          mainAPP.informationAlert("修改成功");
        }
        else{
           mainAPP.errorAlert("未进行修改");
        }
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
