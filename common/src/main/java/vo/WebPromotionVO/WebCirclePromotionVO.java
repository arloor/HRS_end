package vo.WebPromotionVO;

import util.WebPromotionType;

import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/12/8.
 */

/**
 * circleList    0商圈及其对应折扣列表
 * @author Qin Liu
 */
public class WebCirclePromotionVO extends WebPromotionVO {

    public WebPromotionType webPromotionType = WebPromotionType.Circle;

    ArrayList<CircleVO> circleList;

    public WebCirclePromotionVO(ArrayList<CircleVO> circleList) {
        this.circleList = circleList;
    }

    public ArrayList<CircleVO> getCircleList() {
        return circleList;
    }

}
