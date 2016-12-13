package presentation.hotelworker.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.hotelworker.MainApp;

/**
 * Created by 曹利航 on 2016/12/10 16:19.
 */
public class RoomNumEditController {
    private MainApp mainApp;
    private Stage stage;
    private String increaseOrDecrease;
    private int num;

    public String getInfo() {
        return increaseOrDecrease + " " + Integer.toString(num);
    }


    @FXML
    private ChoiceBox<String> increaseOrDecreaseChoiceBox;
    @FXML
    private TextField numberField;
    @FXML
    private Button confirmButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("增加数量");
        list.add("减少数量");
        increaseOrDecreaseChoiceBox.setItems(list);
    }

    @FXML
    private void confirmAction() {
        increaseOrDecrease = increaseOrDecreaseChoiceBox.getValue();
        num = Integer.valueOf(numberField.getText());
        stage.close();
    }
}
