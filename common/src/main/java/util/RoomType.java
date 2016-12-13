package util;

/**
 * Created by Qin Liu on 2016/11/18.
 */

public enum RoomType {

    SINGLE, //单人间
    STANDARD, //标准间
    QUEUE, // 大床房
    DELUXE, //豪华间
    BUSINESS;  //商务间

    @Override
    public String toString() {
        switch(this) {
            case SINGLE: return "单人间";
            case STANDARD: return "标准间";
            case QUEUE: return "大床房";
            case DELUXE: return "豪华间";
            case BUSINESS: return "商务间";
            default: return null;
        }
    }

}
