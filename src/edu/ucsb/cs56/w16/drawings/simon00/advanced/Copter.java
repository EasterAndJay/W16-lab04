package edu.ucsb.cs56.w16.drawings.simon00.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a helicopter that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Simon Huynh 
   @version for CS56, W16, UCSB
   
*/
public class Copter extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of the center of the helicopter body
       @param y y coord of the center of the helicopter body
       @param width of helicopter body
       @param length of helicopter body
       @param radius radius of helicopter rotor
    */
    public Copter(double x, double y, double width, double length, double radius)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	// Make the helicopter body

	double xCenter = x + (0.5 * width); 
	double yCenter = y + (0.5 * length);  
	Rectangle2D.Double heliBody = 
	    new Rectangle2D.Double(x, y, width, length); 

	// Draw the circle rotor
        Circle rotor = 
	    new Circle(xCenter, yCenter, radius);

	// Draw the helicopter tail
	double tailWidth = 0.65 * width; 
	double tailLength = 0.15 * length;
	double tailTopLeftX = xCenter - (0.5 * tailWidth); 
	double tailTopLeftY = yCenter + (0.5 * length) - (0.5 * tailLength); 
	Rectangle2D.Double heliTail = 
	    new Rectangle2D.Double(tailTopLeftX, tailTopLeftY, tailWidth, tailLength); 

        GeneralPath helicopter = this.get();
        helicopter.append(heliBody, false);
	helicopter.append(rotor, false);    
	helicopter.append(heliTail, false); 
    }
}
