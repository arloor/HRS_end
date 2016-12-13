package presentation.websalesman.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.websalesman.MainApp;

/**
 * Created by 曹利航 on 2016/12/03 15:12.
 */
public class SignInController {

    private MainApp mainApp;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void initialize() {
        usernameField.setPromptText("用户名");
        passwordField.setPromptText("密码");
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void signInAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        mainApp.signIn(username, password);
    }
}
