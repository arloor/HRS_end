package presentation.webmanager.view;

import businesslogic.managerbl.ManagerBLService_Stub;
import businesslogicservice.managerblservice.ManagerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.webmanager.MainAPP;
import util.ManagerType;
import util.ResultMessage;

/**
 * Created by 啊 on 2016/11/29.
 */
public class SignInController {
    private MainAPP mainAPP;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button logInButton;

    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
   @FXML
    private void signInAction(){
       if(usernameField.getText()==null) {
           //弹出对话框
       }
       else if(passwordField.getText()==null) {
           //弹出对话框
       }
       else{
           ManagerBLService managerBLService=new ManagerBLService_Stub();
           ResultMessage resultMessage=managerBLService.login(ManagerType.WebManager,usernameField.getText(),passwordField.getText());
           if(resultMessage.equals(ResultMessage.SUCCESS))
               mainAPP.showRootLayout(managerBLService.getManagerInfo(ManagerType.WebManager,usernameField.getText()));

       }
       }
   }

