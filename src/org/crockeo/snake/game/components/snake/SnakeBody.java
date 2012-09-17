package org.crockeo.snake.game.components.snake;

import org.crockeo.snake.game.components.Tiles;
import org.crockeo.snake.game.components.Tile;

/*
 * Class: SnakeBody
 * 
 * Purpose:
 *  The body of the snake
 */

public class SnakeBody extends Tile {
	private Tile nextPart;
	
	public SnakeBody(int x, int y,
					 Tile nextPart) {
		super(Tiles.SNAKE_BODY, x, y);
		this.nextPart = nextPart;
	}
	
	public void move() { moveTo(nextPart.getLastX(), nextPart.getLastY()); }
	
	// Accessors
	public Tile getNextPart() { return nextPart; }
	
	// Mutatrs
	public void setNextPart(Tile nextPart) { this.nextPart = nextPart; }
}
