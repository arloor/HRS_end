package presentation.websalesman.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.websalesman.MainApp;
import vo.CustomerVO;

/**
 * Created by 曹利航 on 2016/11/30 15:35.
 */
public class CustomerRootController {
    private MainApp mainApp;

    @FXML
    private TextField customerIDField;

    @FXML
    private Button searchButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void searchAction() {
        CustomerVO customerVO = mainApp.getCustomerService().getCustomerInfo(customerIDField.getText());

        if (customerVO != null) {
            mainApp.showCreditView(customerVO);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("用户不存在");
            alert.setContentText("请检查用户名");
            alert.showAndWait();
        }
    }
}
