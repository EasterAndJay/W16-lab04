package edu.ucsb.cs56.w16.drawings.natashalee.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
a drawing of a circular candy that implements the Shape interface
so it can be rotated, scaled, etc.

@author Natasha Lee
@version for CS56, W16, UCSB

*/

public class Candy extends GeneralPathWrapper implements Shape
{
	/**  Constructor

	     @param x x coord of lower left of candy
	     @param y y coord of lower left of candy
	     @param radius size of candy
	 */
	public Candy(double x, double y, double diam)
	{
		
		//ellipse params (x,y,width,height)
		
		//the main circle of the candy
		Ellipse2D.Double outerCircle = new Ellipse2D.Double (x, y, diam, diam);
		
		//the second layer of the candy
		Ellipse2D.Double middleCircle = new Ellipse2D.Double (x+diam/6, y+diam/6, diam-diam/3, diam-diam/3);
		
		//the most inner layer of the candy
		Ellipse2D.Double centerCircle = new Ellipse2D.Double (x+diam/3, y+diam/3, diam-(2*(diam/3)), diam-(2*(diam/3)));
		
		
		GeneralPath whole = this.get();
		whole.append(outerCircle, false);
		whole.append(middleCircle, false);
		whole.append(centerCircle, false);

	}
}