package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; 

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2)); 

        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);

        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); 
        cp.add(tfOutput);

        tfInput.addActionListener(new TFInputListener());

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setVisible(true); 
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                String inputStr = tfInput.getText();
                int numberIn = Integer.parseInt(inputStr); 
                sum += numberIn;
                tfInput.setText(""); 
                tfOutput.setText(sum + "");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                    "Dữ liệu nhập vào không hợp lệ! Vui lòng chỉ nhập số nguyên.", 
                    "Lỗi nhập liệu", 
                    JOptionPane.ERROR_MESSAGE);
                tfInput.setText(""); 
            }
        }
    }
}
