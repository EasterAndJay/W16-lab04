package edu.ucsb.cs56.w16.drawings.simon00.advanced;

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
    /** Draw a picture with a few copters and two attack helicopters. 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Copter h1 = new Copter(250,100,20,150,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
       
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
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
	
	// Draw two houses with Windows
	
	AttackHelicopter hw1 = new AttackHelicopter(250,100,20,150,50); 
	AttackHelicopter hw2 = new AttackHelicopter(200,35,50,200,90);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Two Helicopters and Two Attack Helicopters", 20,20);
    }
    
    
    /** Draw a lot of helicopters of different sizes. 
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some helicopters
	
	Copter large = new Copter(100,50,30,150,60);
	Copter smallCC = new Copter(20,5,5,30,20);
	Copter tallSkinny = new Copter(200,150,20,100,50);
	Copter shortFat = new Copter(400,250,20,40,50);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	AttackHelicopter h1 = new AttackHelicopter(100,250,20,90,80);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
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
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Large number of helicopters. Different sizes and ratios of length, width, and rotor radius. ", 20,20);
	
    }
    
    /** Draw a different picture with rotated helicopters
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	g2.drawString("Helicopters and attack helicopters going in different directions.", 20,20);
	
	// We'll draw this with a thicker stroke
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

        // for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
        // #002FA7 is "International Klein Blue" according to Wikipedia
        // In HTML we use #, but in Java (and C/C++) its 0x

	Copter h1 = new Copter(400,70,30,90,100); 
	Shape h1rotate = ShapeTransforms.rotatedCopyOf(h1, -Math.PI/4.0); 
	g2.setColor(Color.BLACK); g2.draw(h1rotate); 
	
	Copter h2 = new Copter(50,50,50,100,50); 
	g2.setColor(Color.MAGENTA); g2.draw(h2); 

	
        Stroke orig=g2.getStroke();
        g2.setStroke(thick);
        g2.setColor(new Color(0x002FA7));
        g2.draw(h2);


        AttackHelicopter hw1 = new AttackHelicopter(200,350,40,75,80);
        AttackHelicopter hw2 = new AttackHelicopter(150,200,30,100,70);

        g2.setColor(new Color(0x99ffcc));

        // Rotate the second house 45 degrees around its center.
        Shape hw1rotate = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
	g2.draw(hw1rotate); 
	Shape hw2rotate = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/8.0); 
        g2.draw(hw1rotate);

    }       
}
