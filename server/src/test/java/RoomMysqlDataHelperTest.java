import dataFactory.impl.RoomMysqlDataHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.AvailableRoomPO;

import java.util.Map;

/** 
* RoomMysqlDataHelper Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 2, 2016</pre> 
* @version 1.0 
*/ 
public class RoomMysqlDataHelperTest { 

    Map<String, AvailableRoomPO> availableRoomPOMap;
    RoomMysqlDataHelper roomMysqlDataHelper = new RoomMysqlDataHelper();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     * @throws Exception
     */
    @Test
    public void testGetAvailableRoomData() throws Exception {
        /*
        availableRoomPOMap = roomMysqlDataHelper.getAvailableRoomData("如家酒店（仙林）");
        AvailableRoomPO arpo = availableRoomPOMap.get("标准间");
        assertEquals(200.00, arpo.getPrice());
        assertEquals(50, arpo.getRoomNum());
        */
    }

    /**
     * 测试已通过
     * @throws Exception
     */
    @Test
    public void testInsertAvailableRoom() throws Exception {
        /*
        availableRoomPOMap = roomMysqlDataHelper.getAvailableRoomData("如家酒店（仙林）");
        AvailableRoomPO arpo = availableRoomPOMap.get("标准间");
        arpo.setRoomType("商务间");
        roomMysqlDataHelper.insertAvailableRoom(arpo);
        availableRoomPOMap = roomMysqlDataHelper.getAvailableRoomData(arpo.getHotelName());

        AvailableRoomPO newArpo = availableRoomPOMap.get("商务间");

        assertEquals(arpo.getHotelName(), newArpo.getHotelName());
        assertEquals(arpo.getRoomType(), newArpo.getRoomType());
        assertEquals(arpo.getRoomNum(), newArpo.getRoomNum());
        assertEquals(arpo.getPrice(), newArpo.getPrice());
        */
    }

    /**
     * 测试已通过
     * @throws Exception
     */
    @Test
    public void testUpdateAvailableRoomData() throws Exception {
        /*
        AvailableRoomPO arpo = new AvailableRoomPO("如家酒店（仙林）", "单人间", -10, 50);
        roomMysqlDataHelper.updateAvailableRoomData(arpo);
        availableRoomPOMap = roomMysqlDataHelper.getAvailableRoomData("如家酒店（仙林）");
        arpo = availableRoomPOMap.get("单人间");

        assertEquals("如家酒店（仙林）", arpo.getHotelName());
        assertEquals("单人间", arpo.getRoomType());
        assertEquals(90, arpo.getRoomNum());
        assertEquals(50.00, arpo.getPrice());
        */
    }

} 
