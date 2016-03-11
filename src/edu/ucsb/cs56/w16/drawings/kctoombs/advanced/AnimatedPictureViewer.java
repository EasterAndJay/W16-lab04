package edu.ucsb.cs56.w16.drawings.kctoombs.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Kenneth Toombs
 * @version for CS56, W16
 */

public class AnimatedPictureViewer{

    private DrawPanel panel = new DrawPanel();

    private int x = 100;
    private int y = 100;
    private int dx = 5;
    private int dy = 5;

    private Speaker speaker = new Speaker(100, 250, 75, 100);
    
    Thread thread;

    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }
    
    public void go() {
	JFrame frame = new JFrame("A speaker bouncing off the walls");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);
      
	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e){
		    System.out.println("Mouse entered");
		    thread = new Animation();
		    thread.start();
		}

		public void mouseExited(MouseEvent e){        
		    System.out.println("Mouse exited");
		    // Kill the animation thread
		    thread.interrupt();
		    while (thread.isAlive()){}
		    thread = null;         
		    panel.repaint();        
		}
	    });
      
    }

    class DrawPanel extends JPanel{
	public void paintComponent(Graphics g){
	    Graphics2D g2D = (Graphics2D) g;

	    g2D.setColor(Color.white);
	    g2D.fillRect(0,0, this.getWidth(), this.getHeight());

	    g2D.setColor(Color.BLACK);

	    Speaker sp = new Speaker(x, y, 75, 100);
	    g2D.draw(sp);
	}
    }

    class Animation extends Thread{
	public void run(){
	    try{
		while(true){
		    //make speaker pulsate

		    if(y >= 350) { dy = -5; }
		    if(y <= 5) { dy = 5; }
		    
		    if (x >= 550) { dx = -5; }
		    if (x <= 5) { dx = 5; }
		    
		    x += dx;
		    y += dy;
		    
		    panel.repaint();
		    Thread.sleep(50);
		}
	    }
	    
	    catch(Exception ex) {
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
