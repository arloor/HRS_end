package presentation.customer.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vo.CustomerVO;

/**
 * Created by 啊 on 2016/12/4.
 */
public class CustomerInfoModifyController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField trueNameField;
    @FXML
    private TextField idtentifyField;
    @FXML
    private TextField idtentifyContextField;
    @FXML
    private TextField contactField;
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField oldPasswordField;
    @FXML
    private PasswordField newPasswordField;

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    @FXML
    private void setTrueNameField(){
        if(trueNameField.getText()!="")
            customerVO.setCustomerName(trueNameField.getText());
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
        if(idtentifyContextField.getText()!="")
            customerVO.setUniqueInformation(idtentifyContextField.getText());
    }
    @FXML
    private void setContactField(){
        if(contactField.getText()!="")
            customerVO.setPhoneNumber(contactField.getText());
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
    private void setNewPasswordField(){
        if(newPasswordField.getText()!=null){
            if(newPasswordField.getText().equals(oldPasswordField.getText()))
                customerVO.setPassword(newPasswordField.getText());
            else{
                //弹出对话框提示两次密码输入不一致
            }
        }
    }
    @FXML
    public void setConfirmButton() {
        if (trueNameField.getText() != null)
            customerVO.setCustomerName(trueNameField.getText());
        if (idtentifyContextField.getText() != null)
            customerVO.setUniqueInformation(idtentifyContextField.getText());
        if (contactField.getText() != null)
            customerVO.setPhoneNumber(contactField.getText());
        if (newPasswordField != null && oldPasswordField.getText().equals(customerVO.getPassword()))
            customerVO.setPassword(newPasswordField.getText());
        //弹出对话框提示修改成功没有实现！！
    }
    @FXML
    public void setCancelButton(){
        mainAPP.showPersonalInformationView(customerVO);
    }
}
