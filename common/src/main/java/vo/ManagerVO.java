package vo;

import util.ManagerType;

import java.util.Vector;

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
public class ManagerVO extends Vector<String> {

    public ManagerVO(ManagerType managerType, String username, String password, String phoneNumber, String hotelName) {
        this.add(managerType.toString());
        this.add(username);
        this.add(password);
        this.add(phoneNumber);
        this.add(hotelName);
    }

    public ManagerType getManagerType() {
        return ManagerType.toManagerType(this.get(0));
    }

    public String getUsername() {
        return this.get(1);
    }

    public String getPassword() {
        return this.get(2);
    }

    public String getPhoneNumber() {
        return this.get(3);
    }

    public String getHotelName() {
        return this.get(4);
    }

    public void setPhoneNumber(String phoneNumber){
        this.set(3,phoneNumber);
    }

}
