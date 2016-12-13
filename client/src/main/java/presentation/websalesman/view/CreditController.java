package presentation.websalesman.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.websalesman.MainApp;
import util.CreditCharge;
import vo.CustomerVO;

/**
 * Created by 曹利航 on 2016/11/30 15:35.
 */
public class CreditController {
    private MainApp mainApp;

    private CustomerVO customerVO;

    @FXML
    private Label customerTypeLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label contactLabel;
    @FXML
    private Label truenameLabel;

    @FXML
    private TextField valueField;

    @FXML
    private Button chargeButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setCustomerInfo(CustomerVO vo) {
        this.customerVO = vo;
        usernameLabel.setText(vo.getUserName());
        customerTypeLabel.setText(vo.getCustomerType().toString());
        contactLabel.setText(vo.getPhoneNumber());
        truenameLabel.setText(vo.getCustomerName());
    }

    @FXML
    public void chargeAction() {
        int creditChange = Integer.valueOf(valueField.getText()) * CreditCharge.TIMES;
        mainApp.getCreditService(customerVO.getUserName()).increaseCredit(customerVO.getUserName(), creditChange);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("成功");
        alert.setHeaderText("充值成功");
        alert.showAndWait();
    }
}
