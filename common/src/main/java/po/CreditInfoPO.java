package po;

import java.io.Serializable;

/**
 * Created by 段梦洋 on 2016/10/16 17:11.
 */
public class CreditInfoPO implements Serializable {
    double change;
    String time;
    int creditChangeType;
    int OrderID;
    double numCredit;
    String userName;
    public CreditInfoPO(String name,double change,String time,int type,int orderID,double numCredit){
        this.userName=name;
        this.change=change;
        this.time=time;
        this.creditChangeType=type;
        this.OrderID=orderID;
        this.numCredit=numCredit;
    }

    public String getUserName(){
        return  userName;
    }

    public void setUserName(String name){
        this.userName=name;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCreditChangeType(){
        return creditChangeType;
    }

    public void setCreditChangeType(int type) {
        this.creditChangeType = type;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public double getNumCredit(){
       return this.numCredit;
   }

    public void setNumCredit(double numCredit) {
        this.numCredit = numCredit;
    }

}
