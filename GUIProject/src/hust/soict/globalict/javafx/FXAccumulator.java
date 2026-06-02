package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Tương tự SwingAccumulator nhưng viết bằng JavaFX + FXML.
 * - Nhập số nguyên, cộng dồn và hiển thị tổng.
 * - Bắt NumberFormatException và hiển thị Alert lỗi nếu nhập sai kiểu.
 */
public class FXAccumulator extends Application {

    // --- Các thành phần FXML (Controller) ---

    @FXML
    private TextField tfInput;

    @FXML
    private TextField tfOutput;

    private int sum = 0;

    // --- Phần khởi chạy Application ---

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML từ cùng package
        Parent root = FXMLLoader.load(getClass().getResource("FXAccumulator.fxml"));

        primaryStage.setTitle("FX Accumulator");
        primaryStage.setScene(new Scene(root, 380, 120));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // --- Phần xử lý sự kiện (Controller) ---

    /**
     * Xử lý sự kiện khi người dùng nhấn Enter trong ô nhập.
     * Tính tổng tích lũy, bắt lỗi NumberFormatException.
     */
    @FXML
    private void handleInput() {
        try {
            String inputStr = tfInput.getText();
            int numberIn = Integer.parseInt(inputStr);
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(String.valueOf(sum));
        } catch (NumberFormatException e) {
            // Hiển thị hộp thoại lỗi bằng JavaFX Alert
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi nhập liệu");
            alert.setHeaderText(null);
            alert.setContentText("Dữ liệu nhập vào không hợp lệ! Vui lòng chỉ nhập số nguyên.");
            alert.showAndWait();
            tfInput.setText("");
        }
    }
}
