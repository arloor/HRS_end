package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogicservice.hotelblservice.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import util.SortType;
import util.SortWay;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.SearchInfoVO;

import java.util.ArrayList;


/**
 * Created by 啊 on 2016/11/29.
 */
//这个是搜索酒店的酒店列表
public class SearchHotelController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    private SearchInfoVO searchInfoVO;
    private HotelBLService hotelBLService;
    private ArrayList<HotelInfoVO>hotelInfoVOList;

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
        initialize();
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }

    private void initialize(){
        hotelNameColumn.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        hotelLevelColumn.setCellValueFactory(cellData->cellData.getValue().hotelLevelProperty());
        gradeColumn.setCellValueFactory(cellData->cellData.getValue().gradesProperty());
        lowestPriceColumn.setCellValueFactory(cellData->cellData.getValue().lowestPriceProperty());
        addressColumn.setCellValueFactory(cellData->cellData.getValue().addressProperty());
        hotelBLService=new Hotel();
        setSortChoiceBox();
    }
    public void setSearchInfoVO(SearchInfoVO searchInfoVO) {
        this.searchInfoVO=searchInfoVO;
    }

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
    }

    public void reSort(){
        int i=sortChoiceBox.getSelectionModel().getSelectedIndex();
        switch(i){
            case 0:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList, SortType.Price, SortWay.Ascend);break;
            case 1:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,SortType.Price,SortWay.Descend);break;
            case 2:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,SortType.StarLevel,SortWay.Ascend);break;
            case 3:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,SortType.StarLevel,SortWay.Descend);break;
            case 4:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,SortType.Score,SortWay.Ascend);break;
            default:hotelInfoVOList=hotelBLService.sort(hotelInfoVOList,SortType.Score,SortWay.Descend);break;
        }
        setSearchTable();

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
        ViewSearchedHotelObjects temp=searchTable.getSelectionModel().getSelectedItem();
        if(temp!=null)
            mainAPP.showHotelInfoView(customerVO,temp.getHotelName(),searchInfoVO);
        else{
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText(null);
            alert.setContentText("请先选择酒店");
            alert.showAndWait();
        }
    }

    @FXML
    private void setOrderButton() {
        ViewSearchedHotelObjects temp = searchTable.getSelectionModel().getSelectedItem();
        if (temp != null)
            mainAPP.showOrderGeneratedView(customerVO, temp.getHotelName(), searchInfoVO);
        else {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText(null);
            alert.setContentText("请先选择酒店");
            alert.showAndWait();
        }
    }
}
