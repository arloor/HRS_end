package presentation.webmanager.view;

import businesslogic.managerbl.Manager;
import businesslogicservice.managerblservice.ManagerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.webmanager.MainAPP;
import util.ManagerType;
import util.ResultMessage;
import vo.ManagerVO;

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
       if(usernameField.getText()=="") {
           //弹出对话框
       }
       else if(passwordField.getText()=="") {
           //弹出对话框
       }
       else{
           ManagerBLService managerBLService=new Manager();
           ResultMessage resultMessage=managerBLService.login(ManagerType.WebManager,usernameField.getText(),passwordField.getText());
           if(resultMessage.equals(ResultMessage.USER_EXIST)) {
               ManagerVO managerVO=managerBLService.getManagerInfo(ManagerType.WebManager, usernameField.getText());
               System.out.print(managerVO.getUsername());
               mainAPP.showRootLayout(managerBLService.getManagerInfo(ManagerType.WebManager, usernameField.getText()));
           }
       }
       }
   }

