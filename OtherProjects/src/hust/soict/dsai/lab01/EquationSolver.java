package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog(null, 
            "Chọn loại phương trình cần giải:\n" +
            "1. Bậc nhất 1 ẩn (ax + b = 0)\n" +
            "2. Hệ bậc nhất 2 ẩn\n" +
            "3. Bậc hai 1 ẩn (ax^2 + bx + c = 0)", 
            "Equation Solver", JOptionPane.QUESTION_MESSAGE);

        switch (choice) {
            case "1": solveLinearEquation(); break;
            case "2": solveLinearSystem(); break;
            case "3": solveQuadraticEquation(); break;
            default: JOptionPane.showMessageDialog(null, "Lựa chọn không hợp lệ!");
        }
    }

   
    private static void solveLinearEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        if (a == 0) {
            JOptionPane.showMessageDialog(null, b == 0 ? "Vô số nghiệm" : "Vô nghiệm");
        } else {
            JOptionPane.showMessageDialog(null, "Nghiệm x = " + (-b / a));
        }
    }

    private static void solveLinearSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "Nghiệm: x = " + (D1 / D) + ", y = " + (D2 / D));
        } else {
            if (D1 == 0 && D2 == 0) JOptionPane.showMessageDialog(null, "Hệ vô số nghiệm");
            else JOptionPane.showMessageDialog(null, "Hệ vô nghiệm");
        }
    }

    private static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("c:"));

        if (a == 0) {
            if (b == 0) JOptionPane.showMessageDialog(null, c == 0 ? "Vô số nghiệm" : "Vô nghiệm");
            else JOptionPane.showMessageDialog(null, "x = " + (-c / b));
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "Nghiệm kép x = " + (-b / (2 * a)));
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm thực");
            }
        }
    }
}