
package edu.ucsb.cs56.w16.drawings.thienhoang.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.lang.Math.*;

// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
   A component that draws an animated picture by Thien Hoang
   
   @author Thien Hoang
   @version CS56, W16
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape sign;
    private double x;
    private double y;
    private double width;
    private double initWidth;
    private double height;
    private double initHeight;
    private double shrinkSpeed;
    private double initAngle;
    private double angle;
    private int counter; //use to determine when to expand and when to shrink
    // starting length: 300; width: 100
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a rotating Hi sign that shrinks to until either height or width is 0 pixel.
	Then it expands at a random position on the screen until it reaches the initial height or initial width, then it shrinks again 
	@param x initial x position
	@param y initial y position
	@param width the width of the sign in pixels
	@param height the height of the sign in pixels
	@param shrinkSpeed determines how fast the sign shrink or expand
	@param initAngle the starting angle of the sign when it starts off and when it randomly pops onto the screen
    */
    public AnimatedPictureComponent(double x, double y, double width, double height, double shrinkSpeed, double initAngle) {

	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	this.initWidth=width;
	this.initHeight=height;
	this.shrinkSpeed=shrinkSpeed;
	this.initAngle=initAngle;
	this.angle=initAngle;
	this.counter=0;
	sign = new HiSign(this.x, this.y, this.initWidth, this.initHeight);
    }
    /** Use to shrink the sign */
    public void shrink(){
	width = width-shrinkSpeed;
	height = height-2*shrinkSpeed;
	angle +=0.01;
	sign = ShapeTransforms.rotatedCopyOf(new HiSign(x, y, width, height), angle);    
    }

    /** Used to expand the sign*/
    public void expand(){
  	width = width+shrinkSpeed;
	height = height+2*shrinkSpeed;
	angle +=0.01;
	sign = ShapeTransforms.rotatedCopyOf(new HiSign(x, y, width, height), angle);    
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the sign is updated
     */

   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
       if(height<=0 || width<=0){ //when the sign is fully shrunk
	   x=Math.random()*600;
	   y=Math.random()*400;
	   angle=initAngle;
	   height=0.01;
	   width=initWidth/initHeight*height;
	   ++counter;
	   return;
       }
       if(height>initHeight || width>initWidth){
	   height-=0.01;
	   width-= 0.01;
	   ++counter;
	   return;
       }
       else
	   g2.setColor(Color.BLACK); g2.draw(sign);	   
       if(counter%2==1) 
	   this.expand();
       else //always shrink
	   this.shrink();       
   }      
}
