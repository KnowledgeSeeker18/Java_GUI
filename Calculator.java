
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame {
    JTextField display;
    StringBuilder input;
    
    public Calculator() {
        setTitle("Calaulator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }
    void createContents(){
        input=new StringBuilder();
        display=new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));

        String[] buttons={
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "c", "0", "=", "+"
        };
        for (String numOp:buttons){
            JButton button =new JButton(numOp);
            button.setPreferredSize(new Dimension(60,60));
            button.setBackground(new Color(200,200,200));
            button.setFont(new Font("Arial",Font.PLAIN,20));
            button.addActionListener(new MyListner());
            panel.add(button);
        }
        add(panel,BorderLayout.CENTER);
    
    }
    private class MyListner implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            String command=ae.getActionCommand();
            if(command.equals("c")){
                display.setText("0");
                input=new StringBuilder();
            }
            else if (!command.equals("=")){
            input.append(command);
            display.setText(input.toString());
            }
            else{
                try {
                    double result = evaluateExpression(input.toString());
                    display.setText(String.valueOf(result));
                    input = new StringBuilder();  // Clear the input after evaluation
                } 
                catch (Exception e) {
                    display.setText("Error");
                    input = new StringBuilder();  // Clear input in case of error
                }
            }
        }       
        private double evaluateExpression(String expression) {
            String[] tokens = expression.split("(?=[-+*/])|(?<=[^-+*/][-+*/])");
            double result = 0;
            char operator = '-';
            if (tokens.length > 0) {
                result = Double.parseDouble(tokens[0]);
                for (int i = 1; i < tokens.length; i += 2) {
                    operator = tokens[i].charAt(0);
                    double number = Double.parseDouble(tokens[i + 1]);
                    switch (operator) {
                        case '+':
                            result += number;
                            break;
                        case '-':
                            result -= number;
                            break;
                        case '*':
                            result *= number;
                            break;
                        case '/':
                            if (number != 0) {
                                result /= number;
                            } 
                            else {
                            throw new ArithmeticException("Division by zero");
                            }
                            break;
                        }
                    }
                }
                
                return result;
            }
        }
                
        public static void main(String[] args) {
            new Calculator();
         }
    }

