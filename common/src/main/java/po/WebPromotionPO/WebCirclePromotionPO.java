package po.WebPromotionPO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/12/8.
 */

/**
 * circleList   0商圈及其对应折扣列表
 * @author Qin Liu
 */
public class WebCirclePromotionPO extends WebPromotionPO implements Serializable {

    ArrayList<CirclePO> circleList;

    public WebCirclePromotionPO(ArrayList<CirclePO> circleList) {
        this.circleList = circleList;
    }

    public ArrayList<CirclePO> getCircleList() {
        return circleList;
    }

}
