package presentation.websalesman.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.websalesman.MainApp;
import presentation.websalesman.model.LevelPromotion;
import vo.WebPromotionVO.LevelVO;

/**
 * Created by 曹利航 on 2016/12/11 16:36.
 */
public class LevelPromotionController {
    private MainApp mainApp;
    private Stage stage;

    private LevelPromotion levelPromotion;

    @FXML
    private TextField levelField;
    @FXML
    private TextField creditField;
    @FXML
    private TextField discountField;
    @FXML
    private Button confirmButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setLevelPromotion(LevelPromotion levelPromotion) {
        if (levelPromotion != null) {
            this.levelPromotion = levelPromotion;
            levelField.setText(levelPromotion.getLevel());
            creditField.setText(levelPromotion.getCredit());
            discountField.setText(levelPromotion.getDiscount());
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public LevelPromotion getLevelPromotion() {
        return levelPromotion;
    }

    @FXML
    private void confirmAction() {

        if (levelField.getText() != null && levelField.getText().length() > 0
                && creditField.getText() != null && creditField.getText().length() > 0
                && discountField.getText() != null && discountField.getText().length() > 0) {
            int level = Integer.valueOf(levelField.getText());
            double credit = Double.valueOf(creditField.getText());
            double discount = Double.valueOf(discountField.getText());
            if (levelPromotion != null) {
                levelPromotion.setLevel(String.format("%02d", level));
                levelPromotion.setCredit(String.format("%.2f", credit));
                levelPromotion.setDiscount(String.format("%.2f", discount));
            } else {
                levelPromotion = new LevelPromotion(new LevelVO(level, credit, discount));
            }
            stage.close();
        } else {
            Alert alert;
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("缺少输入");
            alert.setContentText("请输入完整信息！");
            alert.showAndWait();
        }
    }
}
