package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogic.orderbl.OrderImpl;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.customer.MainAPP;
import util.ResultMessage;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 啊 on 2016/11/29.
 */

public class OrderInfoController {
    private MainAPP mainAPP;
    private CustomerVO customerVO;
    private HotelInfoVO hotelVO;
    private List<OrderVO> list;
    private OrderBLservice orderBLservice;

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
   private TableColumn<ViewOrder,String> lastestCheckInTime;
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
    private TableColumn<ViewOrder,String> startTime;
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
    private TableColumn<ViewOrder,String> cancelTime;

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
        orderBLservice=OrderImpl.getMemberOrderInstance(customerVO.getUserName());
    }
    public void setHotelInfoVO(HotelInfoVO hotelInfoVO) {
        this.hotelVO=hotelInfoVO;
    }

    public void getOrderList() {
        ArrayList<OrderVO> orderList;
        if(hotelVO==null){
            orderList = new ArrayList<OrderVO>(orderBLservice.getOrderVOList().values());
            list=orderList;
        }
        else {
            orderList = new ArrayList<OrderVO>(orderBLservice.getSpecificHotelOrderList(hotelVO.getHotelName()).values());
            list=orderList;
        }
    }
    public void setMainAPP(MainAPP mainAPP) {
        this.mainAPP=mainAPP;
        initialize();
        getOrderList();
        setExecutedOrderTable();
        setUnexecutedOrderTable();
        setUnusualOrderTable();
        setCancelOrderTable();
    }

    private void setExecutedOrderTable(){
        ObservableList<ViewOrder> tempViewList= FXCollections.observableArrayList();
        for (OrderVO tempOrderVO : list) {
            if(tempOrderVO.getStatus().equals("已执行")) {
                tempViewList.add(new ViewOrder(tempOrderVO.getOrderID(), tempOrderVO.getHotel(), tempOrderVO.getRoomID(),
                        tempOrderVO.getRoomNum(), tempOrderVO.getPeopleNum(),
                        tempOrderVO.getHasChild(), tempOrderVO.getPrice(), tempOrderVO.getCharge(),tempOrderVO.getCheckInTime()));
                System.out.print(tempOrderVO.getCheckInTime());
            }
        }
        executedOrderTable.setItems(tempViewList);
    }

    private void setUnexecutedOrderTable(){
        ObservableList<ViewOrder> tempViewList= FXCollections.observableArrayList();
        for (OrderVO tempOrderVO : list) {
            if(tempOrderVO.getStatus().equals("未执行")) {
                tempViewList.add(new ViewOrder(tempOrderVO.getOrderID(), tempOrderVO.getHotel(), tempOrderVO.getRoomID(),
                        tempOrderVO.getRoomNum(), tempOrderVO.getPeopleNum(),
                        tempOrderVO.getHasChild(), tempOrderVO.getPrice(), tempOrderVO.getCharge(),tempOrderVO.getLastCheckInTime()));
            }
        }
        unexecutedOrderTable.setItems(tempViewList);
    }

    private void setUnusualOrderTable(){
        ObservableList<ViewOrder> tempViewList= FXCollections.observableArrayList();
        for (OrderVO tempOrderVO : list) {
            if(tempOrderVO.getStatus().equals("异常")) {
                tempViewList.add(new ViewOrder(tempOrderVO.getOrderID(), tempOrderVO.getHotel(), tempOrderVO.getRoomID(),
                        tempOrderVO.getRoomNum(), tempOrderVO.getPeopleNum(),
                        tempOrderVO.getHasChild(), tempOrderVO.getPrice(), tempOrderVO.getCharge(),null));
            }
        }
        unusualOrderTable.setItems(tempViewList);
    }

    private void setCancelOrderTable(){
        ObservableList<ViewOrder> tempViewList= FXCollections.observableArrayList();
        for (OrderVO tempOrderVO : list) {
            if(tempOrderVO.getStatus().equals("已撤销")) {
                tempViewList.add(new ViewOrder(tempOrderVO.getOrderID(), tempOrderVO.getHotel(), tempOrderVO.getRoomID(),
                        tempOrderVO.getRoomNum(), tempOrderVO.getPeopleNum(),
                        tempOrderVO.getHasChild(), tempOrderVO.getPrice(), tempOrderVO.getCharge(),tempOrderVO.getCancelTime()));
            }
        }
        cancelOrderTable.setItems(tempViewList);
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
        lastestCheckInTime.setCellValueFactory(cellData->cellData.getValue().uniqueProperty());
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
        startTime.setCellValueFactory(cellData->cellData.getValue().uniqueProperty());
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
        cancelTime.setCellValueFactory(cellData->cellData.getValue().uniqueProperty());
    }
    @FXML
    private void setCancelOrderButton(){
        ViewOrder viewUnexecutedOrder=unexecutedOrderTable.getSelectionModel().getSelectedItem();
        if(viewUnexecutedOrder!=null){
            ResultMessage resultMessage=orderBLservice.cancelOrder(Integer.parseInt(viewUnexecutedOrder.getOrderID()));
            if(resultMessage.equals(ResultMessage.SUCCESS))
                mainAPP.informationAlert("取消成功");
            else if(resultMessage.equals(ResultMessage.CREDIT_DECRESE))
                mainAPP.informationAlert("距最晚订单执行时间小于6小时，扣除本次订单的一半信用值");
        }
        else{
           mainAPP.errorAlert("请先选择");
        }
    }
    @FXML
    private void setEvaluateButton() {
        ViewOrder viewExecutedOrder = executedOrderTable.getSelectionModel().getSelectedItem();
        if (viewExecutedOrder != null) {
            OrderVO orderVO = orderBLservice.getOrderInfo(Integer.parseInt(viewExecutedOrder.getOrderID()));
            HotelBLService hotelBLService = new Hotel();
            HotelInfoVO hotelInfoVO = hotelBLService.getHotelInfo(viewExecutedOrder.getHotelName());
            mainAPP.showCustomerEvaluateView(customerVO, orderVO, hotelInfoVO);
        } else {
            mainAPP.errorAlert("请先选择");
        }
    }
}
