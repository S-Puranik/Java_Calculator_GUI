package calculator.ui;
import calculator.core.StandardCalculator;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font; //for styling

public class CalculatorUI extends JFrame {

    public CalculatorUI() {
        StandardCalculator calc = new StandardCalculator();
        setTitle("Smart Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add Tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel standardPanel = new JPanel();
        standardPanel.setLayout(null);

        // Display field
        JTextField display = new JTextField();
        display.setBounds(20, 20, 340, 40);
        standardPanel.add(display);
        display.setFont(new Font("Segoe UI", Font.BOLD, 22));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Buttons
        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "C"
        };

        int x = 20, y = 80;

        for (int i = 0; i < buttons.length; i++) {
            String text = buttons[i];
            JButton btn = new JButton(text);
            btn.setBounds(x, y, 70, 50);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(200, 200, 200));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (text.matches("[+\\-*/=]")) {
                    btn.setBackground(new Color(220, 220, 220));
                } else {
                    btn.setBackground(Color.WHITE);
                }
            }
        });
        btn.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));

            btn.addActionListener(e -> {
                try {
                    if (text.matches("[0-9.]")) {
                        display.setText(display.getText() + text);
                    } 
                    else if (text.matches("[+\\-*/]")) {
                        calc.setFirstNumber(Double.parseDouble(display.getText()));
                        calc.setOperator(text);
                        display.setText("");
                    } 
                    else if (text.equals("=")) {
                        double result = calc.calculate(Double.parseDouble(display.getText()));
                        display.setText(String.valueOf(result));
                    }
                    else if (text.equals("C")) {
                    display.setText("");
                    }
                    else if (text.matches("[+\\-*/]")) { //executes on an empty input
                        if (display.getText().isEmpty()) return;//when the user doesnt enter anything

                        calc.setFirstNumber(Double.parseDouble(display.getText())); // but operators are present
                        calc.setOperator(text);
                        display.setText("");
                    }
                    else if (text.equals("=")) { //when = is clicked without input
                        if (display.getText().isEmpty()) return;

                        double result = calc.calculate(Double.parseDouble(display.getText()));
                        display.setText(String.valueOf(result));
                    }
                } catch (Exception ex) {
                    display.setText("Error");
                }
            });
            

            standardPanel.add(btn);

            x += 80;
            if ((i + 1) % 4 == 0) {
                x = 20;
                y += 60;
            }
        }

        //clear btn logic
        JButton clearBtn = new JButton("C");
        clearBtn.setBounds(20, y, 320, 50);
        standardPanel.add(clearBtn);
        clearBtn.addActionListener(e -> {
            display.setText("");
        });

        tabbedPane.add("Standard", standardPanel);

        // end of standart panel
