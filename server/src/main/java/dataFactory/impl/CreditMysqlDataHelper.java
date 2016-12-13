package dataFactory.impl;

import dataFactory.CreditDataHelper;
import po.CreditInfoPO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by njulgh on 16-12-5.
 */
public class CreditMysqlDataHelper implements CreditDataHelper {

    static String url= "jdbc:mysql://123.206.213.148:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    Connection conn;
    /**
     * 构造函数：初始化数据库连接
     */
    public CreditMysqlDataHelper(){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("mysql驱动缺失");
        }
        try {
            conn= DriverManager.getConnection(url );
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public ArrayList<CreditInfoPO> getCustomerCredits(String userName) {
        String sql="SELECT * FROM creditChange";
        ArrayList<CreditInfoPO> list=new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while( resultSet.next() ){
                String memberID=resultSet.getString(1);
                if(memberID.equals(userName)) {
                    double change = resultSet.getDouble(2);
                    String time = resultSet.getTimestamp(3).toString().substring(0,19);
                    int creditChangeType = resultSet.getInt(4);
                    int orderID = resultSet.getInt(5);
                    double numCredit = resultSet.getDouble(6);
                    CreditInfoPO cipo =new CreditInfoPO(memberID,change,time,creditChangeType,orderID,numCredit);
                    list.add(cipo);
                }
            }
            statement.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public ArrayList<CreditInfoPO> insert(CreditInfoPO cipo) {
        ArrayList<CreditInfoPO> list=new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO creditChange  VALUES (" + "'"+
                    cipo.getUserName()+"',"+
                    cipo.getChange()+",'" +
                    cipo.getTime()+ "',"+
                    cipo.getCreditChangeType()+","+
                    cipo.getOrderID()+","+
                    cipo.getNumCredit()+
                    ")"
            );

            statement.close();
            list=getCustomerCredits(cipo.getUserName());
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
