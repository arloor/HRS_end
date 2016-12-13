import dataFactory.DataFactory;
import dataFactory.PromotionDataHelper;
import dataServiceImpl.PromotionDataServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* PromotionDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 9, 2016</pre> 
* @version 1.0 
*/ 
public class PromotionDataServiceImplTest {

    private static PromotionDataServiceImpl promotionDao;

    private DataFactory dataFactory;

    private PromotionDataHelper promotionDataHelper;

    @Before
    public void setUp() throws Exception {
        promotionDao = PromotionDataServiceImpl.getInstance();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试已通过
     */
    @Test
    public void testFindHotelPromotion() {
        /*
        HotelSpecialTimePromotionPO hotelSpecialTimePromotionPO = (HotelSpecialTimePromotionPO) promotionDao.findHotelPromotion(HotelPromotionType.SpecialTime, "汉庭酒店");
        if(hotelSpecialTimePromotionPO == null) {
            System.out.println("酒店促销策略不存在！");
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
        HotelPromotionPO hotelPromotionPO = new HotelSpecialTimePromotionPO("如家酒店", "2016-12-07 00:00:00", "2016-12-08 01:00:00", 0.95);
        boolean result = promotionDao.updateHotelPromotion(HotelPromotionType.SpecialTime, hotelPromotionPO);
        System.out.println(result);
        */
    }

    /**
     * 测试已通过
     */
    @Test
    public void  testFindWebPromotion() {
        /*
        promotionDao = new PromotionDataServiceImpl();
        WebLevelPromotionPO webLevelPromotionPO = (WebLevelPromotionPO) promotionDao.findWebPromotion(WebPromotionType.Level);
        if(webLevelPromotionPO == null) {
            System.out.println("网站促销策略不存在！");
        }else {
            ArrayList<LevelPO> levelList = webLevelPromotionPO.getLevelList();
            System.out.println(levelList.size());
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
        LevelPO levelPO_1 = new LevelPO(1, 500, 0.88);
        LevelPO levelPO_2 = new LevelPO(2, 1000, 0.81);
        levelList.add(levelPO_1);
        levelList.add(levelPO_2);
        WebPromotionPO webPromotionPO = new WebLevelPromotionPO(levelList);
        boolean result = promotionDao.updateWebPromotion(WebPromotionType.Level, webPromotionPO);
        System.out.println(result);
        */
    }

} 
