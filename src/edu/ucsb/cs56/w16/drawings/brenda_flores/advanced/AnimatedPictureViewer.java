package edu.ucsb.cs56.w16.drawings.brenda_flores.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Brenda Flores
 * @version for CS56, W16
 */


public class AnimatedPictureViewer extends JFrame
{

    Thread animate;
    AnimatedPictureComponent component;
    static final double xCoord=200;
    static final double yCoord=200;
    static final double height=100;
    static final double currentDirection=1;
    static final double currentAngle=Math.PI/6;
    static final double currentXDirection=1;

    public AnimatedPictureViewer() {

	setSize(640,480);
        setTitle("Brenda Flores' Animated Drawing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	component = new AnimatedPictureComponent(xCoord, yCoord, height, currentAngle, currentDirection, currentXDirection);
	add(component);

	getContentPane().addMouseListener(
					  new MouseAdapter(){
					      public void mouseEntered(MouseEvent e){
						  
						  animate = new Animate();
						  animate.start();
					      }

					      public void mouseExited(MouseEvent e){
						  //Terminate the animation.
						  animate.interrupt();
						  
						  while (animate.isAlive()){}
						  animate = null;
					      }
					  }
					  );
        setVisible(true);
    }

    public static void main(String[] args) {
        AnimatedPictureViewer apv = new AnimatedPictureViewer();
    }

    class Animate extends Thread{

        public void run(){
            try{
           
                while(true){
                    
                    display(52);//parameter is the legnth of the delay the shorter the delay the faster the guitar moves
                }

	    }catch(Exception ex){
                if(ex instanceof InterruptedException){
                }else{
                    System.out.println(ex);
                    System.exit(1);
                }
	    }
	}

        void display(int delay)
            throws InterruptedException{
            
            component.repaint();
            
            if(Thread.currentThread().interrupted())
                throw(new InterruptedException());
            
            Thread.currentThread().sleep(delay);
        }
        
    }
}


