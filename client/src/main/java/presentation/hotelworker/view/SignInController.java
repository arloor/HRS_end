package presentation.hotelworker.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.hotelworker.MainApp;

/**
 * Created by 曹利航 on 2016/12/08 14:24.
 */
public class SignInController {
    private MainApp mainApp;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void signInAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        mainApp.signIn(username, password);
    }

}
