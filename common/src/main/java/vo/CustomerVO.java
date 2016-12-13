package vo;

import po.CustomerPO;
import util.CustomerType;

/**
 * Created by 段梦洋 on 2016/10/16 17:11.
 */
public class CustomerVO {
    private String userName;
    private String password;
    private String phoneNumber;
    private String customerName;
    private CustomerType customerType;
    private String uniqueInformation;
    private String email;


    public CustomerVO(CustomerPO po){
        super();
        this.userName=po.getUserName();
        this.password=po.getPassword();
        this.phoneNumber=po.getPhoneNumber();
        this.customerName=po.getCustomerName();
        this.customerType=po.getCustomerType();
        this.uniqueInformation=po.getUniqueInformation();
    }

    public CustomerVO(String userName, String password,
                       String phoneNumber, String customerName,
                       CustomerType customerType, String informaition,String email){
        this.userName=userName;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.customerName=customerName;
        this.customerType=customerType;
        this.uniqueInformation=informaition;
        this.email=email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getUniqueInformation() {
        return uniqueInformation;
    }

    public void setUniqueInformation(String uniqueInformation) {
        this.uniqueInformation = uniqueInformation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
