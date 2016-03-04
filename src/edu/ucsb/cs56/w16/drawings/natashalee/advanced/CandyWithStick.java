package edu.ucsb.cs56.w16.drawings.natashalee.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
a Lollipop

@author Natasha Lee
@version for CS56, W16, UCSB

*/

public class CandyWithStick extends Candy implements Shape
{

// constructor

	public CandyWithStick(double x, double y, double diam)
	{
		super(x, y, diam);

		GeneralPath gp = this.get();

		//make a stick that goes under the candy, to make a lollipop!

		double len = diam*1.5;
		double wofstick = diam/10;

		Rectangle2D.Double stick = new Rectangle2D.Double ((x+diam/2)-(wofstick/2), y+diam, wofstick, len);
		
		
		GeneralPath lolli = this.get();
		lolli.append(stick, false);

	}
}
