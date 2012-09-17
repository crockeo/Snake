package org.crockeo.snake;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/*
 * Class: Main
 * 
 * Purpose:
 *  The 'start' class of the Snake program.
 */

public class Main {
	public Main() {
		AppGameContainer app = null;
		
		try {
			app = new AppGameContainer(new StateSwitcher());

			app.setDisplayMode(640, 480, false);
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.setTitle("Snake");
			
			app.start();
		} catch (SlickException e) { e.printStackTrace(); }
	}
	
	public static void main(final String[] args) { new Main(); }
}