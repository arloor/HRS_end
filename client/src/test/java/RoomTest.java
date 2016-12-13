import businesslogic.roombl.Room;
import businesslogicservice.roomblservice.RoomBLService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Room Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 5, 2016</pre> 
* @version 1.0 
*/ 
public class RoomTest {

    RoomBLService roomBLService = new Room();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test
    public void testAddAvailableRooms() {
        /*
        AvailableRoomVO arvo = new AvailableRoomVO("如家酒店（仙林）", "商务间", 20, -1);
        ResultMessage resultMessage = roomBLService.addAvailableRooms(arvo);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("添加客房成功！");
        }else {
            System.out.println("添加客房失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testInsertAvailableRooms() {
        /*
        AvailableRoomVO arvo = new AvailableRoomVO("如家酒店（仙林）", "大床房", 20, 150);
        ResultMessage resultMessage = roomBLService.addAvailableRooms(arvo);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("插入客房成功！");
        }else {
            System.out.println("插入客房失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testDeleteAvailableRooms() {
        /*
        AvailableRoomVO arvo = new AvailableRoomVO("如家酒店（仙林）", "大床房", 5, -1);
        ResultMessage resultMessage = roomBLService.deleteAvailableRooms(arvo);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("减少客房成功！");
        }else {
            System.out.println("减少客房失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testGetAvailableRooms() {
        /*
        ArrayList<AvailableRoomVO> roomVOList = roomBLService.getAvailableRoomList("南京中心大酒店", null, null);
        for(int i = 0; i < roomVOList.size(); i++) {
            AvailableRoomVO arvo = roomVOList.get(i);
            System.out.print(arvo.getHotelName() + " " + arvo.getRoomType() + " " + arvo.getRoomNum() + " " + arvo.getPrice());
            System.out.println("");
        }

        System.out.println("");
        System.out.println("");

        ArrayList<AvailableRoomVO> realRoomVOList = roomBLService.getAvailableRoomList("南京中心大酒店", "2016-12-09 13:00:00", "2016-12-14 00:00:00");
        for(int i = 0; i < realRoomVOList.size(); i++) {
            AvailableRoomVO arvo = realRoomVOList.get(i);
            System.out.print(arvo.getHotelName() + " " + arvo.getRoomType() + " " + arvo.getRoomNum() + " " + arvo.getPrice());
            System.out.println("");
        }
        */
    }

} 
