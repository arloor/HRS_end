package presentation.customer.view;

import businesslogic.orderbl.OrderImpl;
import businesslogic.orderbl.OrderProcesser;
import businesslogic.promotionbl.Promotion;
import businesslogic.roombl.Room;
import businesslogicservice.orderbusinesslogicservice.OrderBLservice;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import util.ResultMessage;
import vo.*;

import java.text.DecimalFormat;
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

    @FXML
    private Label roomTypeField;
    @FXML
    private Label roomNumField;
    @FXML
    private Label checkInDate;
    @FXML
    private Label checkOutDate;
    @FXML
    private Label initialPrice;
    @FXML
    private Label actualPrice;
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
        setRoomNumField();
        setRoomTypeField();
        setCheckInDate();
        setCheckOutDate();
        setInitialPrice();
        setActualPrice();
    }


    private void setRoomTypeField(){
        roomTypeField.setText(orderVO.getRoomID());
    }

    private void setRoomNumField(){
        roomNumField.setText(String.valueOf(orderVO.getRoomNum()));
    }

    private void setCheckInDate(){
        String checkInTime=orderVO.getLastCheckInTime().split(" ")[0];       //checkInDate的格式是2016-12-06 08:08:08这样，现在只需要前半部分
        checkInDate.setText(checkInTime);
    }

    private void setCheckOutDate(){
        String checkOutTime=orderVO.getLastCheckoutTime().split(" ")[0];
        checkOutDate.setText(checkOutTime);
    }

    private void setInitialPrice(){
        RoomBLService roomBLService=new Room();
        List<AvailableRoomVO>availableRoomVOs=roomBLService.getAvailableRoomList(hotelInfoVO.getHotelName(),null,null);
        for(AvailableRoomVO tempVO:availableRoomVOs){
            if(tempVO.getRoomType().equals(roomTypeField.getText())){
                orderVO.setPrice(tempVO.getPrice());
                break;
            }
        }
    }

    private void setActualPrice(){
         PromotionBLService salePromotionBLService=new Promotion();
        orderVO=salePromotionBLService.calculatePrice(orderVO);
        String promotionType=orderVO.getPromotionType();
        double price= orderVO.getCharge();
        DecimalFormat df=new DecimalFormat("0.00");
        String CNY=df.format(price);
        if(promotionType!=null)
            actualPrice.setText(CNY+" "+promotionType);
        else
            actualPrice.setText(CNY);
        initialPrice.setText(String.valueOf(orderVO.getPrice()));
    }
    @FXML
    public void setConfirmButton() {
        orderVO.setOrderID(OrderProcesser.getOrderID());
        orderVO.setStatus("未执行");
        OrderBLservice orderBLservice= OrderImpl.getMemberOrderInstance(orderVO.getCustomerID());
        ResultMessage resultMessage=orderBLservice.newOrder(orderVO);
        String information="";
        if(resultMessage.equals(ResultMessage.SUCCESS))
            information="预订成功";
        else if(resultMessage.equals(ResultMessage.CREDIT_LT_ZERO))
            information="信用不足";
        else if(resultMessage.equals(ResultMessage.NO_ENOUGH_ROOM))
            information="当前类型房屋已满";
       mainAPP.informationAlert(information);
    }
    @FXML
    public void setCancelButton() {
        mainAPP.showOrderGeneratedView(customerVO,hotelInfoVO,searchInfoVO);
    }

}
