package edu.ucsb.cs56.w16.drawings.clholoien.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

public class ManWithSmile extends Man implements Shape{
    //Constructor
    public ManWithSmile(double x, double y, double width, double height){
	super(x,y,width,height);

	GeneralPath gp = this.get();

	Ellipse2D.Double eye1 = new Ellipse2D.Double(x + width * 0.4, y - height * 0.95, 0.02 * width, 0.02 * width);
	
	Ellipse2D.Double eye2 = new Ellipse2D.Double(x + width * 0.6, y - height * 0.95, 0.02 * width, 0.02 * width);

	Arc2D.Double smile = new Arc2D.Double(x + width * 0.375, y - height * 0.92, width * 0.25, height * 0.05, 180,180 , Arc2D.OPEN);
	
	GeneralPath wholeMan = this.get();
	wholeMan.append(eye1, false);
	wholeMan.append(eye2, false);
	wholeMan.append(smile, false);
    }
}
