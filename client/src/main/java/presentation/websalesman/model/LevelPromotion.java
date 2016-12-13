package presentation.websalesman.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.WebPromotionVO.LevelVO;

/**
 * Created by 曹利航 on 2016/12/11 14:14.
 */
public class LevelPromotion {
    final private StringProperty level;
    final private StringProperty credit;
    final private StringProperty discount;

    public LevelPromotion(LevelVO levelVO) {
        level = new SimpleStringProperty(String.format("%02d", levelVO.getLevel()));
        credit = new SimpleStringProperty(String.format("%.2f", levelVO.getCredit()));
        discount = new SimpleStringProperty(String.format("%.2f", levelVO.getDiscount()));
    }

    public LevelVO toLevelVO() {
        return new LevelVO(Integer.valueOf(level.get()), Double.valueOf(credit.get()), Double.valueOf(discount.get()));
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public String getCredit() {
        return credit.get();
    }

    public StringProperty creditProperty() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit.set(credit);
    }

    public String getDiscount() {
        return discount.get();
    }

    public StringProperty discountProperty() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }
}
