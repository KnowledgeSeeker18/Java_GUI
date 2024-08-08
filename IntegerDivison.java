
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
