package presentation.customer.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import vo.CustomerVO;
import vo.SearchInfoVO;

/**
 * Created by 曹利航 on 2016/11/26 12:24.
 */
//浏览历史订单和住过的酒店未实现
public class HomeController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private ChoiceBox cityChoiceBox;
    @FXML
    private ChoiceBox areaChoiceBox;
    @FXML
    private Button searchButton;
    @FXML
    private Button detailedSearchButton;
    @FXML
    private Button historyOrderButton;
    @FXML
    private Button personalInformationButton;
    @FXML
    private TextField nameField;
    @FXML
    private Button historyHotelButton;
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    @FXML
    private void setDetailedSearchButton(){
        mainAPP.showDetailedSearchView(customerVO);
    }
    @FXML
    private void setHistoryOrderButton(){
        mainAPP.showOrderInfoView(customerVO);
    }
    @FXML
    private void setPersonalInformationButton(){
        mainAPP.showPersonalInformationView(customerVO);
    }
    @FXML
    private void setCityChoiceBox(){

    }
    @FXML
    private void setAreaChoiceBox(){

    }
    @FXML
    private  void setSearchButton() {
        SingleSelectionModel city = cityChoiceBox.getSelectionModel();
        SingleSelectionModel area = areaChoiceBox.getSelectionModel();
        SearchInfoVO searchInfoVO=new SearchInfoVO(customerVO.getUserName(),city.toString(),area.toString(),null,-1,-1,-1,null,-1,-1,null,null,-1);
      //  HotelBLService hotelBLService = new Hotel();
       // ArrayList<HotelInfoVO>hotelList=hotelBLService.getHotelList(searchInfoVO);
        mainAPP.showSearchHotelView(customerVO,searchInfoVO);

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
    private void setHistoryHotelButton(){
        mainAPP.showLivedHotelView(customerVO);
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }

}
