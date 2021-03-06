package notabugbutafeature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SyntaxBoard extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private RedSquare square;
    private final int DELAY = 10;

    public SyntaxBoard() {

        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLUE);

 
        EnviormentBoard enviormentBoard = null;
		craft = new Craft(enviormentBoard);
        square = new RedSquare();

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
        Graphics2D g2d2 = (Graphics2D) g;
        
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);        
        g2d2.drawImage(square.getImage(), square.getX(), square.getY(), this);
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
}