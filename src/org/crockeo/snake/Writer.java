package org.crockeo.snake;

import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;

import java.awt.Font;

/*
 * Class: Writer
 * 
 * Purpose:
 *  Writing text to the screen
 */

public class Writer {
	private final String fontName = "Verdana";
	
	private UnicodeFont font;
	private Font awtFont;
	
	private Writer() {
		awtFont = new Font(fontName, 60, Font.PLAIN);
	}
	
	// Changing the current font
	public void changeFontSize(int size) {
		awtFont = new Font(fontName, size, Font.PLAIN);
		font = new UnicodeFont(awtFont, size, false, false);
		
		// UnicodeFont stuffs
		font.addAsciiGlyphs();
		font.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
		try {
			font.loadGlyphs();
		} catch (SlickException e) { e.printStackTrace(); }
	}
	
	// Writing onto the screen
	public void write(float x, float y, String str) { font.drawString(x, y, str); }
	public void writeCentered(float x, float y, String str) { write(x - (font.getWidth(str) / 2), y - (font.getHeight(str) / 2), str); }
	
	// Singleton
	public final Object clone() { return null; }
	
	private static Writer instance;
	public static Writer instance() {
		if (instance == null)
			instance = new Writer();
		return instance;
	}
}
