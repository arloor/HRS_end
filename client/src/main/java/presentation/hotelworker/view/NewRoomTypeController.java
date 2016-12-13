package presentation.hotelworker.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.hotelworker.MainApp;
import util.RoomType;
import vo.AvailableRoomVO;

import java.util.ArrayList;

/**
 * Created by 曹利航 on 2016/12/10 17:13.
 */
public class NewRoomTypeController {
    private MainApp mainApp;
    private Stage stage;

    private RoomType type;
    private int number;
    private double price;

    @FXML
    private ChoiceBox<RoomType> typeChoiceBox;
    @FXML
    private TextField numberField;
    @FXML
    private TextField priceField;
    @FXML
    private Button confirmButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        ArrayList<AvailableRoomVO> availableRoomList = mainApp.getRoomService().getAvailableRoomList(mainApp.getHotelName(), null, null);
        ArrayList<String> existTypeList = new ArrayList<>();
        for (int i = 0; i < availableRoomList.size(); i++) {
            existTypeList.add(availableRoomList.get(i).getRoomType());
        }

        ObservableList<RoomType> typeList = FXCollections.observableArrayList();
        for (RoomType type : RoomType.values()) {
            boolean isExist = false;
            for (int i = 0; i < existTypeList.size(); i++) {
                if (type.toString().equals(existTypeList.get(i))) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                typeList.add(type);
            }
        }
        typeChoiceBox.setItems(typeList);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public AvailableRoomVO getVO() {
        AvailableRoomVO availableRoomVO = new AvailableRoomVO(mainApp.getHotelName(), type.toString(), number, price);
        return availableRoomVO;
    }

    @FXML
    private void confirmAction() {
        type = typeChoiceBox.getValue();
        number = Integer.valueOf(numberField.getText());
        price = Double.valueOf(priceField.getText());

        stage.close();
    }
}
