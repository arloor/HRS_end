package presentation.customer.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import presentation.customer.MainAPP;
import presentation.utility.XMLDao;
import vo.CustomerVO;
import vo.SearchInfoVO;

/**
 * Created by 啊 on 2016/12/11.
 */
public class SearchController {
    ObservableList<String> cityList = FXCollections.observableArrayList();
    ObservableList<String> circleList = FXCollections.observableArrayList();
    private CustomerVO customerVO;
    private MainAPP mainAPP;
    @FXML
    private ChoiceBox cityChoiceBox;
    @FXML
    private ChoiceBox areaChoiceBox;

    public void setMainApp(MainAPP mainApp) {
        this.mainAPP = mainApp;
        initialize();
    }
    public void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
    }

    private void initialize() {
        for (String tempStr : XMLDao.getCities()) {
            cityList.add(tempStr);
        }
        cityChoiceBox.setItems(cityList);
        cityChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCircleBoxItems((String) newValue));

    }

    private void setCircleBoxItems(String city) {
        circleList = FXCollections.observableArrayList();
        for (String tempStr : XMLDao.getCircles(city)) {
            circleList.add(tempStr);
        }
        areaChoiceBox.setItems(circleList);

    }

    @FXML
    private void search(){
        String city = cityChoiceBox.getSelectionModel().getSelectedItem().toString();
        String area = areaChoiceBox.getSelectionModel().getSelectedItem().toString();
        SearchInfoVO searchInfoVO=new SearchInfoVO(customerVO.getUserName(),city,area,null,-1,-1,-1,null,-1,-1,null,null,-1);
        mainAPP.showSearchHotelView(customerVO,searchInfoVO);
    }
}
