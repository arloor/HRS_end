package businesslogic.hotelbl;


/**
 * Created by Qin Liu on 2016/10/16.
 */

public class HotelBLService_Stub {
    /*
    OrderVO orderInfo;
    HotelInfo hotelInfo;
    AvailableRoomInfo availableRoomInfo;

    public HotelBLService_Stub(CustomerOrderInfo oi, HotelInfo hi, AvailableRoomInfo ari) {
        orderInfo = oi;
        hotelInfo = hi;
        availableRoomInfo = ari;
    }

    //获取酒店列表需要得到会员历史订单（标记是否预定过）
    public ArrayList<CustomerOrderVO> getCustomerOrderList (Stiring CustomID, OrderType type) {
        ArrayList<CustomerOrderVO> customerOrderList = new ArrayList<CustomerOrderVO>();
        customerOrderList.add(new CustomerOrderVO(orderInfo));
        return customerOrderList;
    }

    //获取酒店详情
    public HotelInfoVO getHotelInfo(String hotelName) {
        return new HotelInfoVO(hotelInfo);
    }

    //修改酒店详情
    public ResultMessage modifyHotelInfo(HotelInfoVO hivo) {
        if (hivo.address == "") {
            return ResultMessage.AddressNull;
        }
        return ResultMessage.Success;
    }

    //获取可用客房列表
    public ArrayList<AvailableRoomVO> getAvailableRoomList(String hotelName, String startDate, String endDate) {
        ArrayList<AvailableRoomVO> availableRoomList = new ArrayList<AvailableRoomVO>();
        availableRoomList.add(new AvailableRoomVO(availableRoomInfo));
        return availableRoomList;
    }

    //新增可用客房
    public ResultMessage addAvailableRooms(AvailableRoomVO arvo, String startDate, String endDate) {
        if(arvo.number == "") {
            return ResultMessage.NumberNull;
        }
        return ResultMessage.Success;
    }

    //删除可用客房
    public ResultMessage deleteAvailableRooms(AvailableRoomVO arvo, String startDate, String endDate) {
        if(arvo.number == "") {
            return ResultMessage.NumberNull;
        }
        return ResultMessage.Success;
    }

    //获取会员住过的酒店列表
    public ArrayList<HotelInfoVO> getHistoryList(String customerID) {
        ArrayList<HotelInfoVO> hotelList = new ArrayList<HotelInfoVO>();
        hotelList.add(new HotelInfoVO(hotelInfo));
        return hotelList;
    }

    //获取搜索酒店列表
    public ArrayList<HotelInfoVO> getHotelList (String customerID, SearchInfoVO sivo) {
        ArrayList<HotelInfoVO> hotelList = new ArrayList<HotelInfoVO>();
        hotelList.add(new HotelInfoVO(hotelInfo));
        return hotelList;
    }

    //添加酒店
    public ResultMessage addHotel(HotelInfoVO hivo) {
        if(hivo.hotelName == "如家酒店") {
            return ResultMessage.Exist;
        }else {
            return ResultMessage.NotExist;
        }
    }
    */
}
