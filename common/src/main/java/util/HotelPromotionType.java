package util;

/**
 * Created by Qin Liu on 2016/12/8.
 */
public enum HotelPromotionType {

    Birthday,   //生日特惠
    Company,    //合作企业客户折扣
    MultiRooms,    //多间客房预订折扣
    SpecialTime;    //特定期间预订折扣

    @Override
    public String toString() {
        switch(this) {
            case Birthday: return "生日特惠";
            case Company: return "合作企业客户折扣";
            case MultiRooms: return "多间客房预订折扣";
            case SpecialTime: return "酒店特定期间预订折扣";
            default: return null;
        }
    }

    public static HotelPromotionType toHotelPromotionType(String m) {
        switch(m) {
            case "生日特惠": return HotelPromotionType.Birthday;
            case "合作企业客户折扣": return HotelPromotionType.Company;
            case "多间客房预订折扣": return HotelPromotionType.MultiRooms;
            case "酒店特定期间预订折扣": return HotelPromotionType.SpecialTime;
            default: return null;
        }
    }

}
