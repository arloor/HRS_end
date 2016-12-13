package presentation.websalesman.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.WebPromotionVO.WebSpecialTimePromotionVO;

/**
 * Created by 曹利航 on 2016/12/11 14:28.
 */
public class SpecialTimePromotion {
    final private StringProperty start;
    final private StringProperty end;
    final private StringProperty discount;

    public SpecialTimePromotion(WebSpecialTimePromotionVO webSpecialTimePromotionVO) {
        start = new SimpleStringProperty(webSpecialTimePromotionVO.getStartDate());
        end = new SimpleStringProperty(webSpecialTimePromotionVO.getEndDate());
        discount = new SimpleStringProperty(String.format("%.2f", webSpecialTimePromotionVO.getDiscount()));
    }

    public String getStart() {
        return start.get();
    }

    public StringProperty startProperty() {
        return start;
    }

    public void setStart(String start) {
        this.start.set(start);
    }

    public String getEnd() {
        return end.get();
    }

    public StringProperty endProperty() {
        return end;
    }

    public void setEnd(String end) {
        this.end.set(end);
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
