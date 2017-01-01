package presentation.websalesman.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.websalesman.MainApp;

/**
 * Created by 曹利航 on 2016/11/30 15:36.
 */
public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    private Label websalesmanLabel;

    @FXML
    private Button exitButton;
    @FXML
    private Button orderManageButton;
    @FXML
    private Button creditIncreaseButton;
    @FXML
    private Button salePromotionButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        websalesmanLabel.setText("欢迎！" + mainApp.getUsername());
    }


    @FXML
    public void orderManageAction() {
        // 更换样式
        this.orderManageButton.getStyleClass().set(1, "button-navigation-selected");
        this.creditIncreaseButton.getStyleClass().set(1, "button-navigation");
        this.salePromotionButton.getStyleClass().set(1, "button-navigation");

        mainApp.showOrderManageView();
    }

    @FXML
    public void creditIncreaseAction() {
        // 更换样式
        this.orderManageButton.getStyleClass().set(1, "button-navigation");
        this.creditIncreaseButton.getStyleClass().set(1, "button-navigation-selected");
        this.salePromotionButton.getStyleClass().set(1, "button-navigation");

        mainApp.showCustomerRoot();
    }

    @FXML
    public void salePromotionAction() {
        // 更换样式
        this.orderManageButton.getStyleClass().set(1, "button-navigation");
        this.creditIncreaseButton.getStyleClass().set(1, "button-navigation");
        this.salePromotionButton.getStyleClass().set(1, "button-navigation-selected");

        mainApp.showSalePromotionView();
    }

    @FXML
    public void signOutAction() {
        mainApp.showSignInView();
    }

}
