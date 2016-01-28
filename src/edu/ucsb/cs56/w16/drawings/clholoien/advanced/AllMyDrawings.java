package edu.ucsb.cs56.w16.drawings.clholoien.advanced;

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
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Man m1 = new Man(70, 160,50,130);
	g2.setColor(Color.BLUE); g2.draw(m1);
	
	// Make a man that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a man that's 4x as big (2x the original)
	// and moved over 200 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,200,200);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	// Draw two houses with Windows
	
	ManWithSmile mws1 = new ManWithSmile(50,350,150,150);
	ManWithSmile mws2 = new ManWithSmile(200,350,100,250);
	
	g2.draw(mws1);
	g2.setColor(new Color(255,0,0)); g2.draw(mws2);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Stick figuresby Carson Holoien", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Man large = new Man(100,200,225,150);
	Man smallCC = new Man(20,50,40,30);
	Man tallSkinny = new Man(20,150,20,40);
	Man shortFat = new Man(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Man m1 = new Man(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(m1);
	
	// Make a man that is colored black but is half the size, 
	// and moved over 150 pixels in x direction
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a house that's 4x as big (2x the original)
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
	
	// Draw two guys with smiles.
	
	ManWithSmile mws1 = new ManWithSmile(50,350,40,75);
	ManWithSmile mws2 = new ManWithSmile(200,350,200,100);
	
	g2.draw(mws1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape mws = ShapeTransforms.rotatedCopyOf(mws2, Math.PI);
	
	g2.draw(mws);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLUE); 
	g2.drawString("More stick figures, with one upsidedown. by Carosn Holoien", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A few happy guys hanging out.", 20,20);
	
	
	// Draw some coffee cups.
	
	ManWithSmile largeMan = new ManWithSmile(100,380,160,300);
	ManWithSmile smallMan = new ManWithSmile(20,200,20,80);
	
	g2.setColor(Color.CYAN);     g2.draw(largeMan);
	g2.setColor(Color.GREEN);   g2.draw(smallMan);
	
    }       
}
