package edu.ucsb.cs56.w16.drawings.stefanagloginic.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a box that implements
   the Shape interface, and so can be drawn, as well a\
s
   rotated, scaled, etc.

   @author Stefana Gloginic
   @version for CS56, W16, UCSB

*/
public class Laptop extends Box implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of laptop
       @param y y coord of lower left corner of laptop
       @param width width of the laptop
       @param height of laptop
    */
    
    public Laptop(double x, double y, double width, double height)
    {

	// Rather than having to scale at the end, we \
	//can just
	// draw things the right way to begin with, us\
	//  ing the
	// x, y, width and height.   If you haven't al\
	//  ready
	// hard coded a particular drawing, this may be an easier
	// way.

	super(x,y,width,height);

	 Line2D.Double left=
	     new Line2D.Double (x, y+height,
				(x - width), y+1.5*height);

	  Line2D.Double right=
	      new Line2D.Double (x+width, y+height,
				 x, y+1.5*height);
	   Line2D.Double bottom=
	       new Line2D.Double (x, y+1.5*height,
				  x - width, y+1.5*height);


	   GeneralPath wholeLaptop = this.get();
	   wholeLaptop.append(left, false);
	   wholeLaptop.append(right, false);
	   wholeLaptop.append(bottom, false);
    }
}
