package presentation.customer.view;

import businesslogic.creditbl.Credit;
import businesslogic.promotionbl.Promotion;
import businesslogicservice.creditblservice.CreditBLservice;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private Button backButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField numCreditField;
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
    private TextField levelField;
    public void setMainAPP(presentation.customer.MainAPP mainAPP){
        this.mainAPP=mainAPP;
    }

    @FXML
    private void setNameField(){
        nameField.setEditable(false);
        nameField.setText(customerVO.getUserName());
    }

    @FXML
    private void setNumCreditField(){
        numCreditField.setEditable(false);
        double credit=creditBLservice.getNumCredit(customerVO.getUserName());
        numCreditField.setText(String.valueOf(credit));
    }

    @FXML
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
    private void setBackButton(){
        mainAPP.showHomeView(customerVO);
    }

    @FXML
    private void setLogOutButton(){
        mainAPP.showSignInView();
    }
    @FXML
    private void setLevelField(){
        PromotionBLService salePromotionBLService=new Promotion();
        int level=salePromotionBLService.calculateLevel(creditBLservice.getNumCredit(customerVO.getUserName()));
        levelField.setEditable(false);
        levelField.setText(String.valueOf(level));
    }
    @FXML
    private void initialize(){
        timeTableColumn.setCellValueFactory(cellData->cellData.getValue().timeProperty());
        orderIdTableColumn.setCellValueFactory(cellData->cellData.getValue().orderIDProperty());
        modifyTypeTableColumn.setCellValueFactory(cellData->cellData.getValue().creditChangeTypeProperty());
        creditChangeTableColumn.setCellValueFactory(cellData->cellData.getValue().creditChangeTypeProperty());
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO = customerVO;
        creditBLservice = new Credit(this.customerVO.getUserName());
    }
}
