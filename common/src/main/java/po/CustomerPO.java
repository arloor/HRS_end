package po;


import util.CustomerType;
import vo.CustomerVO;

import java.io.Serializable;

/**
 * Created by 段梦洋 on 2016/10/16 17:11.
 */
public class CustomerPO implements Serializable {
    private String userName;
    private String password;
    private String phoneNumber;
    private String customerName;
    private CustomerType customerType;
    private String uniqueInformation;
    private String email;

    public CustomerPO(String userName, String password,
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

    public CustomerPO(CustomerVO cvo){
        String userName=cvo.getUserName();
        String password=cvo.getPassword();
        String phone=cvo.getPhoneNumber();
        String customerName=cvo.getCustomerName();
        CustomerType customerType=cvo.getCustomerType();
        String uniqueInfo=cvo.getUniqueInformation();
        String email=cvo.getEmail();

        this.userName=userName;
        this.password=password;
        this.phoneNumber=phone;
        this.customerName=customerName;
        this.customerType=customerType;
        this.uniqueInformation=uniqueInfo;
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
