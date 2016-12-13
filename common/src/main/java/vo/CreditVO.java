package vo;

import po.CreditInfoPO;

import java.util.Vector;

/**
 * Created by 段梦洋 on 2016/10/26.
 */
public class CreditVO extends Vector<String>{
    String userName;
    int OrderID;
    String creditChangeType;
    double change;
    String time;
    double numCredit;
    public CreditVO(CreditInfoPO creditInfoPO){
        this.userName=creditInfoPO.getUserName();
        this.OrderID=creditInfoPO.getOrderID();
        switch (creditInfoPO.getCreditChangeType()){
            case 1:
                this.creditChangeType="执行订单";
                break;
            case 2:
                this.creditChangeType="充值";
                break;
            case 3:
                this.creditChangeType="订单异常";
                break;
            case 4:
                this.creditChangeType="延迟入住成功";
                break;
            case 5:
                this.creditChangeType="线下申诉成功";
                break;
            case 6:
                this.creditChangeType="逾期撤销";
                break;
            case 0:
                this.creditChangeType="注册";
                break;
        }
        this.change=creditInfoPO.getChange();
        this.time=creditInfoPO.getTime();
        this.numCredit=creditInfoPO.getNumCredit();
    }
/***
     public CreditVO(int orderID,String creditChangeType,double change,String time,double numCredit){
        this.add(String.valueOf(orderID));
        this.add(creditChangeType);
        this.add(String.valueOf(change));
        this.add(time);
        this.add(String.valueOf(numCredit));
    }
 ***/


    public int getOrderID(){
        return this.OrderID;
    }

    public String getCreditChangeType(){
        return this.creditChangeType;
    }

    public double getChange(){
        return Double.valueOf(this.change);
    }

    public String getTime(){
        return this.time;
    }

    public double getNumCredit(){
        return this.numCredit;
    }
}
