package presentation.websalesman.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import presentation.websalesman.MainApp;
import util.RecoveryType;
import vo.OrderVO;

/**
 * Created by 曹利航 on 2016/11/30 15:36.
 */
public class AbnormalOrderController {
    private MainApp mainApp;

    private Alert alert;
    private OrderVO orderVO;

    final private ToggleGroup group = new ToggleGroup();

    @FXML
    private Button confirmButton;
    @FXML
    private RadioButton halfRecoverRadioButton;
    @FXML
    private RadioButton allRecoverRadioButton;

    @FXML
    private Label orderIDLabel;
    @FXML
    private Label hotelLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label creditLabel;


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        halfRecoverRadioButton.setToggleGroup(group);
        allRecoverRadioButton.setToggleGroup(group);
    }

    public void setOrderInfo(OrderVO vo) {
        this.orderVO = vo;
        orderIDLabel.setText(Integer.toString(vo.getOrderID()));
        hotelLabel.setText(vo.getHotel());
        usernameLabel.setText(vo.getCustomerID());
        creditLabel.setText(Double.toString(vo.getPrice()));
    }

    @FXML
    public void confirmAction() {
        if (halfRecoverRadioButton.isSelected()) {
            mainApp.getOrderService().cancelAbnormalOrder(orderVO.getOrderID(), RecoveryType.HALF);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("撤销成功");
            alert.setContentText("已恢复一半信用值");
            alert.showAndWait();
        } else if (allRecoverRadioButton.isSelected()) {
            mainApp.getOrderService().cancelAbnormalOrder(orderVO.getOrderID(), RecoveryType.WHOLE);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("撤销成功");
            alert.setContentText("已恢复全部信用值");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.setContentText("请选择恢复一半或全部信用值！");
            alert.showAndWait();
        }
    }
}
