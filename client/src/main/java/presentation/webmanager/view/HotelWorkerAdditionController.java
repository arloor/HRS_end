package presentation.webmanager.view;

import businesslogic.managerbl.Manager;
import businesslogicservice.managerblservice.ManagerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.webmanager.MainAPP;
import util.ManagerType;
import vo.ManagerVO;


/**
 * Created by 啊 on 2016/11/29.
 */
public class HotelWorkerAdditionController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    private String hotelName;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField phoneNumber;
    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    public void setHotelName(String hotelName){
        this.hotelName=hotelName;
    }


    @FXML
    private void confirm(){
        ManagerVO hotelWorkerVO=new ManagerVO(ManagerType.HotelWorker,nameField.getText(),
                passwordField.getText(),phoneNumber.getText(),hotelName);
        ManagerBLService managerBLService=new Manager();
        managerBLService.addManager(hotelWorkerVO);
        //弹出对话框显示成功
    }

}
