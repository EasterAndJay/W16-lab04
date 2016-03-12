package edu.ucsb.cs56.w16.drawings.angel00.advanced;

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
 * @author Angel Rivera
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few Trains 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Train t1 = new Train(120,200,45,75);
	g2.setColor(Color.BLUE); g2.draw(t1);
	
	// Make a black train that's 0.2 the size, 
	// and moved over 150 pixels in x direction
	
	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.2,0.2);
	t2 = ShapeTransforms.translatedCopyOf(t2,120,3);
	g2.setColor(Color.GREEN); g2.draw(t2);
	
	// Here's a train that's 6x as big (600% the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,6,6);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x0eafa5)); 
	g2.draw(t2); 
	
	// Draw two trains
	
	Train hw1 = new Train(75,300,20,125);
	Train  hw2 = new Train(210,354,56,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8f0923)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.CYAN); 
	g2.drawString("A million trains by Angel Rivera ", 20,20);
    }
    
    
    /** Draw a picture with a few trains and more trains
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some trains
	
	Train large = new Train (100,50,225,150);
	Train smallCC = new Train(20,50,40,30);
	Train tallSkinny = new Train(20,150,20,40);
	Train shortFat = new Train(20,250,40,20);
	
	g2.setColor(Color.ORANGE);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Train  h1 = new Train(120,250,55,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black train that is 1.5 times bigger
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,1.5,1.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,45,100);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a train that's .5 as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,.5,.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two trains
	
	Train hw1 = new Train(24,350,40,75);
	Train hw2 = new Train(210,350,220,130);
	
	g2.draw(hw1);
	g2.setColor(new Color(0xCAE00D)); 
	
	// Rotate the second train 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/2.0);
	
	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of trains by Angel Rivera", 20,20);
    }
    
    /** Draw a different picture with a Trains
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A Trains by Angel Rivera", 20,20);
	
	
	// Draw some MORE TRAINS!!!!!!!
	
	Train large = new Train(123,54,220,153);
	Train  smallCC = new Train(25,55,49,35);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	
    }       
}
