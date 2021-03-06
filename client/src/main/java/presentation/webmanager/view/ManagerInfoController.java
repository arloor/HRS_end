package presentation.webmanager.view;

import businesslogic.managerbl.Manager;
import businesslogicservice.managerblservice.ManagerBLService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import presentation.webmanager.MainAPP;
import util.ManagerType;
import vo.ManagerVO;

/**
 * Created by 啊 on 2016/12/9.
 */
public class ManagerInfoController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    private ManagerVO managerVO;


    @FXML
    private ChoiceBox managerTypeBox;
    @FXML
    private Label contact;
    @FXML
    private Label hotelNameLabel;
    @FXML
    private Label hotelName;
    @FXML
    private AnchorPane informationPane;
    @FXML
    private TextField userNameField;

    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
        setManagerTypeBox();
        informationPane.setVisible(false);
    }
    private void setManagerVO(ManagerVO managerVOVO){
        this.managerVO=managerVOVO;
    }

    @FXML
    private void search(){
        System.out.print(userNameField.getText());
        if(userNameField.getText()!=""){
            String userName=userNameField.getText();
            ManagerBLService managerBLService=new Manager();
            ManagerVO temp=managerBLService.getManagerInfo(ManagerType.WebManager,"manager");
            System.out.print(temp.getPhoneNumber());
            setManagerVO(managerBLService.getManagerInfo(getManagerType(),userName));       //有问题！！
            System.out.print(managerVO.getUsername());
            setContactField();
            setHotelNameField();
            informationPane.setVisible(true);
        }
        else{
            mainAPP.errorAlert("请先输入用户名");
        }
    }
    private void setContactField(){
        contact.setText(managerVO.getPhoneNumber());
    }

    private void setHotelNameField(){
        if(getManagerType().equals(ManagerType.HotelWorker)) {
            hotelNameLabel.setText(managerVO.getHotelName());
            hotelNameLabel.setVisible(true);
            hotelName.setVisible(true);
        }
        else{
            hotelName.setVisible(false);
            hotelNameLabel.setVisible(false);
        }
    }
    @FXML
    private void setManagerTypeBox(){

        managerTypeBox.setItems(FXCollections.observableArrayList("酒店工作人员","网站营销人员","网站管理人员"));

    }
    private ManagerType getManagerType(){
        ManagerType managerType;
        String managertype =  managerTypeBox.getSelectionModel().getSelectedItem().toString();
        switch(managertype){
            case"酒店工作人员":
                managerType=ManagerType.HotelWorker;
                break;
            case"网站营销人员":
                managerType=ManagerType.WebSalesMan;
                break;
            default:
                managerType=ManagerType.WebManager;
                break;
        }
        return managerType;
    }
    @FXML
    private void modify(){
        mainAPP.showManagerInfoModifyView(webManagerVO,managerVO);
    }
}
