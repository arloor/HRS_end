package dataFactory.impl;

import dataFactory.ManagerDataHelper;
import po.ManagerPO;
import util.ManagerType;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qin Liu on 2016/12/7.
 */
public class ManagerMysqlDataHelper implements ManagerDataHelper {

    static String url = "jdbc:mysql://123.206.213.148:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    Connection conn;

    /**
     * 构造函数：初始化数据库连接
     */
    public ManagerMysqlDataHelper(){
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
    public Map<String, ManagerPO> findManagerInfo(ManagerType managerType) {
        Map<String, ManagerPO> managerPOMap = new HashMap<String, ManagerPO>();
        DeEnCode deEnCode = new DeEnCode();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            switch(managerType) {
                case HotelWorker:
                    resultSet = statement.executeQuery("SELECT * FROM hotelWorker");
                    while(resultSet.next()) {
                        String hotelName = resultSet.getString(1);
                        String username = deEnCode.decode(resultSet.getString(2));
                        String password = deEnCode.decode(resultSet.getString(3));
                        String phoneNumber = resultSet.getString(4);

                        ManagerPO mpo = new ManagerPO(ManagerType.HotelWorker, username, password, phoneNumber, hotelName);
                        managerPOMap.put(username, mpo);
                    }
                    statement.close();
                    resultSet.close();
                    return managerPOMap;

                case WebSalesMan:
                    resultSet = statement.executeQuery("SELECT * FROM webSalesMan");
                    while(resultSet.next()) {
                        String username = deEnCode.decode(resultSet.getString(1));
                        String password = deEnCode.decode(resultSet.getString(2));
                        String phoneNumber = resultSet.getString(3);

                        ManagerPO mpo = new ManagerPO(ManagerType.WebSalesMan, username, password, phoneNumber, null);
                        managerPOMap.put(username, mpo);
                    }
                    statement.close();
                    resultSet.close();
                    return managerPOMap;

                case WebManager:
                    resultSet = statement.executeQuery("SELECT * FROM webManager");
                    while(resultSet.next()) {
                        String username = deEnCode.decode(resultSet.getString(1));
                        String password = deEnCode.decode(resultSet.getString(2));
                        String phoneNumber = resultSet.getString(3);

                        ManagerPO mpo = new ManagerPO(ManagerType.WebManager, username, password, phoneNumber, null);
                        managerPOMap.put(username, mpo);
                    }
                    statement.close();
                    resultSet.close();
                    return managerPOMap;

                default:
                    System.out.println("无当前类型管理人员！");
                    return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("管理人员不存在！");
        }
        return null;
    }

    @Override
    public void updateManagerInfo(ManagerPO mpo) {
        DeEnCode deEnCode = new DeEnCode();
        try {
            Statement statement = conn.createStatement();
            switch(mpo.getManagerType()) {
                case HotelWorker:
                    statement.executeUpdate("UPDATE hotelWorker " +
                            "SET password='"+deEnCode.encode(mpo.getPassword())+"', " +
                            "phoneNumber='"+mpo.getPhoneNumber()+"' " +
                            "WHERE username='"+deEnCode.encode(mpo.getUsername())+"'");
                    statement.close();
                    break;

                case WebSalesMan:
                    statement.executeUpdate("UPDATE webSalesMan " +
                            "SET password='"+deEnCode.encode(mpo.getPassword())+"', " +
                            "phoneNumber='"+mpo.getPhoneNumber()+"' " +
                            "WHERE username='"+deEnCode.encode(mpo.getUsername())+"'");
                    statement.close();
                    break;

                default:
                    System.out.println("无法修改当前类型管理人员！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("管理人员不存在！");
        }
    }

    @Override
    public void insertManager(ManagerPO mpo) {
        DeEnCode deEnCode = new DeEnCode();
        try {
            Statement statement = conn.createStatement();
            switch(mpo.getManagerType()) {
                case HotelWorker:
                    statement.executeUpdate("INSERT INTO hotelWorker " +
                            "VALUES ('"+mpo.getHotelName()+"', " +
                            "'"+deEnCode.encode(mpo.getUsername())+"', " +
                            "'"+deEnCode.encode(mpo.getPassword())+"', " +
                            "'"+mpo.getPhoneNumber()+"')");
                    statement.close();
                    break;

                case WebSalesMan:
                    statement.executeUpdate("INSERT INTO webSalesMan " +
                            "VALUES ('"+deEnCode.encode(mpo.getUsername())+"', " +
                            "'"+deEnCode.encode(mpo.getPassword())+"', " +
                            "'"+mpo.getPhoneNumber()+"')");
                    statement.close();
                    break;

                default:
                    System.out.println("无法添加当前类型管理人员！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("管理人员不存在！");
        }
    }

}
