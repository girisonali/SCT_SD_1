import javax.swing.*;
import java.awt.*;

public class TempConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("🌡️ Temperature Converter");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel inputLabel = new JLabel("Enter Value:");
        inputLabel.setBounds(50, 30, 100, 25);
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(160, 30, 250, 25);
        frame.add(inputField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 70, 100, 25);
        frame.add(fromLabel);

        JComboBox<String> fromUnit = new JComboBox<>();
        fromUnit.addItem("Celsius");
        fromUnit.addItem("Fahrenheit");
        fromUnit.addItem("Kelvin");
        fromUnit.setBounds(160, 70, 250, 25);
        frame.add(fromUnit);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(50, 110, 100, 25);
        frame.add(toLabel);

        JComboBox<String> toUnit = new JComboBox<>();
        toUnit.addItem("Celsius");
        toUnit.addItem("Fahrenheit");
        toUnit.addItem("Kelvin");
        toUnit.setBounds(160, 110, 250, 25);
        frame.add(toUnit);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(160, 150, 100, 30);
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(160, 190, 300, 25);
        frame.add(resultLabel);

        Color bg = Color.BLACK;
        Color fg = Color.GREEN;

        inputLabel.setBackground(bg);
        inputLabel.setForeground(fg);

        inputField.setBackground(bg);
        inputField.setForeground(fg);
        inputField.setOpaque(true);

        fromLabel.setBackground(bg);
        fromLabel.setForeground(fg);

        fromUnit.setBackground(bg);
        fromUnit.setForeground(fg);
        fromUnit.setOpaque(true);

        toLabel.setBackground(bg);
        toLabel.setForeground(fg);

        toUnit.setBackground(bg);
        toUnit.setForeground(fg);
        toUnit.setOpaque(true);

        convertButton.setBackground(bg);
        convertButton.setForeground(fg);
        convertButton.setOpaque(true);

        resultLabel.setBackground(bg);
        resultLabel.setForeground(fg);

        frame.getContentPane().setBackground(bg);

        convertButton.addActionListener(e -> {
            try {
                double value = Double.parseDouble(inputField.getText());
                String from = (String) fromUnit.getSelectedItem();
                String to = (String) toUnit.getSelectedItem();
                double result = convert(value, from, to);
                resultLabel.setText("Result: " + String.format("%.2f", result) + " " + getSymbol(to));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid number.");
            }
        });

        frame.setVisible(true);
    }

    static double convert(double value, String from, String to) {
        if (from.equals(to)) return value;
        if (from.equals("Celsius") && to.equals("Fahrenheit")) return value * 9 / 5 + 32;
        if (from.equals("Celsius") && to.equals("Kelvin")) return value + 273.15;
        if (from.equals("Fahrenheit") && to.equals("Celsius")) return (value - 32) * 5 / 9;
        if (from.equals("Fahrenheit") && to.equals("Kelvin")) return (value - 32) * 5 / 9 + 273.15;
        if (from.equals("Kelvin") && to.equals("Celsius")) return value - 273.15;
        if (from.equals("Kelvin") && to.equals("Fahrenheit")) return (value - 273.15) * 9 / 5 + 32;
        return value;
    }

    static String getSymbol(String unit) {
        if (unit.equals("Celsius")) {
            return "℃";
        } else if (unit.equals("Fahrenheit")) {
            return "℉";
        } else if (unit.equals("Kelvin")) {
            return "K";
        } else {
            return "";
        }
    }
}
