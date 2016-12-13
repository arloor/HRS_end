package dataFactory.impl;

import dataFactory.RoomDataHelper;
import po.AvailableRoomPO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/12/1.
 */
public class RoomMysqlDataHelper implements RoomDataHelper{

    static String url = "jdbc:mysql://123.206.213.148:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    Connection conn;

    /**
     * 构造函数：初始化数据库连接
     */
    public RoomMysqlDataHelper(){
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
    public Map<String, AvailableRoomPO> getAvailableRoomData(String hotelName) {
        Map<String, AvailableRoomPO> availableRoomPOMap = new HashMap<String, AvailableRoomPO>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM room WHERE hotelName='"+hotelName+"'");

            while( resultSet.next() ) {
                String temphotelName = resultSet.getString(1);
                String roomType = resultSet.getString(2);
                int roomNum = resultSet.getInt(3);
                double price = resultSet.getDouble(4);

                AvailableRoomPO arpo = new AvailableRoomPO(temphotelName, roomType, roomNum, price);
                availableRoomPOMap.put(roomType, arpo);
            }

            statement.close();
            resultSet.close();
            return availableRoomPOMap;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取可用客房列表失败！");
        }
        return null;
    }

    @Override
    public void updateAvailableRoomData(AvailableRoomPO arpo) {
        AvailableRoomPO newArpo = null;
        //获取之前的客房数量
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM room " +
                    "WHERE hotelName='"+arpo.getHotelName()+"' " +
                    "AND roomType='"+arpo.getRoomType()+"'");

            while( resultSet.next() ) {
                String hotelName = resultSet.getString(1);
                String roomType = resultSet.getString(2);
                int roomNum = resultSet.getInt(3);
                double price = resultSet.getDouble(4);

                newArpo = new AvailableRoomPO(hotelName, roomType, roomNum, price);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //计算更新后的客房数量
        int roomNum = newArpo.getRoomNum() + arpo.getRoomNum();

        //如果客房数量小于等于0，在数据表中删除这条记录；否则，执行更新操作
        String sql = null;
        if(roomNum <= 0) {
            sql = "DELETE FROM room " +
                    "WHERE hotelName='"+arpo.getHotelName()+"' " +
                    "AND roomType='"+arpo.getRoomType()+"'";
        }else {
            sql = "UPDATE room " +
                    "SET roomNum='"+roomNum+"' " +
                    "WHERE hotelName='"+arpo.getHotelName()+"' " +
                    "AND roomType='"+arpo.getRoomType()+"'";
        }

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新可用客房信息失败！");
        }
    }

    @Override
    public void insertAvailableRoom(AvailableRoomPO arpo) {
        String sql = "INSERT INTO room VALUES ('"+arpo.getHotelName()+"', '"+arpo.getRoomType()+"', '"+arpo.getRoomNum()+"', " +
                "'"+arpo.getPrice()+"')";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入可用客房失败！");
        }
    }

}
