package presentation.customer.view;

import businesslogic.creditbl.Credit;
import businesslogicservice.creditblservice.CreditBLservice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import vo.CustomerVO;


/**
 * Created by 段梦洋 on 2016/11/28.
 */
public class CustomerInfoController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField trueNameField;
    @FXML
    private TextField customerTypeField;
    @FXML
    private TextField idtentifyField;
    @FXML
    private TextField idtentifyContextField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField numCreditField;
    @FXML
    private Button detailedCreditButton;
    @FXML
    private Button modifyButton;
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    @FXML
    private void setUserNameField(){
        usernameField.setEditable(false);
        usernameField.setText(customerVO.getUserName());
    }
    @FXML
    private void setTrueNameField(){
        trueNameField.setEditable(false);
        trueNameField.setText(customerVO.getCustomerName());
    }
    @FXML
    private void setCustomerTypeField(){
        customerTypeField.setEditable(false);
        customerTypeField.setText(String.valueOf(customerVO.getCustomerType()));
    }
    @FXML
    private void setIdtentifyField(){
        idtentifyField.setEditable(false);
        if(customerVO.getCustomerType().equals("个人用户"))
            idtentifyField.setText("生日");
        else if(customerVO.getCustomerType().equals("企业用户"))
            idtentifyField.setText("企业名");
    }
    @FXML
    private void setIdtentifyContextField(){
        idtentifyContextField.setEditable(false);
        idtentifyContextField.setText(customerVO.getUniqueInformation());
    }
    @FXML
    private void setContactField(){
        contactField.setEditable(false);
        contactField.setText(customerVO.getPhoneNumber());
    }
    @FXML
    private void setNumCreditField(){
        numCreditField.setEditable(false);
        CreditBLservice creditBLservice=new Credit(customerVO.getUserName());
        creditBLservice.getNumCredit(customerVO.getUserName());
    }
    @FXML
    private void setDetailedCreditButton(){
        mainAPP.showDetailedCreditField(customerVO);
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
    private void setModifyButton(){
        mainAPP.showCustomerInfoModifyView(customerVO);
    }
    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
}

