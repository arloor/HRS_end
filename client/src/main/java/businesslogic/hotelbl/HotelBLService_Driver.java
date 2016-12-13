package businesslogic.hotelbl;


/**
 * Created by Qin Liu on 2016/10/16.
 */
public class HotelBLService_Driver {
    /*
    public void drive(HotelBLService hotelBLService) {
        //获取酒店详情
        HotelInfoVO hivo = hotelBLService.getHotelInfo("如家酒店");
        System.out.println(hivo.address);

        //修改酒店详情
        HotelInfoVO hivo_1 = new HotelInfoVO();
        hivo.address = "";
        ResultMessage result_1 = hotelBLService.modifyHotelInfo(hivo_1);
        if(result_1 = ResultMessage.addressNull) {
            System.out.println("输入的地址为空");
        }else {
            System.out.print("修改成功");
        }

        //获取可用客房列表
        ArrayList<AvailableRoomVO> availableRoomList = hotelBLService.getAvailableRoomList("如家", "2016-10-16", "2016-10-17");
        System.out.println(availableRoomList(0).number);

        //新增可用客房
        AvailableRoomVO arvo_1 = new AvailableRoomVO();
        arvo.number = "3";
        ResultMessage result_2 = hotelBLService.addAvailableRooms(arvo_1, "2016-10-16", "2016-10-17");
        if(result_2 == ResultMessage.NumberNull) {
            System.out.println("请输入数量");
        }else {
            System.out.println("添加成功");
        }

        //删除可用客房
        AvailableRoomVO arvo_2 = new AvailableRoomVO();
        arvo.number = "3";
        ResultMessage result_3 = hotelBLService.addAvailableRooms(arvo_2, "2016-10-16", "2016-10-17");
        if(result_3 == ResultMessage.NumberNull) {
            System.out.println("请输入数量");
        }else {
            System.out.println("删除成功");
        }

        //获取会员住过的酒店列表
        ArrayList<HotelInfoVO> hotelList_1 = hotelBLService.getHistoryList("123456");
        System.out.println(hotelList_1(0).hotelName);

        //获取搜索酒店列表
        SearchInfoVO sivo = new SearchInfoVO();
        sivo.hotelName = "如家酒店";
        ArrayList<HotelInfoVO> hotelList_2 = getHotelList ("123456", sivo);
        System.out.println(hotelList_2(0).hotelName);

        //添加酒店
        HotelInfoVO hivo_2 = new HotelInfoVO();
        hivo_2.hotelName = "如家酒店";
        ResultMessage result_4 = hotelBLService.addHotel(hivo_2);
        if(result_4 == ResultMessage.Exist) {
            System.out.println("酒店已存在");
        }else {
            System.out.println("添加成功");
        }
    }
    */
}
/*
public class Client {
    public static void main(String[] args) {
        HotelBLService hotelController = new HotelController();
        HotelBLService_Driver driver = new HotelBLService_Driver();
        driver.drive(hotelController);
    }
}
*/