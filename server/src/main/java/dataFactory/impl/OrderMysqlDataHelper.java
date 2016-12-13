package dataFactory.impl;

import dataFactory.OrderDataHelper;
import po.OrderEvaluationPO;
import po.OrderPO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arloor on 16-11-22.
 */
public class OrderMysqlDataHelper implements OrderDataHelper {

    /*
    static String url= "jdbc:mysql://104.194.66.38:3306/hotelSystem?"
            + "user=ruangong&password=ruangong&useUnicode=true&characterEncoding=UTF8useSSL=true";
    */

    static String url= "jdbc:mysql://123.206.213.148:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    /*
    //使用本地数据库
    static String url= "jdbc:mysql://localhost:3306/hotelSystem?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=true";
            */

    Connection conn;

    /**
     * 构造函数：初始化数据库连接
     */
    public OrderMysqlDataHelper(){
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

    /**
     * 测试已通过
     * 获取订单评价列表
     * @return
     */
    @Override
    public Map<Integer, OrderEvaluationPO> getEvaluation() {
        Map<Integer, OrderEvaluationPO> map =new HashMap<Integer, OrderEvaluationPO>();
        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT orderID,pingfen,pingjia FROM orderInfo");
            //statement.close();放在这里汇报错。。。。
            while( resultSet.next() ){
                int orderID=Integer.parseInt(resultSet.getString(1));
                double pingfen=resultSet.getDouble("pingfen");
                String pingjia=resultSet.getString("pingjia");
                //只有pignfen部委0,评价部位空才加进去
                if(pingfen!=0.0&&pingjia!=null) {
                    //System.out.println(pingfen+" "+pingjia);
                    OrderEvaluationPO oepo = new OrderEvaluationPO(orderID, pingfen, pingjia);
                    map.put(orderID, oepo);
                }
            }
            statement.close();
            resultSet.close();
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试已通过
     * 获取订单列表
     * @return
     */
    @Override
    public Map<Integer, OrderPO> getOrderData() {
        Map<Integer, OrderPO> map =new HashMap<Integer, OrderPO>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM orderInfo");

            while( resultSet.next() ){
                int orderID=Integer.parseInt(resultSet.getString(1));
                String memberID=resultSet.getString(2);
                String hotel=resultSet.getString(3);
                String status=resultSet.getString(4);
                String roomID=resultSet.getString(5);
                int roomNum=resultSet.getInt(6);
                int peopleNum=resultSet.getInt(7);
                String haschild=resultSet.getString(8);
                String lastCheckinTime=resultSet.getTimestamp(9).toString().substring(0,19);
                String checkinTime;
                try {
                    checkinTime = resultSet.getTimestamp(10).toString().substring(0,19);
                }catch (NullPointerException e){
                    //System.out.println("入住时间默认为1970-01-01。。。尚未入住，入住时间为空，将checkinTime设置为空");
                    checkinTime="1970-01-01 00:00:01";
                }
                String lastCheckoutTime=resultSet.getTimestamp(11).toString().substring(0,19);
                String CheckoutTime;
                try {
                    CheckoutTime = resultSet.getTimestamp(12).toString().substring(0,19);
                    /*
                    if(CheckoutTime.equals("1970-01-01 00:00:01.0")||CheckoutTime.equals("1970-01-01 00:00:01")){
                        System.out.println("退房时间默认为1970-01-01。。。 尚未退房，退房时间为空，将checkoutTime设为空");
                        //CheckoutTime="";
                    }*/
                }catch (NullPointerException e){
                    //System.out.println("尚未退房，退房时间为空，将checkoutTime设为空");
                    CheckoutTime="1970-01-01 00:00:01";
                }
                double price=resultSet.getDouble(13);
                double charge=resultSet.getDouble(14);
                String cancelTime=resultSet.getTimestamp(15).toString().substring(0,19);
                //System.out.println(cancelTime);


                OrderPO opo=new OrderPO(orderID,memberID,hotel,status,roomID,roomNum,peopleNum,haschild,lastCheckinTime,
                                        checkinTime,lastCheckoutTime,CheckoutTime,price,charge,cancelTime);
                map.put(orderID,opo);
            }

            statement.close();
            resultSet.close();
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    @Override
    public OrderEvaluationPO getOrderEvaluationBiID(int orderID) {
        return null;
    }*/

    /**
     * 测试已通过
     * @param oepo
     * @return
     */
    @Override
    public Map<Integer, OrderEvaluationPO> updateOrderEvaluation(OrderEvaluationPO oepo) {
        Map<Integer, OrderEvaluationPO> map=new HashMap<>();
        String sql="UPDATE orderInfo " +
                "SET pingfen="+oepo.getPingfen()+",pingjia='"+oepo.getPingjia()+
                "' WHERE orderID="+oepo.getOrderID();
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            map=getEvaluation();
            statement.close();
            return map;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*@Override
    public ResultMessage insertOrderEvaluation(OrderEvaluationPO oepo) {
        return null;
    }*/

    /**
     * 测试通过
     * @param opo
     * @return
     */

    @Override
    public Map<Integer,OrderPO>  insertOrder(OrderPO opo) {
        Map<Integer,OrderPO> map=new HashMap<>();
        //String sql="";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO orderInfo (orderID,memberID,hotel,status,roomID,roomNum,peopleNum,hasChild,lastCheckinTime,lastCheckoutTime,price,charge) VALUES (" +opo.getOrderID()+",'"+
                    opo.getCustomerID()+"','" +
                    opo.getHotel() + "','"+
                    opo.getStatus()+"','"+
                    opo.getRoomID()+"',"+
                    opo.getRoomNum()+","+
                    opo.getPeopleNum()+",'"+
                    opo.getHasChild()+"','" +
                    opo.getLastCheckInTime()+"','"+
                    opo.getLastCheckoutTime()+"',"+
                    opo.getPrice()+","+
                    opo.getCharge()+
                    ")"
            );
            /*
            statement.executeUpdate("INSERT INTO orderInfo (orderID,memberID,hotel,status,roomID,roomNum,peopleNum,hasChild,lastCheckinTime,checkoutTime,price,charge,creditChange)" +
                    " VALUES ("+opo.getOrderID()+",'"+opo.getMemberID()+"','"+opo.getHotel()
                    +"','"+opo.getStatus()+"','"+opo.getRoomType()+"',"+opo.getRoomNum()+","+opo.getPeopleNum()+",'"+opo.getHaschild()+"','"
                    +opo.getLastCheckinTime()+"','"+opo.getCheckOutime()+"',"+opo.getPrice()+","+opo.getCharge()+","+opo.getCreditChange()+")");
            */
            statement.close();
            map=getOrderData();
            return map;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 撤销订单，已经测试过
     * @param OrderID
     * @return
     */
    @Override
    public Map<Integer, OrderPO> deleteOrderByID(int OrderID) {
        Map<Integer, OrderPO> map=new HashMap<>();
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time =dateFormat.format(new Date());
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE orderInfo " +
                    "SET status='已撤销',cancelTime='"+
                    time+"' "+
                    "WHERE orderID="+OrderID);
            statement.close();
            map=getOrderData();
            return map;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 测试已通过
     * @param opo
     * @return
     */
    @Override
    public Map<Integer, OrderPO> updateOrder(OrderPO opo) {
        Map<Integer, OrderPO> map=new HashMap<>();
        String sql="UPDATE orderInfo " +
                "SET lastCheckinTime='"+opo.getLastCheckInTime()+"'"+
                ",checkoutTime='"+opo.getCheckOutTime()+"'"+
                ",checkinTime='"+opo.getCheckInTime()+"'"+
                ",LastCheckoutTime='"+opo.getLastCheckoutTime()+"'"+
                ",status='"+opo.getStatus()+"'"+
                ",cancelTime='"+opo.getCancelTime()+"'"+
                " WHERE orderID="+opo.getOrderID();
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            map=getOrderData();
            statement.close();
            return map;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
