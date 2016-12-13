package dataFactory.impl;

import dataFactory.HotelDataHelper;
import po.HotelInfoPO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/11/27.
 */
public class HotelMysqlDataHelper implements HotelDataHelper {

    static String url = "jdbc:mysql://123.206.213.148:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    Connection conn;

    /**
     * 构造函数：初始化数据库连接
     */
    public HotelMysqlDataHelper(){
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
    public Map<String, HotelInfoPO> getHotelInfoData() {
        Map<String, HotelInfoPO> hotelInfoPOMap = new HashMap<String, HotelInfoPO>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hotelInfo");

            while( resultSet.next() ) {
                String hotelName = resultSet.getString(1);
                String city = resultSet.getString(2);
                String businessCircle = resultSet.getString(3);
                String address = resultSet.getString(4);
                String introduction = resultSet.getString(5);
                String facility = resultSet.getString(6);
                int starLevel = resultSet.getInt(7);
                String cooperCompany = resultSet.getString(8);
                double score = resultSet.getDouble(9);

                HotelInfoPO hipo = new HotelInfoPO(hotelName, city, businessCircle, address,
                        introduction, facility, starLevel, cooperCompany, score);
                hotelInfoPOMap.put(hotelName, hipo);
            }

            statement.close();
            resultSet.close();
            return hotelInfoPOMap;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取酒店信息失败！");
        }
        return null;
    }

    @Override
    public void updateHotelInfoData(HotelInfoPO hipo) {
        String sql = "UPDATE hotelInfo " +
                "SET address='"+hipo.getAddress()+"', " +
                "introduction='"+hipo.getIntroduction()+"', " +
                "facility='"+hipo.getFacility()+"', " +
                "cooperCompany='"+hipo.getCooperCompany()+"' " +
                "WHERE hotelName='"+hipo.getHotelName()+"'";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新酒店信息失败！");
        }
    }

    @Override
    public void insertHotel(HotelInfoPO hipo) {
        String sql = "INSERT INTO hotelInfo VALUES ('"+hipo.getHotelName()+"', '"+hipo.getCity()+"', " +
                "'"+hipo.getBusinessCircle()+"', '"+hipo.getAddress()+"', '"+hipo.getIntroduction()+"', '"+hipo.getFacility()+"', " +
                "'"+hipo.getStarLevel()+"', '"+hipo.getCooperCompany()+"', '"+hipo.getScore()+"')";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入酒店失败！");
        }
    }

    @Override
    public void updateHotelScore(String hotelName, double score) {
        String sql = "UPDATE hotelInfo " +
                "SET score='"+score+"' " +
                "WHERE hotelName='"+hotelName+"'";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新酒店评分失败！");
        }
    }

}
