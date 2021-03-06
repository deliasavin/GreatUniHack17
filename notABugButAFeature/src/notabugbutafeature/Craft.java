package notabugbutafeature;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Craft {
    private int x;
    private int y;
    private Image image;
    private Rectangle collisionBox;
    private MasterBoard currentBoard;
    private boolean lockedInQuest;

    public Craft(MasterBoard passedBoard) {
        currentBoard = passedBoard;
        initCraft();
    }
    
    private void initCraft() {       
        ImageIcon ii = new ImageIcon("green_square.png");
        image = ii.getImage();
        x = 25;
        y = 0;
        collisionBox = new Rectangle(x, y, 50, 50);        
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
    
    public Rectangle getCollisionBox() {
        return collisionBox;
    }
    
    public boolean getLockedInQuest() {
        return lockedInQuest;
    }
    
    public void setLockedInQuest(boolean passedLockedInQuest) {
        lockedInQuest = passedLockedInQuest;
        System.out.println(lockedInQuest);
    }
    
    public void setX(int passedX) {
        x = passedX;
    }
    
    public void setY(int passedY) {
        y = passedY;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (!currentBoard.overlaps(collisionBox) && !lockedInQuest) {
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
        } else {
            lockedInQuest = true;
        }
        
        x = Math.max(0, x);
        x = Math.min(1400 - 50, x);
        y = Math.max(0, y);
        y = Math.min(800 - 78, y);
        
        collisionBox.setLocation(x, y);
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
        
        collisionBox.setLocation(x, y);
    }
}
