package po;


import util.ManagerType;

import java.io.Serializable;

/**
 * Created by 曹利航 on 2016/10/16 16:47.
 */

/**
 * ManagerType      0管理人员类型
 * username         1用户名
 * password         2密码
 * phoneNumber      3手机号码
 * hotelName        4酒店名称
 * @author Qin Liu
 */
public class ManagerPO implements Serializable {

    private ManagerType managerType;
    private String username;
    private String password;
    private String phoneNumber;
    private String hotelName;

    public ManagerPO(ManagerType managerType, String username, String password, String phoneNumber, String hotelName) {
        this.managerType = managerType;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.hotelName = hotelName;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHotelName() {
        return hotelName;
    }

}
