package edu.ucsb.cs56.w16.drawings.natashalee.advanced;

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
    /** Draw a picture with a few candies
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Candy c1 = new Candy(10,50,100);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black candy that's half the size,
	// and moved over 150 pixels in x direction
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a candy that's 4x as big (2x the original)
	// and moved over 120 more pixels to right and 200 pixels down.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,120,200);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2);

	// Draw two candies with stick(lollipops)
	
	CandyWithStick lp1 = new CandyWithStick(50,180,60);
	CandyWithStick lp2 = new CandyWithStick(500,40,100);

	g2.draw(lp1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(lp1);
		
	g2.draw(lp2);
	g2.setColor(Color.RED); g2.draw(lp2);
		

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few candies by Natasha Lee", 20,20);
    }
	
    
    /** Draw a picture with a few lollipops
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some lollipops.
	
		CandyWithStick large = new CandyWithStick (160,50,250);
		CandyWithStick small = new CandyWithStick (20,50,40);
		CandyWithStick medium = new CandyWithStick (70,150,110);
		CandyWithStick  loli= new CandyWithStick (510,90,80);
	
		g2.setColor(Color.RED);     g2.draw(large);
		g2.setColor(Color.GREEN);   g2.draw(small);
		g2.setColor(Color.BLUE);    g2.draw(medium);
		g2.setColor(Color.MAGENTA); g2.draw(loli);
	
		Candy c1 = new Candy(440,140,50);
		g2.setColor(Color.YELLOW); g2.draw(c1);
	
		// Make a black candy that's half the size,
		// and moved over 150 pixels in x direction
		Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
		c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
		g2.setColor(Color.BLACK); g2.draw(c2);
		
		// Here's a candy that's 4x as big (2x the original)
		// and moved over 150 more pixels to right.
		c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
		c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
		
		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
		
		// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors

		
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x0D98BA));
		g2.draw(c2);
		
		// Draw two candies with sticks, aka lollipops
		
		CandyWithStick lol1 = new CandyWithStick(50,50,70);
		CandyWithStick lol2 = new CandyWithStick(320,250,120);
		
		g2.draw(lol1);
		g2.setColor(new Color(0x014421));

		// Rotate the second lollipop 45 degrees around its center.
		Shape lol3 = ShapeTransforms.rotatedCopyOf(lol2, Math.PI/4.0);
		
		g2.draw(lol3);
		
		// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
		
		g2.setStroke(orig);
		g2.setColor(Color.BLACK);
		g2.drawString("A Candies and Lollipops by Natasha Lee", 20,20);
	}
	
	
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of winter lollipops by Natasha Lee", 20,20);
	
	
	// Draw some blue colored lollipops
	
		CandyWithStick lol1 = new CandyWithStick(350,20,225);
		CandyWithStick lol2 = new CandyWithStick(100,50,40);
		CandyWithStick lol3 = new CandyWithStick(200,100,150);
		CandyWithStick lol4 = new CandyWithStick(30,150,80);
		CandyWithStick lol5 = new CandyWithStick(20,250,50);
		CandyWithStick lol6 = new CandyWithStick(80,300,70);
		CandyWithStick lol7 = new CandyWithStick(140,230,100);
		Shape lol8 = ShapeTransforms.rotatedCopyOf(lol7, Math.PI/4.0);
		
		
		
		g2.setColor(new Color(0x5DADEC));   g2.draw(lol1);
		g2.setColor(new Color(0xACE5EE));   g2.draw(lol2);
		g2.setColor(new Color(0x0247FE));   g2.draw(lol3);
		g2.setColor(new Color(0x08E8DE));   g2.draw(lol4);
		g2.setColor(new Color(0x0070FF));   g2.draw(lol5);
		g2.setColor(new Color(0xE7FEFF));
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
		g2.setStroke(thick);  g2.draw(lol6);
		g2.setColor(new Color(0xB2FFFF));   g2.draw(lol8);
		
	
    }       
}
