package edu.ucsb.cs56.w16.drawings.kctoombs.advanced;

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
	
	Speaker s1 = new Speaker(100,250,75,100);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few speakers by Kenneth Toombs", 20,20);
    }
  
    
    /** Draw a picture with a few houses and coffee cups
     */ 
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some portable speakers.
	
	portableSpeaker large = new portableSpeaker(100,250,75,100);
	portableSpeaker small = new portableSpeaker(20,50,25,33);
		
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
  
	
	Speaker s1 = new Speaker(350,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a speaker that's half the size, 
	// and moved over 150 pixels in x direction
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a speaker that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	
	portableSpeaker pS1 = new portableSpeaker(50,350,75,100);
	portableSpeaker pS2 = new portableSpeaker(200,100,100,133);
	
	g2.draw(pS1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second speaker 45 degrees around its center.
	Shape pS3 = ShapeTransforms.rotatedCopyOf(pS2, Math.PI/4.0);
	Shape pS4 = ShapeTransforms.rotatedCopyOf(pS2, Math.PI);
	pS4 = ShapeTransforms.translatedCopyOf(s2,150,50);
	g2.draw(pS3);
	g2.draw(pS4);
	//SIGN AND LABEL THE DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of speakers and portable speakers by Kenneth Toombs", 20,20);
    }
    
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A few portable speakers, some upside down, by Kenneth Toombs", 20,20);
	
	
	// Draw some coffee cups.
	
	portableSpeaker pS1 = new portableSpeaker(50,50,75,100);
	portableSpeaker pS2 = new portableSpeaker(200,200,75,100);
	portableSpeaker pS3 = new portableSpeaker(350,350,75,100);
	g2.setColor(Color.RED);     g2.draw(pS1);
	g2.setColor(Color.GREEN);   g2.draw(pS2);


        Shape pS4 = ShapeTransforms.rotatedCopyOf(pS3, Math.PI);
	g2.setColor(Color.CYAN); g2.draw(pS4);	

	Shape pS5 = ShapeTransforms.rotatedCopyOf(pS1, Math.PI);
	pS5 = ShapeTransforms.translatedCopyOf(pS1,500,0);
	g2.setColor(Color.BLACK); g2.draw(pS5);
    }
}




