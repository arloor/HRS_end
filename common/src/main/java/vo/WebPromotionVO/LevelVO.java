package vo.WebPromotionVO;

import java.util.Vector;

/**
 * Created by Qin Liu on 2016/12/8.
 */

/**
 * level      0等级
 * credit     1信用值
 * discount   2折扣
 * @author Qin Liu
 */
public class LevelVO extends Vector<String> {

    public LevelVO(int level, double credit, double discount) {
        this.add(String.valueOf(level));
        this.add(String.valueOf(credit));
        this.add(String.valueOf(discount));
    }

    public int getLevel() {
        return Integer.parseInt(this.get(0));
    }

    public double getCredit() {
        return Double.parseDouble(this.get(1));
    }

    public double getDiscount() {
        return Double.parseDouble(this.get(2));
    }

}
