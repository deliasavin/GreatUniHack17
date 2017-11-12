package notabugbutafeature;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;


public class IfBoard extends MasterBoard implements ActionListener {

    private Timer timer;
    private Craft craft;
    private BlueSquare character;
    private final int DELAY = 10;
    
    private final JPanel ifTutor = new JPanel();
    private Image ifTutorImage;
    private Rectangle ifTutorCollisionRectangle = new Rectangle(1190, 666, 90, 90);

    public IfBoard() {

        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.GRAY);

        craft = new Craft(this);
        character = new BlueSquare();

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
        g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();  
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
    @Override
    public boolean overlaps (Rectangle r) {
         
        SpeechBubble speechBubble = new SpeechBubble();

        return(ifTutorCollisionRectangle.intersects(r));
        
        
    }
 
}