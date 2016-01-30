package edu.ucsb.cs56.w16.drawings.stefanagloginic.advanced;

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
 * @author Stefana Gloginic
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few beautiful laptops 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Laptop h1 = new Laptop(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,160,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
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
	
	// Draw two laptops
	
	Laptop hw1 = new Laptop(50,370,20,75);
	Laptop hw2 = new Laptop(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few laptops by Stefana Gloginic", 20,20);
    }
    
    /*
    /** Draw a picture with a few houses and coffee cups
     */
    
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some laptops.
	
	Laptop large = new Laptop(100,50,225,150);
        Laptop smallCC = new Laptop(20,50,40,30);
	Laptop tallSkinny = new Laptop(20,150,20,40);
	Laptop shortFat = new Laptop(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Laptop h1 = new Laptop(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black laptop that's half the size, 
	// and moved over 200 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,200,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a train that's 4x as big (2x the original)
	// and moved over 170 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,170,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFE6F5E)); 
	g2.draw(h2); 
    
	// Draw two laptops!
	
	Laptop hw1 = new Laptop(50,350,40,75);
        Laptop hw2 = new Laptop(200,350,200,100);
	//putting the color to amaranth red!
	g2.draw(hw1);
	g2.setColor(new Color(0xACE5EE)); 
	
	// Rotatating the laptop 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
	
	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of laptops and more laptops by Stefana Gloginic", 20,20);
    }
	

    /** Draw a different picture with a few laptops and guess what, more laptops!
     */
   
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Laptops by Stefana Gloginic", 20,20);
	
	
	// Draw some moooree laptops!
	
	Laptop large = new Laptop(100,50,225,150);
	Laptop smallCC = new Laptop(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	
	}
}
