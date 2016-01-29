package edu.ucsb.cs56.w16.drawings.marcosimone.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class Machine extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
    */
    public Machine(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
             
        
        
        // Make the box
        
        Rectangle2D.Double box = 
            new Rectangle2D.Double(x, y, width, height);
	
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen

	Ellipse2D.Double butt1 =
            new Ellipse2D.Double (x+width/4-height/16,y+height/4,
				  height/8.0, (height)/8);
                               
        Rectangle2D.Double pane =
            new Rectangle2D.Double ( x + (width)/4, y  + height/2.0,
                               width/2, height/4);

	Ellipse2D.Double butt2 =
            new Ellipse2D.Double (x+(3*width)/4-height/16, y+height/4,
				  height/8.0, (height)/8);

	Line2D.Double ant =
	    new Line2D.Double (x+width,y,x+width, y-height/4);
	
        // put the whole house together
	
        GeneralPath radio = this.get();
	radio.append(box, false);
	radio.append(butt1, false);
        radio.append(pane, false);
        radio.append(butt2, false);    
	radio.append(ant,false);
    }
}
