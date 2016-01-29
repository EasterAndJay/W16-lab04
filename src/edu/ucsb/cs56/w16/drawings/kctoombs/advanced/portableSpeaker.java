//portableSpeaker class that extends Speaker for lab04, CS56  W16
package edu.ucsb.cs56.w16.drawings.kctoombs.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;


/**
   A Portable Speaker
      
   @author Kenneth Toombs 
   @version for CS56, W16, UCSB
   
*/
public class portableSpeaker extends Speaker implements Shape
{
    /**
     * Constructor for objects of class portableSpeaker
     */
    public portableSpeaker(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	Ellipse2D.Double bluetooth = new Ellipse2D.Double(x + .8*width, y + .8*height,
					       .1*width, .1*width); 
	
	
	// add the bluetooth button to the speaker
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholePortableSpeaker = this.get();
        wholePortableSpeaker.append(bluetooth, false); 
    }    
}
