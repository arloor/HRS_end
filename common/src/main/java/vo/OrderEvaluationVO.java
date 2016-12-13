package vo;

import po.OrderEvaluationPO;

import java.util.Vector;

/**
 * Created by 12931 on 2016/10/16.
 */

public class OrderEvaluationVO extends Vector<String> {

    /**
     * 构造函数
     * @param OrderID
     * @param pingfen
     * @param pingjia
     */
    public OrderEvaluationVO(int OrderID, double pingfen, String pingjia){
        this.add(String.valueOf(OrderID));
        this.add(String.valueOf(pingfen));
        this.add(pingjia);
    }

    public OrderEvaluationVO(OrderEvaluationPO oepo){
        int OrderID=oepo.getOrderID();
        double pingfen =oepo.getPingfen();
        String pingjia=oepo.getPingjia();

        this.add(String.valueOf(OrderID));
        this.add(String.valueOf(pingfen));
        this.add(pingjia);
    }

    public int getOrderID(){
        return Integer.parseInt(this.get(0));
    }

    public double getPingfen(){
        return Double.parseDouble(this.get(1));
    }

    public String getPingjia(){
        return this.get(2);
    }

    public void setPingfen(double pingfen){
        this.set(1,String.valueOf(pingfen));
    }

    public void setPingjia (String pingjia){
        this.set(1,String.valueOf(pingjia));
    }

    public void setEvaluation(double pingfen,String pingjia){
        setPingfen(pingfen);
        setPingjia(pingjia);
    }
}
