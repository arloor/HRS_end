package util;

/**
 * Created by njulgh on 16-12-13.
 */
public class RMIcontroller {
    static private String hostIP="127.0.0.1";//使用本地
    //static private String hostIP="123.206.213.148";//使用123.206.213.148
    static private int port=6600;

    public static String getHostIP(){
        return hostIP;
    }

    public static int getPort(){
        return port;
    }
}
