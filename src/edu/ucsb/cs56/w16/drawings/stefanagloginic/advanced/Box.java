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
public class Box extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of box
       @param y y coord of lower left corner of box
       @param width width of the box
       @param height of box 
    */
    public Box(double x, double y, double width, double height)
	{

	    // Rather than having to scale at the end, we \
	    //can just
		// draw things the right way to begin with, us\
	    //	ing the
		// x, y, width and height.   If you haven't al\
	    //	ready
		// hard coded a particular drawing, this may be an easier
		// way.

	    GeneralPath leftSide = new GeneralPath();

	    leftSide.moveTo(x,y);
	    leftSide.lineTo(x,y+height);

	    GeneralPath rightSide = new GeneralPath();

	    rightSide.moveTo(x+width,y);
	    rightSide.lineTo(x+width,y+height);

	    GeneralPath bottomLine = new GeneralPath();
	    bottomLine.moveTo(x,y+height);
	    bottomLine.lineTo(x+width,y+height);

	    GeneralPath topLine = new GeneralPath();
	    topLine.moveTo(x,y);
	    topLine.lineTo(x+width,y);

	    GeneralPath wholeBox = new GeneralPath();
	    wholeBox.append(rightSide,false);
	    wholeBox.append(topLine,false);
	    wholeBox.append(bottomLine,false);
	    wholeBox.append(leftSide,false);
    
	    this.set(new GeneralPath(wholeBox));
	}
}	 
