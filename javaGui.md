## JAVA GUI

## 1 Factorial GUI

```java
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class FactGui extends JFrame {
    JTextField jf1, jf2;

    public FactGui() {
        setTitle("Factorial Calculator");
        setSize(400, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    void createContents() {
        add(new JLabel("Enter the number: "));
        jf1 = new JTextField(5);
        
        JLabel jl2 = new JLabel("Result: ");
        jf2 = new JTextField(10);
        jf2.setEditable(false);

        JButton jb = new JButton("Calculate");
        
        add(jf1);
        add(jl2);
        add(jf2);
        add(jb);

        MyListener ml=new MyListener();
        jf1.addActionListener(ml);
    //     jb.addActionListener(new ActionListener() {
    //         public void actionPerformed(ActionEvent aee){
    //             String userInput = jf1.getText();
    //             int result = 1;
    //             try {
    //                 int number = Integer.parseInt(userInput);
                    
    //                 if (number < 0) {
    //                     jf2.setText("Please enter a non-negative number");
    //                 } else {
    //                     for (int i = 1; i <= number; i++) {
    //                         result *= i;
    //                     }
    //                     jf2.setText(String.valueOf(result));
    //                 }
    //             } catch (NumberFormatException e) {
    //                 jf2.setText("Invalid input. Enter an integer.");
    //             }
    //         }
    //     });
    }

    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String userInput = jf1.getText();
            int result = 1;
            try {
                int number = Integer.parseInt(userInput);
                
                if (number < 0) {
                    jf2.setText("Please enter a non-negative number");
                } else {
                    for (int i = 1; i <= number; i++) {
                        result *= i;
                    }
                    jf2.setText(String.valueOf(result));
                }
            } catch (NumberFormatException e) {
                jf2.setText("Invalid input. Enter an integer.");
            }
        }
    }

    public static void main(String[] args) {
        // new FactGui();
        SwingUtilities.invokeLater(FactGui::new);
    }
}

```

## 2 SUM OF N NATURAL NUMBERS (WITH MouseListner and MouseAdapter)

``` java 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SumGui extends JFrame {
    JTextField jt1,jt2;
    SumGui(){
        setTitle("SUM OF N NUMBERS");
        setSize(500, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }
    void createContents(){
        add(new JLabel("enTER THE NUMBER:"));
        add(jt1=new JTextField(5));
        add(new JLabel("RESULT: "));
        add(jt2=new JTextField(10));
        jt2.setEditable(false);
        JButton jbListener,jbAdapter;
       
        add(jbListener=new JButton("Calculate"));
        jjbListener.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent me){
                System.out.println("Button Clicked");
            }
            @Override
            public void mousePressed (MouseEvent me){
                System.out.println("Button Pressed");
            }
            @Override
            public void mouseReleased (MouseEvent me){
                System.out.println("Button Released");
            }
            @Override
            public void mouseEntered (MouseEvent me){
                jbListener.setToolTipText("Click to calculate");
                // jbListener.setText("done");
            }
            @Override
            public void mouseExited (MouseEvent me){
                jbListener.setToolTipText(null);
                // jbListener.setText("calcuate");
            }

        });

        add (jbAdapter=new JButton("Calculate (A)"));
        jbAdapter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me){
                jbAdapter.setToolTipText("Click to calculate (A)");
            }
            @Override
            public void mouseClicked (MouseEvent me){
                System.out.println("Mouse CLicked @ (" + me.getX() + ", " + me.getY() + ")");
            }
        });

        jbAdapter.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Mouse dragged at: (" + e.getX() + ", " + e.getY() + ")");
            }
            
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("Mouse moved at: (" + e.getX() + ", " + e.getY() + ")");
            }
        });
        jbListener.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
            try
            { String input=jt1.getText();
                int n= Integer.parseInt(input);
                if (n<0){
                    jt2.setText("Provide Positive Integer");
                }
                int result=(n*(n+1))/2;
                jt2.setText(String.valueOf(result));
            }
            catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
        });        
    }
    public static void main(String[] args) {
        new SumGui();
    }
}

```


## 3 Calculator 

``` java

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



```

## 4 KeyEvents

```java

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class KeyEvents extends JFrame {
    JTextField jt1,jt2;
    public KeyEvents(){
        setTitle("KeyEvents Ex");
        setSize(500, 300);
        setLayout(new FlowLayout());
        createContents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    void createContents(){
        add(new JLabel("First Input"));
        add(jt1=new JTextField(6));
        add(new JLabel("Second Input:"));
        add(jt2=new JTextField(4));

        jt1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed: " + e.getKeyChar()+ " Key Code: " + e.getKeyCode() + " Key String : " + e.getKeyText(e.getKeyCode()));
            }
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released: " + e.getKeyChar());
            }
        
            // @Override
            // public void keyTyped(KeyEvent e) {
            //     System.out.println("Key Typed: " + e.getKeyChar());
            // }
            
        });

        

        // Action printHelloAction = new AbstractAction() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         System.out.println("Hello Key Binding!");
        //     }
        // };

        // // Bind the action to the "H" key
        // getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("H"), "printHello");
        // getRootPane().getActionMap().put("printHello", printHelloAction);



    }
    public static void main(String[] args) {
        new KeyEvents();
    }
}

```

## 6 Integer Division

``` java

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IntegerDivison extends JFrame {
    JTextField jt1,jt2,jt3;

    public IntegerDivison() {
    setTitle("Integer Division");
    setSize(600,200);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    createContents();
    setVisible(true);
    }
    void createContents(){
        add(new JLabel("NUM 1"));
        add(jt1=new JTextField(10));
        add(new JLabel("NUM 2"));
        add(jt2=new JTextField(10));
        
        JButton jb=new JButton();
        add (jb = new JButton("DIVIDE"));
        
        add(new JLabel("Result "));
        add(jt3=new JTextField(8));
        jt3.setEditable(false);

        MyDivListner mdl=new MyDivListner();
        jb.addActionListener(mdl);
        jt2.addActionListener(mdl);
        
    }
    private class MyDivListner implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            String input1=jt1.getText();
            String input2=jt2.getText();
            try {
                int n1=Integer.parseInt(input1);
                int n2=Integer.parseInt(input2);
                
                int result = n1/n2;

                jt3.setText(String.valueOf(result));
            } 
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(IntegerDivison.this,"Number Format Exception","ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch (ArithmeticException e){
                JOptionPane.showMessageDialog(IntegerDivison.this,"Arithmetic Exception","ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    public static void main(String[] args) {
        new IntegerDivison();
    }
    
}

```
