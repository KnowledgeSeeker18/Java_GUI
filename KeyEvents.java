
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
