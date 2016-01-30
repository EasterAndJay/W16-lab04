package edu.ucsb.cs56.w16.drawings.drdipepperjr.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Birthday Cake
      
   @author Domenic DiPeppe
   @version for CS56, W16, UCSB
   
*/
public class BirthdayCake extends Cake implements Shape
{
    /**
     * Constructor for objects of class BirthdayCake
     */
    public BirthdayCake(double x, double y, double width, double height, double sideHeight)
    {
	// construct the basic house shell
	super(x,y,width,height,sideHeight);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make three candles, spaced like this, where w=width/20.0;
	// |      xx xx xx      |
	// |      xx xx xx      |
	// |      xx xx xx      |
	// |                    |
	// |  6w  2w 2w 2w  6w  |
	//
	// The top of window will be at y + 0.5*height and the
	// height of the window is 0.25height;
	
	double w =  width/20;
	double canTop = y - height/3;
	
	Rectangle2D.Double can1 =
	    new Rectangle2D.Double(x + 6*w, canTop, 2*w, height);
	Rectangle2D.Double can2 =
	    new Rectangle2D.Double(x + 9*w, canTop, 2*w, height);
	Rectangle2D.Double can3 =
	    new Rectangle2D.Double(x + 12*w, canTop, 2*w, height);
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholeHouse = this.get();
        wholeHouse.append(can1, false);
        wholeHouse.append(can2, false);
        wholeHouse.append(can3, false); 
    }    
}
