package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogic.orderbl.OrderImpl;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import presentation.customer.MainAPP;
import util.OrderType;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.OrderVO;

import java.util.List;


/**
 * Created by 啊 on 2016/11/29.
 */
//还没有写查询在特定酒店下的订单
public class OrderInfoController {
    private MainAPP mainAPP;
    private CustomerVO customerVO;
    private HotelInfoVO hotelVO;
    private List<OrderVO> list;
    private OrderBLservice orderBLservice;
    private ViewOrder viewUnexecutedOrder;
    private ViewOrder viewExecutedOrder;
    @FXML
    private ImageView imageView;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
   @FXML
   private TableView<ViewOrder> executedOrderTable;
    @FXML
    private TableView<ViewOrder> unexecutedOrderTable;
    @FXML
    private TableView<ViewOrder> unusualOrderTable;
    @FXML
    private TableView<ViewOrder> cancelOrderTable;
    @FXML
    private TableColumn<ViewOrder,String> orderId1;
    @FXML
    private TableColumn<ViewOrder,String> hotelName1;
    @FXML
    private TableColumn<ViewOrder,String> roomType1;
    @FXML
    private TableColumn<ViewOrder,String> roomNum1;
    @FXML
    private TableColumn<ViewOrder,String> peopleNum1;
    @FXML
    private TableColumn<ViewOrder,String> whetherChild1;
    @FXML
    private TableColumn<ViewOrder,String> originPrice1;
    @FXML
    private TableColumn<ViewOrder,String> actualPrice1;
    @FXML
    private TableColumn<ViewOrder,String> orderId2;
    @FXML
    private TableColumn<ViewOrder,String> hotelName2;
    @FXML
    private TableColumn<ViewOrder,String> roomType2;
    @FXML
    private TableColumn<ViewOrder,String> roomNum2;
    @FXML
    private TableColumn<ViewOrder,String> peopleNum2;
    @FXML
    private TableColumn<ViewOrder,String> whetherChild2;
    @FXML
    private TableColumn<ViewOrder,String> originPrice2;
    @FXML
    private TableColumn<ViewOrder,String> actualPrice2;
    @FXML
    private TableColumn<ViewOrder,String> orderId3;
    @FXML
    private TableColumn<ViewOrder,String> hotelName3;
    @FXML
    private TableColumn<ViewOrder,String> roomType3;
    @FXML
    private TableColumn<ViewOrder,String> roomNum3;
    @FXML
    private TableColumn<ViewOrder,String> peopleNum3;
    @FXML
    private TableColumn<ViewOrder,String> whetherChild3;
    @FXML
    private TableColumn<ViewOrder,String> originPrice3;
    @FXML
    private TableColumn<ViewOrder,String> actualPrice3;
    @FXML
    private TableColumn<ViewOrder,String> orderId4;
    @FXML
    private TableColumn<ViewOrder,String> hotelName4;
    @FXML
    private TableColumn<ViewOrder,String> roomType4;
    @FXML
    private TableColumn<ViewOrder,String> roomNum4;
    @FXML
    private TableColumn<ViewOrder,String> peopleNum4;
    @FXML
    private TableColumn<ViewOrder,String> whetherChild4;
    @FXML
    private TableColumn<ViewOrder,String> originPrice4;
    @FXML
    private TableColumn<ViewOrder,String> actualPrice4;
    @FXML
    private Button cancelOrderButton;
    @FXML
    private Button evaluateButton;

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
        orderBLservice=OrderImpl.getMemberOrderInstance(customerVO.getUserName());
        list= (List<OrderVO>) orderBLservice.getOrderVOList();
    }   //这里同时实现了获得orderList列表
    public void setHotelInfoVO(HotelInfoVO hotelInfoVO) {
        this.hotelVO=hotelInfoVO;
        getOrderList();          //setCustomerVO在setHotelInfoVO之前
    }
    public void getOrderList() {
        if(hotelVO==null)
            list= (List<OrderVO>) orderBLservice.getOrderVOList();
        else {
            list = (List<OrderVO>) orderBLservice.getSpecificHotelOrderList(customerVO.getCustomerName());
        }
    }
    public void setMainAPP(MainAPP mainAPP) {
        this.mainAPP=mainAPP;
    }

    private  ObservableList setOrder(OrderType orderType){
        ObservableList<ViewOrder> tempViewList= FXCollections.observableArrayList();
        for (OrderVO tempOrderVO : list) {
            if(tempOrderVO.getStatus().equals(orderType))
                tempViewList.add(new ViewOrder(tempOrderVO.getOrderID(),tempOrderVO.getHotel(),tempOrderVO.getRoomID(),
                    tempOrderVO.getRoomNum(),tempOrderVO.getPeopleNum(),
                    tempOrderVO.getHasChild(),tempOrderVO.getPrice(),tempOrderVO.getCharge()));
        }
        return tempViewList;
    }
    @FXML
    private void setExecutedOrderTable(){
        ObservableList observableList=setOrder(OrderType.Executed);
        executedOrderTable.setItems(observableList);
        viewExecutedOrder=null;
        executedOrderTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showExecutedChanges(newValue));
    }

    private void showExecutedChanges(ViewOrder newValue) {
        viewExecutedOrder=newValue;
    }

    @FXML
    private void setUnexecutedOrderTable(){
        ObservableList observableList=setOrder(OrderType.Unexecuted);
        unexecutedOrderTable.setItems(observableList);
        viewUnexecutedOrder=null;
        unexecutedOrderTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showUnexecutedDetails(newValue));
    }

    private void showUnexecutedDetails(ViewOrder newValue) {
        viewUnexecutedOrder=newValue;
    }

    @FXML
    private void setUnusualOrderTable(){
        ObservableList observableList=setOrder(OrderType.Abnormol);
        unusualOrderTable.setItems(observableList);
    }
    @FXML
    private void setCancelOrderTable(){
        ObservableList observableList=setOrder(OrderType.Canceled);
        cancelOrderTable.setItems(observableList);
    }

    @FXML
    private void initialize(){
        orderId1.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        hotelName1.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        roomType1.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        roomNum1.setCellValueFactory(cellData->cellData.getValue().roomNumProperty());
        peopleNum1.setCellValueFactory(cellData->cellData.getValue().peopleNumProperty());
        whetherChild1.setCellValueFactory(cellData->cellData.getValue().hasChildProperty());
        originPrice1.setCellValueFactory(cellData->cellData.getValue().originPriceProperty());
        actualPrice1.setCellValueFactory(cellData->cellData.getValue().actualPriceProperty());
        orderId2.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        hotelName2.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        roomType2.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        roomNum2.setCellValueFactory(cellData->cellData.getValue().roomNumProperty());
        peopleNum2.setCellValueFactory(cellData->cellData.getValue().peopleNumProperty());
        whetherChild2.setCellValueFactory(cellData->cellData.getValue().hasChildProperty());
        originPrice2.setCellValueFactory(cellData->cellData.getValue().originPriceProperty());
        actualPrice2.setCellValueFactory(cellData->cellData.getValue().actualPriceProperty());
        orderId2.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        hotelName2.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        roomType2.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        roomNum2.setCellValueFactory(cellData->cellData.getValue().roomNumProperty());
        peopleNum2.setCellValueFactory(cellData->cellData.getValue().peopleNumProperty());
        whetherChild2.setCellValueFactory(cellData->cellData.getValue().hasChildProperty());
        originPrice2.setCellValueFactory(cellData->cellData.getValue().originPriceProperty());
        actualPrice2.setCellValueFactory(cellData->cellData.getValue().actualPriceProperty());
        orderId3.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        hotelName3.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        roomType3.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        roomNum3.setCellValueFactory(cellData->cellData.getValue().roomNumProperty());
        peopleNum3.setCellValueFactory(cellData->cellData.getValue().peopleNumProperty());
        whetherChild3.setCellValueFactory(cellData->cellData.getValue().hasChildProperty());
        originPrice3.setCellValueFactory(cellData->cellData.getValue().originPriceProperty());
        actualPrice3.setCellValueFactory(cellData->cellData.getValue().actualPriceProperty());
        orderId4.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        hotelName4.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        roomType4.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        roomNum4.setCellValueFactory(cellData->cellData.getValue().roomNumProperty());
        peopleNum4.setCellValueFactory(cellData->cellData.getValue().peopleNumProperty());
        whetherChild4.setCellValueFactory(cellData->cellData.getValue().hasChildProperty());
        originPrice4.setCellValueFactory(cellData->cellData.getValue().originPriceProperty());
        actualPrice4.setCellValueFactory(cellData->cellData.getValue().actualPriceProperty());
    }
    @FXML
    private void setCancelOrderButton(){
        if(viewUnexecutedOrder!=null){
            orderBLservice.cancelOrder(Integer.parseInt(viewUnexecutedOrder.getOrderID()));
            //提示取消成功
        }
        else{
            //提示请先选择
        }
    }
    @FXML
    private void setEvaluateButton(){
        if(viewUnexecutedOrder!=null){
            OrderVO orderVO=orderBLservice.getOrderInfo(Integer.parseInt(viewExecutedOrder.getOrderID()));
            HotelBLService hotelBLService=new Hotel();
            HotelInfoVO hotelInfoVO=hotelBLService.getHotelInfo(viewExecutedOrder.getHotelName());
            mainAPP.showCustomerEvaluateView(customerVO,orderVO,hotelInfoVO);
            //弹出
        }
        //弹出
    }

}
