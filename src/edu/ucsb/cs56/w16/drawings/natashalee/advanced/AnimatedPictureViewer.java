package edu.ucsb.cs56.w16.drawings.natashalee.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Andrew Berls
 * @version for CS56, W14
 */


public class AnimatedPictureViewer {
	
	private DrawPanel panel = new DrawPanel();
	
	private CandyWithStick lollipop = new CandyWithStick(100, 100, 100);
	
	Thread anim;
	
	private int x = 60;
	private int y = 60;
	
	private int dx = 5;
	
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
			g2.setColor(Color.YELLOW);
			CandyWithStick test = new CandyWithStick(x, y, 150);
			g2.draw(test);
		}
	}
	
	class Animation extends Thread {
		public void run() {
			try {
				while (true) {
					//make lollipop bounce down, then up/down a little, then back up
					
					if (y >= 105) { dx = -5; }
					if (y <= 50) { dx = 5; }
					if (y==100){
						for(int i = 0; i<6; i++){
							y+=1;
							panel.repaint();
							Thread.sleep(50);
						}
						for(int j = 0; j<6; j++){
							y+=-1;
							panel.repaint();
							Thread.sleep(50);
						}
					}
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
