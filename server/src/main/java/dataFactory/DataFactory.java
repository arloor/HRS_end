package dataFactory;

/**
 * Created by arloor on 2016/10/26.
 */
public interface DataFactory {

    public OrderDataHelper getOrderDataHelper();

    public HotelDataHelper getHotelDataHelper();

    public RoomDataHelper getRoomDataHelper();

    public CustomerDatahelper getCustomerDataHelper();

    public CreditDataHelper getCreditDataHelper();
    public ManagerDataHelper getManagerDataHelper();

    public PromotionDataHelper getPromotionDataHelper();
}
