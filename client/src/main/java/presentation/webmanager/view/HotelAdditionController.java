package presentation.webmanager.view;

import businesslogic.hotelbl.Hotel;
import businesslogicservice.hotelblservice.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.utility.XMLDao;
import presentation.webmanager.MainAPP;
import vo.HotelInfoVO;
import vo.ManagerVO;


/**
 * Created by 曹利航 on 2016/11/26 12:24.
 */
public class HotelAdditionController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;

    ObservableList<String> cityList = FXCollections.observableArrayList();
    ObservableList<String> circleList = FXCollections.observableArrayList();

    @FXML
    private TextField hotelNameField;
    @FXML
    private ChoiceBox cityChoiceBox;
    @FXML
    private ChoiceBox areaChoiceBox;
    @FXML
    private TextField addressField;
    @FXML
    private TextArea facilityArea;
    @FXML
    private TextArea cooperArea;
    @FXML
    private TextField hotelLevelField;
    @FXML
    private TextArea introductionArea;
    @FXML
    private Button addHotelWorkerButton;

    public void setWebManagerVO(ManagerVO webManagerVO) {
        this.webManagerVO = webManagerVO;
    }

    public void setMainAPP(MainAPP mainAPP) {
        this.mainAPP = mainAPP;
    }

    @FXML
    private void initialize() {
        for (String tempStr : XMLDao.getCities()) {
            cityList.add(tempStr);
        }
        cityChoiceBox.setItems(cityList);
        cityChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCircleBoxItems((String) newValue));

    }

    private void setCircleBoxItems(String city) {
        circleList = FXCollections.observableArrayList();
        for (String tempStr : XMLDao.getCircles(city)) {
            circleList.add(tempStr);
        }
        areaChoiceBox.setItems(circleList);

    }

    @FXML
    private void addHotelWorker() {
        //判断信息是否完整

        String city = cityChoiceBox.getSelectionModel().getSelectedItem().toString();
        String area = areaChoiceBox.getSelectionModel().getSelectedItem().toString();
        HotelInfoVO hotelInfoVO = new HotelInfoVO(hotelNameField.getText(), city, area, addressField.getText(), introductionArea.getText(),
                facilityArea.getText(), Integer.parseInt(hotelLevelField.getText()), cooperArea.getText(), 3.0, false, 0);
        HotelBLService hotelBLService = new Hotel();
        hotelBLService.addHotel(hotelInfoVO);

        mainAPP.showAddHotelWorkerView(webManagerVO, hotelNameField.getText());
    }
}
