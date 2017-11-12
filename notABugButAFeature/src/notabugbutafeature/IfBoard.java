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
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;


public class IfBoard extends MasterBoard implements ActionListener {

    private Timer timer;
    private Craft craft;
    private BlueSquare character;
    private final int DELAY = 10;

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
    
public class LeftArrowBubble extends JPanel {
   private static final long serialVersionUID = -5389178141802153305L;
   private int radius = 10;
   private int arrowSize = 12;
   private int strokeThickness = 3;
   private int padding = strokeThickness / 2;
   @Override
   protected void paintComponent(final Graphics g) {
      final Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(new Color(0.5f, 0.8f, 1f));
      int x = padding + strokeThickness + arrowSize;
      int width = getWidth() - arrowSize - (strokeThickness * 2);
      int bottomLineY = getHeight() - strokeThickness;
      g2d.fillRect(x, padding, width, bottomLineY);
      g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON));
      g2d.setStroke(new BasicStroke(strokeThickness));
      RoundRectangle2D.Double rect = new RoundRectangle2D.Double(x, padding, width, bottomLineY, radius, radius);
      Polygon arrow = new Polygon();
      arrow.addPoint(20, 8);
      arrow.addPoint(0, 10);
      arrow.addPoint(20, 12);
      Area area = new Area(rect);
      area.add(new Area(arrow));
      g2d.draw(area);
   }
}
}