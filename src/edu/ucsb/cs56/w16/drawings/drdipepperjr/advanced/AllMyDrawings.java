package edu.ucsb.cs56.w16.drawings.drdipepperjr.advanced;

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

	Cake c1 = new Cake(100, 100, 70, 40, 30);
	g2.setColor(Color.BLACK); g2.draw(c1);
	
	// Make a red cake that's 3/4 the size, 
	// and moved over 150 pixels in x and y direction
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1, 0.75, 0.75);
	c2 = ShapeTransforms.translatedCopyOf(c1, 150, 150);
	g2.setColor(Color.RED); g2.draw(c2);
	
	
	// Here's a cake that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #A7F432 is "Green Lizard" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xA7F432)); 
	g2.draw(c2); 
	
	// Draw two Birthday Cakes
	
	BirthdayCake bc1 = new BirthdayCake(50,350,100,40,50);
	BirthdayCake bc2 = new BirthdayCake(200,350,200,100,75);
	
	g2.draw(bc1);
	g2.setColor(new Color(0xFF1DCE)); g2.draw(bc2);
	
     	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.GREEN); 
	g2.drawString("CakeDay by Domenic DiPeppe", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some regular cakes.
	
	Cake largeCake = new Cake(150,75,300,200,150);
	Cake smallCake = new Cake(20,50,20,5,20);
	Cake circle = new Cake(20,150,50,50,30);
	Cake shortFat = new Cake(20,250,200,10,20);
	
	g2.setColor(Color.YELLOW);  g2.draw(largeCake);
	g2.setColor(Color.RED);     g2.draw(smallCake);
	g2.setColor(Color.BLUE);    g2.draw(circle);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Cake c1 = new Cake(300,250,50,25,20);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a green cake that's half the size, 
	// and moved over 100 pixels in x direction
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,100,0);
	g2.setColor(Color.GREEN); g2.draw(c2);
	
	// Here's a house that's 3x as big (1.5x the original)
	// and moved over 100 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,3,3);
	c2 = ShapeTransforms.translatedCopyOf(c2,100,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two birthday cakes
	
	BirthdayCake bc1 = new BirthdayCake(200,350,75,40,30);
	BirthdayCake bc2  = new BirthdayCake(300,375,20,10,50);
	
	g2.draw(bc1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape bc3 = ShapeTransforms.rotatedCopyOf(bc2, Math.PI/4.0);
	
	g2.draw(bc3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Cake Party, by Domenic Dipeppe", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Synchronized Cakes, by Domenic DiPeppe", 20,20);

	BirthdayCake greatLeader = new BirthdayCake(170,190,300,50,40);
	
	BirthdayCake bc1 = new BirthdayCake(280,400,75,40,30);

	Shape bc2 = ShapeTransforms.translatedCopyOf(bc1,-160,-100);
	Shape bc3 = ShapeTransforms.rotatedCopyOf(bc2, Math.PI/4.0);
	
	Shape bc4 = ShapeTransforms.translatedCopyOf(bc3,-100,-100);
        Shape bc5 = ShapeTransforms.rotatedCopyOf(bc4, Math.PI/4.0);

	Shape bc6 = ShapeTransforms.translatedCopyOf(bc5,100,-100);
        Shape bc7 = ShapeTransforms.rotatedCopyOf(bc6, Math.PI/4.0);

	Shape bc8 = ShapeTransforms.translatedCopyOf(bc7,160,-100);
        Shape bc9 = ShapeTransforms.rotatedCopyOf(bc8, Math.PI/4.0);

	Shape bc10 = ShapeTransforms.translatedCopyOf(bc9,160,100);
        Shape bc11 = ShapeTransforms.rotatedCopyOf(bc10, Math.PI/4.0);

	Shape bc12 = ShapeTransforms.translatedCopyOf(bc11,100,100);
        Shape bc13 = ShapeTransforms.rotatedCopyOf(bc12, Math.PI/4.0);

	Shape bc14 = ShapeTransforms.translatedCopyOf(bc13,-100,100);
        Shape bc15 = ShapeTransforms.rotatedCopyOf(bc14, Math.PI/4.0);

	
	g2.setColor(Color.RED);     g2.draw(bc1);
	g2.setColor(new Color(0xff9900));   g2.draw(bc3);
	g2.setColor(Color.YELLOW);   g2.draw(bc5);
	g2.setColor(Color.GREEN);   g2.draw(bc7);
        g2.setColor(Color.BLUE);   g2.draw(bc9);
	g2.setColor(new Color(0xcc00cc));   g2.draw(bc11);
        g2.setColor(new Color(0xff3399));   g2.draw(bc13);
	g2.setColor(new Color(0x663300));   g2.draw(bc15);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig=g2.getStroke();
        g2.setStroke(thick);
        g2.setColor(Color.BLACK);
        g2.draw(greatLeader);

    }       
}
