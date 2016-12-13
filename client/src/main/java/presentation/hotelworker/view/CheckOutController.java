package presentation.hotelworker.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import presentation.hotelworker.MainApp;

/**
 * Created by 曹利航 on 2016/12/11 11:53.
 */
public class CheckOutController {
    private MainApp mainApp;
    private Stage stage;

    boolean isConfirmed = false;

    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    @FXML
    private void confirmAction() {
        isConfirmed = true;
        stage.close();
    }

    @FXML
    private void cancelAction() {
        stage.close();
    }

}
