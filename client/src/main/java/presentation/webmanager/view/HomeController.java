package presentation.webmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.webmanager.MainAPP;
import vo.ManagerVO;


/**
 * Created by 曹利航 on 2016/11/26 12:23.
 */
public class HomeController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private Button informationButton;
    @FXML
    private Button addSalesManButton;
    @FXML
    private Button addHotelButton;
    @FXML
    private Button managerInformationButton;
    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    @FXML
    private void setNameField(){
        nameField.setEditable(false);
        nameField.setText(webManagerVO.getUsername());
    }
    @FXML
    private void setLogOutButton(){
        mainAPP.showSignInView();
    }
    @FXML
    private void setInformationButton(){
        mainAPP.showCustomerInfoView(webManagerVO);
    }
    @FXML
    private void setAddSalesManButton(){
        mainAPP.showAddWebSalesManView(webManagerVO);
    }
    @FXML
    private void setAddHotelButton(){
        mainAPP.showAddHotelView(webManagerVO);
    }
    @FXML
    private void setManagerInformationButton(){
        mainAPP.showManagerInfoView(webManagerVO);
    }
}
