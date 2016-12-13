import dataFactory.impl.PromotionMysqlDataHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.HotelPromotionPO.HotelPromotionPO;
import po.WebPromotionPO.WebPromotionPO;
import util.HotelPromotionType;
import util.WebPromotionType;

import java.util.Map;

/** 
* PromotionMysqlDataHelper Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 9, 2016</pre> 
* @version 1.0 
*/ 
public class PromotionMysqlDataHelperTest {

    private Map<HotelPromotionType, HotelPromotionPO> hotelPromotionPOMap;

    private Map<WebPromotionType, WebPromotionPO> webPromotionPOMap;

    private PromotionMysqlDataHelper promotionMysqlDataHelper = new PromotionMysqlDataHelper();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindHotelPromotions() {
        /*
        hotelPromotionPOMap = promotionMysqlDataHelper.findHotelPromotions("如家酒店");
        HotelSpecialTimePromotionPO hotelSpecialTimePromotionPO = (HotelSpecialTimePromotionPO) hotelPromotionPOMap.get(HotelPromotionType.SpecialTime);

        if(hotelSpecialTimePromotionPO == null) {
            System.out.println("酒店策略不存在！");
        }else {
            System.out.println(hotelSpecialTimePromotionPO.getHotelName() + " " + hotelSpecialTimePromotionPO.getStartDate() + " " + hotelSpecialTimePromotionPO.getEndDate() + " " + hotelSpecialTimePromotionPO.getDiscount());
        }
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testUpdateHotelPromotion() {
        /*
        HotelPromotionPO hotelPromotionPO = new HotelSpecialTimePromotionPO("汉庭酒店", "2016-12-9 00:01:00", "2016-12-10 00:02:00",0.5);
        promotionMysqlDataHelper.updateHotelPromotion(HotelPromotionType.SpecialTime, hotelPromotionPO);
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindWebPromotions() {
        /*
        webPromotionPOMap = promotionMysqlDataHelper.findWebPromotions();
        WebLevelPromotionPO webLevelPromotionPO = (WebLevelPromotionPO) webPromotionPOMap.get(WebPromotionType.Level);

        ArrayList<LevelPO> levelList = webLevelPromotionPO.getLevelList();
        if(levelList.size() == 0) {
            System.out.println("网站VIP会员专属促销策略不存在！");
        }else {
            for(int i = 0; i < levelList.size(); i++) {
                System.out.println(levelList.get(i).getLevel() + " " + levelList.get(i).getCredit() + " " + levelList.get(i).getDiscount());
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
        ArrayList<LevelPO> levelList = new ArrayList<LevelPO>();
        LevelPO levelPO_1 = new LevelPO(1, 1000, 0.98);
        LevelPO levelPO_2 = new LevelPO(2, 2000, 0.96);
        LevelPO levelPO_3 = new LevelPO(3, 3000, 0.94);
        LevelPO levelPO_4 = new LevelPO(4, 4000, 0.92);
        levelList.add(levelPO_1);
        levelList.add(levelPO_2);
        levelList.add(levelPO_3);
        levelList.add(levelPO_4);
        WebPromotionPO webPromotionPO = new WebLevelPromotionPO(levelList);
        promotionMysqlDataHelper.updateWebPromotion(WebPromotionType.Level, webPromotionPO);
        */
    }

} 
