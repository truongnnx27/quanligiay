/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Until;

/**
 *
 * @author XUAN TRUONG
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Calendar;

public class ChonNgaySinh {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chọn Ngày Sinh");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);

        JButton button = new JButton("Chọn ngày sinh");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame dateFrame = new JFrame("Chọn Ngày Sinh");

                // Tạo các ComboBox để chọn ngày, tháng, năm
                String[] days = new String[31];
                String[] months = new String[12];
                String[] years = new String[120];

                for (int i = 0; i < 31; i++) {
                    days[i] = String.valueOf(i + 1);
                }

                for (int i = 0; i < 12; i++) {
                    months[i] = String.valueOf(i + 1);
                }

                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                for (int i = 0; i < 120; i++) {
                    years[i] = String.valueOf(currentYear - i);
                }

                JComboBox<String> dayBox = new JComboBox<>(days);
                JComboBox<String> monthBox = new JComboBox<>(months);
                JComboBox<String> yearBox = new JComboBox<>(years);

                JButton selectButton = new JButton("Chọn");
                selectButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedDate = (String) dayBox.getSelectedItem() + "-" +
                                              (String) monthBox.getSelectedItem() + "-" +
                                              (String) yearBox.getSelectedItem();
                        textField.setText(selectedDate);
                        dateFrame.dispose();
                    }
                });

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(4, 2));
                panel.add(new JLabel("Ngày:"));
                panel.add(dayBox);
                panel.add(new JLabel("Tháng:"));
                panel.add(monthBox);
                panel.add(new JLabel("Năm:"));
                panel.add(yearBox);
                panel.add(selectButton);

                dateFrame.add(panel);
                dateFrame.pack();
                dateFrame.setLocationRelativeTo(null);
                dateFrame.setVisible(true);
            }
        });

        frame.add(button);
        frame.add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    
}


