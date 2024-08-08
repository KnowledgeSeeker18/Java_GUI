import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private String operator;
    private double num1, num2, result;

    public Calculator() {
        // Create the display field
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        // Create a panel for the buttons and set grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Button labels
        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "C", "0", "=", "%"
        };

        // Add buttons to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            panel.add(button);
        }

        // Add components to the frame
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // Frame settings
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) == 'C') {
            // Clear the display
            display.setText("");
            num1 = num2 = result = 0;
            operator = "";
        } else if (command.charAt(0) == '=') {
            // Perform the calculation
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
            }

            display.setText(String.valueOf(result));
            operator = "";
        } else if ("+-*%".contains(command)) {
            // Store the operator and first number
            operator = command;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else {
            // Append digit to the display
            display.setText(display.getText() + command);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
