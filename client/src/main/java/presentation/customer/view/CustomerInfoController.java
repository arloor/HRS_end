package presentation.customer.view;

import businesslogic.creditbl.Credit;
import businesslogicservice.creditblservice.CreditBLservice;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import util.CustomerType;
import vo.CustomerVO;


/**
 * Created by 段梦洋 on 2016/11/28.
 */
public class CustomerInfoController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    @FXML
    private Label usernameField;
    @FXML
    private Label trueNameField;
    @FXML
    private Label customerTypeField;
    @FXML
    private Label idtentifyField;
    @FXML
    private Label idtentifyContextField;
    @FXML
    private Label contactField;
    @FXML
    private Label numCreditField;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        setUsernameField();
        setTrueNameField();
        setCustomerTypeField();
        setIdtentifyContextField();
        setIdtentifyField();
        setContactField();
        setNumCreditField();

    }

    private void setUsernameField(){
        usernameField.setText(customerVO.getUserName());
    }

    private void setTrueNameField(){
        trueNameField.setText(customerVO.getCustomerName());
    }

    private void setCustomerTypeField(){
        customerTypeField.setText(String.valueOf(customerVO.getCustomerType()));
    }

    private void setIdtentifyField(){
        if(customerVO.getCustomerType().equals(CustomerType.PERSONAL))
            idtentifyField.setText("生日");
        else if(customerVO.getCustomerType().equals(CustomerType.COMPANY))
            idtentifyField.setText("企业名");
    }

    private void setIdtentifyContextField(){
        idtentifyContextField.setText(customerVO.getUniqueInformation());
    }

    private void setContactField(){
        contactField.setText(customerVO.getPhoneNumber());
    }

    private void setNumCreditField(){
        CreditBLservice creditBLservice=new Credit(customerVO.getUserName());
        numCreditField.setText(String.valueOf(creditBLservice.getNumCredit(customerVO.getUserName())));
    }

    @FXML
    private void setDetailedCreditButton(){
        mainAPP.showDetailedCreditField(customerVO);
    }

    @FXML
    private void setModifyButton(){
        mainAPP.showCustomerInfoModifyView(customerVO);
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
}

