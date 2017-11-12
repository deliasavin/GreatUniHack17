/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notabugbutafeature;


import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

/*import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class SpeechBubble {
 public class LeftArrowBubble extends JPanel {
  //private static final long serialVersionUID = -5389178141802153305L;
  private int radius = 10;
  private int arrowSize = 12;
  private int strokeThickness = 3;
  private int padding = strokeThickness / 2;
  @Override
  protected void paintComponent(final Graphics g) {
   final Graphics2D g2d = (Graphics2D) g;
   g2d.setColor(new Color(0.51f, 0.8f, 1f));
   int x = padding + strokeThickness + arrowSize;
   int width = getWidth() - arrowSize - (strokeThickness * 2);
   int bottomLineY = getHeight() - strokeThickness;
   g2d.fillRect(x, padding, width, bottomLineY);
   g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
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
 public class RightArrowBubble extends JPanel {
  //private static final long serialVersionUID = -5L;
  private int strokeThickness = 3;
  private int radius = 10;
  private int arrowSize = 12;
  private int padding = strokeThickness / 2;
  @Override
  protected void paintComponent(final Graphics g) {
   final Graphics2D g2d = (Graphics2D) g;
   g2d.setColor(new Color(0.5f, 0.5f, 1f));
   int bottomLineY = getHeight() - strokeThickness;
   int width = getWidth() - arrowSize - (strokeThickness * 2);
   g2d.fillRect(padding, padding, width, bottomLineY);
   RoundRectangle2D.Double rect = new RoundRectangle2D.Double(padding, padding, width, bottomLineY, radius, radius);
   Polygon arrow = new Polygon();
   arrow.addPoint(width, 8);
   arrow.addPoint(width + arrowSize, 10);
   arrow.addPoint(width, 12);
   Area area = new Area(rect);
   area.add(new Area(arrow));
   g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
   g2d.setStroke(new BasicStroke(strokeThickness));
   g2d.draw(area);
  }
 }

 public class TestPanel extends JPanel {
  private static final long serialVersionUID = 67L;
  private JLabel messageLbl1, userImageLbl1, messageLbl, userImageLbl;
  private JPanel msgPanel1, msgPanel;
  //String userImageUrl = "http://cdn1.iconfinder.com/data/icons/nuvola2/22x22/apps/personal.png";

  public TestPanel() throws MalformedURLException {
   //userImageLbl = new JLabel();
   msgPanel = new LeftArrowBubble();
   messageLbl = new JLabel();
   //messageLbl1 = new JLabel();
   //msgPanel1 = new RightArrowBubble();
   //userImageLbl1 = new JLabel();

   //userImageLbl.setIcon(new ImageIcon(new URL(userImageUrl)));
   messageLbl.setText("Hi, How are you?");

   GroupLayout msgPanelLayout = new GroupLayout(msgPanel);
   msgPanel.setLayout(msgPanelLayout);
   msgPanelLayout.setHorizontalGroup(
    msgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(msgPanelLayout.createSequentialGroup()
     .addGap(21, 21, 21)
     .addComponent(messageLbl)
     .addContainerGap(162, Short.MAX_VALUE))
   );
   msgPanelLayout.setVerticalGroup(
    msgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(msgPanelLayout.createSequentialGroup()
     .addComponent(messageLbl)
     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
   );

   /*messageLbl1.setIcon(new ImageIcon(new URL(userImageUrl)));
   userImageLbl1.setText("I'm Good.");

   GroupLayout jPanel1Layout = new GroupLayout(msgPanel1);
   msgPanel1.setLayout(jPanel1Layout);
   jPanel1Layout.setHorizontalGroup(
    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
     .addContainerGap(171, Short.MAX_VALUE)
     .addComponent(userImageLbl1)
     .addGap(22, 22, 22))
   );
   jPanel1Layout.setVerticalGroup(
    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(jPanel1Layout.createSequentialGroup()
     .addComponent(userImageLbl1)
     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
   );

   GroupLayout layout = new GroupLayout(this);
   this.setLayout(layout);
   layout.setHorizontalGroup(
    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
     .addContainerGap()
     //.addComponent(userImageLbl)
     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
      //.addComponent(msgPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(msgPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
     //.addComponent(messageLbl1)
     .addContainerGap())
   );
   /*layout.setVerticalGroup(
    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    /*.addGroup(layout.createSequentialGroup()
     .addContainerGap()
     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      //.addComponent(userImageLbl)
      .addComponent(msgPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
     .addGap(18, 18, 18)
     //.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      //.addComponent(messageLbl1)
      //.addComponent(msgPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
     //.addContainerGap(22, Short.MAX_VALUE))
   );
  }
 }

public class RightArrowBubble extends JPanel{
    private int strokeThickness = 3;
  private int radius = 10;
  private int arrowSize = 12;
  private int padding = strokeThickness / 2;
    @Override
  protected void paintComponent(final Graphics g) {
   final Graphics2D g2d = (Graphics2D) g;
   g2d.setColor(new Color(0.5f, 0.5f, 1f));
   int bottomLineY = getHeight() - strokeThickness;
   int width = getWidth() - arrowSize - (strokeThickness * 2);
   g2d.fillRect(padding, padding, width, bottomLineY);
   RoundRectangle2D.Double rect = new RoundRectangle2D.Double(padding, padding, width, bottomLineY, radius, radius);
   Polygon arrow = new Polygon();
   arrow.addPoint(width, 8);
   arrow.addPoint(width + arrowSize, 10);
   arrow.addPoint(width, 12);
   Area area = new Area(rect);
   area.add(new Area(arrow));
   g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
   g2d.setStroke(new BasicStroke(strokeThickness));
   g2d.draw(area);
  }
}

public class LeftArrowBubble extends JPanel{
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
   g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
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
}*/

    
 public class SpeechBubble extends JApplet{
     @Override
     public void init(){
     ImageIcon bubble = new ImageIcon("speechBubble.png");
     
     JLabel speechBubbleLabel = new JLabel("Please work", bubble, JLabel.CENTER);
     
     add(speechBubbleLabel);
     
    /* JLabel icon = new JLabel(new ImageIcon);
    icon.setLayout(new GridBagLayout());
    add(icon);

    JLabel text = new JLabel();
    text.setText(language.getString("translation"));
    text.setLocation(10, 10);
    text.setSize(text.getPreferredSize());
    icon.add(text);
    
    JLabel bubble = new JLabel(language.getString("Please work"));
    bubble.setIcon(new ImageIcon("speechBubble.png"));*/
   }
 }