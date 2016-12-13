package presentation.webmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.webmanager.MainAPP;
import util.CustomerType;
import vo.CustomerVO;
import vo.ManagerVO;


/**
 * Created by 曹利航 on 2016/11/26 12:23.
 */
public class CustomerInfoModifyController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    private CustomerVO customerVO;

    @FXML
    private TextField actualNameField;
    @FXML
    private Label idtentifyLabel;
    @FXML
    private TextField idtentifyContextField;
    @FXML
    private TextField contactField;

    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    public void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
        setIdtentifyField();
    }

    @FXML
    private void setIdtentifyField(){
        if(customerVO.getCustomerType().equals(CustomerType.PERSONAL))
            idtentifyLabel.setText("生日");
        else
            idtentifyLabel.setText("企业名");
    }
    @FXML
    private void confirm(){
        if(actualNameField.getText()!=null)
            customerVO.setCustomerName(actualNameField.getText());
        if(idtentifyContextField.getText()!=null)
            customerVO.setUniqueInformation(idtentifyContextField.getText());
        if(contactField.getText()!=null)
            customerVO.setPhoneNumber(contactField.getText());
        //弹出对话框显示修改成功
    }
}
