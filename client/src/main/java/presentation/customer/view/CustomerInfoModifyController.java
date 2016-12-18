package presentation.customer.view;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
            hasModified=true;
            customerVO.setPhoneNumber(contactField.getText());
        }
        if (newPasswordField.getText().length()!=0) {
            if(oldPasswordField.getText().equals(customerVO.getPassword())) {
                hasModified=true;
                customerVO.setPassword(newPasswordField.getText());
            }
            else{
                Alert alert;
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("修改失败");
                alert.setContentText("旧密码输入错误");
                alert.showAndWait();
                return;
            }
        }
        if(hasModified==true) {
            CustomerBLService customerBLService = new Customer();
            customerBLService.changeCustomerInfo(customerVO);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("修改成功");
            alert.showAndWait();
        }
        else{
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText(null);
            alert.setContentText("未进行修改");
            alert.showAndWait();
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
