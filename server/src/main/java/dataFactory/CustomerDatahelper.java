package dataFactory;

import po.CustomerPO;
import util.ResultMessage;

/**
 * Created by njulgh on 16-12-5.
 */
public interface CustomerDatahelper {
    public ResultMessage insert(CustomerPO po);

    public ResultMessage update(CustomerPO po);

    public CustomerPO getCustomer(String userName);
}
