package vo.WebPromotionVO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

import util.WebPromotionType;

/**
 * startDate   0开始时间
 * endDate     1结束时间
 * discount    2折扣
 * @author Qin Liu
 */
public class WebSpecialTimePromotionVO extends WebPromotionVO {

    public WebPromotionType webPromotionType = WebPromotionType.SpecialTime;

    public WebSpecialTimePromotionVO(String startDate, String endDate, double discount) {
        this.add(startDate);
        this.add(endDate);
        this.add(String.valueOf(discount));
    }

    public String getStartDate() {
        return this.get(0);
    }

    public String getEndDate() {
        return this.get(1);
    }

    public double getDiscount() {
        return Double.parseDouble(this.get(2));
    }

}
