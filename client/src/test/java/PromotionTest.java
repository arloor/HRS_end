import businesslogic.promotionbl.Promotion;
import businesslogicservice.promotionblservice.PromotionBLService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import vo.OrderVO;

/** 
* Promotion Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 9, 2016</pre> 
* @version 1.0 
*/ 
public class PromotionTest {

    PromotionBLService promotionBLService;

    @Before
    public void setUp() throws Exception {
        promotionBLService = new Promotion();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test@Ignore
    public void testGetHotelPromotion() {
        /*
        HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO = (HotelSpecialTimePromotionVO) promotionBLService.getHotelPromotion(HotelPromotionType.SpecialTime, "如家酒店");
        if(hotelSpecialTimePromotionVO == null) {
            System.out.println("该类型的酒店促销策略不存在！");
        }else {
            System.out.println(hotelSpecialTimePromotionVO.getHotelName() + " " + hotelSpecialTimePromotionVO.getStartDate() + " " + hotelSpecialTimePromotionVO.getEndDate() + " " + hotelSpecialTimePromotionVO.getDiscount());
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateHotelPromotion() {
        /*
        HotelPromotionVO hotelPromotionVO = new HotelSpecialTimePromotionVO("如家", "2015-12-08 00:00:00", "2015-12-10 00:00:00", 0.9);
        ResultMessage resultMessage = promotionBLService.updateHotelPromotion(HotelPromotionType.SpecialTime, hotelPromotionVO);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("更新酒店促销策略成功！");
        }else {
            System.out.println("更新酒店促销策略失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testGetWebPromotion() {
        /*
        WebLevelPromotionVO webLevelPromotionVO = (WebLevelPromotionVO) promotionBLService.getWebPromotion(WebPromotionType.Level);
        if(webLevelPromotionVO == null) {
            System.out.println("不存在该类型的网站促销策略！");
        }else {
            ArrayList<LevelVO> levelVOList = webLevelPromotionVO.getLevelList();
            System.out.println(levelVOList.size());
            for(int i = 0; i < levelVOList.size(); i++) {
                LevelVO levelVO = levelVOList.get(i);
                System.out.println(levelVO.getLevel() + " " + levelVO.getCredit() + " " + levelVO.getDiscount());
            }
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateWebPromotion() {
        /*
        ArrayList<LevelVO> levelVOList = new ArrayList<LevelVO>();
        LevelVO levelVO_1 = new LevelVO(1, 501, 0.9);
        LevelVO levelVO_2 = new LevelVO(2, 1001, 0.8);
        LevelVO levelVO_3 = new LevelVO(3, 1501, 0.7);
        levelVOList.add(levelVO_1);
        levelVOList.add(levelVO_2);
        levelVOList.add(levelVO_3);
        WebPromotionVO webPromotionVO = new WebLevelPromotionVO(levelVOList);
        ResultMessage resultMessage = promotionBLService.updateWebPromotion(WebPromotionType.Level, webPromotionVO);
        if(resultMessage == ResultMessage.SUCCESS) {
            System.out.println("更新网站促销策略成功！");
        }else {
            System.out.println("更新网站促销策略失败！");
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testCalculateLevel() {
        /*
        int level = promotionBLService.calculateLevel(3100);
        System.out.println(level);
        */
    }


    /**
     * 测试已通过
     */
    @Test
    public void testCalculatePrice() {

        OrderVO orderVO = new OrderVO(66, "mytest", "南京中心大酒店", "未执行", "单人间",
        1, 1, "yes", "2015-12-23 10:00:00", null, "2015-12-24 00:00:00", null,
        128, -1, null);
        OrderVO newOrderVO = promotionBLService.calculatePrice(orderVO);
        if(newOrderVO.getPromotionType() != null) {
            System.out.println(newOrderVO.getPromotionType());
        }else {
            System.out.println("无可用促销策略！");
        }
        System.out.println(newOrderVO.getPrice() + " " + newOrderVO.getCharge());

    }

} 
