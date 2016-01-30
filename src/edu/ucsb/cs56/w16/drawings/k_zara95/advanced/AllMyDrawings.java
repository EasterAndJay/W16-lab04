package edu.ucsb.cs56.w16.drawings.k_zara95.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad
 * @modifier Kevin Zaragoza 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few droids 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Droid d1 = new Droid(100,150,100);
	g2.setColor(Color.CYAN); g2.draw(d1);
	
	// Make a black Droid that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(Color.BLACK); g2.draw(d2);
	
	// Here's a Droid that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(d2); 
	
	// Draw two BB8s
	
	BB8 dw1 = new BB8(50,350,40);
	BB8 dw2 = new BB8(200,350,200);
	
	g2.draw(dw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(dw2);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few BB8s by Kevin Zaragoza", 20,20);
    }
    
    
    /** Draw a picture with a few Droids and BB8s
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some Droids.
	
	Droid largeB = new BB8(100,50,225);
	Droid smallBB = new BB8(20,50,40);
	Droid reallySmall = new BB8(20,150,10);
	Droid dSmall = new BB8(20,250,20);
	
	g2.setColor(Color.RED);     g2.draw(largeB);
	g2.setColor(Color.GREEN);   g2.draw(smallBB);
	g2.setColor(Color.BLUE);    g2.draw(reallySmall);
	g2.setColor(Color.MAGENTA); g2.draw(dSmall);
	
	Droid d1 = new Droid(100,250,75);
	g2.setColor(Color.CYAN); g2.draw(d1);
	
	// Make a black Droid that's half the size, 
	// and moved over 150 pixels in x direction
	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(Color.BLACK); g2.draw(d2);
	
	// Here's a Droid that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(d2); 
	
	// Draw two Droids with Windows
	
	BB8 dw1 = new BB8(50,350,40);
	BB8 dw2 = new BB8(200,350,200);
	
	g2.draw(dw1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second Droid 45 degrees around its center.
	Shape dw3 = ShapeTransforms.rotatedCopyOf(dw2, Math.PI/4.0);
	
	g2.draw(dw3);
	
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of droids by Kevin Zaragoza", 20,20);
    }
    
    /** Draw a different picture with a few Droids and BB8's
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Droids and BB8s by Kevin Zaragoza", 20,20);
	
	
	// Draw some coffee cups.
	
	Droid large = new Droid(100,50,225);
	BB8 smallB = new BB8(20,50,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallB);
	
    }       
}
