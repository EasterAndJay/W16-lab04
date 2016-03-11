package edu.ucsb.cs56.w16.drawings.drdipepperjr.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a cake that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
    
   @author P. Conrad
   @author Domenic DiPeppe 
   @version for CS56, W16, UCSB
   
*/
public class Cake extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of top-left corner of cake
       @param y y coord of top-left corner of cake
       @param width width of the cake
       @param height height of the ellipse on top
       @param sideHeight heght of the sides of the cake
    */
    public Cake(double x, double y, double width, double height, double sideHeight)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        //draw the ellipse on top of the cake
	
	Ellipse2D.Double cakeTop = 
	    new Ellipse2D.Double(x, y, width, height);

	//sides of the cake

	double sideY = y + height/2;

	Line2D.Double leftSide = 
	    new Line2D.Double(x, sideY, x, sideY + sideHeight); 

        Line2D.Double rightSide = 
            new Line2D.Double (x + width, sideY, x + width, sideY + sideHeight);
	
	//bottom of the cake
	
        Line2D.Double cakeBottom =
            new Line2D.Double (x, sideY + sideHeight, x + width, sideY + sideHeight);
	
        // put the whole cake together
	
        GeneralPath wholeCake = this.get();
        wholeCake.append(cakeTop, false);
        wholeCake.append(leftSide, false);
        wholeCake.append(rightSide, false);
	wholeCake.append(cakeBottom, false);
    }
}
