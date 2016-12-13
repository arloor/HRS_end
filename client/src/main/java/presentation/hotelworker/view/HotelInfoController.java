package presentation.hotelworker.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.hotelworker.MainApp;
import vo.HotelInfoVO;

/**
 * Created by 曹利航 on 2016/12/06 20:08.
 */
public class HotelInfoController {
    private MainApp mainApp;

    @FXML
    private Label starLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label circleLabel;

    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;

    @FXML
    private TextArea introductionArea;
    @FXML
    private TextArea facilityArea;
    @FXML
    private TextArea cooperArea;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setHotelInfo(HotelInfoVO vo) {
        starLabel.setText(Integer.toString(vo.getStarLevel()));
        scoreLabel.setText(Double.toString(vo.getScore()));
        cityLabel.setText(vo.getCity());
        circleLabel.setText(vo.getBusinessCircle());
        nameField.setText(vo.getHotelName());
        addressField.setText(vo.getAddress());
        introductionArea.setText(vo.getIntroduction());
        facilityArea.setText(vo.getFacility());
        cooperArea.setText(vo.getCooperCompany());
    }

    @FXML
    private void confirmAction() {
        HotelInfoVO hotelInfoVO = new HotelInfoVO(nameField.getText(), cityLabel.getText(), circleLabel.getText(), addressField.getText(), introductionArea.getText(), facilityArea.getText(), Integer.valueOf(starLabel.getText()), cooperArea.getText(), Double.valueOf(scoreLabel.getText()), false, 9999);
        mainApp.updateHotelInfo(hotelInfoVO);
    }
}
