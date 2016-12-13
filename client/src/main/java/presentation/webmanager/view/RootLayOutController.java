package presentation.webmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.webmanager.MainAPP;
import vo.ManagerVO;

/**
 * Created by 啊 on 2016/12/10.
 */
public class RootLayOutController {
    private ManagerVO managerVO;
    private MainAPP mainAPP;
    @FXML
    private Label usernameLabel;
    @FXML
    private Button customerInfoButton;
    @FXML
    private Button managerInfoButton;
    @FXML
    private Button addHotelAndWorkerButton;
    @FXML
    private Button addSalesManButton;
    public void setMainApp(MainAPP mainApp) {
        this.mainAPP = mainApp;
        this.usernameLabel.setText("欢迎！" + managerVO.getUsername());
    }
    public void setManagerVO(ManagerVO managerVO){
        this.managerVO=managerVO;
    }
    @FXML
    private void customerInfoAction() {
        this.customerInfoButton.getStyleClass().set(1, "button-navigation-selected");
        this.managerInfoButton.getStyleClass().set(1, "button-navigation");
        this.addHotelAndWorkerButton.getStyleClass().set(1, "button-navigation");
        this.addSalesManButton.getStyleClass().set(1, "button-navigation");

        mainAPP.showCustomerInfoView(managerVO);
    }

    @FXML
    private void managerInfoAction() {
        this.customerInfoButton.getStyleClass().set(1, "button-navigation");
        this.managerInfoButton.getStyleClass().set(1, "button-navigation-selected");
        this.addHotelAndWorkerButton.getStyleClass().set(1, "button-navigation");
        this.addSalesManButton.getStyleClass().set(1, "button-navigation");

        mainAPP.showManagerInfoView(managerVO);
    }

    @FXML
    private void addHotelAndWorkerAction() {
        this.customerInfoButton.getStyleClass().set(1, "button-navigation");
        this.managerInfoButton.getStyleClass().set(1, "button-navigation");
        this.addHotelAndWorkerButton.getStyleClass().set(1, "button-navigation-selected");
        this.addSalesManButton.getStyleClass().set(1, "button-navigation");

        mainAPP.showAddHotelView(managerVO);
    }

    @FXML
    private void addSalesManAction() {
        this.customerInfoButton.getStyleClass().set(1, "button-navigation");
        this.managerInfoButton.getStyleClass().set(1, "button-navigation");
        this.addHotelAndWorkerButton.getStyleClass().set(1, "button-navigation");
        this.addSalesManButton.getStyleClass().set(1, "button-navigation-selected");

        mainAPP.showAddWebSalesManView(managerVO);
    }

    @FXML
    private void signOutAction() {
        mainAPP.showSignInView();
    }

}
