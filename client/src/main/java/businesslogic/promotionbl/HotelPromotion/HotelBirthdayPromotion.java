package businesslogic.promotionbl.HotelPromotion;

import businesslogic.customerbl.Customer;
import businesslogicservice.customerblservice.CustomerBLService;
import util.CustomerType;
import vo.CustomerVO;
import vo.HotelPromotionVO.HotelBirthdayPromotionVO;
import vo.OrderVO;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class HotelBirthdayPromotion extends HotelPromotion {

    private OrderVO orderVO;

    private HotelBirthdayPromotionVO hotelBirthdayPromotionVO;

    public HotelBirthdayPromotion(OrderVO orderVO, HotelBirthdayPromotionVO hotelBirthdayPromotionVO) {
        this.orderVO = (OrderVO) orderVO.clone();
        this.hotelBirthdayPromotionVO = hotelBirthdayPromotionVO;
    }

    @Override
    public OrderVO calculatePrice() {
        String checkInDate = orderVO.getLastCheckInTime().substring(5,10);
        CustomerBLService customerBLService = new Customer();
        CustomerVO customerVO = customerBLService.getCustomerInfo(orderVO.getCustomerID());
        if(customerVO.getCustomerType() == CustomerType.PERSONAL) {
            String birthday = customerVO.getUniqueInformation().substring(5,10);
            if(checkInDate.equals(birthday)) {
                orderVO.setPrice(orderVO.getPrice() * hotelBirthdayPromotionVO.getDiscount());
            }
        }
        return this.orderVO;
    }

}
