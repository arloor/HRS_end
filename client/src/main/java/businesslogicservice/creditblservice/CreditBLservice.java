package businesslogicservice.creditblservice;


import util.ResultMessage;
import vo.CreditVO;
import vo.OrderVO;

import java.util.List;

/**
 * Created by 段梦洋 on 2016/11/6.
 */
//与界面层交互的接口
public interface CreditBLservice {

    public List<CreditVO> getCustomerCreditInfo(String userName);


    public double getNumCredit(String userName);


    /**
     * 信用充值
     * @param userName
     * @param creditChange
     */
    public void increaseCredit(String userName, int creditChange);

    /**
     * 如果是重值等没有OrderVO的操作产生的信用值变化
     * 则orderVO传入NUll
     * @param userName
     * @param creditVO
     * @param orderVO
     * @return
     */
    public ResultMessage updateCustomerCreditInfo(String userName, CreditVO creditVO, OrderVO orderVO);
}
