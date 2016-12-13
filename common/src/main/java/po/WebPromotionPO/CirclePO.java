package po.WebPromotionPO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import java.io.Serializable;

/**
 * circle    0商圈
 * discount  1折扣
 * @author Qin Liu
 */
public class CirclePO implements Serializable {

    private String circle;

    private double discount;

    public CirclePO(String circle, double discount) {
        this.circle = circle;
        this.discount = discount;
    }

    public String getCircle() {
        return circle;
    }

    public double getDiscount() {
        return discount;
    }

}
