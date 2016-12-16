package presentation.customer.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.customer.MainAPP;
import vo.CustomerVO;


/**
 * Created by 啊 on 2016/12/11.
 */
public class RootLayoutController {
    private CustomerVO customerVO;
    private MainAPP mainAPP;
    @FXML
    private Label usernameLabel;
    @FXML
    private Button detailedSearchButton;
    @FXML
    private Button historyOrderButton;
    @FXML
    private Button personalInformationButton;
    @FXML
    private Button historyHotelButton;
    public void setMainApp(MainAPP mainApp) {
        this.mainAPP = mainApp;
        this.usernameLabel.setText("欢迎！" + customerVO.getUserName());
    }
    public void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
    }
    @FXML
    private void detailedSearchAction() {
        this.detailedSearchButton.getStyleClass().set(1, "button-navigation-selected");
        this.historyHotelButton.getStyleClass().set(1, "button-navigation");
        this.historyOrderButton.getStyleClass().set(1, "button-navigation");
        this.personalInformationButton.getStyleClass().set(1, "button-navigation");

        mainAPP.showDetailedSearchView(customerVO);
    }

    @FXML
    private void historyOrderAction() {
        this.detailedSearchButton.getStyleClass().set(1, "button-navigation");
        this.historyOrderButton.getStyleClass().set(1, "button-navigation-selected");
        this.historyHotelButton.getStyleClass().set(1, "button-navigation");
        this.personalInformationButton.getStyleClass().set(1, "button-navigation");

        mainAPP.showOrderInfoView(customerVO);
    }

    @FXML
    private void historyHotelAction() {
        this.detailedSearchButton.getStyleClass().set(1, "button-navigation");
        this.historyOrderButton.getStyleClass().set(1, "button-navigation");
        this.historyHotelButton.getStyleClass().set(1, "button-navigation-selected");
        this.personalInformationButton.getStyleClass().set(1, "button-navigation");

        mainAPP.showLivedHotelView(customerVO);
    }

    @FXML
    private void personalInformationAction() {
        this.detailedSearchButton.getStyleClass().set(1, "button-navigation");
        this.historyOrderButton.getStyleClass().set(1, "button-navigation");
        this.historyHotelButton.getStyleClass().set(1, "button-navigation");
        this.personalInformationButton.getStyleClass().set(1, "button-navigation-selected");

        mainAPP.showPersonalInformationView(customerVO);
    }

    @FXML
    private void signOutAction() {
        mainAPP.showSignInView();
    }

}
