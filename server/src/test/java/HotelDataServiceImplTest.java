import dataFactory.DataFactory;
import dataFactory.HotelDataHelper;
import dataFactory.impl.DataFactoryImpl;
import dataServiceImpl.HotelDataServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.HotelInfoPO;

import java.util.Map;

/**
* HotelDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 30, 2016</pre> 
* @version 1.0 
*/ 
public class HotelDataServiceImplTest { 

    private Map<String, HotelInfoPO> hotelInfoPOMap;
    private static HotelDataServiceImpl hotelDao;
    private DataFactory dataFactory;
    private HotelDataHelper hotelDataHelper;

    @Before
    public void setUp() throws Exception {
        hotelDao = HotelDataServiceImpl.getInstance();
        if(hotelInfoPOMap == null){
            dataFactory = new DataFactoryImpl() ;
            hotelDataHelper = dataFactory.getHotelDataHelper();
            hotelInfoPOMap = hotelDataHelper.getHotelInfoData();
        }
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindHotelInfo() {
        /*
        HotelInfoPO hipo = hotelDao.findHotelInfo("如家酒店（仙林）");
        assertEquals("如家酒店（仙林）", hipo.getHotelName());
        assertEquals("南京", hipo.getCity());
        assertEquals("仙林", hipo.getBusinessCircle());
        assertEquals("仙林大道163号", hipo.getAddress());
        assertEquals("交通方便", hipo.getIntroduction());
        assertEquals("热水24小时供应", hipo.getFacility());
        assertEquals(3, hipo.getStarLevel());
        assertEquals("网易;阿里", hipo.getCooperCompany());
        assertEquals(4.0, hipo.getScore());
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateHotelInfo() {
        /*
        HotelInfoPO hipo = new HotelInfoPO("如家酒店（新街口）", null, null, "南京市新街口123号",
                "娱乐设施完善", "空调、热水24小时供应", -1, "网易;腾讯", 4.2);
        boolean result = hotelDao.updateHotelInfo(hipo);
        if(result) {
            hipo = hotelDao.findHotelInfo("如家酒店（新街口）");
            assertEquals("如家酒店（新街口）", hipo.getHotelName());
            assertEquals("南京", hipo.getCity());
            assertEquals("新街口", hipo.getBusinessCircle());
            assertEquals("南京市新街口123号", hipo.getAddress());
            assertEquals("娱乐设施完善", hipo.getIntroduction());
            assertEquals("空调、热水24小时供应", hipo.getFacility());
            assertEquals(4, hipo.getStarLevel());
            assertEquals("网易;腾讯", hipo.getCooperCompany());
            assertEquals(4.2, hipo.getScore());
        }else {
            System.out.println("当前酒店不存在！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindHotels() {
        /*
        ArrayList<HotelInfoPO> hotelList = new ArrayList<HotelInfoPO>();
        Iterator<Map.Entry<String, HotelInfoPO>> iterator = hotelInfoPOMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, HotelInfoPO> entry = iterator.next();
            HotelInfoPO hotelInfoPO = entry.getValue();
            hotelList.add(hotelInfoPO);
        }
        assertEquals(hotelList.get(0).getAddress(), hotelDao.findHotels().get(0).getAddress());
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testInsertHotel() {
        /*
        HotelInfoPO hipo = new HotelInfoPO("和东酒店（仙林）", "南京", "仙林", "南京市新街口123号",
                "娱乐设施完善", "空调、热水24小时供应", 5, "网易;腾讯", 4.0);
        boolean result = hotelDao.insertHotel(hipo);
        if(result) {
            hipo = hotelDao.findHotelInfo("和东酒店（仙林）");
            assertEquals("和东酒店（仙林）", hipo.getHotelName());
            assertEquals("南京", hipo.getCity());
            assertEquals("仙林", hipo.getBusinessCircle());
            assertEquals("南京市新街口123号", hipo.getAddress());
            assertEquals("娱乐设施完善", hipo.getIntroduction());
            assertEquals("空调、热水24小时供应", hipo.getFacility());
            assertEquals(5, hipo.getStarLevel());
            assertEquals("网易;腾讯", hipo.getCooperCompany());
            assertEquals(4.0, hipo.getScore());
        }else {
            System.out.println("酒店已存在！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateHotelScore() {
        /*
        boolean result = hotelDao.updateHotelScore("如家酒店（新街口）", 2);
        if(result) {
            HotelInfoPO hipo = hotelDao.findHotelInfo("如家酒店（新街口）");
            assertEquals(3.1, hipo.getScore());
        }else {
            System.out.println("酒店不存在！");
        }
        */
    }
} 
