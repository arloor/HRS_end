package presentation.hotelworker.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.hotelworker.MainApp;

/**
 * Created by 曹利航 on 2016/12/07 21:03.
 */
public class RootLayoutController {
    private MainApp mainApp;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button hotelInfoButton;
    @FXML
    private Button orderManageButton;
    @FXML
    private Button roomManageButton;
    @FXML
    private Button salePromotionButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.usernameLabel.setText("欢迎！" + mainApp.getUsername());
    }

    @FXML
    private void hotelInfoAction() {
        this.hotelInfoButton.getStyleClass().set(1, "button-navigation-selected");
        this.orderManageButton.getStyleClass().set(1, "button-navigation");
        this.roomManageButton.getStyleClass().set(1, "button-navigation");
        this.salePromotionButton.getStyleClass().set(1, "button-navigation");

        mainApp.showHotelInfoView();
    }

    @FXML
    private void orderManageAction() {
        this.hotelInfoButton.getStyleClass().set(1, "button-navigation");
        this.orderManageButton.getStyleClass().set(1, "button-navigation-selected");
        this.roomManageButton.getStyleClass().set(1, "button-navigation");
        this.salePromotionButton.getStyleClass().set(1, "button-navigation");

        mainApp.showOrderManageView();
    }

    @FXML
    private void roomManageAction() {
        this.hotelInfoButton.getStyleClass().set(1, "button-navigation");
        this.orderManageButton.getStyleClass().set(1, "button-navigation");
        this.roomManageButton.getStyleClass().set(1, "button-navigation-selected");
        this.salePromotionButton.getStyleClass().set(1, "button-navigation");

        mainApp.showRoomManageView();
    }

    @FXML
    private void salePromotionAction() {
        this.hotelInfoButton.getStyleClass().set(1, "button-navigation");
        this.orderManageButton.getStyleClass().set(1, "button-navigation");
        this.roomManageButton.getStyleClass().set(1, "button-navigation");
        this.salePromotionButton.getStyleClass().set(1, "button-navigation-selected");

        mainApp.showSalePromotionView();
    }

    @FXML
    private void signOutAction() {
        mainApp.showSignInView();
    }
}
