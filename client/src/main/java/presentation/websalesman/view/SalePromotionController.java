package presentation.websalesman.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import presentation.websalesman.MainApp;
import presentation.websalesman.model.CirclePromotion;
import presentation.websalesman.model.LevelPromotion;
import util.ResultMessage;
import util.WebPromotionType;
import vo.WebPromotionVO.*;

import java.util.ArrayList;

/**
 * Created by 曹利航 on 2016/12/11 13:53.
 */
public class SalePromotionController {
    private MainApp mainApp;

    Alert alert;

    private WebLevelPromotionVO webLevelPromotionVO;
    private WebCirclePromotionVO webCirclePromotionVO;
    private WebSpecialTimePromotionVO webSpecialTimePromotionVO;

    private ObservableList<LevelPromotion> levelPromotionList = FXCollections.observableArrayList();
    private ObservableList<CirclePromotion> circlePromotionList = FXCollections.observableArrayList();

    @FXML
    private TextField startDateField;
    @FXML
    private TextField endDateField;
    @FXML
    private TextField discountField;

    @FXML
    private Button specialTimeSaveButton;

    @FXML
    private Button levelAddButton;
    @FXML
    private Button levelEditButton;
    @FXML
    private Button levelDeleteButton;
    @FXML
    private Button levelSaveButton;

    @FXML
    private Button circleAddButton;
    @FXML
    private Button circleEditButton;
    @FXML
    private Button circleDeleteButton;
    @FXML
    private Button circleSaveButton;

    @FXML
    private TableView<LevelPromotion> levelTable;
    @FXML
    private TableColumn<LevelPromotion, String> levelColumn;
    @FXML
    private TableColumn<LevelPromotion, String> creditColumn;
    @FXML
    private TableColumn<LevelPromotion, String> levelDiscountColumn;

