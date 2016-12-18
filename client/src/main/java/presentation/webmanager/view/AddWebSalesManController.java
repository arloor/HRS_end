package presentation.webmanager.view;

import businesslogic.managerbl.Manager;
import businesslogicservice.managerblservice.ManagerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.webmanager.MainAPP;
import util.ManagerType;
import vo.ManagerVO;


/**
 * Created by 啊 on 2016/11/29.
 */
public class AddWebSalesManController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    private String hotelName;
    @FXML
    private TextField salesManNameField;
    @FXML
    private TextField initialPasswordField;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField phoneNumber;
    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }

    @FXML
    private void setConfirmButton(){
        ManagerBLService managerBLService=new Manager();
        managerBLService.addManager(new ManagerVO(ManagerType.WebSalesMan,salesManNameField.getText(),initialPasswordField.getText(),
                phoneNumber.getText(),null));
       mainAPP.informationAlert("添加成功");
    }

}
