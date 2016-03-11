package edu.ucsb.cs56.w16.drawings.thienhoang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape;
    
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
/**
   A HiSign (extends RoadSign class, implements Shape)
   
   The HiSign class corresponds to a road sign that says "Hi"
   @author Thien Hoang 
   @version for CS56, W16, UCSB
   
*/
public class HiSign extends RoadSign implements Shape
{
    /**
       Constructor
       @param x x coord of the upper left corner of the Hi sign
       @param y y coord of the upper left corner of the Hi sign
       @param width width of the the Hi sign (mostly width of the rectagular sign)
       @param height height of the Hi sign (including the pole and the sign)
     */
    public HiSign(double x, double y, double width, double height)
    {
	// construct the basic road sign shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	//draw capital H
	GeneralPath H = new GeneralPath();

	H.moveTo(x+width*0.4,y+height*0.055);
	H.lineTo(x+width*0.4,y+height*0.278);
	H.moveTo(x+width*0.4,y+height*0.167);
	H.lineTo(x+width*0.5,y+height*0.167);
	H.moveTo(x+width*0.5,y+height*0.055);
	H.lineTo(x+width*0.5,y+height*0.278);

	//draw lower-case i
	GeneralPath i = new GeneralPath();

	H.moveTo(x+width*0.55,y+height*0.278);
	H.lineTo(x+width*0.55,y+height*0.167);
	// add the letters to the sign
	
        GeneralPath wholeHiSign = this.get();
	wholeHiSign.append(H,false);
	wholeHiSign.append(i,false);
    }    
}
