package edu.ucsb.cs56.w16.drawings.athielk.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
   a vector drawing of a mountain that implements Shape so it can be 
   drawn and transformed.

   @author Alex Thielk
   @version for cs56, W16, UCSB
*/
public class Mountain extends GeneralPathWrapper implements Shape{ 
    /**
       Constructor
       
       @param x x coord of lower left corner of mountain
       @param y y coord of lower left corner of mountain
       @param width width of the base of mountain
       @param height of mountain
  */
    public Mountain(double x, double y, double width, double height){
	Line2D.Double leftSlope = 
	    new Line2D.Double(x,y,
			      x+width/2,y-height);
	Line2D.Double rightSlope =
	    new Line2D.Double(x+width/2,y-height,
			      x+width, y);

	GeneralPath wholeMountain = this.get();
	wholeMountain.append(leftSlope, false);
	wholeMountain.append(rightSlope, false);
    }
}
