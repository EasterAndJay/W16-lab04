package edu.ucsb.cs56.w16.drawings.natashalee.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.geom.Rectangle2D;


/**
 * A main class to view an animation
 *
 * @author Natasha Lee
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
	
	private DrawPanel panel = new DrawPanel();
	
	private CandyWithStick lollipop = new CandyWithStick(100, 100, 100);
	
	Thread anim;
	
	private int x = 60;
	private int y = 50;
	
	private int dx = 5;
	
	private Color color = new Color(0x5DADEC);
	private Color oppcolor = Color.gray;

	
	public static void main (String[] args) {
		new AnimatedPictureViewer().go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel);
		frame.setSize(300,640);
		frame.setVisible(true);
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				System.out.println("mouse entered");
				anim = new Animation();
				anim.start();
			}
			
			public void mouseExited(MouseEvent e){
				System.out.println("mouse exited");
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
			g2.setColor(Color.BLACK);
			g2.fillRect(0,0,this.getWidth(), this.getHeight());
			
			// Draw the lollipop
			g2.setColor(color);
			CandyWithStick test = new CandyWithStick(x, y, 150);
			g2.draw(test);
			
			//draw top wall
			g2.setColor(oppcolor);
			Rectangle2D.Double wall = new Rectangle2D.Double(0,10,300,39);
			g2.fillRect(0,10,300,39);
			g2.draw(wall);
			
			
		}
	}
	
	class Animation extends Thread {
		public void run() {
			try {
				while (true) {
					//make lollipop bounce down, then up/down a little, then back up
					
					
					if (y <= 50) {
						dx = 5;
						if (oppcolor== color.lightGray){
							oppcolor = Color.gray;
						}
						else{
							oppcolor = Color.lightGray;
						}
						
						int r = (int) (Math.random() * 255);
						int g = (int) (Math.random() * 255);
						int b = (int) (Math.random() * 255);
						
 						color = new Color(r,g,b);
					}
					
					
					if (y==105){
						for(int i = 0; i<6; i++){
							y+=1;
							panel.repaint();
							Thread.sleep(30);
						}
						for(int j = 0; j<6; j++){
							y+=-1;
							panel.repaint();
							Thread.sleep(30);
						}
						for(int i = 0; i<6; i++){
							y+=1;
							panel.repaint();
							Thread.sleep(30);
						}
						for(int j = 0; j<6; j++){
							y+=-1;
							panel.repaint();
							Thread.sleep(30);
						}
					}
					
					if (y >= 105) { dx = -5;}
					
					y += dx;
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
