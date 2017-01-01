package presentation.websalesman.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.websalesman.MainApp;
import presentation.websalesman.model.CirclePromotion;
import vo.WebPromotionVO.CircleVO;

/**
 * Created by 曹利航 on 2016/12/11 16:36.
 */
public class CirclePromotionController {
    private MainApp mainApp;
    private Stage stage;

    private CirclePromotion circlePromotion;

    @FXML
    private TextField circleField;
    @FXML
    private TextField discountField;
    @FXML
    private Button confirmButton;

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
            circleField.setText(circlePromotion.getCircle());
            discountField.setText(circlePromotion.getDiscount());
        }
    }

    @FXML
    private void confirmAction() {

        if (circleField.getText() != null && circleField.getText().length() > 0
                && discountField.getText() != null && discountField.getText().length() > 0) {   // 检查是否完整填写
            String circle = circleField.getText();
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
