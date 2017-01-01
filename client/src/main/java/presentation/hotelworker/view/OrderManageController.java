package presentation.hotelworker.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.hotelworker.MainApp;
import presentation.hotelworker.model.Order;
import util.OrderType;
import util.Time;
import vo.OrderVO;

import java.util.Map;

/**
 * Created by 曹利航 on 2016/12/08 11:50.
 */
public class OrderManageController {
    private MainApp mainApp;
    private ObservableList<Order> unexecutedList = FXCollections.observableArrayList();
    private ObservableList<Order> executedList = FXCollections.observableArrayList();
    private ObservableList<Order> canceledList = FXCollections.observableArrayList();
    private ObservableList<Order> abnormalList = FXCollections.observableArrayList();

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

    // 已执行订单列表
    @FXML
    private TableView<Order> executedTable;
    @FXML
    private TableColumn<Order, String> executedOrderIDColumn;
    @FXML
    private TableColumn<Order, String> executedCustomerIDColumn;
    @FXML
    private TableColumn<Order, String> executedRoomTypeColumn;
    @FXML
    private TableColumn<Order, String> executedRoomNumberColumn;
    @FXML
    private TableColumn<Order, String> executedPeopleNumberColumn;
    @FXML
    private TableColumn<Order, String> executedChildColumn;
    @FXML
    private TableColumn<Order, String> executedExceptInTimeColumn;
    @FXML
    private TableColumn<Order, String> executedActualInTimeColumn;
    @FXML
    private TableColumn<Order, String> executedExceptOutTimeColumn;
    @FXML
    private TableColumn<Order, String> executedActualOutTimeColumn;
    @FXML
    private TableColumn<Order, String> executedPriceColumn;
    @FXML
    private TableColumn<Order, String> executedChargeColumn;

    // 已撤销订单列表
    @FXML
    private TableView<Order> canceledTable;
    @FXML
    private TableColumn<Order, String> canceledOrderIDColumn;
    @FXML
    private TableColumn<Order, String> canceledCustomerIDColumn;
    @FXML
    private TableColumn<Order, String> canceledRoomTypeColumn;
    @FXML
    private TableColumn<Order, String> canceledRoomNumberColumn;
    @FXML
    private TableColumn<Order, String> canceledPeopleNumberColumn;
    @FXML
    private TableColumn<Order, String> canceledChildColumn;
    @FXML
    private TableColumn<Order, String> canceledCancelTimeColumn;
    @FXML
    private TableColumn<Order, String> canceledPriceColumn;
    @FXML
    private TableColumn<Order, String> canceledChargeColumn;

    // 异常订单列表
    @FXML
    private TableView<Order> abnormalTable;
    @FXML
    private TableColumn<Order, String> abnormalOrderIDColumn;
    @FXML
    private TableColumn<Order, String> abnormalCustomerIDColumn;
    @FXML
    private TableColumn<Order, String> abnormalRoomTypeColumn;
    @FXML
    private TableColumn<Order, String> abnormalRoomNumberColumn;
    @FXML
    private TableColumn<Order, String> abnormalPeopleNumberColumn;
    @FXML
    private TableColumn<Order, String> abnormalChildColumn;
    @FXML
    private TableColumn<Order, String> abnormalExceptInTimeColumn;
    @FXML
    private TableColumn<Order, String> abnormalPriceColumn;
    @FXML
    private TableColumn<Order, String> abnormalChargeColumn;

