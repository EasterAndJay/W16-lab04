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
    private int y = 300;
    private int objHeight = 100;
    private int objWidth = 70;
    private int dx = 10;
    private int tiltNum = 0;
    private int frameWidth;
    private int frameHeight;

    private DrawPanel panel = new DrawPanel();
    
    private ManWithSmile man = new ManWithSmile(x, y, objWidth, objHeight);
    
    Thread anim;   

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);  //set size of frame.
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
	   tiltNum++;
	  
	  Graphics2D g2 = (Graphics2D) g;
	  

	  //set the tilt variable, this will make it look like hes running.
	  tiltNum = (tiltNum) % 4;
	  if(tiltNum == 0)
	      angle = Math.PI / 20.0;
	  if((tiltNum == 1)||(tiltNum ==3))
	      angle =0.0;
	  if(tiltNum == 2)
	      angle = -Math.PI/20.0;

	  //when we resize the frame, set the instance variable equal to the changed size.
	  frameWidth = this.getWidth();
	  frameHeight = this.getHeight();
	  
	  //Paint the background black.
          g2.setColor(Color.black);
          g2.fillRect(0,0,frameWidth, frameHeight);
	  //draw the message.
	  g2.setColor(Color.white);
	  g.drawString("Meet Al, the running man.", frameWidth/2 - 50, 30);


          // Draw the man with new rotated psoition.
          g2.setColor(Color.white);
          ManWithSmile man = new ManWithSmile(x, y, objWidth,objHeight);
	  Shape manRotated = ShapeTransforms.rotatedCopyOf(man, angle);

          g2.draw(manRotated);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	      if (x >= (frameWidth - objWidth - 10)){dx = -1*dx;}
            if (x <= 10) { dx = dx*-1; }
            
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

    
