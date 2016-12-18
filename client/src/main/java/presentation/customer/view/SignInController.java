package presentation.customer.view;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
            mainAPP.showSearchView(customerBLService.successLog(usernameField.getText()));
        }
        else{
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("登录失败");
            alert.setContentText("用户名或密码错误");
            alert.showAndWait();
        }
    }
    @FXML

    private void signUp(){
        mainAPP.showSignUpView();
    }
}
