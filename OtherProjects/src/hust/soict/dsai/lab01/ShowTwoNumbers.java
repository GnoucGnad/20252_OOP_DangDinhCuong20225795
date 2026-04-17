package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
public static void main(String[] args) {
    // Khai báo kiểu String cho 2 biến số (dạng chuỗi)
    String strNum1, strNum2; 
    
    // Khai báo kiểu String và khởi tạo giá trị cho thông báo
    String strNotification = "You've just entered: "; 

    // Bây giờ bạn có thể gán giá trị cho chúng mà không bị lỗi
    strNum1 = JOptionPane.showInputDialog(null, 
              "Please input the first number: ", "Input the first number",
              JOptionPane.INFORMATION_MESSAGE);
    strNotification += strNum1 + " and ";

    strNum2 = JOptionPane.showInputDialog(null, 
              "Please input the second number: ", "Input the second number",
              JOptionPane.INFORMATION_MESSAGE);
    strNotification += strNum2;

    JOptionPane.showMessageDialog(null, strNotification,
              "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
}
}