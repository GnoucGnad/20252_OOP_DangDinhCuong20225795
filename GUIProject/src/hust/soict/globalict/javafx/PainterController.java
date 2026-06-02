package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadio;

    @FXML
    private RadioButton eraserRadio;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Chỉ vẽ nếu chuột nằm trong vùng Pane
        if (event.getX() >= 0 && event.getX() <= drawingAreaPane.getWidth() && 
            event.getY() >= 0 && event.getY() <= drawingAreaPane.getHeight()) {
            
            if (penRadio.isSelected()) {
                // Pen: vẽ hình tròn nhỏ màu đen
                Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
                drawingAreaPane.getChildren().add(newCircle);
            } else if (eraserRadio.isSelected()) {
                // Eraser: vẽ hình tròn lớn màu trắng
                Circle newCircle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
                drawingAreaPane.getChildren().add(newCircle);
            }
        }
    }
}
