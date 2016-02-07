package edu.ucsb.cs56.w16.drawings.brenda_flores.advanced;
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
   A component that draws an animated picture by Brenda Flores

   @author Brenda Flores
   @version CS56, W16

*/


public class AnimatedPictureComponent extends JComponent
{
    private Shape guitar;
    private double xCoord;
    private double yCoord;
    private double height;
    private double currentAngle;
    private double currentDirection;
    private double currentXDirection;

    
    /** Constructs an AnimatedPictureComponent with specific properties.
        This animated picture depicts a a guitar rocking back and forth and moving across the screen

        @param xCoord the x position of the guitar
        @param yCoord the y position of the guitar
        @param height the length of the guitar neck
        @param currentAngle the angle the guitar needs to rotate from the starting position
        @param currentDirection the direction the guitar needs to rotate
    */
    public AnimatedPictureComponent(double xCoord, double yCoord, double height, double currentAngle, double currentDirection, double currentXDirection) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
	this.height=height;
	this.currentAngle=currentAngle;
	this.currentDirection=currentDirection;
	this.currentXDirection=currentXDirection;

	guitar=new GuitarShape(this.xCoord, this.yCoord, this.height);

    }

    /** The paintComponent method is orverriden to display
        out animation. Each time this method is called, the
        position of the pencil is updated
     */

    public void paintComponent(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	
	g2.setColor(Color.BLACK);
	g2.draw(guitar);

	if(currentDirection == 1){
	    currentAngle+=(Math.PI/24);
	}
	else{
	    currentAngle-=(Math.PI/24);
	}
	if(currentAngle>=Math.PI/2||currentAngle<=Math.PI/6){
	    currentDirection=currentDirection*(-1);
	}

	if(xCoord >=500||xCoord<=150){
	    currentXDirection*=(-1);
	}

	if(currentXDirection==1){
	    xCoord+=5;
	}
	else{
	    xCoord-=5;
	}

	guitar = ShapeTransforms.rotatedCopyOf(new GuitarShape(xCoord, yCoord, height),currentAngle);
       
    }

}
