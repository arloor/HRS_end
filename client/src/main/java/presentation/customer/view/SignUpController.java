package presentation.customer.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import presentation.customer.MainAPP;
import util.CustomerType;
import vo.CustomerVO;

/**
 * Created by 曹利航 on 2016/11/26 12:25.
 */
public class SignUpController {
    private MainAPP mainAPP;
    private CustomerType customerType;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordConfirmField;
    @FXML
    private TextField trueNameField;
    @FXML
    private TextField contactField;
    @FXML
    private RadioButton personalButton;
    @FXML
    private TextField emailField;
    @FXML
    private RadioButton enterpriseButton;
    @FXML
    private Button nextButton;
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
        initialize();
    }
    private void initialize(){
        final ToggleGroup group=new ToggleGroup();
        personalButton.setToggleGroup(group);
        enterpriseButton.setToggleGroup(group);
    }
    @FXML
    private void setPersonalButton(){
        customerType=CustomerType.PERSONAL;
    }
    @FXML
    private void setEnterpriseButton(){
        customerType=CustomerType.COMPANY;
    }
    @FXML
    private void NextStep(){
        if(passwordField.getText().equals(passwordConfirmField.getText())) {
                if (customerType.equals(CustomerType.PERSONAL)) {
                    mainAPP.showSignUpBirthdayView(new CustomerVO(usernameField.getText(), passwordField.getText(),
                           contactField.getText(), trueNameField.getText(), customerType, "",emailField.getText()));
                }
                else if (customerType.equals(CustomerType.COMPANY)) {
                    mainAPP.showSignUpEnterpriseView(new CustomerVO(usernameField.getText(),passwordField.getText(),
                            contactField.getText(),trueNameField.getText(),customerType,"",emailField.getText()));

                }
        }
        else{
            //弹出窗口提示密码两次输入不一致，请重新输入
        }
    }
}
