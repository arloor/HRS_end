package vo.WebPromotionVO;

import java.util.Vector;

/**
 * Created by Qin Liu on 2016/12/8.
 */

/**
 * circle     0商圈
 * discount   1折扣
 * @author Qin Liu
 */
public class CircleVO extends Vector<String> {

    public CircleVO(String circle, double discount) {
        this.add(circle);
        this.add(String.valueOf(discount));
    }

    public String getCircle() {
        return this.get(0);
    }

    public double getDiscount() {
        return Double.parseDouble(this.get(1));
    }

}
