package edu.ucsb.cs56.w16.drawings.clholoien.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * @author Carson Holoien
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
    private int x = 100;
    private int y = 100;
    private int height = 100;
    private int width = 70;
    private int dx = 5;
    private int tiltNum = 0;

    private DrawPanel panel = new DrawPanel();
    
    private ManWithSmile man = new ManWithSmile(y, x, width, height);
    
    Thread anim;   

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {
	   double angle = 0.0;

	  Graphics2D g2 = (Graphics2D) g;
	  tiltNum = (tiltNum++) % 4;
	  if(tiltNum == 0)
	      angle = Math.PI / 16;
	  if((tiltNum == 1)||(tiltNum ==3))
	      angle =0.0;
	  if(tiltNum == 2)
	      angle = -Math.PI/16;
	    
         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the man
          g2.setColor(Color.BLUE);
          ManWithSmile man = new ManWithSmile(x, y, width,height);
	  Shape manRotated = ShapeTransforms.rotatedCopyOf(man, angle);

          g2.draw(manRotated);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -5; }
            if (x <= 50) { dx = 5; }
            
            x += dx;                
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}

    
