package presentation.customer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.customer.view.*;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.SearchInfoVO;

import java.io.IOException;

/**
 * Created by 啊 on 2016/12/5.
 */
public class MainAPP extends Application{
    private Stage primaryStage;
    private BorderPane rootLayout;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("顾客");
        showSignInView();
    }
    public void showRootView(CustomerVO customerVO) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            RootLayoutController controller = loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSearchView(CustomerVO customerVO) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/search.fxml"));
            AnchorPane search=(AnchorPane)loader.load();
            rootLayout.setCenter(search);
            SearchController controller = loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSignUpView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/SignUp.fxml"));
            Scene scene=new Scene( loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
            SignUpController controller=loader.getController();
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSignUpBirthdayView(CustomerVO customerVO){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/SignUp_Birthday.fxml"));
            Scene scene=new Scene(loader.load());
            primaryStage.setScene(scene);
            SignUp_BirthdayController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSignUpEnterpriseView(CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/SignUp_Enterprise.fxml"));
            Scene scene=new Scene( loader.load());
            primaryStage.setScene(scene);
            SignUp_EnterpriseController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSignInView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/SignIn.fxml"));
            Scene scene=new Scene( loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
            SignInController controller=loader.getController();
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOrderInfoView(CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/OrderInfo.fxml"));
            AnchorPane order=(AnchorPane)loader.load();
            rootLayout.setCenter(order);
            OrderInfoController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOrderInfoView(CustomerVO customerVO, HotelInfoVO hotelInfoVO) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/OrderInfo.fxml"));
            AnchorPane order=(AnchorPane)loader.load();
            rootLayout.setCenter(order);
            OrderInfoController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setHotelInfoVO(hotelInfoVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showDetailedCreditField(CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerCreditInfo.fxml"));
            AnchorPane credit=(AnchorPane)loader.load();
            rootLayout.setCenter(credit);
            CreditInfoController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showCustomerInfoModifyView(CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerInfoModify.fxml"));
            AnchorPane modify=(AnchorPane)loader.load();
            rootLayout.setCenter(modify);
            CustomerInfoModifyController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDetailedSearchView(CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/DetailedSearch.fxml"));
            AnchorPane search=(AnchorPane)loader.load();
            rootLayout.setCenter(search);
            DetailedSearchController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonalInformationView(CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerInfo.fxml"));
            AnchorPane information=(AnchorPane)loader.load();
            rootLayout.setCenter(information);
            CustomerInfoController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOrderGeneratedView(CustomerVO customerVO,String hotelName, SearchInfoVO searchInfoVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerOrderGenerated1.fxml"));
            AnchorPane generate=(AnchorPane)loader.load();
            rootLayout.setCenter(generate);
            OrderGeneratedController controller=loader.getController();
            controller.setHotelVO(hotelName);
            controller.setCustomerVO(customerVO);
            controller.setSearchInfoVO(searchInfoVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSearchHotelView(CustomerVO customerVO, SearchInfoVO searchInfoVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/SearchHotel.fxml"));
            AnchorPane search=(AnchorPane)loader.load();
            rootLayout.setCenter(search);
            SearchHotelController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setSearchInfoVO(searchInfoVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOrderGenerated2ControllerView(CustomerVO customerVO, OrderVO orderVO, HotelInfoVO hotelInfoVO, SearchInfoVO searchInfoVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerOrderGenerated.fxml"));
            AnchorPane generate=(AnchorPane)loader.load();
            rootLayout.setCenter(generate);
            OrderGenerated2Controller controller=loader.getController();
            controller.setOrderVO(orderVO);
            controller.setCustomerVO(customerVO);
            controller.setHotelVO(hotelInfoVO);
            controller.setSearchInfoVO(searchInfoVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHotelInfoView(CustomerVO customerVO,String hotelName, SearchInfoVO searchInfoVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/HotelInfo.fxml"));
            AnchorPane hotel=(AnchorPane)loader.load();
            rootLayout.setCenter(hotel);
            HotelInfoController controller=loader.getController();
            controller.setCustomer(customerVO);
            controller.setSearchInfoVO(searchInfoVO);
            controller.setHotelInfoVO(hotelName);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch();
    }

    public void showCustomerEvaluateView(CustomerVO customerVO, OrderVO orderVO,HotelInfoVO hotelInfoVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/CustomerEvaluate.fxml"));
            AnchorPane evaluate=(AnchorPane)loader.load();
            rootLayout.setCenter(evaluate);
            CustomerEvaluateController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setOrderVO(orderVO);
            controller.setHotelInfoVO(hotelInfoVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLivedHotelView(CustomerVO customerVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAPP.class.getResource("view/livedHotel.fxml"));
            AnchorPane lived=(AnchorPane)loader.load();
            rootLayout.setCenter(lived);
            LivedHotelController controller=loader.getController();
            controller.setCustomerVO(customerVO);
            controller.setMainAPP(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void informationAlert(String information) {
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(information);
        alert.showAndWait();
    }
    public void errorAlert(String information){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("错误");
        alert.setHeaderText(null);
        alert.setContentText(information);
        alert.showAndWait();
    }
}
