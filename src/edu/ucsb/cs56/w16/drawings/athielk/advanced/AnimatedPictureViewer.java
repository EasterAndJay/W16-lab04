package edu.ucsb.cs56.w16.drawings.athielk.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * A main class to view an animation
 *
 * @author Alex Thielk
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    //private Mountain mountain = new Mountain(200, 200, 100, 100);

    Thread anim;

    private int x = 320;
    private int y = 240;
    private int size=1;
    
    private int dx = 5;
    private int dy = 5;
    private double grow =10;

    int R = (int)(Math.random()*256);
    int G = (int)(Math.random()*256);
    int B= (int)(Math.random()*256);
    Color color = new Color(R, G, B); 

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

	    // Draw the Mountain
	    g2.setColor(color);
	    SnowCappedMountain test = new SnowCappedMountain(x, y, size, size);
	    g2.draw(test);
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    //respawn after too big

		    if (size >= 1920) {
			x = 320;
			y = 240;
			size=1;
			int R = (int)(Math.random()*256);
			int G = (int)(Math.random()*256);
			int B= (int)(Math.random()*256);
			color = new Color(R, G, B); 
		    }

		    x -= dx;
		    y+= dy;
		    size+=grow;
		    
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
