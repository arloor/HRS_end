package util;

/**
 * Created by njulgh on 16-12-7.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Time {
    public static String  getCurrentTIme() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());
        return time;
    }
    public static long getDiffHours(String lastCheckinTime,String currentTime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date later = null;
        Date former=null;
        try {
            later= df.parse(lastCheckinTime);
            former= df.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff=(later.getTime()-former.getTime())/1000;//这个diif是以秒为单位
        long hour=diff/(60*60);
        return hour;
    }

    /**
     * 用于·判断当前时间是否晚于某个时间
     * 如果晚于某个则返回true，需要将订单置为异常
     * 主要用于判断是否需要将订单置为异常订单
     * @param someTime
     * @return
     */
    public static boolean laterThanSomeTime(String someTime){
        String now=getCurrentTIme();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date current=null;
        Date ddl=null;
        try {
            current=df.parse(now);
            ddl=df.parse(someTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(current.getTime()>ddl.getTime()){
            return true;
        }else return false;
    }

    public static ResultMessage timeComapre(String time1, String time2){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date first=null;
        Date second=null;
        try {
            first=df.parse(time1);
            second=df.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(first.getTime()>=second.getTime()){
            return ResultMessage.FIRST_LATER;
        }else return ResultMessage.SECOND_LATER;
    }
}
