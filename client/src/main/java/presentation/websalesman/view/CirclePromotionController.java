package presentation.websalesman.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.utility.XMLDao;
import presentation.websalesman.MainApp;
import presentation.websalesman.model.CirclePromotion;
import vo.WebPromotionVO.CircleVO;

/**
 * Created by 曹利航 on 2016/12/11 16:36.
 */
public class CirclePromotionController {
    private MainApp mainApp;
    private Stage stage;

    private ObservableList<String> cityList = FXCollections.observableArrayList();
    private ObservableList<String> circleList = FXCollections.observableArrayList();

    private CirclePromotion circlePromotion;

    @FXML
    private ChoiceBox<String> cityChoiceBox;
    @FXML
    private ChoiceBox<String> circleChoiceBox;
    @FXML
    private TextField discountField;
    @FXML
    private Button confirmButton;

    @FXML
    private void initialize() {
        for (String tempCity : XMLDao.getCities()) {
            cityList.add(tempCity);
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
        circleChoiceBox.setItems(circleList);

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public CirclePromotion getCirclePromotion() {
        return circlePromotion;
    }

    public void setCirclePromotion(CirclePromotion circlePromotion) {
        if (circlePromotion != null) {
            this.circlePromotion = circlePromotion;

            cityChoiceBox.getSelectionModel().select(XMLDao.findCity(circlePromotion.getCircle()));
            circleChoiceBox.getSelectionModel().select(circlePromotion.getCircle());

            discountField.setText(circlePromotion.getDiscount());
        }
    }

    @FXML
    private void confirmAction() {

        if (circleChoiceBox.getSelectionModel().getSelectedIndex() >= 0
                && discountField.getText() != null && discountField.getText().length() > 0) {   // 检查是否完整填写
            String circle = circleChoiceBox.getSelectionModel().getSelectedItem();
            double discount = Double.valueOf(discountField.getText());
            if (circlePromotion != null) {  // 修改原有策略
                circlePromotion.setCircle(circle);
                circlePromotion.setDiscount(String.format("%.2f", discount));
            } else {    // 添加新策略
                circlePromotion = new CirclePromotion(new CircleVO(circle, discount));
            }
            stage.close();
        } else {
            Alert alert;
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("缺少输入");
            alert.setContentText("请输入完整的信息！");
            alert.showAndWait();
        }
    }
}
