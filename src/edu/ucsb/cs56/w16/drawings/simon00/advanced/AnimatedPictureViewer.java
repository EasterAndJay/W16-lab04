package edu.ucsb.cs56.w16.drawings.simon00.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms; 

/**
 * A main class to view an animation
 *
 * @author Simon Huynh 
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Shape newHeli; 
    
    Thread anim;
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 10;

    private int direction = 90; 

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

	    // Clear the panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    // Draw the attack helicopter 
	    g2.setColor(Color.BLACK);
	    
	    AttackHelicopter heli = new AttackHelicopter(x, y, 25, 100, 60);
	    newHeli = ShapeTransforms.rotatedCopyOf(heli, Math.toRadians(direction)); 
	    g2.draw(newHeli);
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls

		    if (x >= 530) {
			dx = -10;
			direction = -90; 
		    }
		    if (x <= 50) {
			dx = 10;
			direction = 90; 
		    }
            
		    x += dx;                
		    panel.repaint();
		    Toolkit.getDefaultToolkit().sync(); 
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
