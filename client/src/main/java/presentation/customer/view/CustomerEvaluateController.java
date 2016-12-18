package presentation.customer.view;

import businesslogic.orderbl.OrderImpl;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private Label hotelNameField;
    @FXML
    private Label checkInTimeField;
    @FXML
    private TextField gradeField;
    @FXML
    private TextArea evaluateTextArea;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        setHotelNameField();
        setCheckInTimeField();
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

    private void setHotelNameField(){
        hotelNameField.setText(hotelInfoVO.getHotelName());
    }

    private void setCheckInTimeField(){
        checkInTimeField.setText(orderVO.getCheckInTime());
    }
    @FXML
    private void setConfirmButton(){
        String grade=gradeField.getText();
        String evaluation=evaluateTextArea.getText();
        OrderEvaluationVO orderEvaluationVO=new OrderEvaluationVO(orderVO.getOrderID(),Double.parseDouble(grade),evaluation);
        OrderBLservice orderBLservice=OrderImpl.getMemberOrderInstance(customerVO.getUserName());
        orderBLservice.evaluateOrder(orderEvaluationVO);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("评价成功");
        alert.showAndWait();
    }
    @FXML
    private void setCancelButton(){
        mainAPP.showOrderInfoView(customerVO);
    }

}
