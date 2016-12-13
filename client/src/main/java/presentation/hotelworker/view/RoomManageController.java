package presentation.hotelworker.view;

import businesslogicservice.roomblservice.RoomBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.hotelworker.MainApp;
import presentation.hotelworker.model.AvailableRoom;
import util.ResultMessage;
import util.RoomType;
import vo.AvailableRoomVO;

import java.util.ArrayList;

/**
 * Created by 曹利航 on 2016/12/08 19:08.
 */
public class RoomManageController {
    private MainApp mainApp;
    private Alert alert;
    private ObservableList<AvailableRoom> availableRoomList = FXCollections.observableArrayList();
    private RoomBLService roomBLService;

    @FXML
    private TableView<AvailableRoom> availableRoomTable;
    @FXML
    private TableColumn<AvailableRoom, String> typeColumn;
    @FXML
    private TableColumn<AvailableRoom, String> priceColumn;
    @FXML
    private TableColumn<AvailableRoom, String> numColumn;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        roomBLService = mainApp.getRoomService();
        ArrayList<AvailableRoomVO> tempList = roomBLService.getAvailableRoomList(mainApp.getHotelName(), null, null);

        for (int i = 0; i < tempList.size(); i++) {
            availableRoomList.add(new AvailableRoom(tempList.get(i)));
        }

        availableRoomTable.setItems(availableRoomList);
    }

    @FXML
    private void initialize() {
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        numColumn.setCellValueFactory(cellData -> cellData.getValue().numProperty());

    }

    @FXML
    private void editAction() {
        AvailableRoom selectedRoom = availableRoomTable.getSelectionModel().getSelectedItem();
        int selectedIndex = availableRoomTable.getSelectionModel().getSelectedIndex();

        String info = null;
        if (selectedIndex >= 0) {
            info = mainApp.showRoomNumEditDialog();
        } else {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("未选中");
            alert.showAndWait();
            return;
        }
        boolean isIncrease = false;
        int num = Integer.valueOf(info.split(" ")[1]);
        if (info.split(" ")[0].equals("增加数量")) {
            isIncrease = true;
        }

        AvailableRoomVO availableRoomVO = new AvailableRoomVO(mainApp.getHotelName(), selectedRoom.getType(), num, -1);

        if (isIncrease) {
            ResultMessage rm;
            rm = roomBLService.addAvailableRooms(availableRoomVO);
            switch (rm) {
                case SUCCESS:
                    selectedRoom.setNum(Integer.toString(Integer.valueOf(selectedRoom.getNum()) + num));
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("成功");
                    alert.setHeaderText("已修改房间数量");
                    alert.showAndWait();
                    break;
                case FAILED:
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("失败");
                    alert.setHeaderText("修改房间数量失败");
                    alert.showAndWait();
                    break;
            }
        } else {
            ResultMessage rm;

            if (Integer.valueOf(selectedRoom.getNum()) > num) {
                rm = roomBLService.deleteAvailableRooms(availableRoomVO);
                switch (rm) {
                    case SUCCESS:
                        selectedRoom.setNum(Integer.toString(Integer.valueOf(selectedRoom.getNum()) - num));
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("成功");
                        alert.setHeaderText("已修改房间数量");
                        alert.showAndWait();
                        break;
                    case FAILED:
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("失败");
                        alert.setHeaderText("修改房间数量失败");
                        alert.showAndWait();
                        break;
                }

            } else if (Integer.valueOf(selectedRoom.getNum()) == num) {
                rm = roomBLService.deleteAvailableRooms(availableRoomVO);
                switch (rm) {
                    case SUCCESS:
                        availableRoomList.remove(selectedIndex);
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("成功");
                        alert.setHeaderText("已删除该房间类型");
                        alert.showAndWait();
                        break;
                    case FAILED:
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("失败");
                        alert.setHeaderText("修改房间数量失败");
                        alert.showAndWait();
                        break;
                }
            } else {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告");
                alert.setHeaderText("请检查房间数量！");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void insertAction() {
        AvailableRoomVO availableRoomVO = null;
        if (availableRoomList.size() < RoomType.values().length) {
            availableRoomVO = mainApp.showNewRoomTypeDialog();
        }
        if (availableRoomVO != null) {
            ResultMessage rm = roomBLService.addAvailableRooms(availableRoomVO);
            switch (rm) {
                case SUCCESS:
                    availableRoomList.add(new AvailableRoom(availableRoomVO));
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("成功");
                    alert.setHeaderText("已成功添加房间类型");
                    alert.showAndWait();
                    break;
                case FAILED:
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("失败");
                    alert.setHeaderText("增加房间类型失败");
                    alert.showAndWait();
                    break;
            }
        } else {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("所有房间类型均已存在");
            alert.showAndWait();
        }
    }
}
