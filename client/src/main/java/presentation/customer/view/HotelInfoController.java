package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogic.roombl.Room;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.roomblservice.RoomBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vo.AvailableRoomVO;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.SearchInfoVO;

import java.util.List;


/**
 * Created by 啊 on 2016/11/29.
 */
public class HotelInfoController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    private HotelInfoVO hotelInfoVO;
    private SearchInfoVO searchInfoVO;

    @FXML
    private Label hotelNameField;
    @FXML
    private Label hotelAddressField;
    @FXML
    private Label serviceField;
    @FXML
    private Label hotelLevelField;
    @FXML
    private Label hotelGradeField;
    @FXML
    private TextArea briefInformationArea;
    @FXML
    private TableView<ViewRoomAndPriceObjects> priceTable;
    @FXML
    private TableColumn<ViewRoomAndPriceObjects,String> roomTypeColumn;
    @FXML
    private TableColumn<ViewRoomAndPriceObjects,String> originPriceColumn;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        initialize();
    }
    public void setHotelInfoVO(String hotelName){
        System.out.print(hotelName);
        HotelBLService hotelBLService=new Hotel();
        hotelInfoVO=hotelBLService.getHotelInfo(hotelName);
    }


    private void setHotelNameField(){
        hotelNameField.setText(hotelInfoVO.getHotelName());
    }

    private void setHotelAddressField(){
        hotelAddressField.setText(hotelInfoVO.getAddress());
    }

    private  void setServiceField(){
        serviceField.setText(hotelInfoVO.getFacility());
    }

    private void setHotelLevelField(){
        hotelLevelField.setText(String.valueOf(hotelInfoVO.getStarLevel()));
    }

    private void setHotelGradeField(){
        hotelGradeField.setText(String.valueOf(hotelInfoVO.getScore()));
    }

    private void setBriefInformationArea(){
        briefInformationArea.setEditable(false);
        briefInformationArea.setText(hotelInfoVO.getIntroduction());
    }

    private void setPriceTable(){
        RoomBLService roomBLService=new Room();
        List<AvailableRoomVO>roomList;
        roomList=roomBLService.getAvailableRoomList(String.valueOf(hotelInfoVO.getHotelName()),null,null);
        ObservableList<ViewRoomAndPriceObjects> tempViewList= FXCollections.observableArrayList();
        for (AvailableRoomVO availableRoomVO : roomList) {
            tempViewList.add(new ViewRoomAndPriceObjects(availableRoomVO.getRoomType(),String.valueOf(availableRoomVO.getPrice())));
        }
        priceTable.setItems(tempViewList);
    }

    private void initialize(){
        roomTypeColumn.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        originPriceColumn.setCellValueFactory(cellData->cellData.getValue().originPriceProperty());
        setHotelNameField();
        setHotelAddressField();
        setHotelGradeField();
        setHotelLevelField();
        setPriceTable();
        setServiceField();
        setBriefInformationArea();
    }

    @FXML
    private void setOrderGeneratedButton(){
        mainAPP.showOrderGeneratedView(customerVO,hotelInfoVO,searchInfoVO);
    }
    @FXML
    private void setSearchOrderButton(){
        mainAPP.showOrderInfoView(customerVO,hotelInfoVO);
    }
    @FXML
    private void setCancelButton(){
        mainAPP.showSearchHotelView(customerVO,searchInfoVO);
    }

    public void setCustomer(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }

    public void setSearchInfoVO(SearchInfoVO searchInfoVO){
        this.searchInfoVO=searchInfoVO;
    }
}
