package edu.ucsb.cs56.w16.drawings.angel00.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import java.awt.geom.Rectangle2D;


/**
   A Box (wrapper around a General Path, implements Shape)

  

   @author Angel Rivera
   @version for CS56, W16, UCSB

*/
public class Box extends GeneralPathWrapper implements Shape
{
    public Box(double x, double y, double length, double height)
    {
       
	
	GeneralPath leftSide = new GeneralPath();
	
	leftSide.moveTo(x,y);
	leftSide.lineTo(x,height+y);
	
	GeneralPath rightSide = new GeneralPath();
	
	rightSide.moveTo(x+length,y+0.5*height);
	rightSide.lineTo(x+length,height+y);
	
	GeneralPath topSide = new GeneralPath();
	
	topSide.moveTo(x,y);
	topSide.lineTo(x+0.75*length,y);

	GeneralPath extraPart1 = new GeneralPath();
	extraPart1.moveTo(x+0.75*length,y);
	extraPart1.lineTo(x+0.75*length,y+0.5*height);

	GeneralPath extraPart2 = new GeneralPath();
	extraPart1.moveTo(x+0.75*length,y+0.5*height);
        extraPart1.lineTo(x+length,y+0.5*height);

	
	GeneralPath bottomSide = new GeneralPath();
	bottomSide.moveTo(x,y+height);
	bottomSide.lineTo(x+length,y+height);
	
	GeneralPath wholeBox = this.get();
	wholeBox.append(leftSide, false);
	wholeBox.append(rightSide, false);
	wholeBox.append(topSide, false);
	wholeBox.append(bottomSide, false);
	wholeBox.append(extraPart1, false);
	wholeBox.append(extraPart2, false);
	
    }
}
