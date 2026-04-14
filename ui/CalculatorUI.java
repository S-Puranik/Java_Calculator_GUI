package calculator.ui;
import calculator.core.StandardCalculator;
import calculator.converter.UnitConverter;
import calculator.core.ScientificCalculator;
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
        //scientific panel:
        JPanel sciPanel = new JPanel();
        sciPanel.setLayout(null);
        ScientificCalculator sciCalc = new ScientificCalculator();

        // Display
        JTextField sciDisplay = new JTextField();
        sciDisplay.setBounds(20, 20, 340, 40);
        sciDisplay.setFont(new Font("Arial", Font.BOLD, 20));
        sciPanel.add(sciDisplay);

        // Buttons
        String[] sciButtons = {
            "sin", "cos", "tan", "log",
            "sqrt", "x^2", "1/x", "C"
        };

        int x1 = 20, y1 = 80;

        for (String text : sciButtons) {
            JButton btn = new JButton(text);
            btn.setBounds(x1, y1, 80, 50);
            btn.setFont(new Font("Arial", Font.BOLD, 12));

            btn.addActionListener(e -> {
                try {
                    double val = Double.parseDouble(sciDisplay.getText());

                   switch (text) {
                        case "sin":
                            sciDisplay.setText(String.valueOf(sciCalc.sin(val)));
                            break;
                        case "cos":
                            sciDisplay.setText(String.valueOf(sciCalc.cos(val)));
                            break;
                        case "tan":
                            sciDisplay.setText(String.valueOf(sciCalc.tan(val)));
                            break;
                        case "log":
                            sciDisplay.setText(String.valueOf(sciCalc.log(val)));
                            break;
                        case "sqrt":
                            sciDisplay.setText(String.valueOf(sciCalc.sqrt(val)));
                            break;
                        case "x^2":
                            sciDisplay.setText(String.valueOf(sciCalc.square(val)));
                            break;
                        case "1/x":
                            sciDisplay.setText(String.valueOf(sciCalc.reciprocal(val)));
                            break;
                        case "C":
                            sciDisplay.setText("");
                            break;
                    }
                } catch (Exception ex) {
                    sciDisplay.setText("Error");
                }
            });

            sciPanel.add(btn);

            x1 += 90;
            if (x1 > 300) {
                x1 = 20;
                y1 += 60;
            }
        }

        tabbedPane.add("Scientific", sciPanel);
        // end of scientific panel
        //converter panel:
        UnitConverter converter = new UnitConverter();
        JPanel convPanel = new JPanel();
        convPanel.setLayout(null);

        // Input field
        JTextField inputField = new JTextField();
        inputField.setBounds(20, 20, 150, 30);
        convPanel.add(inputField);

        // Output field
        JTextField outputField = new JTextField();
        outputField.setBounds(200, 20, 150, 30);
        outputField.setEditable(false);
        convPanel.add(outputField);
        inputField.setHorizontalAlignment(JTextField.CENTER);
        outputField.setHorizontalAlignment(JTextField.CENTER);

        // Category dropdown
        String[] categories = {"Length", "Weight", "Temperature", "Area", "Volume", "Speed"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);
        categoryBox.setBounds(20, 70, 150, 30);
        convPanel.add(categoryBox);

        // From unit
        JComboBox<String> fromUnit = new JComboBox<>();
        fromUnit.setBounds(20, 120, 150, 30);
        convPanel.add(fromUnit);

        // To unit
        JComboBox<String> toUnit = new JComboBox<>();
        toUnit.setBounds(200, 120, 150, 30);
        convPanel.add(toUnit);

        // Convert button
        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(120, 180, 120, 40);
        convPanel.add(convertBtn);
        convertBtn.addActionListener(e -> {
        try {
            double input = Double.parseDouble(inputField.getText());
            String category = (String) categoryBox.getSelectedItem();
            String from = (String) fromUnit.getSelectedItem();
            String to = (String) toUnit.getSelectedItem();

            double result = converter.convert(category, from, to, input);
            outputField.setText(String.valueOf(result));
        } catch (Exception ex) {
            outputField.setText("Error");
        }
    });

        // Add panel
        tabbedPane.add("Converter", convPanel);
        categoryBox.setSelectedIndex(0);
        categoryBox.addActionListener(e -> {
        fromUnit.removeAllItems();
        toUnit.removeAllItems();

        String selected = (String) categoryBox.getSelectedItem();

        if (selected.equals("Length")) {
            String[] units = {"Meter", "Kilometer", "Centimeter"};
            for (String u : units) {
                fromUnit.addItem(u);
                toUnit.addItem(u);
            }
        } else if (selected.equals("Weight")) {
            String[] units = {"Gram", "Kilogram"};
            for (String u : units) {
                fromUnit.addItem(u);
                toUnit.addItem(u);
            }
        } else if (selected.equals("Temperature")) {
            String[] units = {"Celsius", "Fahrenheit"};
            for (String u : units) {
                fromUnit.addItem(u);
                toUnit.addItem(u);
            }
        }
        else if (selected.equals("Area")) {
            String[] units = {"Sq Meter", "Sq Kilometer"};
            for (String u : units) {
                fromUnit.addItem(u);
                toUnit.addItem(u);
            }
        }

        else if (selected.equals("Volume")) {
            String[] units = {"Liter", "Milliliter"};
            for (String u : units) {
                fromUnit.addItem(u);
                toUnit.addItem(u);
            }
        }

        else if (selected.equals("Speed")) {
            String[] units = {"m/s", "km/h"};
            for (String u : units) {
                fromUnit.addItem(u);
                toUnit.addItem(u);
            }
        }
    });
    standardPanel.setBackground(new Color(245, 245, 245));
    sciPanel.setBackground(new Color(245, 245, 245));
    convPanel.setBackground(new Color(245, 245, 245));                

        add(tabbedPane);

        setVisible(true);
        setResizable(false);
    }
    
}
