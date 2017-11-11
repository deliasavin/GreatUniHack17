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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class EnviormentBoard extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private final int DELAY = 10;
    
    private final JPanel enviormentTutor = new JPanel();
    private Image environmentTutorImage;
    private final Rectangle environmentTutorCollisionRectangle = new Rectangle(1000, 400, 70, 70);

    public EnviormentBoard() {
        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        craft = new Craft(this);
        ImageIcon environmentTutorImageIcon = new ImageIcon("red_square.png");
        environmentTutorImage = environmentTutorImageIcon.getImage();
        

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
        g2d.drawImage(environmentTutorImage, 1000, 400, this);          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public boolean overlaps (Rectangle r) {
        return(environmentTutorCollisionRectangle.intersects(r));
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