package edu.ucsb.cs56.w16.drawings.drdipepperjr.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Graphics2D;
import java.awt.Shape;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A main class to view an animation
 *
 * @author Domenic DiPeppe
 * @version for CS56, W16
 */


public class AnimatedPictureViewer{

    private DrawPanel panel = new DrawPanel();
   
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx;
    private int dy;
     
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
	    
	    Graphics2D g2 = (Graphics2D) g;

	    double angle = Math.atan2(y-240,x-320) - Math.PI / 2;
	    
	    // Clear the panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    // Draw the BirthdayCake
	    g2.setColor(Color.BLACK);

	    g2.rotate(angle, x, y);
	    Shape bc1 = new BirthdayCake(x,y,100,30,30);
	    g2.draw(bc1);	    
	    
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Moves in a square
		    //starts at (100,100) and dx = -5
		    
		    if(x <= 100){
			dx = 0;
			dy = -5;
			x += dx;
			y += dy;
		    }
		    
		    if(x > 540){
			dx = 0;
			dy = 5;
			x += dx;
			y += dy;
		    }
		    
		    if(y < 90){
			dx = 5;
			dy = 0;
			x += dx;
			y += dy;
		    }
		    
		    if(y > 390){
			dx = -5;
			dy = 0;
			x += dx;
			y += dy;
		    }
		    
		    
		    
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
