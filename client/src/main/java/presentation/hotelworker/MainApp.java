package presentation.hotelworker;

/**
 * Created by 曹利航 on 2016/12/07 21:03.
 */

import businesslogic.hotelbl.Hotel;
import businesslogic.managerbl.Manager;
import businesslogic.orderbl.OrderImpl;
import businesslogic.promotionbl.Promotion;
import businesslogic.roombl.Room;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.managerblservice.ManagerBLService;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.hotelworker.view.*;
import util.HotelPromotionType;
import util.ManagerType;
import util.ResultMessage;
import vo.AvailableRoomVO;
import vo.HotelInfoVO;
import vo.HotelPromotionVO.HotelBirthdayPromotionVO;
import vo.HotelPromotionVO.HotelCompanyPromotionVO;
import vo.HotelPromotionVO.HotelMultiRoomsPromotionVO;
import vo.HotelPromotionVO.HotelSpecialTimePromotionVO;
import vo.ManagerVO;

import java.io.IOException;
import java.util.ArrayList;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private String username;
    private ManagerVO managerVO;
    private HotelInfoVO hotelInfoVO;

    private ManagerBLService managerBLService = new Manager();
    private HotelBLService hotelBLService = new Hotel();
    private PromotionBLService promotionBLService = new Promotion();
    private RoomBLService roomBLService = new Room();
    private OrderBLservice orderBLservice;

    private HotelBirthdayPromotionVO hotelBirthdayPromotionVO;
    private HotelCompanyPromotionVO hotelCompanyPromotionVO;
    private HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO;
    private HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO;

    public String getUsername() {
        return username;
    }

    public String getHotelName() {
        return hotelInfoVO.getHotelName();
    }

    public ManagerBLService getManagerBLService() {
        return managerBLService;
    }

    public HotelBLService getHotelService() {
        return hotelBLService;
    }

    public PromotionBLService getPromotionService() {
        return promotionBLService;
    }

    public RoomBLService getRoomService() {
        return roomBLService;
    }

    public OrderBLservice getOrderService() {
        return orderBLservice;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CDLL酒店预订系统 - 酒店工作人员");
        this.primaryStage.getIcons().add(new Image("/presentation/icon_title.png"));

        showSignInView();

    }

    public void signIn(String username, String password) {
        ResultMessage rm = managerBLService.login(ManagerType.HotelWorker, username, password);

        if (rm.equals(ResultMessage.USER_EXIST)) {
            this.username = username;
            this.managerVO = managerBLService.getManagerInfo(ManagerType.HotelWorker, username);

            this.hotelInfoVO = hotelBLService.getHotelInfo(this.managerVO.getHotelName());
            this.orderBLservice = OrderImpl.getHotelOrderInstance(this.getHotelName());

            showRootLayout();
        } else {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("登录失败");
            alert.setContentText("用户名或密码错误");
            alert.showAndWait();
        }
    }

    public void updateHotelInfo(HotelInfoVO hotelInfoVO) {
        ResultMessage rm = hotelBLService.modifyHotelInfo(hotelInfoVO);
        Alert alert;
        switch (rm) {
            case SUCCESS:
                this.hotelInfoVO = hotelInfoVO;
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("成功");
                alert.setHeaderText("酒店信息修改成功");
                alert.showAndWait();
                break;
            case FAILED:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("失败");
                alert.setHeaderText("酒店信息修改失败");
                alert.showAndWait();
        }
    }

    public void updateHotelPromotions(HotelBirthdayPromotionVO hotelBirthdayPromotionVO, HotelCompanyPromotionVO hotelCompanyPromotionVO, HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO, HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO) {
        ResultMessage rm;
        Alert alert;
        ArrayList<String> errorPrompts = new ArrayList<>();
        boolean hasError = false;

        rm = promotionBLService.updateHotelPromotion(HotelPromotionType.Birthday, hotelBirthdayPromotionVO);
        switch (rm) {
            case SUCCESS:
                this.hotelBirthdayPromotionVO = hotelBirthdayPromotionVO;
                break;
            case FAILED:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("更新失败");
                alert.setContentText("会员生日特惠更新失败");
                alert.showAndWait();
                hasError = true;
                break;
        }

        rm = promotionBLService.updateHotelPromotion(HotelPromotionType.Company, hotelCompanyPromotionVO);
        switch (rm) {
            case SUCCESS:
                this.hotelCompanyPromotionVO = hotelCompanyPromotionVO;
                break;
            case FAILED:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("更新失败");
                alert.setContentText("合作企业特惠更新失败");
                alert.showAndWait();
                hasError = true;
                break;
        }

        rm = promotionBLService.updateHotelPromotion(HotelPromotionType.MultiRooms, hotelMultiRoomsPromotionVO);
        switch (rm) {
            case SUCCESS:
                this.hotelMultiRoomsPromotionVO = hotelMultiRoomsPromotionVO;
                break;
            case FAILED:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("更新失败");
                alert.setContentText("多间特惠更新失败");
                alert.showAndWait();
                hasError = true;
                break;
        }

        rm = promotionBLService.updateHotelPromotion(HotelPromotionType.SpecialTime, hotelSpecialTimePromotionVO);
        switch (rm) {
            case SUCCESS:
                this.hotelSpecialTimePromotionVO = hotelSpecialTimePromotionVO;
                break;
            case FAILED:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("更新失败");
                alert.setContentText("节日特惠更新失败");
                alert.showAndWait();
                hasError = true;
                break;
        }

        if (!hasError) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("促销信息更新成功");
            alert.showAndWait();
        }
    }


    public String showRoomNumEditDialog() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RoomNumEdit.fxml"));

            // Create the dialog stage.
            Stage roomNumEditDialog = new Stage();
            roomNumEditDialog.getIcons().add(new Image("/presentation/icon_title.png"));
            roomNumEditDialog.setTitle("修改房间数量");
            roomNumEditDialog.initModality(Modality.WINDOW_MODAL);
            roomNumEditDialog.initOwner(primaryStage);
            roomNumEditDialog.setResizable(false);

            // Show the scene containing the root layout.
            Scene scene = new Scene(loader.load());
            roomNumEditDialog.setScene(scene);

            RoomNumEditController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(roomNumEditDialog);

            roomNumEditDialog.showAndWait();

            return controller.getInfo();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AvailableRoomVO showNewRoomTypeDialog() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/NewRoomType.fxml"));

            // Create the dialog stage.
            Stage newRoomTypeDialog = new Stage();
            newRoomTypeDialog.getIcons().add(new Image("/presentation/icon_title.png"));
            newRoomTypeDialog.setTitle("新增房间类型");
            newRoomTypeDialog.initModality(Modality.WINDOW_MODAL);
            newRoomTypeDialog.initOwner(primaryStage);
            newRoomTypeDialog.setResizable(false);

            // Show the scene containing the root layout.
            Scene scene = new Scene(loader.load());
            newRoomTypeDialog.setScene(scene);

            NewRoomTypeController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(newRoomTypeDialog);

            newRoomTypeDialog.showAndWait();

            return controller.getVO();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean showOrderExecuteDialog() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/OrderExecute.fxml"));

            // Create the dialog stage.
            Stage orderExecuteDialog = new Stage();
            orderExecuteDialog.getIcons().add(new Image("/presentation/icon_title.png"));
            orderExecuteDialog.setTitle("执行订单");
            orderExecuteDialog.initModality(Modality.WINDOW_MODAL);
            orderExecuteDialog.initOwner(primaryStage);
            orderExecuteDialog.setResizable(false);

            // Show the scene containing the root layout.
            Scene scene = new Scene(loader.load());
            orderExecuteDialog.setScene(scene);

            OrderExecuteController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(orderExecuteDialog);

            orderExecuteDialog.showAndWait();

            return controller.isConfirmed();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showCheckOutDialog() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CheckOut.fxml"));

            // Create the dialog stage.
            Stage checkOutDialog = new Stage();
            checkOutDialog.getIcons().add(new Image("/presentation/icon_title.png"));
            checkOutDialog.setTitle("退房");
            checkOutDialog.initModality(Modality.WINDOW_MODAL);
            checkOutDialog.initOwner(primaryStage);
            checkOutDialog.setResizable(false);

            // Show the scene containing the root layout.
            Scene scene = new Scene(loader.load());
            checkOutDialog.setScene(scene);

            CheckOutController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(checkOutDialog);

            checkOutDialog.showAndWait();

            return controller.isConfirmed();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



    public void showSignInView() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SignIn.fxml"));
            AnchorPane signIn = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(signIn);
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
            primaryStage.show();

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHotelInfoView() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/HotelInfo.fxml"));
            GridPane hotelInfo = (GridPane) loader.load();

            // Set into the center of root layout.
            rootLayout.setCenter(hotelInfo);

            // Give the controller access to the main app.
            HotelInfoController controller = loader.getController();
            controller.setMainApp(this);

            controller.setHotelInfo(hotelInfoVO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOrderManageView() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/OrderManage.fxml"));

            // Set into the center of root layout.
            rootLayout.setCenter(loader.load());

            // Give the controller access to the main app.
            OrderManageController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRoomManageView() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RoomManage.fxml"));
            AnchorPane roomManage = (AnchorPane) loader.load();

            // Set into the center of root layout.
            rootLayout.setCenter(roomManage);

            // Give the controller access to the main app.
            RoomManageController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSalePromotionView() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SalePromotion.fxml"));
            GridPane salePromotion = (GridPane) loader.load();

            // Set into the center of root layout.
            rootLayout.setCenter(salePromotion);

            // Give the controller access to the main app.
            SalePromotionController controller = loader.getController();
            controller.setMainApp(this);

            // Get VOs.
            hotelBirthdayPromotionVO = (HotelBirthdayPromotionVO) promotionBLService.getHotelPromotion(HotelPromotionType.Birthday, this.hotelInfoVO.getHotelName());
            hotelCompanyPromotionVO = (HotelCompanyPromotionVO) promotionBLService.getHotelPromotion(HotelPromotionType.Company, this.hotelInfoVO.getHotelName());
            hotelMultiRoomsPromotionVO = (HotelMultiRoomsPromotionVO) promotionBLService.getHotelPromotion(HotelPromotionType.MultiRooms, this.hotelInfoVO.getHotelName());
            hotelSpecialTimePromotionVO = (HotelSpecialTimePromotionVO) promotionBLService.getHotelPromotion(HotelPromotionType.SpecialTime, this.hotelInfoVO.getHotelName());

            // Set sale promotion information.
            controller.setSalePromotions(hotelBirthdayPromotionVO, hotelCompanyPromotionVO, hotelMultiRoomsPromotionVO, hotelSpecialTimePromotionVO);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
