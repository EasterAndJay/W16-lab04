package edu.ucsb.cs56.w16.drawings.marcosimone.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A House
      
   @author Marco Simone
   @version for CS56, W16, UCSB
   
*/
public class Robot extends Machine implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Robot(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
        
	double body_w = 0.5*width;
	double body_h = 0.75*height;
	double arm_h = height/4;
	double arm_w = width/4;
	
	double leg_h =  0.25 * height;
	
	Rectangle2D.Double body =
	    new Rectangle2D.Double(x + width/4, y+height, body_w, body_h);
	Rectangle2D.Double left_arm =
	    new Rectangle2D.Double(x + width/4-arm_w,y+ height+body_h/4, arm_w, arm_h);
	Rectangle2D.Double right_arm =
	    new Rectangle2D.Double(x + (3*width)/4, y+height+body_h/4,   arm_w, arm_h);

	Rectangle2D.Double left_leg =
	    new Rectangle2D.Double(x + width/2-body_w/2, y+height+body_h,   arm_h, arm_w);
	Rectangle2D.Double right_leg =
	    new Rectangle2D.Double(x + width/2+body_w/2-arm_h, y+height+body_h,   arm_h, arm_w);
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath robot = this.get();
        robot.append(body, false);
        robot.append(left_arm, false);
	robot.append(right_arm, false);
	robot.append(left_leg, false);
	robot.append(right_leg, false);
    }
}
