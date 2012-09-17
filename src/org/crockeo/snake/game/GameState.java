package org.crockeo.snake.game;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/*
 * Class: GameState
 * 
 * Purpose:
 *  The game state.
 */

public class GameState extends BasicGameState {
	private World world;
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		world = new World(9, 9, gc);
		world.init();
	}
	
	public void update(GameContainer gc, StateBasedGame sbg,
			 		   int delta)
			throws SlickException { world.update(); }
	
	public void render(GameContainer gc, StateBasedGame sbg,
					 Graphics g)
			throws SlickException { world.render(g); }
	
	
	public int getID() { return 1; }
}
