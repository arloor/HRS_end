import dataFactory.DataFactory;
import dataFactory.RoomDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataServiceImpl.RoomDataServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.AvailableRoomPO;

import java.util.Map;

/**
* RoomDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 2, 2016</pre> 
* @version 1.0 
*/ 
public class RoomDataServiceImplTest {

    Map<String, AvailableRoomPO> availableRoomPOMap;
    private static RoomDataServiceImpl roomDao;
    private DataFactory dataFactory;
    private RoomDataHelper roomDataHelper;

    @Before
    public void setUp() throws Exception {
        roomDao = RoomDataServiceImpl.getInstance();
        dataFactory = new DataFactoryImpl() ;
        roomDataHelper = dataFactory.getRoomDataHelper();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindAvailableRooms() {
        /*
        availableRoomPOMap = roomDataHelper.getAvailableRoomData("如家酒店（仙林）");
        ArrayList<AvailableRoomPO> roomList = new ArrayList<AvailableRoomPO>();
        Iterator<Map.Entry<String, AvailableRoomPO>> iterator = availableRoomPOMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, AvailableRoomPO> entry = iterator.next();
            AvailableRoomPO arpo = entry.getValue();
            roomList.add(arpo);
        }
        assertEquals(roomList.get(0).getRoomNum(), roomDao.findAvailableRooms("如家酒店（仙林）").get(0).getRoomNum());
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateAvailableRooms() {
        /*
        AvailableRoomPO arpo = new AvailableRoomPO("如家酒店（仙林）", "单人间", -10, -1);
        boolean result = roomDao.updateAvailableRooms(arpo);
        if(result) {
            arpo = roomDao.findAvailableRooms("如家酒店（仙林）").get(2);
            assertEquals("如家酒店（仙林）", arpo.getHotelName());
            assertEquals("单人间", arpo.getRoomType());
            assertEquals(90, arpo.getRoomNum());
            assertEquals(50.00, arpo.getPrice());
        }else {
            System.out.println("该类客房不存在！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testInsertAvailableRooms() {
        /*
        AvailableRoomPO arpo = new AvailableRoomPO("如家酒店（仙林）", "豪华间", 15, 600);
        boolean result = roomDao.insertAvailableRooms(arpo);
        if(result) {
            arpo = roomDao.findAvailableRooms("如家酒店（仙林）").get(2);
            assertEquals("如家酒店（仙林）", arpo.getHotelName());
            assertEquals("豪华间", arpo.getRoomType());
            assertEquals(15, arpo.getRoomNum());
            assertEquals(600.00, arpo.getPrice());
        }else {
            System.out.println("该类客房已存在！");
        }
        */
    }

} 
