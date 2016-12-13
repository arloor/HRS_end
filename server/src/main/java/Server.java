import dataService.creditdataservice.CreditDataService;
import dataService.customerdataservice.CustomerDataservice;
import dataService.hoteldataservice.HotelDataService;
import dataService.managerdataservice.ManagerDataService;
import dataService.orderdataservice.OrderDataService;
import dataService.promotiondataservice.PromotionDataService;
import dataService.roomdataservice.RoomDataService;
import dataServiceImpl.*;
import util.RMIcontroller;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by njulgh on 16-12-13.
 */
public class Server {



    public static void main(String[] args){
        String hostIP= RMIcontroller.getHostIP();
        int port=RMIcontroller.getPort();
        try {
            LocateRegistry.createRegistry(port);
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {

            OrderDataService orderDao= OrderDataServiceImpl.getInstance();
            CustomerDataservice customerDao= CustomerDataServiceImpl.getInstance();
            CreditDataService creditDao= CreditDataServiceImpl.getCreditDataServiceInstance();
            HotelDataService hotelDao= HotelDataServiceImpl.getInstance();
            RoomDataService roomDao= RoomDataServiceImpl.getInstance();
            ManagerDataService managerDao = ManagerDataServiceImpl.getInstance();
            PromotionDataService promotionDao= PromotionDataServiceImpl.getInstance();


            Naming.rebind("rmi://" + hostIP + ":" + port + "/OrderDataService", orderDao);
            Naming.rebind("rmi://" + hostIP + ":" + port + "/CustomerDataservice", customerDao);
            Naming.rebind("rmi://" + hostIP + ":" + port + "/CreditDataService", creditDao);
            Naming.rebind("rmi://" + hostIP + ":" + port + "/HotelDataService", hotelDao);
            Naming.rebind("rmi://" + hostIP + ":" + port + "/RoomDataService", roomDao);
            Naming.rebind("rmi://" + hostIP + ":" + port + "/ManagerDataService", managerDao);
            Naming.rebind("rmi://" + hostIP + ":" + port + "/PromotionDataService", promotionDao);




            System.out.println("Service Start!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        AbnormalOrderProcesser abnormalOrderProcesser=new AbnormalOrderProcesser();
        abnormalOrderProcesser.start();
    }



}
