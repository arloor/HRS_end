import businesslogic.hotelbl.Hotel;
import businesslogicservice.hotelblservice.HotelBLService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import vo.HotelInfoVO;

import java.util.ArrayList;

/** 
* Hotel Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 5, 2016</pre> 
* @version 1.0 
*/ 
public class HotelTest {

    HotelBLService hotelBLService = new Hotel();

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
    public void testGetHotelInfo() {
        /*
        HotelInfoVO hivo = hotelBLService.getHotelInfo("南京英尊假日酒店");
        System.out.println(hivo.getHotelName() + " " + hivo.getCity() + " " + hivo.getBusinessCircle() + " " + hivo.getAddress() + " " +
                hivo.getIntroduction() + " " + hivo.getFacility() + " " + hivo.getStarLevel() + " " + hivo.getCooperCompany() + " " + hivo.getScore() + " " +
                hivo.getReserve() + " " + hivo.getLowestPrice());
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testModifyHotelInfo() {
        /*
        HotelInfoVO hivo = new HotelInfoVO("如家酒店01", "南京", "仙林", "仙林大道", "方便", "热水24小时", -1, "网易;百度", -1, false, -1);
        ResultMessage resultMessage = hotelBLService.modifyHotelInfo(hivo);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("修改酒店基本信息成功！");
        }else {
            System.out.println("修改酒店基本信息失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testGetHistoryHotelList() {
        /*
        ArrayList<HotelInfoVO> historyHotelList = hotelBLService.getHistoryHotelList("mytest");
        for(int i = 0; i < historyHotelList.size(); i++) {
            HotelInfoVO hivo = historyHotelList.get(i);
            System.out.println(hivo.getHotelName() + " " + hivo.getCity() + " " + hivo.getBusinessCircle() + " " + hivo.getAddress() + " " +
                    hivo.getIntroduction() + " " + hivo.getFacility() + " " + hivo.getStarLevel() + " " + hivo.getCooperCompany() + " " + hivo.getScore() + " " +
                    hivo.getReserve() + " " + hivo.getLowestPrice());
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testGetHotelList() {
        /*
        SearchInfoVO sivo = new SearchInfoVO("liuqin", "南京", "仙林学府区", "酒店", -1,
                3.8, 4.3, null, -1, -1, null, null, -1);

        ArrayList<HotelInfoVO> hotelList = hotelBLService.getHotelList(sivo);

        if(hotelList.size() == 0) {
            System.out.println("酒店列表为空！");
        }
        for(int i = 0; i < hotelList.size(); i++) {
            HotelInfoVO hivo = hotelList.get(i);
            System.out.print(hivo.getHotelName() + " " + hivo.getCity() + " " + hivo.getBusinessCircle() + " " + hivo.getAddress() + " " +
            hivo.getIntroduction() + " " + hivo.getFacility() + " " + hivo.getStarLevel() + " " + hivo.getCooperCompany() + " " + hivo.getScore() + " " +
            hivo.getReserve() + " " + hivo.getLowestPrice());
            System.out.println("");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testAddHotel() {
        /*
        HotelInfoVO hivo = new HotelInfoVO("汉庭酒店", "南京", "仙林", "仙林大道", "方便", "热水24小时", 5, "网易;百度", 4.0, false, -1);
        ResultMessage resultMessage = hotelBLService.addHotel(hivo);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("添加酒店成功！");
        }else {
            System.out.println("添加酒店失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testSort() {
        /*
        SearchInfoVO sivo = new SearchInfoVO("liuqin", "南京", "新街口地区", null, -1,
                -1, -1, null, -1, -1, null, null, -1);

        ArrayList<HotelInfoVO> hotelList = hotelBLService.getHotelList(sivo);
        if(hotelList.size() == 0) {
            System.out.println("酒店列表为空！");
        }
        for(int i = 0; i < hotelList.size(); i++) {
            HotelInfoVO hivo = hotelList.get(i);
            System.out.print(hivo.getHotelName() + " " + hivo.getCity() + " " + hivo.getBusinessCircle() + " " + hivo.getAddress() + " " +
                    hivo.getIntroduction() + " " + hivo.getFacility() + " " + hivo.getStarLevel() + " " + hivo.getCooperCompany() + " " + hivo.getScore() + " " +
                    hivo.getReserve() + " " + hivo.getLowestPrice());
            System.out.println("");
        }
        System.out.println();
        System.out.println();
        System.out.println();

        ArrayList<HotelInfoVO> newHotelList = hotelBLService.sort(hotelList, SortType.Score, SortWay.Ascend);
        if(newHotelList.size() == 0) {
            System.out.println("酒店列表为空！");
        }
        for(int i = 0; i < newHotelList.size(); i++) {
            HotelInfoVO hivo = newHotelList.get(i);
            System.out.print(hivo.getHotelName() + " " + hivo.getCity() + " " + hivo.getBusinessCircle() + " " + hivo.getAddress() + " " +
                    hivo.getIntroduction() + " " + hivo.getFacility() + " " + hivo.getStarLevel() + " " + hivo.getCooperCompany() + " " + hivo.getScore() + " " +
                    hivo.getReserve() + " " + hivo.getLowestPrice());
            System.out.println("");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateHotelScore() {
        /*
        ResultMessage resultMessage = hotelBLService.updateHotelScore("如家酒店（新街口", 2);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("更新酒店评分成功！");
        }else {
            System.out.println("更新酒店评分失败！");
        }
        */
    }
} 
