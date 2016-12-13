package presentation.webmanager.view;

import businesslogic.creditbl.Credit;
import businesslogic.customerbl.Customer;
import businesslogicservice.creditblservice.CreditBLservice;
import businesslogicservice.customerblservice.CustomerBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import presentation.webmanager.MainAPP;
import util.CustomerType;
import vo.CustomerVO;
import vo.ManagerVO;


/**
 * Created by 曹利航 on 2016/11/26 12:23.
 */
public class CustomerInfoController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    private CustomerVO customerVO;

    @FXML
    private TextField userNameField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label idtentifyLabel;
    @FXML
    private Label idtentifyContextLabel;
    @FXML
    private Label contactLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private GridPane informationPane;

    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
        informationPane.setVisible(false);

    }
    private void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
    }
    @FXML
    private void search(){
        if(userNameField.getText()!=null){
            String userName=userNameField.getText();
            CustomerBLService customerBLService=new Customer();
            setCustomerVO(customerBLService.getCustomerInfo(userName));
            setActualNameField();
            setCustomerTypeField();
            setIdtentifyField();
            setIdtentifyContextField();
            setContactField();
            setNumCreditField();
            //还应有一个正确不正确的判断
            informationPane.setVisible(true);
        }
        else{
            //弹出对话框请先输入用户名
        }
    }
    private void setActualNameField(){
        nameLabel.setText(customerVO.getCustomerName());
    }
    private void setCustomerTypeField(){
        typeLabel.setText(String.valueOf(customerVO.getCustomerType()));
    }
    private void setIdtentifyField(){
        if(customerVO.getCustomerType().equals(CustomerType.PERSONAL))
            idtentifyLabel.setText("生日");
        else
            idtentifyLabel.setText("企业名");
    }
    private void setIdtentifyContextField(){
        idtentifyContextLabel.setText(customerVO.getUniqueInformation());
    }
    private void setContactField(){
        contactLabel.setText(customerVO.getPhoneNumber());
    }
    private void setNumCreditField(){
        CreditBLservice creditBLservice=new Credit(customerVO.getUserName());
        creditLabel.setText(String.valueOf(creditBLservice.getNumCredit(customerVO.getUserName())));
    }
    @FXML
    private void detailedCredit(){
        mainAPP.showCreditInfoView(webManagerVO,customerVO);
    }
    @FXML
    private void modifyInformation(){
        mainAPP.showCustomerInfoModifyView(webManagerVO,customerVO);
    }
}
