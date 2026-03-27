package mypackage;

import javax.swing.JOptionPane;

public class Calculations{
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Nhập số thứ nhất: ", "Input number 1", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Nhập số thứ hai: ", "Input number 2", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        String result = "Tổng: " + (num1 + num2) + "\n"
                      + "Hiệu: " + (num1 - num2) + "\n"
                      + "Tích: " + (num1 * num2) + "\n";

        if (num2 != 0) {
            result += "Thương: " + (num1 / num2);
        } else {
            result += "Thương: Không thể chia cho 0";
        }

        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}