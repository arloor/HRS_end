package presentation.customer.view;

import businesslogic.hotelbl.Hotel;
import businesslogicservice.hotelblservice.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.CustomerVO;
import vo.HotelInfoVO;

import java.util.List;


/**
 * Created by 啊 on 2016/12/8.
 */
public class LivedHotelController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    private HotelBLService hotelBLService;

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

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        initialize();
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }

    private void initialize(){
        hotelNameColumn.setCellValueFactory(cellData->cellData.getValue().hotelNameProperty());
        levelColumn.setCellValueFactory(cellData->cellData.getValue().hotelLevelProperty());
        scoreColumn.setCellValueFactory(cellData->cellData.getValue().gradesProperty());
        lowestPriceColumn.setCellValueFactory(cellData->cellData.getValue().lowestPriceProperty());
        addressColumn.setCellValueFactory(cellData->cellData.getValue().addressProperty());
        cityColumn.setCellValueFactory(cellData->cellData.getValue().cityProperty());
        areaColumn.setCellValueFactory(cellData->cellData.getValue().areaProperty());
        hotelBLService=new Hotel();
        setLivedHotelTable();
    }


    private void setLivedHotelTable(){
        List<HotelInfoVO>hotelInfoVOList=hotelBLService.getHistoryHotelList(customerVO.getUserName());
        HotelInfoVO hotelInfoVOs=hotelInfoVOList.get(0);
        if(hotelInfoVOs==null){
            //弹出对话框
        }
        System.out.print(hotelInfoVOs.getCity()+hotelInfoVOs.getHotelName()+hotelInfoVOs.getBusinessCircle());
        ObservableList<ViewHotel> tempViewList= FXCollections.observableArrayList();
        for(HotelInfoVO hotelInfoVO:hotelInfoVOList){
            tempViewList.add(new ViewHotel(hotelInfoVO.getCity(),hotelInfoVO.getBusinessCircle(),hotelInfoVO.getHotelName(),
                    String.valueOf(hotelInfoVO.getStarLevel()), String.valueOf(hotelInfoVO.getScore()),
                    String.valueOf(hotelInfoVO.getLowestPrice()),hotelInfoVO.getAddress()));
        }
        livedHotelTable.setItems(tempViewList);
    }

    @FXML
    private void setHotelOrderButton(){
        ViewHotel hotel=livedHotelTable.getSelectionModel().getSelectedItem();
        if(hotel==null){
            //duihuakuang!!！
        }
        else{
            mainAPP.showOrderInfoView(customerVO,hotelBLService.getHotelInfo(hotel.getHotelName()));
        }
    }
    @FXML
    private void orderThis(){
        ViewHotel hotel=livedHotelTable.getSelectionModel().getSelectedItem();
        mainAPP.showOrderGeneratedView(customerVO,hotel.getHotelName(),null);
    }
}
