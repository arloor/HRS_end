package presentation.websalesman;

/**
 * Created by 曹利航 on 2016/12/03 16:11.
 */

import businesslogic.creditbl.Credit;
import businesslogic.customerbl.Customer;
import businesslogic.managerbl.Manager;
import businesslogic.orderbl.WebManagerOrderImpl;
import businesslogic.promotionbl.Promotion;
import businesslogicservice.creditblservice.CreditBLservice;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.managerblservice.ManagerBLService;
import businesslogicservice.orderbusinesslogicservice.WebManagerOrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.websalesman.model.CirclePromotion;
import presentation.websalesman.model.LevelPromotion;
import presentation.websalesman.view.*;
import util.ManagerType;
import util.ResultMessage;
import vo.CustomerVO;
import vo.ManagerVO;
import vo.OrderVO;

import java.io.IOException;

public class MainApp extends Application {
    private Alert alert;

    private Stage primaryStage;
    private BorderPane rootLayout;
    private BorderPane customerRoot;
    private BorderPane orderManageRoot;
    private String username;
    private ManagerVO managerVO;


    private ManagerBLService managerBLService = new Manager();
    private PromotionBLService promotionBLService = new Promotion();
    private CreditBLservice creditBLService;
    private WebManagerOrderBLService orderBLService = new WebManagerOrderImpl();
    private CustomerBLService customerBLService = new Customer();

    public ManagerBLService getManagerService() {
        return managerBLService;
    }

    public PromotionBLService getPromotionService() {
        return promotionBLService;
    }

    public CreditBLservice getCreditService(String username) {
        creditBLService = new Credit(username);
        return creditBLService;
    }

    public WebManagerOrderBLService getOrderService() {
        return orderBLService;
    }

    public CustomerBLService getCustomerService() {
        return customerBLService;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CDLL酒店预订系统 - 网站营销人员");
        this.primaryStage.getIcons().add(new Image("/presentation/icon_title.png"));

        showSignInView();
    }

    public void signIn(String username, String password) {
        ResultMessage rm = managerBLService.login(ManagerType.WebSalesMan, username, password);

        if (rm.equals(ResultMessage.USER_EXIST)) {
            this.username = username;
            this.managerVO = managerBLService.getManagerInfo(ManagerType.WebSalesMan, username);

            showRootLayout();
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("登录失败");
            alert.setContentText("用户名或密码错误");
            alert.showAndWait();
        }
    }


    public LevelPromotion showLevelPromotionDialog(LevelPromotion levelPromotion) {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelPromotion.fxml"));

            // Create the dialog stage.
            Stage levelPromotionDialog = new Stage();
            levelPromotionDialog.getIcons().add(new Image("/presentation/icon_title.png"));
            levelPromotionDialog.setTitle("VIP会员专属折扣");
            levelPromotionDialog.initModality(Modality.WINDOW_MODAL);
            levelPromotionDialog.initOwner(primaryStage);
            levelPromotionDialog.setResizable(false);

            // Show the scene containing the root layout.
            Scene scene = new Scene(loader.load());
            levelPromotionDialog.setScene(scene);

            LevelPromotionController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(levelPromotionDialog);
            controller.setLevelPromotion(levelPromotion);

            levelPromotionDialog.showAndWait();

            if (levelPromotion == null) {
                return controller.getLevelPromotion();
            } else {
                return levelPromotion;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CirclePromotion showCirclePromotionDialog(CirclePromotion circlePromotion) {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CirclePromotion.fxml"));

            // Create the dialog stage.
            Stage circlePromotionDialog = new Stage();
            circlePromotionDialog.getIcons().add(new Image("/presentation/icon_title.png"));
            circlePromotionDialog.setTitle("特定商圈折扣");
            circlePromotionDialog.initModality(Modality.WINDOW_MODAL);
            circlePromotionDialog.initOwner(primaryStage);
            circlePromotionDialog.setResizable(false);

            // Show the scene containing the root layout.
            Scene scene = new Scene(loader.load());
            circlePromotionDialog.setScene(scene);

            CirclePromotionController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(circlePromotionDialog);
            controller.setCirclePromotion(circlePromotion);

            circlePromotionDialog.showAndWait();

            if (circlePromotion == null) {
                return controller.getCirclePromotion();
            } else {
                return circlePromotion;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void showSignInView() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SignIn.fxml"));

            // Show the scene containing the root layout.
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

            SignInController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOrderManageView() {
        try {
            // Load Sign in from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/OrderManage.fxml"));
            TabPane orderManage = (TabPane) loader.load();

            // Set Sign in into the center of root layout.
            rootLayout.setCenter(orderManage);

            // Give the controller access to the main app.
            OrderManageController controller = loader.getController();
            controller.setMainApp(this);

            this.orderManageRoot = controller.getOrderManageRoot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAbnormalOrderView(OrderVO orderVO) {
        try {
            // Load Sign in from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AbnormalOrder.fxml"));
            AnchorPane abnormalOrder = (AnchorPane) loader.load();

            // Set Sign in into the center of root layout.
            orderManageRoot.setCenter(abnormalOrder);

            // Give the controller access to the main app.
            AbnormalOrderController controller = loader.getController();
            controller.setMainApp(this);

            controller.setOrderInfo(orderVO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCustomerRoot() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CustomerRoot.fxml"));
            customerRoot = (BorderPane) loader.load();

            // Set into the center of root layout.
            rootLayout.setCenter(customerRoot);

            // Give the controller access to the main app.
            CustomerRootController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreditView(CustomerVO vo) {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Credit.fxml"));
            AnchorPane credit = (AnchorPane) loader.load();

            // Set into the center of root layout.
            customerRoot.setCenter(credit);

            // Give the controller access to the main app.
            CreditController controller = loader.getController();
            controller.setMainApp(this);

            controller.setCustomerInfo(vo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSalePromotionView() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SalePromotion.fxml"));

            // Set into the center of root layout.
            rootLayout.setCenter(loader.load());

            // Give the controller access to the main app.
            SalePromotionController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
