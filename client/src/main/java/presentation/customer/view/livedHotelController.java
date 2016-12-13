package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogicservice.hotelblservice.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vo.CustomerVO;
import vo.HotelInfoVO;

import java.util.List;


/**
 * Created by 啊 on 2016/12/8.
 */
public class livedHotelController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    private HotelBLService hotelBLService;
    private ViewHotel clickedHotel;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private TableView<ViewHotel> livedHotelTable;
    @FXML
   private TableColumn<ViewHotel,String> hotelNameColumn;
    @FXML
    private TableColumn<ViewHotel,String> cityColumn;
    @FXML
    private TableColumn<ViewHotel,String> areaColumn;
    @FXML
    private TableColumn<ViewHotel,String> addressColumn;
    @FXML
    private TableColumn<ViewHotel,String> levelColumn;
    @FXML
    private TableColumn<ViewHotel,String> scoreColumn;
    @FXML
    private TableColumn<ViewHotel,String> lowestPriceColumn;
    @FXML
    private Button hotelOrderButton;
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
    @FXML
    private void initialize(){
        hotelNameColumn.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        levelColumn.setCellValueFactory(cellData->cellData.getValue().hotelLevelProperty());
        scoreColumn.setCellValueFactory(cellData->cellData.getValue().gradesProperty());
        lowestPriceColumn.setCellValueFactory(cellData->cellData.getValue().lowestPriceProperty());
        addressColumn.setCellValueFactory(cellData->cellData.getValue().addressProperty());
        cityColumn.setCellValueFactory(cellData->cellData.getValue().cityProperty());
        areaColumn.setCellValueFactory(cellData->cellData.getValue().areaProperty());
        hotelBLService=new Hotel();
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
    private void setLivedHotelTable(){
        List<HotelInfoVO>hotelInfoVOList=hotelBLService.getHistoryHotelList(customerVO.getUserName());
        ObservableList<ViewHotel> tempViewList= FXCollections.observableArrayList();
        for(HotelInfoVO hotelInfoVO:hotelInfoVOList){
            tempViewList.add(new ViewHotel(hotelInfoVO.getCity(),hotelInfoVO.getBusinessCircle(),hotelInfoVO.getHotelName(),
                    String.valueOf(hotelInfoVO.getStarLevel()), String.valueOf(hotelInfoVO.getScore()),
                    String.valueOf(hotelInfoVO.getLowestPrice()),hotelInfoVO.getAddress()));
        }
        livedHotelTable.setItems(tempViewList);
        showHotelDetails(null);
        livedHotelTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showHotelDetails(newValue));
    }

    private void showHotelDetails(ViewHotel newValue) {
        clickedHotel=newValue;
    }
    @FXML
    private void setHotelOrderButton(){
        if(clickedHotel==null){
            //duihuakuang!!！
        }
        else{
            mainAPP.showOrderInfoView(customerVO,hotelBLService.getHotelInfo(clickedHotel.getHotelName()));
        }
    }
}
