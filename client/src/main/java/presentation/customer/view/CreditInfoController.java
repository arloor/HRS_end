package presentation.customer.view;

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
import vo.CreditVO;
import vo.CustomerVO;

import java.util.List;

/**
 * Created by 啊 on 2016/11/28.
 */
public class CreditInfoController {
    private presentation.customer.MainAPP mainAPP;
    private CreditBLservice creditBLservice;
    private CustomerVO customerVO;

    @FXML
    private Label numCreditField;
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
    @FXML
    private Label levelField;

    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
        initialize();
    }


    private void setNumCreditField(){
        double credit=creditBLservice.getNumCredit(customerVO.getUserName());
        numCreditField.setText(String.valueOf(credit));
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

    private void setLevelField(){
        PromotionBLService salePromotionBLService=new Promotion();
        int level=salePromotionBLService.calculateLevel(creditBLservice.getNumCredit(customerVO.getUserName()));
        levelField.setText(String.valueOf(level));
    }

    private void initialize(){
        timeTableColumn.setCellValueFactory(cellData->cellData.getValue().timeProperty());
        orderIdTableColumn.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        modifyTypeTableColumn.setCellValueFactory(cellData->cellData.getValue().creditChangeTypeProperty());
        creditChangeTableColumn.setCellValueFactory(cellData->cellData.getValue().creditChangeTypeProperty());
        setCreditInfoTable();
        setNumCreditField();
        setLevelField();
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO = customerVO;
        creditBLservice = new Credit(this.customerVO.getUserName());
    }
}
