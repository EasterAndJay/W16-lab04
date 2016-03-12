package edu.ucsb.cs56.w16.drawings.angel00.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
/**
   A Train

   @author Angel Rivera
   @version for CS56, W16, UCSB

*/
public class Train extends Box implements Shape
{
    /**
     * Constructor for objects of class Train
     */
    public Train(double x, double y, double width, double height)
    {
	super(x,y,width,height);
	GeneralPath gp = this.get();

	double radius = width/12;
	
	Circle firstWheel = new Circle (x+(2*radius), y+height+radius, radius);
	Circle secondWheel = new Circle (x+(4*radius), y+height +radius, radius);
	Circle thirdWheel = new Circle (x+(6*radius), y+height+radius, radius);
	Circle fourthWheel = new Circle (x+(8*radius), y+height+radius, radius);
	
	GeneralPath wholeTrain = this.get();
	
	wholeTrain.append(firstWheel,false);
	wholeTrain.append(secondWheel,false);
	wholeTrain.append(thirdWheel,false);
	wholeTrain.append(fourthWheel,false);
	
    }
}
