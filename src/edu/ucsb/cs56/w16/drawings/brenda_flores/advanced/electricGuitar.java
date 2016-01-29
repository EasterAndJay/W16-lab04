package edu.ucsb.cs56.w16.drawings.brenda_flores.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape;
import java.awt.geom.Rectangle2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
   An electric guitar (a guitar with an amplifier and a cord)
      
   @author Brenda Flores
   @version for CS56, W16, UCSB
   
*/
public class electricGuitar extends GuitarShape implements Shape
{
    /**
     * Constructor for objects of electric guitar class
     */
    public electricGuitar(double x, double y, double height)
    {
	// construct the basic guitar shell
	super(x,y,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Have a cord come out from the bottom of the guitar and connect
	// to an amplifier slightly below

	
	double ampLength = 0.4 * height;
	
	Rectangle2D.Double amplifier =
	    new Rectangle2D.Double(x+((0.1*height)/2)-0.6*height-ampLength, y+(1.85*height), ampLength, ampLength);
	Line2D.Double separator =
	    new Line2D.Double(x+((0.1*height)/2)-0.6*height-ampLength, y+(1.85*height)+0.3*ampLength, x+((0.1*height)/2)-0.6*height, y+(1.85*height)+0.3*ampLength);
	Line2D.Double cord1 = new Line2D.Double(x+((0.1*height)/2),y+1.25*height,x+((0.1*height)/2)-0.1*height,y+(1.25*height)+0.3*height);
	Line2D.Double cord2 = new Line2D.Double(x+((0.1*height)/2)-0.1*height,y+(1.25*height)+0.3*height,x+((0.1*height)/2)-0.1*height-0.3*height,y+(1.25*height)+0.3*height+0.2*height);
	Line2D.Double cord3 = new Line2D.Double(x+((0.1*height)/2)-0.1*height-0.3*height,y+(1.25*height)+0.3*height+0.2*height,x+((0.1*height)/2)-0.1*height-0.3*height-0.2*height,y+(1.25*height)+0.3*height+0.2*height+0.1*height);
	Ellipse2D.Double nob=new Ellipse2D.Double(x-0.6*height-0.25*ampLength, y+1.25*height+0.6*height+0.04*height,0.06*height,0.06*height);
	
	// add the cord, the amplifier, and all the parts that
	// make it up to the image
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholeSet = this.get();
        wholeSet.append(amplifier, false);
        wholeSet.append(cord1, false);
        wholeSet.append(cord2, false);
	wholeSet.append(cord3, false);
	wholeSet.append(separator, false);
	wholeSet.append(nob, false); 
    }    
}
