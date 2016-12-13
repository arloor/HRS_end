package presentation.customer.view;

import businesslogic.orderbl.OrderImpl;
import businesslogic.orderbl.OrderProcesser;
import businesslogic.roombl.Room;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import businesslogicservice.roomblservice.RoomBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import vo.*;

import java.util.List;

/**
 * Created by 啊 on 2016/12/4.
 */
public class OrderGenerated2Controller {
    private presentation.customer.MainAPP mainAPP;
    private OrderVO orderVO;
    private CustomerVO customerVO;
    private SearchInfoVO searchInfoVO;
    private HotelInfoVO hotelInfoVO;
    private Boolean hasRoom=false;
    @FXML
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;
   @FXML
   private TextField roomTypeField;
    @FXML
    private TextField roomNumField;
    @FXML
    private TextField checkInDate;
    @FXML
    private TextField checkOutDate;
    @FXML
    private TextField initialPrice;
    @FXML
    private TextField actualPrice;
    public void setOrderVO(OrderVO orderVO) {
        this.orderVO=orderVO;
    }
    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO=customerVO;
    }
    public void setHotelVO(HotelInfoVO hotelInfoVO) {
        this.hotelInfoVO=hotelInfoVO;
    }
    public void setSearchInfoVO(SearchInfoVO searchInfoVO) {
        this.searchInfoVO=searchInfoVO;
    }
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
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
    private void setRoomTypeField(){
        roomTypeField.setEditable(false);
        roomTypeField.setText(orderVO.getRoomID());
    }
    @FXML
    private void setRoomNumField(){
        roomNumField.setEditable(false);
        roomNumField.setText(String.valueOf(orderVO.getRoomNum()));
    }
    @FXML
    private void setCheckInDate(){
        checkInDate.setEditable(false);
        String checkInTime=orderVO.getCheckInTime().split(" ")[0];       //checkInDate的格式是2016-12-06 08:08:08这样，现在只需要前半部分
        checkInDate.setText(checkInTime);
    }
    @FXML
    private void setCheckOutDate(){
        String checkOutTime=orderVO.getCheckOutTime().split(" ")[0];
        checkOutDate.setEditable(false);
        checkOutDate.setText(checkOutTime);
    }
    @FXML
    private void setInitialPrice(){
        RoomBLService roomBLService=new Room();
        List<AvailableRoomVO>availableRoomVOs=roomBLService.getAvailableRoomList(hotelInfoVO.getHotelName(),checkInDate.getText(),checkOutDate.getText());
        for(AvailableRoomVO tempVO:availableRoomVOs){
            if(tempVO.getRoomType().equals(roomTypeField.getText())){
                initialPrice.setText(String.valueOf(tempVO.getPrice()));
                hasRoom=true;
                break;
            }
        }
        if(hasRoom==false){
            //弹出对话框显示今日此房型已满，请重新选择
            mainAPP.showOrderGeneratedView(customerVO,hotelInfoVO.getHotelName(),searchInfoVO);
        }
    }
    @FXML
    private void setActualPrice(){
        /***
        actualPrice.setEditable(false);
        double price=Double.parseDouble(initialPrice.getText());
        PromotionBLService salePromotionBLService=new Promotion();
        actualPrice.setText(String.valueOf(salePromotionBLService.getPrice(orderVO)));
         ***/
    }
    @FXML
    public void setConfirmButton() {
        orderVO.setOrderID(OrderProcesser.getOrderID());
        orderVO.setStatus("未执行");
        orderVO.setPrice(Double.parseDouble(initialPrice.getText()));
        orderVO.setCharge(Double.parseDouble(actualPrice.getText()));
        OrderBLservice orderBLservice= OrderImpl.getMemberOrderInstance(orderVO.getCustomerID());
        orderBLservice.newOrder(orderVO);//newOrder不应该返回是否成功么，还有根据信用值那个也在这部分么
        //弹出对话框确认成功
    }
    @FXML
    public void setCancelButton() {
       mainAPP.showOrderGeneratedView(customerVO,hotelInfoVO.getHotelName(),searchInfoVO);
    }

}
