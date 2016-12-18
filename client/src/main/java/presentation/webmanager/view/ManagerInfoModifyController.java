package presentation.webmanager.view;

import businesslogic.managerbl.Manager;
import businesslogicservice.managerblservice.ManagerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.webmanager.MainAPP;
import vo.ManagerVO;

/**
 * Created by 啊 on 2016/12/9.
 */
public class ManagerInfoModifyController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    private ManagerVO managerVO;
    @FXML
    private Label managerNameLabel;
    @FXML
    private TextField contactField;
    @FXML
    private Label typeLabel;

    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    public void setManagerVO(ManagerVO managerVOVO){
        this.managerVO=managerVOVO;
        setManagerNameField();
        setManagerTypeField();
    }
    private void setManagerNameField(){
        managerNameLabel.setText(managerVO.getUsername());
    }
    private void setManagerTypeField(){
        typeLabel.setText(managerVO.getManagerType().toString());
    }
    @FXML
    private void confirm(){
        ManagerBLService managerBLService=new Manager();
        if(contactField.getText().length()!=0) {
            managerVO.setPhoneNumber(contactField.getText());
            managerBLService.changeManagerInfo(managerVO);
            mainAPP.informationAlert("修改成功");
        }
        else{
            mainAPP.errorAlert("修改失败");
        }
    }
    @FXML
    private void cancel(){
        mainAPP.showManagerInfoView(managerVO);
    }
}
