package presentation.webmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.webmanager.view.*;
import vo.CustomerVO;
import vo.ManagerVO;

import java.io.IOException;

/**
 * Created by 啊 on 2016/12/5.
 */
public class MainAPP extends Application{
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CDLL酒店预订系统—网站管理人员");
        this.primaryStage.getIcons().add(new Image("/presentation/icon_title.png"));
        showSignInView();
    }
    public void showRootLayout(ManagerVO managerVO) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            RootLayOutController controller = loader.getController();
            controller.setManagerVO(managerVO);
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSignInView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/SignIn.fxml"));
            AnchorPane signIn=loader.load();
            Scene scene=new Scene( signIn);
            primaryStage.setScene(scene);
            SignInController controller = loader.getController();
            controller.setMainAPP(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreditInfoView(ManagerVO webManagerVO, CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerCreditInfo.fxml"));
            AnchorPane credit=(AnchorPane) loader.load();
            rootLayout.setCenter(credit);
            CreditInfoController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setWebManagerVO(webManagerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showCustomerInfoModifyView(ManagerVO webManagerVO, CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerInfoModify.fxml"));
            AnchorPane modify=(AnchorPane)loader.load();
            rootLayout.setCenter(modify);
            CustomerInfoModifyController controller=loader.getController();
            controller.setWebManagerVO(webManagerVO);
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCustomerInfoView(ManagerVO webManagerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerInfo.fxml"));
            AnchorPane info=(AnchorPane)loader.load();
            rootLayout.setCenter(info);
            CustomerInfoController controller=loader.getController();
            controller.setWebManagerVO(webManagerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddWebSalesManView(ManagerVO webManagerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/AddWebSalesMan.fxml"));
            AnchorPane add=(AnchorPane) loader.load();
            rootLayout.setCenter(add);
            AddWebSalesManController controller=loader.getController();
            controller.setWebManagerVO(webManagerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddHotelView(ManagerVO webManagerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/HotelAddition.fxml"));
            GridPane addHotel=(GridPane) loader.load();
            rootLayout.setCenter(addHotel);
            HotelAdditionController controller=loader.getController();
            controller.setWebManagerVO(webManagerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddHotelWorkerView(ManagerVO webManagerVO, String text) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/HotelWorkerAddition.fxml"));
            AnchorPane addWorker=(AnchorPane)loader.load();
            rootLayout.setCenter(addWorker);
            HotelWorkerAdditionController controller=loader.getController();
            controller.setWebManagerVO(webManagerVO);
            controller.setHotelName(text);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void showManagerInfoView(ManagerVO webManagerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/ManagerInfo.fxml"));
            AnchorPane info=(AnchorPane)loader.load();
            rootLayout.setCenter(info);
            ManagerInfoController controller=loader.getController();
            controller.setWebManagerVO(webManagerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showManagerInfoModifyView(ManagerVO webManagerVO, ManagerVO managerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/ManagerInfoModify.fxml"));
            AnchorPane modify=(AnchorPane)loader.load();
            rootLayout.setCenter(modify);
            ManagerInfoModifyController controller=loader.getController();
            controller.setWebManagerVO(webManagerVO);
            controller.setManagerVO(managerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void errorAlert(String str){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
    public void informationAlert(String str){
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
}
