package dataFactory.impl;

import dataFactory.PromotionDataHelper;
import po.HotelPromotionPO.*;
import po.WebPromotionPO.*;
import util.HotelPromotionType;
import util.WebPromotionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/12/8.
 */
public class PromotionMysqlDataHelper implements PromotionDataHelper {

    static String url = "jdbc:mysql://123.206.213.148:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    Connection conn;

    /**
     * 构造函数：初始化数据库连接
     */
    public PromotionMysqlDataHelper() {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("mysql驱动缺失");
        }
        try {
            conn = DriverManager.getConnection(url );
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<HotelPromotionType, HotelPromotionPO> findHotelPromotions(String hotelName) {
        Map<HotelPromotionType, HotelPromotionPO> hotelPromotionPOMap = new HashMap<HotelPromotionType, HotelPromotionPO>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet;

            //得到酒店生日特惠PO，若不存在，则为null
            HotelPromotionPO hotelBirthdayPromotionPO = null;
            resultSet = statement.executeQuery("SELECT * FROM hotelBirthdayPromotion WHERE hotelName='"+hotelName+"'");
            while(resultSet.next()) {
                double birthdayDiscount = resultSet.getDouble(2);

                hotelBirthdayPromotionPO = new HotelBirthdayPromotionPO(hotelName, birthdayDiscount);
            }
            hotelPromotionPOMap.put(HotelPromotionType.Birthday, hotelBirthdayPromotionPO);

            //得到酒店合作企业客户折扣PO，若不存在，则为null
            HotelPromotionPO hotelCompanyPromotionPO = null;
            resultSet = statement.executeQuery("SELECT * FROM hotelCompanyPromotion WHERE hotelName='"+hotelName+"'");
            while(resultSet.next()) {
                double companyDiscount = resultSet.getDouble(2);

                hotelCompanyPromotionPO = new HotelCompanyPromotionPO(hotelName, companyDiscount);
            }
            hotelPromotionPOMap.put(HotelPromotionType.Company, hotelCompanyPromotionPO);

            //得到酒店多间以上预定折扣PO，若不存在，则为null
            HotelPromotionPO hotelMultiRoomsPromotionPO = null;
            resultSet = statement.executeQuery("SELECT * FROM hotelMultiRoomsPromotion WHERE hotelName='"+hotelName+"'");
            while(resultSet.next()) {
                int roomNum = resultSet.getInt(2);
                double multiRoomsDiscount = resultSet.getDouble(3);

                hotelMultiRoomsPromotionPO = new HotelMultiRoomsPromotionPO(hotelName, roomNum, multiRoomsDiscount);
            }
            hotelPromotionPOMap.put(HotelPromotionType.MultiRooms, hotelMultiRoomsPromotionPO);

            //得到酒店特定期间预定特惠PO，若不存在，则为null
            HotelPromotionPO hotelSpecialTimePromotionPO = null;
            resultSet = statement.executeQuery("SELECT * FROM hotelSpecialTimePromotion WHERE hotelName='"+hotelName+"'");
            while(resultSet.next()) {
                String startDate = resultSet.getTimestamp(2).toString().substring(0,19);
                String endDate = resultSet.getTimestamp(3).toString().substring(0,19);
                double specialTimeDiscount = resultSet.getDouble(4);

                hotelSpecialTimePromotionPO = new HotelSpecialTimePromotionPO(hotelName, startDate, endDate, specialTimeDiscount);
            }
            hotelPromotionPOMap.put(HotelPromotionType.SpecialTime, hotelSpecialTimePromotionPO);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelPromotionPOMap;
    }

    @Override
    public void updateHotelPromotion(HotelPromotionType hotelPromotionType, HotelPromotionPO hppo) {
        try {
            Statement statement = conn.createStatement();
            switch(hotelPromotionType) {
                case Birthday:
                    HotelBirthdayPromotionPO hotelBirthdayPromotionPO = (HotelBirthdayPromotionPO) hppo;
                    statement.executeUpdate("REPLACE INTO hotelBirthdayPromotion " +
                            "VALUES ('"+hotelBirthdayPromotionPO.getHotelName()+"', " +
                            "'"+hotelBirthdayPromotionPO.getDiscount()+"')");
                    statement.close();
                    break;

                case Company:
                    HotelCompanyPromotionPO hotelCompanyPromotionPO = (HotelCompanyPromotionPO) hppo;
                    statement.executeUpdate("REPLACE INTO hotelCompanyPromotion " +
                            "VALUES ('"+hotelCompanyPromotionPO.getHotelName()+"', " +
                            "'"+hotelCompanyPromotionPO.getDiscount()+"')");
                    statement.close();
                    break;

                case MultiRooms:
                    HotelMultiRoomsPromotionPO hotelMultiRoomsPromotionPO = (HotelMultiRoomsPromotionPO) hppo;
                    statement.executeUpdate("REPLACE INTO hotelMultiRoomsPromotion " +
                            "VALUES ('"+hotelMultiRoomsPromotionPO.getHotelName()+"', " +
                            "'"+hotelMultiRoomsPromotionPO.getRoomNum()+"', " +
                            "'"+hotelMultiRoomsPromotionPO.getDiscount()+"')");
                    statement.close();
                    break;

                case SpecialTime:
                    HotelSpecialTimePromotionPO hotelSpecialTimePromotionPO = (HotelSpecialTimePromotionPO) hppo;
                    statement.executeUpdate("REPLACE INTO hotelSpecialTimePromotion " +
                            "VALUES ('"+hotelSpecialTimePromotionPO.getHotelName()+"', " +
                            "'"+hotelSpecialTimePromotionPO.getStartDate()+"', " +
                            "'"+hotelSpecialTimePromotionPO.getEndDate()+"', " +
                            "'"+hotelSpecialTimePromotionPO.getDiscount()+"')");
                    statement.close();
                    break;

                default:
                    System.out.println("不存在该类型的酒店促销策略！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<WebPromotionType, WebPromotionPO> findWebPromotions() {
        Map<WebPromotionType, WebPromotionPO> webPromotionPOMap = new HashMap<WebPromotionType, WebPromotionPO>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet;

            //得到网站特定期间预订特惠PO，若不存在，则为null
            WebPromotionPO webSpecialTimePromotionPO = null;
            resultSet = statement.executeQuery("SELECT * FROM webSpecialTimePromotion WHERE type='web'");
            while(resultSet.next()) {
                String startDate = resultSet.getTimestamp(2).toString().substring(0,19);
                String endDate = resultSet.getTimestamp(3).toString().substring(0,19);
                double discount = resultSet.getDouble(4);

                webSpecialTimePromotionPO = new WebSpecialTimePromotionPO(startDate, endDate, discount);
            }
            webPromotionPOMap.put(WebPromotionType.SpecialTime, webSpecialTimePromotionPO);

            //得到网站特定商圈折扣PO，若数据表为空，则将circleList置为null
            WebPromotionPO webCirclePromotionPO = null;
            resultSet = statement.executeQuery("SELECT * FROM webCirclePromotion");
            ArrayList<CirclePO> circleList = new ArrayList<CirclePO>();
            while(resultSet.next()) {
                String businessCircle = resultSet.getString(1);
                double discount = resultSet.getDouble(2);

                CirclePO circlePO = new CirclePO(businessCircle, discount);
                circleList.add(circlePO);
            }
            webCirclePromotionPO = new WebCirclePromotionPO(circleList);
            webPromotionPOMap.put(WebPromotionType.Circle, webCirclePromotionPO);

            //得到网站VIP会员专属折扣PO，若数据表为空，则将levelList置为null
            WebPromotionPO webLevelPromotionPO = null;
            resultSet = statement.executeQuery("SELECT * FROM webLevelPromotion ORDER BY level");
            ArrayList<LevelPO> levelList = new ArrayList<LevelPO>();
            while(resultSet.next()) {
                int level = resultSet.getInt(1);
                double credit = resultSet.getDouble(2);
                double discount = resultSet.getDouble(3);

                LevelPO levelPO = new LevelPO(level, credit, discount);
                levelList.add(levelPO);
            }
            webLevelPromotionPO = new WebLevelPromotionPO(levelList);
            webPromotionPOMap.put(WebPromotionType.Level, webLevelPromotionPO);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return webPromotionPOMap;
    }

    @Override
    public void updateWebPromotion(WebPromotionType webPromotionType, WebPromotionPO wppo) {
        try {
            Statement statement = conn.createStatement();
            switch(webPromotionType) {
                case SpecialTime:
                    WebSpecialTimePromotionPO webSpecialTimePromotionPO = (WebSpecialTimePromotionPO) wppo;
                    statement.executeUpdate("REPLACE INTO webSpecialTimePromotion " +
                            "VALUES ('web', '"+webSpecialTimePromotionPO.getStartDate()+"', " +
                            "'"+webSpecialTimePromotionPO.getEndDate()+"', " +
                            "'"+webSpecialTimePromotionPO.getDiscount()+"')");
                    statement.close();
                    break;

                case Circle:
                    //清空表中原来的记录
                    statement.executeUpdate("TRUNCATE TABLE webCirclePromotion");

                    WebCirclePromotionPO webCirclePromotionPO = (WebCirclePromotionPO) wppo;
                    ArrayList<CirclePO> circleList = webCirclePromotionPO.getCircleList();
                    if(circleList.size() != 0) {
                        for(int i = 0; i < circleList.size(); i++) {
                            CirclePO circlePO = circleList.get(i);
                            statement.executeUpdate("REPLACE INTO webCirclePromotion " +
                                    "VALUES ('"+circlePO.getCircle()+"', " +
                                    "'"+circlePO.getDiscount()+"')");
                        }
                    }
                    statement.close();
                    break;

                case Level:
                    //清空表中原来的记录
                    statement.executeUpdate("TRUNCATE TABLE webLevelPromotion");

                    WebLevelPromotionPO webLevelPromotionPO = (WebLevelPromotionPO) wppo;
                    ArrayList<LevelPO> levelList = webLevelPromotionPO.getLevelList();
                    if(levelList.size() != 0) {
                        for(int i = 0; i < levelList.size(); i++) {
                            LevelPO levelPO = levelList.get(i);
                            statement.executeUpdate("REPLACE INTO webLevelPromotion " +
                                    "VALUES ('"+levelPO.getLevel()+"', " +
                                    "'"+levelPO.getCredit()+"', '"+levelPO.getDiscount()+"')");
                        }
                    }
                    statement.close();
                    break;

                default:
                    System.out.println("不存在该类型的网站促销策略！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
