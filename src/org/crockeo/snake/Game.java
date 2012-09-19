package org.crockeo.snake;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Graphics;

import org.crockeo.snake.game.World;

/*
 * Class: Game
 * 
 * Purpose:
 *  Main game class
 */

public class Game extends BasicGame {
	private World w;
	
	public Game() { super("Snake"); }
	
	public void init(GameContainer gc)
			throws SlickException {
		w = new World(20, 20, gc);
		w.init();
	}
	
	public void update(GameContainer gc, int delta)
			throws SlickException { w.update(gc.getInput()); }
	
	public void render(GameContainer gc, Graphics g)
			throws SlickException { w.render(g); }
}
