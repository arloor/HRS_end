package presentation.customer.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import vo.CustomerVO;
import vo.SearchInfoVO;

/**
 * Created by 啊 on 2016/12/7.
 */
public class DetailedSearchController {
    private CustomerVO customerVO;
    private presentation.customer.MainAPP mainAPP;
    private double lowestScore;
    private double highestScore;
    private double lowestPrice;
    private double highestPrice;
    @FXML
    private TextField addressField;
    @FXML
    private TextField areaField;
    @FXML
    private TextField hotelNameField;
    @FXML
    private TextField roomNumField;
    @FXML
    private ChoiceBox levelChoiceBox;
    @FXML
    private ChoiceBox roomTypeChoiceBox;
    @FXML
    private ChoiceBox originPriceBox;
    @FXML
    private ChoiceBox gradeBox;
    @FXML
    private DatePicker checkInPicker;
    @FXML
    private DatePicker checkOutPicker;
    @FXML
    private Button searchButton;

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        setLevelChoiceBox();
        setRoomTypeChoiceBox();
        setOriginPriceBox();
        setGradeBox();
    }


    private void setLevelChoiceBox(){
        levelChoiceBox.setItems(FXCollections.observableArrayList("1星","2星","3星","4星","5星"));
    }

    private void setRoomTypeChoiceBox(){
        roomTypeChoiceBox.setItems(FXCollections.observableArrayList("单人间","标准间","豪华间","商务间","大床房"));
    }

    private void setOriginPriceBox(){
        originPriceBox.setItems(FXCollections.observableArrayList("100以下","100至200","200至300","300至500","500至1000","1000以上"));
    }

    private void setGradeBox(){
        gradeBox.setItems(FXCollections.observableArrayList("0-3分","3至4分","4-4.5分","4.5-5分"));
    }
    @FXML
    private void setSearchButton(){
        getGradeInformation();
        getPriceInformation();
        SearchInfoVO searchInfoVO=new SearchInfoVO(customerVO.getUserName(),addressField.getText(),areaField.getText(),
                exchangeString(hotelNameField.getText()),
                getLevelInformation(),
               lowestScore,highestScore,
                getRoomTypeInformation(),
                lowestPrice,highestPrice,
                getCheckInInformation(),getCheckOutInformation(),
                exchangeInteger(roomNumField.getText())) ;
       mainAPP.showSearchHotelView(customerVO,searchInfoVO);
    }
    private int getLevelInformation(){
        if(levelChoiceBox.getSelectionModel().getSelectedItem()==null)
            return -1;
        else {
            int i = levelChoiceBox.getSelectionModel().getSelectedIndex();
            switch (i){
                case 0:return 1;
                case 1:return 2;
                case 2:return 3;
                case 3:return 4;
                default:return 5;
            }
        }
    }
    private String getRoomTypeInformation(){
        if(roomTypeChoiceBox.getSelectionModel().getSelectedItem()==null)
            return null;
        else
            return exchangeString(roomTypeChoiceBox.getSelectionModel().getSelectedItem().toString());
    }
    private String getCheckInInformation(){
        if(checkInPicker.getValue()==null)
            return null;
        else
            return exchangeString(checkInPicker.getValue().toString());
    }
    private String getCheckOutInformation(){
        if(checkOutPicker.getValue()==null)
            return null;
        else
            return exchangeString(checkOutPicker.getValue().toString());
    }
    private String exchangeString(String str){;
        if(str.equals(""))
            return null;
        else
            return str;
    }
    private int exchangeInteger(String s){
        if(s.equals(""))
            return -1;
       else
           return Integer.parseInt(s);
    }
    private void getGradeInformation(){
        if(gradeBox.getSelectionModel().getSelectedItem()==null){
            lowestScore=-1;
            highestScore=-1;
        }
        else {
            int i = gradeBox.getSelectionModel().getSelectedIndex();
            switch (i) {
                case 0:
                    lowestScore = 0;
                    highestScore = 3;
                    break;
                case 1:
                    lowestScore = 3;
                    highestScore = 4;
                    break;
                case 2:
                    lowestScore = 4;
                    highestScore = 4.5;
                    break;
                default:
                    lowestScore = 4.5;
                    highestScore = 5;
                    break;
            }
        }
    }
    private void getPriceInformation() {
        if (originPriceBox.getSelectionModel().getSelectedItem()==null) {
            lowestPrice = -1;
            highestPrice = -1;
        } else {
            int i = originPriceBox.getSelectionModel().getSelectedIndex();
            switch (i) {
                case 0:
                    lowestPrice = 0;
                    highestPrice = 100;
                    break;
                case 1:
                    lowestPrice = 100;
                    highestPrice = 200;
                    break;
                case 2:
                    lowestPrice = 200;
                    highestPrice = 300;
                    break;
                case 3:
                    lowestPrice = 300;
                    highestPrice = 500;
                    break;
                case 4:
                    lowestPrice = 500;
                    highestPrice = 1000;
                    break;
                case 5:
                    lowestPrice = 1000;
                    highestPrice = 99999;
                    break;                 //默认房价不会超过99999
            }
        }
    }
}
