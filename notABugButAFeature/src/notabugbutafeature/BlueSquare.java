package notabugbutafeature;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class BlueSquare {
    private int x;
    private int y;
    private Image image;

    public BlueSquare() {   
        initBlueSquare();
    }
    
    private void initBlueSquare() {       
        ImageIcon ii = new ImageIcon("blue_square.png");
        image = ii.getImage();
        x = 1200;
        y = 666;        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    /*public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x = x - 10;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x = x + 10;
        }

        if (key == KeyEvent.VK_UP) {
            y = y - 10;
        }

        if (key == KeyEvent.VK_DOWN) {
            y = y + 10;
        }
        
        x = Math.max(0, x);
        x = Math.min(1400 - 50, x);
        y = Math.max(0, y);
        y = Math.min(800 - 78, y);
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x = x;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x = x;
        }

        if (key == KeyEvent.VK_UP) {
            y = y;
        }

        if (key == KeyEvent.VK_DOWN) {
            y = y;
        }
    }*/
}
