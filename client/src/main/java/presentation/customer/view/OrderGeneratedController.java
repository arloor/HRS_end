package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogic.orderbl.OrderProcesser;
import businesslogicservice.hotelblservice.HotelBLService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.SearchInfoVO;


/**
 * Created by 啊 on 2016/11/29.
 */
public class OrderGeneratedController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    private SearchInfoVO searchInfoVO;
    private HotelInfoVO hotelInfoVO;
    private String hasChildren;

    @FXML
    private ChoiceBox roomTypeChoiceBox;
    @FXML
    private ChoiceBox numRoomChoiceBox;
    @FXML
    private ChoiceBox numPeopleChoiceBox;
    @FXML
    private ChoiceBox latestCheckInBox;
    @FXML
    private RadioButton yesButton;
    @FXML
    private RadioButton noButton;
    @FXML
    private DatePicker checkInTime;
    @FXML
    private DatePicker checkOutTime;
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        initialize();
    }



    private void setRoomTypeChoiceBox(){
        roomTypeChoiceBox.setItems(FXCollections.observableArrayList("单人间","标准间","豪华间","商务间","大床房"));
    }

    private void setNumRoomChoiceBox(){
        numRoomChoiceBox.setItems(FXCollections.observableArrayList("1","2","3","4","5"));
    }

    private void setNumPeopleChoiceBox(){
        numPeopleChoiceBox.setItems((FXCollections.observableArrayList("1人","2人","3人","4人","5人及以上")));
    }

    private void setLatestCheckInBox(){
        latestCheckInBox.setItems(FXCollections.observableArrayList("14:00:00","16:00:00","18:00:00","19:00:00","20:00:00","21;00:00",
                "22:00:00","23:00:00","24:00:00"));
    }
    @FXML
    private void setYesButton(){
        hasChildren="yes";
    }
    @FXML
    private void setNoButton(){
        hasChildren="no";
    }
    @FXML
    private void initialize(){
        final ToggleGroup group=new ToggleGroup();
        yesButton.setToggleGroup(group);
        noButton.setToggleGroup(group);
        setRoomTypeChoiceBox();
        setNumPeopleChoiceBox();
        setNumRoomChoiceBox();
        setLatestCheckInBox();
    }

    @FXML
    private void setConfirmButton(){
        String lastCheckInTime=checkInTime.getValue().toString()+" "+latestCheckInBox.getSelectionModel().getSelectedItem().toString();
        String lastCheckOutTime=checkOutTime.getValue().toString()+"  12:00:00";         //默认最晚退房时间为退房日中午12:00
        OrderVO orderVO=new OrderVO(OrderProcesser.getOrderID(),customerVO.getUserName(),hotelInfoVO.getHotelName(),"",
                roomTypeChoiceBox.getSelectionModel().getSelectedItem().toString(),
                Integer.parseInt(numRoomChoiceBox.getSelectionModel().getSelectedItem().toString()),
                Integer.parseInt(numPeopleChoiceBox.getSelectionModel().getSelectedItem().toString()),
                hasChildren,lastCheckInTime, "",lastCheckOutTime,"",-1,-1,-1);                  //入住时间和退房时间
        mainAPP.showOrderGenerated2ControllerView(customerVO,orderVO,hotelInfoVO,searchInfoVO);
    }

    @FXML
    private void setCancelButton(){
        mainAPP.showHotelInfoView(customerVO,hotelInfoVO.getHotelName(),searchInfoVO);
    }

    public void setHotelVO(String hotelName) {
        HotelBLService hotelBLService=new Hotel();
        this.hotelInfoVO=hotelBLService.getHotelInfo(hotelName);
    }

    public void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
    }

    public void setSearchInfoVO(SearchInfoVO searchInfoVO) {
        this.searchInfoVO=searchInfoVO;
    }
}
