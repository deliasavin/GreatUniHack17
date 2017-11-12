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


public class EnviormentBoard extends MasterBoard implements ActionListener {
    
    private Image environmentTutorImage = null;
    private boolean craftLockedInQuest;
    private Graphics2D g2d;

    private Image compilerTutorImage = null;
    
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
        
        ImageIcon compilerTutorImageicon = new ImageIcon("red_square.png");
        compilerTutorImage = compilerTutorImageicon.getImage();
        
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
        g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        g2d.drawImage(environmentTutorImage, 1000, 100, this);
        g2d.drawImage(compilerTutorImage, 300, 300, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
        if (craft.getLockedInQuest()) {
            ImageIcon backgroundImageIcon = new ImageIcon("forest.png");
            Image background = backgroundImageIcon.getImage();
            g2d.drawImage(background, 0, 0, this);
            this.setBackground(Color.DARK_GRAY);
            craft.setLockedInQuest(false);
            craft.setX(1300);
            craft.setY(100);
        }
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