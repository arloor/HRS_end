package util;

/**
 * Created by Qin Liu on 2016/12/8.
 */
public enum WebPromotionType {

    SpecialTime,    //网站特定期间预订折扣
    Circle,    //特定商圈折扣
    Level;    //VIP会员专属折扣

    @Override
    public String toString() {
        switch(this) {
            case SpecialTime: return "网站特定期间预订折扣";
            case Circle: return "特定商圈折扣";
            case Level: return "VIP会员专属折扣";
            default: return null;
        }
    }

    public static WebPromotionType toWebPromotionType(String m) {
        switch(m) {
            case "网站特定期间预订折扣": return WebPromotionType.SpecialTime;
            case "特定商圈折扣": return WebPromotionType.Circle;
            case "VIP会员专属折扣": return WebPromotionType.Level;
            default: return null;
        }
    }

}
