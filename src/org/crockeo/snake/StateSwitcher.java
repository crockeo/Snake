package org.crockeo.snake;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;

import org.crockeo.snake.menu.MenuState;
import org.crockeo.snake.game.GameState;

/*
 * Class: StateSwitcher
 * 
 * Purpose:
 *  Switching between given states
 */

public class StateSwitcher extends StateBasedGame {
	public StateSwitcher() { super("Snake"); }
	
	public void initStatesList(GameContainer gc) {
//		addState(new MenuState());
		addState(new GameState());
	}
}
