import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by njulgh on 16-11-26.
 */
public class MockOrderProcesser {
    public static int getOrderID(){
        SimpleDateFormat df = new SimpleDateFormat("ddHHmmss");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String str =df.format(now);
        str="1"+str;
        int OrderID=Integer.parseInt(str);
        return OrderID;
    }

}
