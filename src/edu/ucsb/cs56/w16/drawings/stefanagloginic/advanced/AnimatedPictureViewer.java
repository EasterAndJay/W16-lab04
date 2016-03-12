package edu.ucsb.cs56.w16.drawings.stefanagloginic.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Stefana Gloginic
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    Thread anim;

    private int x = 0;
    private int y = 0;
    private int center_down = 0;
    private int right_corner_down = 0;
    private int left_center_up = 0;

    private int dx = 0;
    private int dy = 0;

    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(500,500);
	frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e){
		    System.out.println("Ball moves!");
		    x = 0;
		    y = 0;
		    center_down = 0;
		    right_corner_down = 0;
		    left_center_up = 0;
		    
		    anim = new Animation();
		    anim.start();
		}

		public void mouseExited(MouseEvent e){
		    System.out.println("Ball stops.");
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
	    //want flashing different colors

	    int Red = (int)(Math.random()*256);
	    int Green = (int) (Math.random()*256);
	    int Blue = (int) (Math.random()*256);
	    Color randomColor = new Color(Red, Green, Blue);
	    // Change the panel by adding another random color the color function will generate
	    g2.setColor(randomColor);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    // Draw the Ball
	    g2.setColor(Color.RED);
	    g2.fillOval(x,y,20,20);
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls in an x formation
		    if(x == 0 && y == 0){
			while((x != 500)&& (y != 500)){
			    dx = 5;
			    dy = 5;
			    x+=dx;
			    y+=dy;
			    panel.repaint();
			    Thread.sleep(50);
			}
		    }
		    else if(x == 500 && y == 500){
			while((x!=250) && (y!=250)){
			    dx = -5;
			    dy = -5;
			    x += dx;
			    y += dy;
			    panel.repaint();
			    Thread.sleep(50);
			}
			center_down = 1;
		    }
		    else if((x == 250) && (y == 250) && (center_down == 1)){
			while((x!= 0)&&(y!=500)){
			    dx = -5;
			    dy = 5;
			    x += dx;
			    y += dy;
			    panel.repaint();
			    Thread.sleep(50);
			}
			center_down = 0;
		    }
		    else if((x == 0) && (y ==500)){
			while((x!= 500) && (y != 0)) {
			    dx = 5;
			    dy = -5;
			    x += dx;
			    y += dy;
			    panel.repaint();
			    Thread.sleep(50);
			}
			right_corner_down = 1;
		    }
		    else if((x == 500) && (y == 0) && (right_corner_down == 1)){
			while((x != 250) && (y != 250)){
			    dx = -5;
			    dy = 5;
			    x += dx;
			    y += dy;
			    panel.repaint();
			    Thread.sleep(50);
			}
			right_corner_down = 0;
			left_center_up = 1;
		    }
		    else if((x == 250) && (y == 250) && (left_center_up == 1)){
			while((x != 0) && (y != 0)){
			    dx = -5;
			    dy = -5;
			    x += dx;
			    y += dy;
			    panel.repaint();
			    Thread.sleep(50);
			}
			left_center_up = 0;
		    }
		}
	    }catch(Exception ex) {
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
