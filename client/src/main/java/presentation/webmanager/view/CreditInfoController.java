package presentation.webmanager.view;

import businesslogic.creditbl.Credit;
import businesslogic.promotionbl.Promotion;
import businesslogicservice.creditblservice.CreditBLservice;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.customer.view.ViewCreditObjects;
import presentation.webmanager.MainAPP;
import vo.CreditVO;
import vo.CustomerVO;
import vo.ManagerVO;

import java.util.List;

/**
 * Created by 啊 on 2016/11/29.
 */
public class CreditInfoController {
    private MainAPP mainAPP;
    private ManagerVO webManagerVO;
    private CustomerVO customerVO;
    private CreditBLservice creditBLservice;

    @FXML
    private Label creditLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private TableView<ViewCreditObjects> creditInfoTable;
    @FXML
    private TableColumn<ViewCreditObjects,String> timeTableColumn;
    @FXML
    private TableColumn<ViewCreditObjects,String> orderIdTableColumn;
    @FXML
    private TableColumn<ViewCreditObjects,String> modifyTypeTableColumn;
    @FXML
    private TableColumn<ViewCreditObjects,String> creditChangeTableColumn;

    public void setWebManagerVO(ManagerVO webManagerVO){
        this.webManagerVO=webManagerVO;
    }
    public void setMainAPP(MainAPP mainAPP){
        this.mainAPP=mainAPP;
        setLevelField();
        setNumCreditField();
        setCreditInfoTable();
    }
    public void setCustomerVO(CustomerVO customerVO){
        this.customerVO=customerVO;
        creditBLservice=new Credit(customerVO.getUserName());
    }

    private void setNumCreditField(){
        double credit=creditBLservice.getNumCredit(customerVO.getUserName());
        creditLabel.setText(String.valueOf(credit));
    }
    private void setLevelField(){
        PromotionBLService salePromotionBLService=new Promotion();
        int level=salePromotionBLService.calculateLevel(creditBLservice.getNumCredit(customerVO.getUserName()));
        levelLabel.setText(String.valueOf(level));
    }
    private void setCreditInfoTable(){
        List<CreditVO> creditVOList;
        creditVOList = creditBLservice.getCustomerCreditInfo(customerVO.getUserName());
        ObservableList<ViewCreditObjects> tempViewList= FXCollections.observableArrayList();
        for (CreditVO tempCreditVO : creditVOList) {
            tempViewList.add(new ViewCreditObjects(tempCreditVO.getTime(), tempCreditVO.getOrderID(), tempCreditVO.getCreditChangeType(), tempCreditVO.getChange()));
        }
        creditInfoTable.setItems(tempViewList);
    }
    @FXML
    private void back(){
        mainAPP.showCustomerInfoView(webManagerVO);
    }
    @FXML
    private void initialize(){
        timeTableColumn.setCellValueFactory(cellData->cellData.getValue().timeProperty());
        orderIdTableColumn.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        modifyTypeTableColumn.setCellValueFactory(cellData->cellData.getValue().creditChangeTypeProperty());
        creditChangeTableColumn.setCellValueFactory(cellData->cellData.getValue().creditChangeTypeProperty());
    }

}
