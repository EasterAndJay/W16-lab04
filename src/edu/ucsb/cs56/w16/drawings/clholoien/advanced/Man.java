package edu.ucsb.cs56.w16.drawings.clholoien.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector/ circle drawing of a man that implements
   the Shape interface, and so can be drawn, as well as 
   rotated, scaled, etc.
 */


public class Man extends GeneralPathWrapper implements Shape{

    /**
       Constructor

       @param x: x coord pf lower left foot
       @param y: y coord of lower left foot
       @param width of the man
       @param height of the man
     */
    public Man(double x, double y, double width, double height){

	//These are the dimensions of the man's head.
	double headWidth = width / 2;
	double headHeight = 0.2 * height;

	//These are the legs of the man.
	Line2D.Double leftLeg = new Line2D.Double(x, y, x + width * 0.5, y - 0.3 * height);
	Line2D.Double rightLeg =new Line2D.Double(x + width, y, x + width * 0.5, y - height * 0.3);

	//This is the body of the man
	Line2D.Double body = new Line2D.Double(x + width * 0.5, y - height * 0.3, x + width * 0.5, y - 0.8 * height);

	//These are the arms of the man
	Line2D.Double rightArm = new Line2D.Double(x + width * 0.5, y - height * 0.6, x, y - height * 0.7);
	Line2D.Double leftArm = new Line2D.Double(x + width * 0.5, y - height * 0.6, x + width, y -height * 0.7);

	//This is the head for the man
	Ellipse2D.Double head = new Ellipse2D.Double(x + width * 0.25, y - height, headWidth, headHeight);

	//Now appending all the body parts to make the man.
	GeneralPath wholeMan = this.get();
	wholeMan.append(leftLeg, false);
	wholeMan.append(rightLeg,false);
	wholeMan.append(body, false);
	wholeMan.append(leftArm, false);
	wholeMan.append(rightArm,false);
	wholeMan.append(head, false);
	
    }
}
