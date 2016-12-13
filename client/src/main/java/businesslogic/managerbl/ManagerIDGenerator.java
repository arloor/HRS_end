package businesslogic.managerbl;


import util.ManagerType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 曹利航 on 2016/12/06 17:08.
 */
public class ManagerIDGenerator {
    public static long generateManagerID(ManagerType type) {
        long managerID = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String tempStr;

        switch (type) {
            case HotelWorker:
                tempStr = df.format(new Date());
                tempStr = "1" + tempStr;
                managerID = Long.valueOf(tempStr);
                break;
            case WebManager:
                tempStr = df.format(new Date());
                tempStr = "2" + tempStr;
                managerID = Long.valueOf(tempStr);
                break;
            case WebSalesMan:
                tempStr = df.format(new Date());
                tempStr = "3" + tempStr;
                managerID = Long.valueOf(tempStr);
                break;
        }

        return managerID;
    }
}
