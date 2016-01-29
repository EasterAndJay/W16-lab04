package edu.ucsb.cs56.w16.drawings.brenda_flores.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;


import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a guitar that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Brenda Flores
   @version for CS56, W16, UCSB

*/
public class GuitarShape extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of top left corner of guitar neck
       @param y y coord of top left corner of guitar neck
       @param height height of neck (only the rectangle. The rest of the guitar is scaled based on this height.
    */
    public GuitarShape(double x, double y, double height)
    {

        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	double width = 0.1 * height;
	double bottomRadius= 0.25 * height;
        double topRadius = .75 * bottomRadius;
	double holeRadius = .3 * bottomRadius;
	double fretx1=x;
	double fretx2=x+width;
	double frety=y+0.25*height;
	double distanceString=0.25*width;
	double distanceFret=0.1*(.75*height);
        // Make the neck

        Rectangle2D.Double neck =
            new Rectangle2D.Double(x, y ,
                                   width, height);

        Line2D.Double fret1 =
            new Line2D.Double (fretx1, frety,
			       fretx2, frety);

	Line2D.Double fret2 =
	    new Line2D.Double (fretx1, frety+distanceFret,
			fretx2, frety+distanceFret);

	Line2D.Double fret3 =
	    new Line2D.Double (fretx1, frety+distanceFret*2,
	    fretx2, frety+distanceFret*2);

	Line2D.Double fret4 =
	    new Line2D.Double (fretx1, frety+distanceFret*3,
			       fretx2, frety+distanceFret*3);

	Line2D.Double fret5 =
	    new Line2D.Double (fretx1, frety+distanceFret*4,
			       fretx2, frety+distanceFret*4);

	Line2D.Double fret6 =
	    new Line2D.Double (fretx1, frety+distanceFret*5,
		       fretx2, frety+distanceFret*5);

	Line2D.Double fret7 =
	    new Line2D.Double (fretx1, frety+distanceFret*6,
		       fretx2, frety+distanceFret*6);

	Line2D.Double fret8 =
	    new Line2D.Double (fretx1, frety+distanceFret*7,
		       fretx2, frety+distanceFret*7);

	Line2D.Double fret9 =
	    new Line2D.Double (fretx1, frety+distanceFret*8,
		       fretx2, frety+distanceFret*8);


	Line2D.Double string1 = 
	    new Line2D.Double(x+distanceString, frety, x+distanceString, y+height);

	Line2D.Double string2 =
	    new Line2D.Double(x+2*distanceString, frety, x+2*distanceString, y+height);

	Line2D.Double string3 =
	    new Line2D.Double(x+3*distanceString, frety, x+3*distanceString, y+height);

	//Make the body

        Ellipse2D.Double topBody =
            new Ellipse2D.Double (((x + width/2)-topRadius), y+height-bottomRadius-topRadius,
                               2*topRadius, 2*topRadius);

	Ellipse2D.Double bottomBody =
	    new Ellipse2D.Double ((x + width/2)-bottomRadius, y+height-bottomRadius,
			  2*bottomRadius, 2*bottomRadius);

	Ellipse2D.Double hole =
	    new Ellipse2D.Double ((x+width/2)-holeRadius, y+height-holeRadius,
                          2*holeRadius, 2*holeRadius);


        // put the whole house together

        GeneralPath wholeGuitar = this.get();
        wholeGuitar.append(neck, false);
        wholeGuitar.append(topBody, false);
        wholeGuitar.append(bottomBody, false);
	wholeGuitar.append(string1, false);
	wholeGuitar.append(string2, false);
	wholeGuitar.append(string3, false);
	wholeGuitar.append(fret1, false);
	wholeGuitar.append(fret2, false);
	wholeGuitar.append(fret3, false);
	wholeGuitar.append(fret4, false);
	wholeGuitar.append(fret5, false);
	wholeGuitar.append(fret6, false);
	wholeGuitar.append(fret7, false);
	wholeGuitar.append(fret8, false);
	wholeGuitar.append(fret9, false);
	wholeGuitar.append(hole, false);


    }
}