    @FXML
    private Button unexecutedButton;
    @FXML
    private Button abnormalButton;
    @FXML
    private Button executedButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        this.setTables();
    }

    public void setTables() {
        setUnexecutedTable();
        setExecutedTable();
        setAbnormalTable();
        setCanceledTable();
    }

    @FXML
    private void initialize() {
        // 初始化未执行订单列表
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

        // 初始化已执行订单列表
        executedOrderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        executedCustomerIDColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty());
        executedRoomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        executedRoomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumberProperty());
        executedPeopleNumberColumn.setCellValueFactory(cellData -> cellData.getValue().peopleNumberProperty());
        executedChildColumn.setCellValueFactory(cellData -> cellData.getValue().hasChildProperty());
        executedExceptInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().expectCheckInTimeProperty());
        executedActualInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().actualCheckInTimeProperty());
        executedExceptOutTimeColumn.setCellValueFactory(cellData -> cellData.getValue().expectCheckOutTimeProperty());
        executedActualOutTimeColumn.setCellValueFactory(cellData -> cellData.getValue().actualCheckOutTimeProperty());
        executedPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        executedChargeColumn.setCellValueFactory(cellData -> cellData.getValue().chargeProperty());

        // 初始化已撤销订单列表
        canceledOrderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        canceledCustomerIDColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty());
        canceledRoomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        canceledRoomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumberProperty());
        canceledPeopleNumberColumn.setCellValueFactory(cellData -> cellData.getValue().peopleNumberProperty());
        canceledChildColumn.setCellValueFactory(cellData -> cellData.getValue().hasChildProperty());
        canceledCancelTimeColumn.setCellValueFactory(cellData -> cellData.getValue().cancelTimeProperty());
        canceledPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        canceledChargeColumn.setCellValueFactory(cellData -> cellData.getValue().chargeProperty());

        // 初始化异常订单列表
        abnormalOrderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        abnormalCustomerIDColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty());
        abnormalRoomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        abnormalRoomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumberProperty());
        abnormalPeopleNumberColumn.setCellValueFactory(cellData -> cellData.getValue().peopleNumberProperty());
        abnormalChildColumn.setCellValueFactory(cellData -> cellData.getValue().hasChildProperty());
        abnormalExceptInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().expectCheckInTimeProperty());
        abnormalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        abnormalChargeColumn.setCellValueFactory(cellData -> cellData.getValue().chargeProperty());
    }

    private void setUnexecutedTable() {
        Map<Integer, OrderVO> orderMap = mainApp.getOrderService().getOrderListByType(OrderType.Unexecuted);
        for (Integer i : orderMap.keySet()) {
            unexecutedList.add(new Order(orderMap.get(i)));
        }
        unexecutedTable.setItems(unexecutedList);
    }

    private void setExecutedTable() {
        Map<Integer, OrderVO> orderMap = mainApp.getOrderService().getOrderListByType(OrderType.Executed);
        for (Integer i : orderMap.keySet()) {
            executedList.add(new Order(orderMap.get(i)));
        }
        executedTable.setItems(executedList);
    }

    private void setCanceledTable() {
        Map<Integer, OrderVO> orderMap = mainApp.getOrderService().getOrderListByType(OrderType.Canceled);
        for (Integer i : orderMap.keySet()) {
            canceledList.add(new Order(orderMap.get(i)));
        }
        canceledTable.setItems(canceledList);
    }

    private void setAbnormalTable() {
        Map<Integer, OrderVO> orderMap = mainApp.getOrderService().getOrderListByType(OrderType.Abnormol);
        for (Integer i : orderMap.keySet()) {
            abnormalList.add(new Order(orderMap.get(i)));
        }
        abnormalTable.setItems(abnormalList);
    }


    @FXML
    private void unexecutedAction() {
        int selectedIndex = unexecutedTable.getSelectionModel().getSelectedIndex();
        Order selectedItem = unexecutedTable.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) { // 选种某项
            boolean isConfirmed = mainApp.showOrderExecuteDialog();
            if (isConfirmed) {
                if (mainApp.getOrderService().executeOrder(Integer.valueOf(selectedItem.getOrderID()))) {
                    if (mainApp.getOrderService().updateCheckinInfo(Integer.valueOf(selectedItem.getOrderID()), Time.getCurrentTIme())) {
                        mainApp.showOrderManageView();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("成功");
                        alert.setHeaderText("订单已执行");
                        alert.showAndWait();
                    }
                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.showAndWait();
        }

    }

    @FXML
    private void executedAction() {
        int selectedIndex = executedTable.getSelectionModel().getSelectedIndex();
        Order selectedItem = executedTable.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) { // 选种某项
            if (selectedItem.getActualCheckOutTime().equals("未退房")) { // 该订单未退房
                if (mainApp.showCheckOutDialog()) {
                    if (mainApp.getOrderService().updateCheckoutInfo(Integer.valueOf(selectedItem.getOrderID()), Time.getCurrentTIme())) {
                        mainApp.showOrderManageView();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("成功");
                        alert.setHeaderText("退房成功");
                        alert.showAndWait();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告");
                alert.setHeaderText("退房失败");
                alert.setContentText("该房间已退房！");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.showAndWait();
        }
    }

    @FXML
    private void abnormalAction() {
        int selectedIndex = abnormalTable.getSelectionModel().getSelectedIndex();
        Order selectedItem = abnormalTable.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) { // 选种某项
            if (mainApp.showOrderExecuteDialog()) {
                if (mainApp.getOrderService().executeOrder(Integer.valueOf(selectedItem.getOrderID()))) {
                    if (mainApp.getOrderService().updateCheckinInfo(Integer.valueOf(selectedItem.getOrderID()), Time.getCurrentTIme())) {
                        mainApp.showOrderManageView();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("成功");
                        alert.setHeaderText("已执行该异常订单");
                        alert.showAndWait();
                    }
                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.showAndWait();
        }
    }


}
