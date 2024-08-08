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
        jbListener.addMouseListener(new MouseListener() {
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
