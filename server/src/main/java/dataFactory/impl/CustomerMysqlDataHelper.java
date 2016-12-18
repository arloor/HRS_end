package dataFactory.impl;

import dataFactory.CustomerDatahelper;
import po.CustomerPO;
import util.CustomerType;
import util.ResultMessage;

import java.sql.*;

/**
 * Created by njulgh on 16-12-5.
 */
public class CustomerMysqlDataHelper implements CustomerDatahelper{
    DeEnCode deEnCode=new DeEnCode();
    static String url= "jdbc:mysql://123.206.213.148:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    Connection conn;

    public CustomerMysqlDataHelper(){
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
    public ResultMessage insert(CustomerPO po) {

        String username=po.getUserName();
        String password=deEnCode.encode(po.getPassword());
        String phone=po.getPhoneNumber();
        String customerName=po.getCustomerName();
        String type=po.getCustomerType().toString();
        String uniqueInformation=po.getUniqueInformation();
        String email=po.getEmail();


        //如果用户名已经存在则ResultMessage.USER_EXIST;
        CustomerPO cpo=getCustomer(po.getUserName());
        if(cpo!=null){
            return ResultMessage.USER_EXIST;
        }

        try {
            Statement statement=conn.createStatement();
            statement.execute("INSERT INTO member VALUES ("+"'"+
                    username+"','"+
                    password+"','"+
                    phone+"','"+
                    type+"','"+
                    customerName+"','"+
                    uniqueInformation+"','"+
                    email+"'"+
                    ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //return ResultMessage.USER_EXIST;
        }
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage update(CustomerPO po) {
        String sql="UPDATE member " +
                "SET " +
                "password='"+deEnCode.encode(po.getPassword())+
                "',phone='"+po.getPhoneNumber()+
                "',customerName='"+po.getCustomerName()+
                "',uniqueInfo='"+po.getUniqueInformation()+
                "',email='"+po.getEmail()+
                "' WHERE userName='"+po.getUserName()+"'";
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultMessage.SUCCESS;

    }

    @Override
    public CustomerPO getCustomer(String userName) {
        CustomerPO cpo;
        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM member WHERE userName='"+userName+"'");
            if(resultSet.next()){
                String password=deEnCode.decode(resultSet.getString(2));
                String phone=resultSet.getString(3);
                String type=resultSet.getString(4);
                CustomerType customerType;
                if(type.equals("personal")){
                    customerType= CustomerType.PERSONAL;
                }else customerType= CustomerType.COMPANY;

                String customerName=resultSet.getString(5);
                String uniqueInfo=resultSet.getString(6);
                //double creditNum=resultSet.getDouble(7);
                String email=resultSet.getString(7);
                cpo=new CustomerPO(userName,password,phone,customerName,customerType,uniqueInfo,email);
            }else cpo=null;
            statement.close();
            return cpo;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
