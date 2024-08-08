import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventEx extends JFrame {
    MouseEventEx(){
        setTitle("MouseEvents ex");
        setSize(500, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }
    void createContents(){
        JButton jbListener,jbAdapter;
       
        add(jbListener=new JButton("Mouse Listner"));
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

        add (jbAdapter=new JButton("Mouse Adapter"));
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
    }
    public static void main(String[] args) {
        new MouseEventEx();
    }
}
