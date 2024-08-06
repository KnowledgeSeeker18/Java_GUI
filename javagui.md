## JAVA GUI

## 1 Factorial GUI

``` java 
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