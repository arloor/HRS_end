package util;

/**
 * Created by arloor on 2016/10/26.
 */
public enum ManagerType {

    HotelWorker,  //酒店工作人员
    WebSalesMan,  //网站营销人员
    WebManager;  //网站管理人员

    @Override
    public String toString() {
        switch(this) {
            case HotelWorker: return "酒店工作人员";
            case WebSalesMan: return "网站营销人员";
            case WebManager: return "网站管理人员";
            default: return null;
        }
    }

    public static ManagerType toManagerType(String m) {
        switch(m) {
            case "酒店工作人员": return ManagerType.HotelWorker;
            case "网站营销人员": return ManagerType.WebSalesMan;
            case "网站管理人员": return ManagerType.WebManager;
            default: return null;
        }
    }

}
