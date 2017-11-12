package notabugbutafeature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MasterBoard extends JPanel implements ActionListener {

    Timer timer;
    Craft craft;
    final int DELAY = 10;
    
    private final JPanel masterTutor = new JPanel();
    private Image masterTutorImage;
    private Rectangle masterTutorCollisionRectangle = new Rectangle(980, 80, 90, 90);

    public MasterBoard() {
        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.GRAY);
        MasterBoard masterBoard;

        craft = new Craft(this);

        timer = new Timer(DELAY, this);
        timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();  
    }
    
    public boolean overlaps (Rectangle r) {
        return(masterTutorCollisionRectangle.intersects(r));
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
        
        
    }
}