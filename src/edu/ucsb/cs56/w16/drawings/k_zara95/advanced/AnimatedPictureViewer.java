package edu.ucsb.cs56.w16.drawings.k_zara95.advanced;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A main class to view an animation
 *
 * @author Kevin Zaragoza
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
	Random rand = new Random();
    private DrawPanel panel = new DrawPanel();
    
    private BB8 bb8 = new BB8(100, 100, 100);
    private BB8 bb8_2 = new BB8(100,100,100);
    Thread anim;   
    
    //Starting Position of First BB8
    private int x_1 = 100;
    private int y_1 = 300;
    
    //Starting Position of Second BB8
    private int x_2 = 800; 
    private int y_2 = 300;
    
    //Horizontal Modifier
    private int dx_1 = 5;
    private int dx_2 = 5;

    //Vertical Modifier
    private int dy_1 = 5;
    private int dy_2 = 5;



    //Generates Random Colors
    public Color randomColorGen(){
    	int R = (int)(Math.random()*256);
		int G = (int)(Math.random()*256);
		int B= (int)(Math.random()*256);
		Color color = new Color(R, G, B);
		return color;
    }

    public Color dullColorGen(){
    	int R = (int)(Math.random()*256);
		int G = (int)(Math.random()*256);
		int B= (int)(Math.random()*256);
		Color color = new Color(R, G, B);
		return color;
    }

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }


    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(960,540);
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
          g2.setColor(Color.black);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the BB8
          g2.setColor(randomColorGen());
          BB8 test = new BB8(x_1, y_1, 100);
          g2.draw(test);

          //Draw Second BB8 
          g2.setColor(randomColorGen());
          BB8 test_2 = new BB8(x_2, y_2, 100);
          g2.draw(test_2);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls
          	//First BB8
            if (x_1 >= 800) { dx_1 = -5; }
            if (x_1 <= 50) { dx_1 = 5; }

            //Move up and down
            if (y_1 <= 50) { dy_1 = 5; }
            if (y_1 >= 500) { dy_1 = -5; }
            y_1 += dy_1;  
            
            //Second BB8
            if (x_2 >= 800) { dx_2 = -5; }
            if (x_2 <= 50) { dx_2 = 5; }
            x_1 += dx_1;
            x_2 += dx_2;

            //Move up and down
            if (y_2 <= 50) { dy_2 = 5; }
            if (y_2 >= 480) { dy_2 = -5; }
            y_2 += dy_2;  
                    
            

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