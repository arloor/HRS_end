package businesslogic.promotionbl.HotelPromotion;

import businesslogic.customerbl.Customer;
import businesslogic.hotelbl.Hotel;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import util.CustomerType;
import util.HotelPromotionType;
import vo.CustomerVO;
import vo.HotelInfoVO;
import vo.HotelPromotionVO.HotelCompanyPromotionVO;
import vo.OrderVO;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class HotelCompanyPromotion extends HotelPromotion {

    private OrderVO orderVO;

    private HotelCompanyPromotionVO hotelCompanyPromotionVO;

    private HotelPromotionType hotelPromotionType = HotelPromotionType.Company;

    public HotelCompanyPromotion(OrderVO orderVO, HotelCompanyPromotionVO hotelCompanyPromotionVO) {
        this.orderVO = (OrderVO) orderVO.clone();
        this.hotelCompanyPromotionVO = hotelCompanyPromotionVO;
    }

    @Override
    public OrderVO calculatePrice() {
        HotelBLService hotelBLService = new Hotel();
        HotelInfoVO hivo = hotelBLService.getHotelInfo(orderVO.getHotel());
        String cooperCompany[] = hivo.getCooperCompany().split(";");

        CustomerBLService customerBLService = new Customer();
        CustomerVO customerVO = customerBLService.getCustomerInfo(orderVO.getCustomerID());
        if(customerVO.getCustomerType() == CustomerType.COMPANY) {
            String company = customerVO.getUniqueInformation();

            for(int i = 0; i < cooperCompany.length; i++) {
                if(company.equals(cooperCompany[i])) {
                    orderVO.setPrice(orderVO.getPrice() * hotelCompanyPromotionVO.getDiscount());
                }
            }
        }

        return orderVO;
    }

    @Override
    public HotelPromotionType getHotelPromotionType() {
        return this.hotelPromotionType;
    }

}
