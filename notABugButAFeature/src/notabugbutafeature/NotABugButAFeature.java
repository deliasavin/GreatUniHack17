package notabugbutafeature;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class NotABugButAFeature extends JFrame {

    public NotABugButAFeature() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(1400, 1000);
        setResizable(false);
        
        setTitle("Moving sprite");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                NotABugButAFeature ex = new NotABugButAFeature();
                ex.setVisible(true);
            }
        });
    }
}