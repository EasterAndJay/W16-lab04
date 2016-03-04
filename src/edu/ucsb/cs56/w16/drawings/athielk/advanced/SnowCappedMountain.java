package edu.ucsb.cs56.w16.drawings.athielk.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;


import java.awt.geom.Line2D; 
/**
   A snow capped mountain
      
   @author Alex Thielk
   @version for CS56, W16, UCSB
   
*/

public class SnowCappedMountain extends Mountain implements Shape{
    /**
     * Constructor for objects of class SnowCappedMountain
     
     @param x x cord of lower left corner of mountain
     @param y y cord of lower left corner of mountain
     @param width width at the base of the mountain
     @param height of mountain
     */
    public SnowCappedMountain(double x, double y, double width, double height){
	super(x,y,width,height);
	GeneralPath gp = this.get();

	double tipx = x+width/2;
	double tipy= y-height;
	
	double lowSnowHeight = height/3;
	double lowSnowWidth = width/3;
	
	double highSnowHeight = height/4;
	double highSnowWidth= width/4;
	
	Line2D.Double llh1 = 
	    new Line2D.Double(tipx, tipy+lowSnowHeight,
			      tipx-highSnowWidth/6,tipy+highSnowHeight);

	 Line2D.Double lhl2 =
	     new Line2D.Double(tipx-highSnowWidth/6,tipy+highSnowHeight,
			       tipx-highSnowWidth*2/6,tipy+lowSnowHeight);

	 Line2D.Double llh3 =
	     new Line2D.Double(tipx-highSnowWidth*2/6,tipy+lowSnowHeight,
			       tipx-highSnowWidth/2, tipy+highSnowHeight);


	Line2D.Double rlh1 =
	    new Line2D.Double(tipx, tipy+lowSnowHeight,
			      tipx+highSnowWidth/6,tipy+highSnowHeight);
	
         Line2D.Double rhl2 =
             new Line2D.Double(tipx+highSnowWidth/6,tipy+highSnowHeight,
                               tipx+highSnowWidth*2/6,tipy+lowSnowHeight);

         Line2D.Double rlh3 =
             new Line2D.Double(tipx+highSnowWidth*2/6,tipy+lowSnowHeight,
                               tipx+highSnowWidth/2, tipy+highSnowHeight);

	GeneralPath wholeMountain = this.get();
	wholeMountain.append(llh1,false);
	wholeMountain.append(lhl2,false);
        wholeMountain.append(llh3,false);

	wholeMountain.append(rlh1,false);
        wholeMountain.append(rhl2,false);
        wholeMountain.append(rlh3,false);

	
    }
}
