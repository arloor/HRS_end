package util;

/**
 * Created by arloor on 2016/10/26.
 */
public enum OrderType {
    Executed,Abnormol,Canceled,Unexecuted;

    @Override
    public String toString() {
        switch (this){
            case Executed:return "已执行";
            case Abnormol:return "异常";
            case Canceled:return "已撤销";
            case Unexecuted: return "未执行";
            default:return null;
        }

    }
}
