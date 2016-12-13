package dataFactory;


import po.CreditInfoPO;

import java.util.ArrayList;

/**
 * Created by njulgh on 16-12-5.
 */
public interface CreditDataHelper {
    public ArrayList<CreditInfoPO> getCustomerCredits(String userName);

    public ArrayList<CreditInfoPO> insert(CreditInfoPO cipo);
}
