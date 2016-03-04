package edu.ucsb.cs56.w16.drawings.thienhoang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.geom.Rectangle2D; //for the sign
    
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A RoadSign (wrapper around a General Path, implements Shape)

   The RoadSign class corresponds to a road sign which consists of
   a pole and a rectagle sign
      
   @author Thien Hoang
   @version for CS56, W16, UCSB
   
*/
public class RoadSign extends GeneralPathWrapper implements Shape
{   
    /**
       Constructor
       @param x x coord of upper left corner of the road sign
       @param y y coord of upper left corner of the road sign
       @param width width of the road sign (mostly width of the rectangular sign)
       @param height height of the road sign (including the pole and the sign)
     */
    public RoadSign(double x, double y, double width, double height)
    {
        //draw the retangle for the sign
	Rectangle2D.Double sign = new Rectangle2D.Double(x,y,width,0.33*height);
	//draw the pole
        GeneralPath pole = new GeneralPath();
	
        pole.moveTo(x+0.4*width,y+0.33*height);
	pole.lineTo(x+0.4*width,y+height);
	pole.lineTo(x+0.6*width,y+height);
	pole.lineTo(x+0.6*width,y+0.33*height);
	
     	//stick everything together
        GeneralPath wholeRoadSign = this.get();
	wholeRoadSign.append(sign, false);
	wholeRoadSign.append(pole, false);
    }

}
