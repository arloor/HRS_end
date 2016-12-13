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
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField hotelNameField;
    @FXML
    private TextField hotelAddressField;
    @FXML
    private TextField serviceField;
    @FXML
    private TextField hotelLevelField;
    @FXML
    private TextField hotelGradeField;
    @FXML
    private TextArea briefInformationArea;
    @FXML
    private TableView<ViewRoomAndPriceObjects> priceTable;
    @FXML
    private TableColumn<ViewRoomAndPriceObjects,String> roomTypeColumn;
    @FXML
    private TableColumn<ViewRoomAndPriceObjects,String> originPriceColumn;
    @FXML
    private Button orderGeneratedButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button searchOrderButton;
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    public void setHotelInfoVO(String hotelName){
        HotelBLService hotelBLService=new Hotel();
        hotelBLService.getHotelInfo(hotelName);
    }
    @FXML
    private void setBackButton(){
          mainAPP.showHomeView(customerVO);
    }
    @FXML
    private void setLogOutButton(){
       mainAPP.showSignInView();
    }
    @FXML
    private void setNameField(){
        nameField.setEditable(false);
        String name=customerVO.getUserName();
        nameField.setText(name);
    }
    @FXML
    private void setHotelNameField(){
        hotelNameField.setEditable(false);
        hotelNameField.setText(hotelInfoVO.getHotelName());
    }
    @FXML
    private void setHotelAddressField(){
        hotelAddressField.setEditable(false);
        hotelAddressField.setText(hotelInfoVO.getAddress());
    }
    @FXML
    private  void setServiceField(){
        serviceField.setEditable(false);
        serviceField.setText(hotelInfoVO.getFacility());
    }
    @FXML
    private void setHotelLevelField(){
        hotelLevelField.setEditable(false);
        hotelLevelField.setText(String.valueOf(hotelInfoVO.getStarLevel()));
    }
    @FXML
    private void setHotelGradeField(){
        hotelGradeField.setEditable(false);
        hotelGradeField.setText(String.valueOf(hotelInfoVO.getScore()));
    }
    @FXML
    private void setBriefInformationArea(){
        briefInformationArea.setEditable(false);
        briefInformationArea.setText(hotelInfoVO.getIntroduction());
    }
    @FXML
    private void setPriceTable(){
        RoomBLService roomBLService=new Room();
        List<AvailableRoomVO>roomList;
        roomList=roomBLService.getAvailableRoomList(String.valueOf(hotelInfoVO.getHotelName()),"","");
        ObservableList<ViewRoomAndPriceObjects> tempViewList= FXCollections.observableArrayList();
        for (AvailableRoomVO availableRoomVO : roomList) {
            tempViewList.add(new ViewRoomAndPriceObjects(availableRoomVO.getRoomType(),String.valueOf(availableRoomVO.getPrice())));
        }
        priceTable.setItems(tempViewList);
    }
    @FXML
    private void initialize(){
        roomTypeColumn.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        originPriceColumn.setCellValueFactory(cellData->cellData.getValue().originPriceProperty());
    }
    @FXML
    private void setOrderGeneratedButton(){
        mainAPP.showOrderGeneratedView(customerVO,hotelInfoVO.getHotelName(),searchInfoVO);
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
