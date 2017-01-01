package po;

import vo.OrderEvaluationVO;

import java.io.Serializable;

/**
 * Created by 曹利航 on 2016/10/16 17:17.
 */


/**
 * orderID 订单编号
 * pingfen 评分
 * pingjia 评价
 */
public class OrderEvaluationPO implements Serializable {
    private int orderID;
    private double pingfen;
    private String pingjia;

    public OrderEvaluationPO(){
        super();
    }

    public OrderEvaluationPO(int orderID,double pingfen,String pingjia){
        super();
        this.orderID=orderID;
        this.pingfen=pingfen;
        this.pingjia=pingjia;
    }

    public OrderEvaluationPO(OrderEvaluationVO oevo){
        this(oevo.getOrderID(),oevo.getPingfen(),oevo.getPingjia());
    }

    public int getOrderID() {
        return orderID;
    }

    public double getPingfen() {
        return pingfen;
    }

    public String getPingjia() {
        return pingjia;
    }
}
