package po.WebPromotionPO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Qin Liu on 2016/12/8.
 */

/**
 * levelList    0等级及其对应信用值、折扣列表
 * @author Qin Liu
 */
public class WebLevelPromotionPO extends WebPromotionPO implements Serializable {

    ArrayList<LevelPO> levelList;

    public WebLevelPromotionPO(ArrayList<LevelPO> levelList) {
        this.levelList = levelList;
    }

    public ArrayList<LevelPO> getLevelList() {
        return levelList;
    }

}
