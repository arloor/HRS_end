package presentation.hotelworker.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.hotelworker.MainApp;
import vo.HotelPromotionVO.HotelBirthdayPromotionVO;
import vo.HotelPromotionVO.HotelCompanyPromotionVO;
import vo.HotelPromotionVO.HotelMultiRoomsPromotionVO;
import vo.HotelPromotionVO.HotelSpecialTimePromotionVO;

/**
 * Created by 曹利航 on 2016/12/06 20:09.
 */
public class SalePromotionController {
    private MainApp mainApp;

    @FXML
    private TextField companyDiscountField;
    @FXML
    private TextField birthdayDiscountField;
    @FXML
    private TextField multiRoomsDiscountField;
    @FXML
    private TextField holidayDiscountField;
    @FXML
    private TextField multiRoomsMinimumField;
    @FXML
    private TextField startDateField;
    @FXML
    private TextField endDateField;

    @FXML
    private Button confirmButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setSalePromotions(HotelBirthdayPromotionVO hotelBirthdayPromotionVO, HotelCompanyPromotionVO hotelCompanyPromotionVO, HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO, HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO) {

        if (hotelBirthdayPromotionVO != null) {
            birthdayDiscountField.setText(Double.toString(hotelBirthdayPromotionVO.getDiscount()));
        }

        if (hotelCompanyPromotionVO != null) {
            companyDiscountField.setText(Double.toString(hotelCompanyPromotionVO.getDiscount()));
        }

        if (hotelMultiRoomsPromotionVO != null) {
            multiRoomsMinimumField.setText(Integer.toString(hotelMultiRoomsPromotionVO.getRoomNum()));
            multiRoomsDiscountField.setText(Double.toString(hotelMultiRoomsPromotionVO.getDiscount()));
        }

        if (hotelSpecialTimePromotionVO != null) {
            startDateField.setText(hotelSpecialTimePromotionVO.getStartDate());
            endDateField.setText(hotelSpecialTimePromotionVO.getEndDate());
            holidayDiscountField.setText(Double.toString(hotelSpecialTimePromotionVO.getDiscount()));
        }
    }

    @FXML
    private void confirmAction() {
        HotelBirthdayPromotionVO hotelBirthdayPromotionVO = null;
        if (birthdayDiscountField.getText() != null && birthdayDiscountField.getText().length() != 0) { // 检查输入
            hotelBirthdayPromotionVO = new HotelBirthdayPromotionVO(mainApp.getHotelName(), Double.valueOf(birthdayDiscountField.getText()));
        }

        HotelCompanyPromotionVO hotelCompanyPromotionVO = null;
        if (companyDiscountField.getText() != null && companyDiscountField.getText().length() != 0) { // 检查输入
            hotelCompanyPromotionVO = new HotelCompanyPromotionVO(mainApp.getHotelName(), Double.valueOf(companyDiscountField.getText()));
        }

        HotelMultiRoomsPromotionVO hotelMultiRoomsPromotionVO = null;
        if (multiRoomsDiscountField.getText() != null && multiRoomsDiscountField.getText().length() != 0
                && multiRoomsMinimumField.getText() != null && multiRoomsMinimumField.getText().length() != 0) { // 检查输入
            hotelMultiRoomsPromotionVO = new HotelMultiRoomsPromotionVO(mainApp.getHotelName(), Integer.valueOf(multiRoomsMinimumField.getText()), Double.valueOf(multiRoomsDiscountField.getText()));
        }

        HotelSpecialTimePromotionVO hotelSpecialTimePromotionVO = null;
        if (holidayDiscountField.getText() != null && holidayDiscountField.getText().length() != 0
                && startDateField.getText() != null && startDateField.getText().length() != 0
                && endDateField.getText() != null && endDateField.getText().length() != 0) { // 检查输入
            hotelSpecialTimePromotionVO = new HotelSpecialTimePromotionVO(mainApp.getHotelName(), startDateField.getText(), endDateField.getText(), Double.valueOf(holidayDiscountField.getText()));
        }

        mainApp.updateHotelPromotions(hotelBirthdayPromotionVO, hotelCompanyPromotionVO, hotelMultiRoomsPromotionVO, hotelSpecialTimePromotionVO);
    }
}
