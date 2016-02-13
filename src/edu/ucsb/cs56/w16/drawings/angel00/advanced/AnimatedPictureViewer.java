package edu.ucsb.cs56.w16.drawings.angel00.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Angel Rivera
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    
    Thread anim;   
    private int sequence = -1;
    private int x_Old = 100;
    private int y_Old = 600;
    private int x_New = 100;
    private int y_New = 600;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(700,700);
      frame.setVisible(true);
      anim = new Animation();
      anim.start();
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
	if(sequence == -1){
            g2.setColor(Color.white);
            g2.fillRect(0,0,this.getWidth(), this.getHeight());
	}
	g2.setStroke(new BasicStroke(5));
	g2.drawLine(x_Old, y_Old, x_New, y_New);
	

	
	// Clear the panel once animation is done
	if(sequence == 9 ){
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    sequence = -1;
	    x_Old = 100;
	    y_Old = 600;
	    x_New = 100;
	    y_New = 600;
	}
	
       }
    }
    
    class Animation extends Thread {
      public void run() {
          try{
	      while (true) {
		  if(sequence == -1){
		      panel.repaint();
		      sequence = 0;
		  }
		  if(sequence == 0){
		      while(x_Old!= 600 ||  y_Old!=600){
			  x_New = x_Old + 1;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
		      }
		      sequence = 1;
		  }
		  if(sequence == 1){
		      while(x_Old>250 &&  y_Old>100){
			  x_New = x_Old - 1;
			  y_New = y_Old - 2;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
			  y_Old = y_New;
		      }
		      sequence = 2;
		  }
		  if(sequence == 2){
		      while(x_Old>100 && y_Old<600){
			  x_New = x_Old - 1;
			  y_New = y_Old + 2;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
			  y_Old = y_New;
		      }
		      sequence = 3;
		  }
		  if(sequence == 3){
		      x_Old = 350-224;
		      y_Old = 600-112;
		      x_New = x_Old;
		      y_New = y_Old;
		      while(x_Old<574){
			  x_New = x_Old + 1;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
		      }
		      sequence = 4;
		  }
		  if(sequence == 4){
		      while(y_Old<600){
			  x_New = x_Old - 1;
			  y_New = y_Old + 2;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
			  y_Old = y_New;
		      }
		      sequence = 5;
		  }
		  if(sequence == 5){
		      while(x_Old>350 ){
			  x_New = x_Old - 1;
			  y_New = y_Old - 2;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
			  y_Old = y_New;
		      }
		      sequence = 6;
		  }
	      
		  if(sequence == 6){
		      x_Old = 350+224;
		      y_Old = 600-112;
		      x_New = x_Old;
		      y_New = y_Old;
		      while(x_Old>(350-224)){
			  x_New = x_Old - 1;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
		      }
		      sequence = 7;
		  }
		  if(sequence == 7){
		      while(y_Old<600){
			  x_New = x_Old + 1;
			  y_New = y_Old + 2;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
			  y_Old = y_New;
		      }
		      sequence = 8;
		  }
		  if(sequence == 8){
		      while(x_Old<350 ){
			  x_New = x_Old + 1;
			  y_New = y_Old - 2;
			  panel.repaint();
			  Thread.sleep(10);
			  x_Old = x_New;
			  y_Old = y_New;
		      }
		      sequence = 9;
		      panel.repaint(); 
		  }
	      }
	  }
	  catch(Exception ex){
	      if(ex instanceof InterruptedException){}
	      else{
		  ex.printStackTrace();
		  System.exit(1);
	      }
	  
	  }
	
      }
    }
}
