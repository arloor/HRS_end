package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogicservice.hotelblservice.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.SearchInfoVO;

import java.util.ArrayList;


/**
 * Created by 啊 on 2016/11/29.
 */
//这个是搜索酒店的酒店列表
 //   列表中的标记还没有实现
public class SearchHotelController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    private SearchInfoVO searchInfoVO;
    private HotelBLService hotelBLService;
    private ArrayList<HotelInfoVO>hotelInfoVOList;
    private ViewSearchedHotelObjects clickedHotel;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private ChoiceBox sortChoiceBox;
    @FXML
    private TableView<ViewSearchedHotelObjects> searchTable;
    @FXML
    private TableColumn<ViewSearchedHotelObjects,String> hotelNameColumn;
    @FXML
    private TableColumn<ViewSearchedHotelObjects,String> hotelLevelColumn;
    @FXML
    private TableColumn<ViewSearchedHotelObjects,String> gradeColumn;
    @FXML
    private TableColumn<ViewSearchedHotelObjects,String> lowestPriceColumn;
    @FXML
    private TableColumn<ViewSearchedHotelObjects,String> addressColumn;
    @FXML
    private Button detailedInformationButton;
    @FXML
    private Button orderButton;
    @FXML
    private CheckBox livedOnlyBox;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
    @FXML
    private void initialize(){
        hotelNameColumn.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        hotelLevelColumn.setCellValueFactory(cellData->cellData.getValue().hotelLevelProperty());
        gradeColumn.setCellValueFactory(cellData->cellData.getValue().gradesProperty());
        lowestPriceColumn.setCellValueFactory(cellData->cellData.getValue().lowestPriceProperty());
        addressColumn.setCellValueFactory(cellData->cellData.getValue().addressProperty());
        hotelBLService=new Hotel();
    }
    public void setSearchInfoVO(SearchInfoVO searchInfoVO) {
        this.searchInfoVO=searchInfoVO;
    }
    @FXML
    private void setSortChoiceBox(){
        sortChoiceBox=new ChoiceBox(FXCollections.observableArrayList("价格从低到高","价格从高到低","星级从低到高","星级从高到低","评分从低到高","评分从高到低"));
    }
    @FXML
    private void setSearchTable(){
        hotelInfoVOList=hotelBLService.getHotelList(searchInfoVO);
        ObservableList<ViewSearchedHotelObjects>tempViewList= FXCollections.observableArrayList();
        for(HotelInfoVO hotelInfoVO:hotelInfoVOList){
            tempViewList.add(new ViewSearchedHotelObjects(hotelInfoVO.getHotelName(),String.valueOf(hotelInfoVO.getStarLevel()),
                    String.valueOf(hotelInfoVO.getScore()),String.valueOf(hotelInfoVO.getLowestPrice()),hotelInfoVO.getAddress()));
        }
        searchTable.setItems(tempViewList);
        showHotelDetails(null);
        searchTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showHotelDetails(newValue));
    }

    private void showHotelDetails(ViewSearchedHotelObjects newValue) {
        clickedHotel=newValue;
    }

    @FXML
    private void reSort(){
        /***
        int i=sortChoiceBox.getSelectionModel().getSelectedIndex();
        switch(i){
            case 0:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,"1","1");break;
            case 1:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,"1","2");break;
            case 2:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,"2","1");break;
            case 3:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,"2","2");break;
            case 4:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,"3","1");break;
            default:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,"3","2");break;
        }
       setSearchTable();
         ***/
    }
    @FXML
    private void setLivedOnlyBox(){
        ArrayList<HotelInfoVO>tempHotelList=new ArrayList<>();
        for(HotelInfoVO hotelInfoVO:hotelInfoVOList){
            if(hotelInfoVO.getReserve()==true)
                tempHotelList.add(hotelInfoVO);
        }
        hotelInfoVOList=tempHotelList;
        setSearchTable();
    }
    @FXML
    private void setDetailedInformationButton(){
        if(clickedHotel==null){
            //请先选择
        }
        else{
            mainAPP.showHotelInfoView(customerVO,clickedHotel.getHotelName(),searchInfoVO);
        }
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
    private void setOrderButton(){
        if(clickedHotel==null){

        }
        else{
            mainAPP.showOrderGeneratedView(customerVO,clickedHotel.getHotelName(),searchInfoVO);
        }
    }
}
