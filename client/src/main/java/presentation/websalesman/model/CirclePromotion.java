package presentation.websalesman.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.WebPromotionVO.CircleVO;

/**
 * Created by 曹利航 on 2016/12/11 14:24.
 */
public class CirclePromotion {
    final private StringProperty circle;
    final private StringProperty discount;

    public CirclePromotion(CircleVO circleVO) {
        circle = new SimpleStringProperty(circleVO.getCircle());
        discount = new SimpleStringProperty(String.format("%.2f", circleVO.getDiscount()));
    }

    public CircleVO toCircleVO() {
        return new CircleVO(circle.get(), Double.valueOf(discount.get()));
    }

    public String getCircle() {
        return circle.get();
    }

    public StringProperty circleProperty() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle.set(circle);
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
