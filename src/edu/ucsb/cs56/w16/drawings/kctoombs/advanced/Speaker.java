package edu.ucsb.cs56.w16.drawings.kctoombs.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   Speaker class for lab04, CS56  W16
   A drawing of a speaker that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Kenneth Toombs 
   @version for CS56, W16, UCSB
   
*/
public class Speaker extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
    */
    public Speaker(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	
        double bigCircleDiameter = 0.75*width;
	double mediumCircleDiameter = 0.5*width;
	double smallCircleDiameter = 0.25*width;
        // Make the perimeter of the speaker, call it base
        
        Rectangle2D.Double base = 
            new Rectangle2D.Double(x, y,
				   width, height);
	
        // make the circles of the speaker (the part where the noise comes out)
        
        Ellipse2D.Double bigCircle = 
            new Ellipse2D.Double (x + (width/8), y + (height/8),
				  bigCircleDiameter, bigCircleDiameter);
	
        Ellipse2D.Double mediumCircle = 
            new Ellipse2D.Double (x + (width/4), y + (height/4.25),
				  mediumCircleDiameter, mediumCircleDiameter);

        Ellipse2D.Double smallCircle = 
            new Ellipse2D.Double (x + (width/2.7), y + (height/3),
				  smallCircleDiameter, smallCircleDiameter);
	
        // put the whole speaker together
	
        GeneralPath wholeSpeaker = this.get();
        wholeSpeaker.append(base, false);
        wholeSpeaker.append(bigCircle, false);
        wholeSpeaker.append(mediumCircle, false);  
	wholeSpeaker.append(smallCircle, false);
    }
}

