package po.WebPromotionPO;

/**
 * Created by Qin Liu on 2016/12/8.
 */

/**
 * startDate    0开始时间
 * endDate      1结束时间
 * discount     2折扣
 * @author Qin Liu
 */
public class WebSpecialTimePromotionPO extends WebPromotionPO {

    private String startDate;

    private String endDate;

    private double discount;

    public WebSpecialTimePromotionPO(String startDate, String endDate, double discount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getDiscount() {
        return discount;
    }

}
