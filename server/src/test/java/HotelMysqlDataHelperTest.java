import dataFactory.impl.HotelMysqlDataHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.HotelInfoPO;

import java.util.Map;

/** 
* HotelMysqlDataHelper Tester. 
* 
* @author <Qin Liu>
* @since <pre>十一月 29, 2016</pre> 
* @version 1.0 
*/ 
public class HotelMysqlDataHelperTest {

    Map<String, HotelInfoPO> hotelInfoPOMap;
    HotelMysqlDataHelper hotelMysqlDataHelper = new HotelMysqlDataHelper();

    @Before
    public void setUp() throws Exception {
        hotelInfoPOMap = hotelMysqlDataHelper.getHotelInfoData();
    }

    @After
    public void after() throws Exception {

    }

    /**
     * 测试已通过
     * @throws Exception
     */
    @Test
    public void testInsertHotel() throws Exception {
        /*
        SimpleDateFormat df = new SimpleDateFormat("ddHHmmss");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String str = df.format(now);
        str = "如家酒店" + str;
        String hotelName = str;

        HotelInfoPO hipo = hotelInfoPOMap.get("如家酒店（仙林）");
        hipo.setHotelName(hotelName);
        hotelMysqlDataHelper.insertHotel(hipo);
        hotelInfoPOMap = hotelMysqlDataHelper.getHotelInfoData();

        HotelInfoPO newHipo = hotelInfoPOMap.get(hotelName);

        assertEquals(hipo.getHotelName(), newHipo.getHotelName());
        assertEquals(hipo.getCity(), newHipo.getCity());
        assertEquals(hipo.getBusinessCircle(), newHipo.getBusinessCircle());
        assertEquals(hipo.getAddress(), newHipo.getAddress());
        assertEquals(hipo.getFacility(), newHipo.getFacility());
        assertEquals(hipo.getIntroduction(), newHipo.getIntroduction());
        assertEquals(hipo.getStarLevel(), newHipo.getStarLevel());
        assertEquals(hipo.getCooperCompany(), newHipo.getCooperCompany());
        assertEquals(hipo.getScore(), newHipo.getScore());
        */
    }

    /**
     * 测试已通过
     * @throws Exception
     */
    @Test
    public void testUpdateHotelInfoData() throws Exception {
        /*
        HotelInfoPO hipo = new HotelInfoPO("如家酒店（仙林）", null, null, "仙林大道163号",
                "交通方便", "热水24小时供应", -1, "网易;阿里", -1);
        hotelMysqlDataHelper.updateHotelInfoData(hipo);
        hotelInfoPOMap = hotelMysqlDataHelper.getHotelInfoData();
        hipo = hotelInfoPOMap.get("如家酒店（仙林）");

        assertEquals("仙林大道163号", hipo.getAddress());
        assertEquals("交通方便", hipo.getIntroduction());
        assertEquals("热水24小时供应", hipo.getFacility());
        assertEquals("网易;阿里", hipo.getCooperCompany());
        */
    }

    /**
     * 测试已通过
     * @throws Exception
     */
    @Test
    public void testUpdateHotelScore() throws Exception {
        /*
        hotelMysqlDataHelper.updateHotelScore("如家酒店（新街口）", 4.2);
        hotelInfoPOMap = hotelMysqlDataHelper.getHotelInfoData();
        HotelInfoPO hipo = hotelInfoPOMap.get("如家酒店（新街口）");

        assertEquals(4.2, hipo.getScore());
        */
   }

}
