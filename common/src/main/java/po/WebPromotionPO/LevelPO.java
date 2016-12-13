package po.WebPromotionPO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import java.io.Serializable;

/**
 * level    0等级
 * credit   1信用值
 * discount 2折扣
 * @author Qin Liu
 */
public class LevelPO implements Serializable {

    private int level;

    private double credit;

    private double discount;

    public LevelPO(int level, double credit, double discount) {
        this.level = level;
        this.credit = credit;
        this.discount = discount;
    }

    public int getLevel() {
        return level;
    }

    public double getCredit() {
        return credit;
    }

    public double getDiscount() {
        return discount;
    }

}
