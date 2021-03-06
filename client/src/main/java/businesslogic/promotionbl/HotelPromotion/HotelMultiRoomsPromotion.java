package businesslogic.promotionbl.HotelPromotion;

import util.HotelPromotionType;
import vo.HotelPromotionVO.HotelMultiRoomsPromotionVO;
import vo.OrderVO;

/**
 * Created by Qin Liu on 2016/12/10.
 */
public class HotelMultiRoomsPromotion extends HotelPromotion {

    private OrderVO orderVO;

    private HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO;

    private HotelPromotionType hotelPromotionType = HotelPromotionType.MultiRooms;

    public HotelMultiRoomsPromotion(OrderVO orderVO, HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO) {
        this.orderVO = (OrderVO) orderVO.clone();
        this.hotelMultiRoomsPromotionVO = hotelMultiRoomsPromotionVO;
    }

    @Override
    public OrderVO calculatePrice() {
        int roomNum = orderVO.getRoomNum();
        int leastRoomNum = hotelMultiRoomsPromotionVO.getRoomNum();
        if(roomNum >= leastRoomNum) {
            orderVO.setPrice(orderVO.getPrice() * hotelMultiRoomsPromotionVO.getDiscount());
        }
        return this.orderVO;
    }

    @Override
    public HotelPromotionType getHotelPromotionType() {
        return this.hotelPromotionType;
    }

}
