package edu.ucsb.cs56.w16.drawings.k_zara95.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a basic droid without any defining features that
   implements the Shape interface so it can be rotated, scaled, etc.  
      
   @author Kevin Zaragoza
   @version for CS56, W16, UCSB
   
*/
public class Droid extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x, x coord of top left circle
       @param y, y coord of top left circle 
       @param diam_1 diameter of the base circle
    */
    public Droid(double x, double y, double diam_1)
    {
       //Base portion of the droid
	     Ellipse2D.Double baseCircle = new Ellipse2D.Double (x, y, diam_1, diam_1);
       //Head of the droid
       Ellipse2D.Double headCircle = new Ellipse2D.Double (x+diam_1/5,y-diam_1/1.5, diam_1/1.5,diam_1/1.5);

      GeneralPath wholeDroid = this.get();
      wholeDroid.append(baseCircle, false);
      wholeDroid.append(headCircle, false);
    
    }
}
