package dataFactory.impl;

import dataFactory.*;

/**
 * Created by arloor on 16-11-22.
 */
public class DataFactoryImpl implements DataFactory {

    @Override
    public OrderDataHelper getOrderDataHelper() {
        OrderDataHelper orderDao = new OrderMysqlDataHelper();
        return orderDao;
    }

    @Override
    public HotelDataHelper getHotelDataHelper() {
        HotelDataHelper hotelDao = new HotelMysqlDataHelper();
        return hotelDao;
    }

    @Override
    public RoomDataHelper getRoomDataHelper() {
        RoomDataHelper roomDao = new RoomMysqlDataHelper();
        return roomDao;
    }

    @Override
    public CustomerDatahelper getCustomerDataHelper() {
        CustomerDatahelper customerDao = new CustomerMysqlDataHelper();
        return customerDao;
    }

    @Override
    public CreditDataHelper getCreditDataHelper() {
        CreditDataHelper creditDao = new CreditMysqlDataHelper();
        return creditDao;
    }

    @Override
    public ManagerDataHelper getManagerDataHelper() {
        ManagerDataHelper managerDao = new ManagerMysqlDataHelper();
        return managerDao;
    }

    @Override
    public PromotionDataHelper getPromotionDataHelper() {
        PromotionDataHelper promotionDao = new PromotionMysqlDataHelper();
        return  promotionDao;
    }

}
