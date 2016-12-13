package presentation.customer.view;

import businesslogic.orderbl.OrderImpl;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.OrderEvaluationVO;
import vo.OrderVO;

/**
 * Created by 啊 on 2016/11/28.
 */
public class CustomerEvaluateController {
    private presentation.customer.MainAPP mainAPP;
    private CustomerVO customerVO;
    private HotelInfoVO hotelInfoVO;
    private OrderVO orderVO;
    @FXML
    private ImageView imageView;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField hotelNameField;
    @FXML
    private TextField checkInTimeField;
    @FXML
    private TextField gradeField;
    @FXML
    private TextArea evaluateTextArea;
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }
    public void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
    }
    public void setOrderVO(OrderVO orderVO){
        this.orderVO=orderVO;
    }
    public void setHotelInfoVO(HotelInfoVO hotelInfoVO){
        this.hotelInfoVO=hotelInfoVO;
    }
    @FXML
    private void setHotelNameField(){
        hotelNameField.setEditable(false);
        hotelNameField.setText(hotelInfoVO.getHotelName());
    }
    @FXML
    private void setCheckInTimeField(){
        checkInTimeField.setEditable(false);
        checkInTimeField.setText(orderVO.getCheckInTime());
    }
    @FXML
    private void setConfirmButton(){
        String grade=gradeField.getText();
        String evaluation=evaluateTextArea.getText();
        OrderEvaluationVO orderEvaluationVO=new OrderEvaluationVO(orderVO.getOrderID(),Double.parseDouble(grade),evaluation);
        OrderBLservice orderBLservice=OrderImpl.getMemberOrderInstance(customerVO.getUserName());
        orderBLservice.evaluateOrder(orderEvaluationVO);
        //最好能弹出一个对话框显示评价成功
    }
    @FXML
    private void setCancelButton(){
        mainAPP.showOrderInfoView(customerVO);
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
}
