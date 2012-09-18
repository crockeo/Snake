package org.crockeo.snake.game.components.snake;

import org.crockeo.snake.game.World;
import org.crockeo.snake.game.components.Tile;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

/*
 * Class: Snake
 * 
 * Purpose:
 *  Snake container class
 */

public class Snake {
	private SnakeHead head;
	private ArrayList<SnakeBody> body;
	
	public Snake(int x, int y) {
		head = new SnakeHead(x, y);
		body.add(new SnakeBody(x, y + 1, head));
	}
	
	// Updating the snake
	public boolean update(World w) {
		head.move();
		if ((head.getX() < 0 || head.getX() > w.getWidth() - 1)
			|| (head.getY() < 0 || head.getY() > w.getHeight()))
			return true; // Player has lost
		
		for (SnakeBody b: body)
			if (head.on(b))
				return true; // Player has lost
		
		for (SnakeBody b: body)
			b.move();
		
		return false; // Player has NOT lost! :D
	}
	
	// Drawing the snake
	public void render(Graphics g, World w) {
		head.render(g, w);
		for (SnakeBody b: body)
			b.render(g, w);
	}
	
	// Accessors
	public SnakeHead getHead() { return head; }
	public SnakeBody[] getBody() { return (SnakeBody[])body.toArray(); }
	public SnakeBody getBodyPart(int index) { return body.get(index); }
	
	// Mutators
	public Tile getTile(int x, int y) {
		if (head.getX() == x && head.getY() == y)
			return head;
		
		for (SnakeBody b: body)
			if (b.getX() == x && b.getY() == y)
				return b;
		
		return null;
	}
	
	public void setPosition(int x, int y) {
		int dX = head.getX() - x;
		int dY = head.getY() - y;
		
		head.move(dX, dY);
		for (SnakeBody b: body)
			b.move(dX, dY);
	}
	
	public void setX(int x) { setPosition(x, head.getY()); }
	public void setY(int y) { setPosition(head.getX(), y); }
}
