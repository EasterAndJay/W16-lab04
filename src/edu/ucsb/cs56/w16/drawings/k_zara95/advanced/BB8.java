package edu.ucsb.cs56.w16.drawings.k_zara95.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a basic droid without any defining features that
   implements the Shape interface so it can be rotated, scaled, etc.  
      
   @author Kevin Zaragoza
   @version for CS56, W16, UCSB
   
*/
public class BB8 extends Droid implements Shape
{
    /**
       Constructor
       
       @param x x coord of top left of base circle
       @param y y coord of top left of base circle 
       @param diam_1 diameter of the base circle
    */
    public BB8(double x, double y, double diam_1)
    {
      super(x,y,diam_1);
      GeneralPath gp = this.get();

      //Give BB8 his antenna
      double antlen = diam_1/3;
      Line2D.Double antenna = new Line2D.Double(x+diam_1/4,y-diam_1/2,
        x+diam_1/4,y - diam_1/2 - antlen);

      //Give BB8 its eye 
      double height = diam_1/4;
      double width  = diam_1/12;
      Ellipse2D.Double eye = new Ellipse2D.Double(x+diam_1/1.5,y-diam_1/2,
        width, height);
      
      //Give BB8 its facial recetangle 
      double rectHeight = diam_1/9;
      double rectLength = diam_1/4;
      Rectangle2D.Double rect = new Rectangle2D.Double(x+diam_1/3,y-diam_1/2.7,
        rectLength, rectHeight);
      GeneralPath wholeDroid = this.get();
      wholeDroid.append(antenna,false);
      wholeDroid.append(eye, false); 
      wholeDroid.append(rect, false);
      
    }
}
