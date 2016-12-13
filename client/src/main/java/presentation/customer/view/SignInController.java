package presentation.customer.view;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.ResultMessage;

/**
 * Created by 啊 on 2016/11/28.
 */
public class SignInController {
    private presentation.customer.MainAPP mainAPP;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    @FXML
    private void signInAction() {
        CustomerBLService customerBLService=new Customer();
       ResultMessage resultMessage=customerBLService.login(usernameField.getText(),passwordField.getText());
        if(resultMessage.equals(ResultMessage.SUCCESS)){
            mainAPP.showRootView(customerBLService.successLog(usernameField.getText()));
        }
       else{
            //弹出一个对话框
        }
    }
    @FXML

    private void signUp(){
        mainAPP.showSignUpView();
    }
}
