package vo.WebPromotionVO;

import util.WebPromotionType;

import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/12/8.
 */

/**
 * levelList    0等级及其对应信用值、折扣列表
 * @author Qin Liu
 */
public class WebLevelPromotionVO extends WebPromotionVO {

    public WebPromotionType webPromotionType = WebPromotionType.Level;

    ArrayList<LevelVO> levelList;

    public WebLevelPromotionVO(ArrayList<LevelVO> levelList) {
        this.levelList = levelList;
    }

    public ArrayList<LevelVO> getLevelList() {
        return levelList;
    }

}
