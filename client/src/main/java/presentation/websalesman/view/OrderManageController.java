package presentation.websalesman.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import presentation.websalesman.MainApp;
import presentation.websalesman.model.Order;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by 曹利航 on 2016/12/08 18:17.
 */
public class OrderManageController {
    private MainApp mainApp;

    private ObservableList<Order> unexecutedList = FXCollections.observableArrayList();

    // 未执行订单列表
    @FXML
    private TableView<Order> unexecutedTable;
    @FXML
    private TableColumn<Order, String> unexecutedOrderIDColumn;
    @FXML
    private TableColumn<Order, String> unexecutedCustomerIDColumn;
    @FXML
    private TableColumn<Order, String> unexecutedRoomTypeColumn;
    @FXML
    private TableColumn<Order, String> unexecutedRoomNumberColumn;
    @FXML
    private TableColumn<Order, String> unexecutedPeopleNumberColumn;
    @FXML
    private TableColumn<Order, String> unexecutedChildColumn;
    @FXML
    private TableColumn<Order, String> unexecutedExceptInTimeColumn;
    @FXML
    private TableColumn<Order, String> unexecutedExceptOutTimeColumn;
    @FXML
    private TableColumn<Order, String> unexecutedPriceColumn;
    @FXML
    private TableColumn<Order, String> unexecutedChargeColumn;

    @FXML
    private BorderPane abnormalOrderRoot;

    @FXML
    private TextField orderIDField;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        setTable();
    }

    public BorderPane getOrderManageRoot() {
        return abnormalOrderRoot;
    }

    private void setTable() {
        ArrayList<OrderVO> unexecutedOrderList = mainApp.getOrderService().getUnexcutedOrderList();

        for (int i = 0; i < unexecutedOrderList.size(); i++) {
            unexecutedList.add(new Order(unexecutedOrderList.get(i)));
        }
        unexecutedTable.setItems(unexecutedList);
    }

    @FXML
    private void initialize() {
        unexecutedOrderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        unexecutedCustomerIDColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty());
        unexecutedRoomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        unexecutedRoomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumberProperty());
        unexecutedPeopleNumberColumn.setCellValueFactory(cellData -> cellData.getValue().peopleNumberProperty());
        unexecutedChildColumn.setCellValueFactory(cellData -> cellData.getValue().hasChildProperty());
        unexecutedExceptInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().expectCheckInTimeProperty());
        unexecutedExceptOutTimeColumn.setCellValueFactory(cellData -> cellData.getValue().expectCheckOutTimeProperty());
        unexecutedPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        unexecutedChargeColumn.setCellValueFactory(cellData -> cellData.getValue().chargeProperty());
    }

    @FXML
    private void searchAction() {
        String orderID = orderIDField.getText();

        OrderVO orderVO = mainApp.getOrderService().getAbnomalOrder(Integer.valueOf(orderID));
        if (orderVO != null) {
            mainApp.showAbnormalOrderView(orderVO);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("订单号不存在 或 不为异常订单");
            alert.setContentText("请检查订单号 该订单或已被撤销");
            alert.showAndWait();
        }
    }
}
