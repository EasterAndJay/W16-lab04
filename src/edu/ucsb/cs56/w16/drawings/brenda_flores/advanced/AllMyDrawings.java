package edu.ucsb.cs56.w16.drawings.brenda_flores.advanced;

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
 * @author Brenda Flores 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few acoustic guitars 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	GuitarShape gs1 = new GuitarShape(100,100,100);
	g2.setColor(Color.CYAN); g2.draw(gs1);
	
	// Make a black guitar that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(gs1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a guitar that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	//g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two electricGuitars
	
	electricGuitar eg1 = new electricGuitar(300,20,50);
	electricGuitar eg2 = new electricGuitar(200,200,65);
	
	g2.draw(eg1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(eg2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few electric guitars by Brenda Flores", 20,20);
    }
    
    
    /** Draw a picture with a few guitars both acoustic and electric
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	GuitarShape large = new GuitarShape(100,50,225);
	GuitarShape smallCC = new GuitarShape(20,50,40);
	GuitarShape tallSkinny = new GuitarShape(20,150,20);
	GuitarShape shortFat = new GuitarShape(20,250,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	electricGuitar eg1 = new electricGuitar(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(eg1);
	
	// Make an electric guitar that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(eg1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's an electric guitar that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	h2= ShapeTransforms.rotatedCopyOf(h2, Math.PI/3.0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	//g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two guitars
	
	GuitarShape gs1 = new GuitarShape(50,350,75);
	GuitarShape gs2 = new GuitarShape(200,200,100);
	
	g2.draw(gs1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape gs3 = ShapeTransforms.rotatedCopyOf(gs2, Math.PI/4.0);
	
	g2.draw(gs3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some guitars by Brenda Flores", 20,20);
    }
    
    /** Draw a different picture with a couple guitars, both acoustic and electric
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Guitars by Brenda Flores", 20,20);
	
	
	// Draw some coffee cups.
	
	GuitarShape large = new GuitarShape(100,50,150);
	electricGuitar smallCC = new electricGuitar(20,350,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	
    }       
}
