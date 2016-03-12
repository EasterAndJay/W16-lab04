package edu.ucsb.cs56.w16.drawings.marcosimone.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

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
   A component that draws an animated picture by Jakob Staahl
   
   @author Marco Simone
   @version CS56, W16
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape robot;
    private double travelSpeed;
    private double startingPosition;
    
    private double xPos;
    private double yPos;
    private double width;
    private double height;
    private double angle = 0;
    private double jumpHeight;

    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a pencil writing across the screen

	@param startingXPos the starting x position of the robot
	@param startingYPos the starting y position of the robot
	@param travelSpeed the speed at which the robot will move
	across the screen
	@param travelDistance the number of pixels the robot will move
	across the screen before stopping
	@param startingLength the starting length of the pencil in pixels
	@param width the width of the pencil in pixels
    */
    public AnimatedPictureComponent(double startingXPos, double startingYPos, double travelSpeed, double jumpHeight,  double width, double height) {
    
	this.yPos = startingYPos;
	this.xPos = startingXPos;
	this.travelSpeed = travelSpeed;
	this.jumpHeight = jumpHeight;
	this.width = width;
	this.height=height;

	robot = new Robot(this.xPos, startingYPos, this.width, this.height);
	
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the pencil is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
        
       if (this.angle >= 3600) {
	   this.angle=0;
	   return;
       }
       else
	   g2.setColor(Color.BLACK); g2.draw(robot);
       this.angle+=5;
       
       this.xPos=150*Math.cos(2*(angle/360)/Math.PI)+250;
       this.yPos=150*Math.sin(2*(angle/360)/Math.PI)+200;
      
       robot = ShapeTransforms.rotatedCopyOf(new Robot(xPos, yPos, width, height), .05*angle);
      
   }    
  
}
