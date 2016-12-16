package presentation.customer.view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import presentation.customer.MainAPP;
import vo.CustomerVO;
import vo.SearchInfoVO;

/**
 * Created by 啊 on 2016/12/11.
 */
public class SearchController {
    private CustomerVO customerVO;
    private MainAPP mainAPP;
    @FXML
    private ChoiceBox cityChoiceBox;
    @FXML
    private ChoiceBox areaChoiceBox;

    public void setMainApp(MainAPP mainApp) {
        this.mainAPP = mainApp;
    }
    public void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
    }

    @FXML
    private void search(){
        SingleSelectionModel city = cityChoiceBox.getSelectionModel();
        SingleSelectionModel area = areaChoiceBox.getSelectionModel();
        SearchInfoVO searchInfoVO=new SearchInfoVO(customerVO.getUserName(),city.toString(),area.toString(),null,-1,-1,-1,null,-1,-1,null,null,-1);
        mainAPP.showSearchHotelView(customerVO,searchInfoVO);
    }
}
