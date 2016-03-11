package edu.ucsb.cs56.w16.drawings.athielk.advanced;

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
 * @author Alex Thielk
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Mountain m1 = new Mountain(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(m1);
	
	// Make a black mountain that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a mountain that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	// Draw Two snowCapped mountains
	
	SnowCappedMountain scm1 = new SnowCappedMountain (50,350,80,75);
	SnowCappedMountain scm2 = new SnowCappedMountain (200,350,200,100);
	
	g2.draw(scm1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(scm2);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few mountains by Alex Thielk", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	SnowCappedMountain large = new SnowCappedMountain(100,250,225,150);
	SnowCappedMountain  small = new SnowCappedMountain(20,50,40,30);
	Mountain tallSkinny = new Mountain(20,150,20,40);
	Mountain shortFat = new Mountain(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Mountain m1 = new Mountain(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(m1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a mountain that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	// Draw 1 Snow capped mountain and create one to rotate
	
	SnowCappedMountain scm1 = new SnowCappedMountain (50,350,40,75);
	SnowCappedMountain  scm2 = new SnowCappedMountain(200,350,200,100);
	
	g2.draw(scm1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second mountain 45 degrees around its center 
	// because we can.
	Shape scm3 = ShapeTransforms.rotatedCopyOf(scm2, Math.PI/4.0);
	
	g2.draw(scm3);
	
	// mountains and snowcapped mountains, with rotation by Alex Thielk
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString
	    ("Mountains and SnowCapped mountains rotated by Alex Thielk", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("mountain chain", 20,20);
	
	
	// Draw Mountains.
	
	SnowCappedMountain large = new SnowCappedMountain(100,400,225,150);
	Mountain small = new Mountain(0,400,100,100);
	Mountain medium = new Mountain(325,400,175,125);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);   g2.draw(medium);

    }       
}