    @FXML
    private TableView<CirclePromotion> circleTable;
    @FXML
    private TableColumn<CirclePromotion, String> circleColumn;
    @FXML
    private TableColumn<CirclePromotion, String> circleDiscountColumn;


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        setTables();
    }

    @FXML
    private void initialize() {
        levelColumn.setCellValueFactory(cellData -> cellData.getValue().levelProperty());
        creditColumn.setCellValueFactory(cellData -> cellData.getValue().creditProperty());
        levelDiscountColumn.setCellValueFactory(cellData -> cellData.getValue().discountProperty());

        circleColumn.setCellValueFactory(cellData -> cellData.getValue().circleProperty());
        circleDiscountColumn.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
    }

    private void setTables() {
        setLevelTable();
        setCircleTable();
        setSpecialTimeTable();
    }

    private void setLevelTable() {
        webLevelPromotionVO = (WebLevelPromotionVO) mainApp.getPromotionService().getWebPromotion(WebPromotionType.Level);
        ArrayList<LevelVO> levelList = webLevelPromotionVO.getLevelList();
        for (int i = 0; i < levelList.size(); i++) {
            levelPromotionList.add(new LevelPromotion(levelList.get(i)));
        }
        levelTable.setItems(levelPromotionList);
    }

    private void setCircleTable() {
        webCirclePromotionVO = (WebCirclePromotionVO) mainApp.getPromotionService().getWebPromotion(WebPromotionType.Circle);
        ArrayList<CircleVO> circleList = webCirclePromotionVO.getCircleList();
        for (int i = 0; i < circleList.size(); i++) {
            circlePromotionList.add(new CirclePromotion(circleList.get(i)));
        }
        circleTable.setItems(circlePromotionList);
    }

    private void setSpecialTimeTable() {
        webSpecialTimePromotionVO = (WebSpecialTimePromotionVO) mainApp.getPromotionService().getWebPromotion(WebPromotionType.SpecialTime);
        if (webSpecialTimePromotionVO != null) {
            startDateField.setText(webSpecialTimePromotionVO.getStartDate());
            endDateField.setText(webSpecialTimePromotionVO.getEndDate());
            discountField.setText(String.format("%.2f", webSpecialTimePromotionVO.getDiscount()));
        }
    }


    @FXML
    private void specialTimeSaveAction() {
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        double discount = Double.valueOf(discountField.getText());

        if (startDateField.getText() != null && startDateField.getText().length() > 0
                && endDateField.getText() != null && endDateField.getText().length() > 0
                && discountField.getText() != null && discountField.getText().length() > 0) {
            WebSpecialTimePromotionVO webSpecialTimePromotionVO = new WebSpecialTimePromotionVO(startDate, endDate, discount);

            ResultMessage rm = mainApp.getPromotionService().updateWebPromotion(WebPromotionType.SpecialTime, webSpecialTimePromotionVO);

            if (rm.equals(ResultMessage.SUCCESS)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("成功");
                alert.setHeaderText("特定期间预订折扣更新成功");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("失败");
                alert.setHeaderText("更新特定期间预订折扣失败");
                alert.showAndWait();
            }

        } else {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("缺少输入");
            alert.setContentText("请输入完整的信息！");
            alert.showAndWait();
        }
    }

    @FXML
    private void levelAddAction() {
        LevelPromotion levelPromotion = mainApp.showLevelPromotionDialog(null);
        if (levelPromotion != null) {
            levelTable.getItems().add(levelPromotion);
        }
    }

    @FXML
    private void levelEditAction() {
        int selectedIndex = levelTable.getSelectionModel().getSelectedIndex();
        LevelPromotion selectedItem = levelTable.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) {
            mainApp.showLevelPromotionDialog(selectedItem);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.setContentText("请选中需要修改的等级！");
            alert.showAndWait();
        }
    }

    @FXML
    private void levelDeleteAction() {
        int selectedIndex = levelTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            levelTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.setContentText("请选中需要删除的等级！");
            alert.showAndWait();
        }
    }

    @FXML
    private void levelSaveAction() {
        Object[] objects = levelTable.getItems().toArray();
        ArrayList<LevelVO> levelVOList = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            levelVOList.add(((LevelPromotion) objects[i]).toLevelVO());
        }

        WebLevelPromotionVO webLevelPromotionVO = new WebLevelPromotionVO(levelVOList);

        ResultMessage rm = mainApp.getPromotionService().updateWebPromotion(WebPromotionType.Level, webLevelPromotionVO);

        if (rm.equals(ResultMessage.SUCCESS)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("VIP会员专属折扣更新成功");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("失败");
            alert.setHeaderText("更新VIP会员专属折扣失败");
            alert.showAndWait();
        }

    }

    @FXML
    private void circleAddAction() {
        CirclePromotion circlePromotion = mainApp.showCirclePromotionDialog(null);
        if (circlePromotion != null) {
            circleTable.getItems().add(circlePromotion);
        }
    }

    @FXML
    private void circleEditAction() {
        int selectedIndex = circleTable.getSelectionModel().getSelectedIndex();
        CirclePromotion selectedItem = circleTable.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) {
            mainApp.showCirclePromotionDialog(selectedItem);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.setContentText("请选中需要修改的商圈！");
            alert.showAndWait();
        }
    }

    @FXML
    private void circleDeleteAction() {
        int selectedIndex = circleTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            circleTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.setContentText("请选中需要删除的商圈！");
            alert.showAndWait();
        }
    }

    @FXML
    private void circleSaveAction() {
        Object[] objects = circleTable.getItems().toArray();
        ArrayList<CircleVO> circleVOList = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            circleVOList.add(((CirclePromotion) objects[i]).toCircleVO());
        }

        WebCirclePromotionVO webCirclePromotionVO = new WebCirclePromotionVO(circleVOList);

        ResultMessage rm = mainApp.getPromotionService().updateWebPromotion(WebPromotionType.Circle, webCirclePromotionVO);

        if (rm.equals(ResultMessage.SUCCESS)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("特定商圈折扣更新成功");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("失败");
            alert.setHeaderText("更新特定商圈折扣失败");
            alert.showAndWait();
        }

    }
}
