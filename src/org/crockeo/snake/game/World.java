package org.crockeo.snake.game;

import org.crockeo.snake.game.components.snake.Snake;
import org.crockeo.snake.game.components.Tiles;
import org.crockeo.snake.game.components.Tile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;

import java.util.Random;

/*
 * Class: World
 * 
 * Purpose:
 *  Cleaner way to interact with all world objects
 */

public class World {
	private Snake snake;
	private Tile food;
	
	private int width, height;
	private float tileWidth, tileHeight;
	private float screenWidth, screenHeight;
	public World(int width, int height,
				 GameContainer gc) {
		this.width = width;
		this.height = height;
		
		tileWidth = gc.getWidth() / (float)width;
		tileHeight = gc.getHeight() / (float)height;
		
		screenWidth = gc.getWidth();
		screenHeight = gc.getHeight();
	}
	
	// Game functions
	public void init() {
		snake = new Snake(width / 2, height / 2);
		food = generateFood();
	}
	
	public void update() { snake.update(this); }
	
	public void render(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, screenWidth, screenHeight);
		
		snake.render(g, this);
		food.render(g, this);
	}
	
	
	// TODO: Implement food generation
	private Tile generateFood() {
		Tile t;
		
		Random rand = new Random();
		
		int x = rand.nextInt(width);
		int y = rand.nextInt(height);
		
		while (snake.getTile(x, y) != null) {
			x = rand.nextInt(width);
			y = rand.nextInt(height);
		}
		
		t = new Tile(Tiles.FOOD, x, y);
		return t;
	}

	// Accessors
	public Snake getSnake() { return snake; }
	public Tile getFood() { return food; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public float getTileWidth() { return tileWidth; }
	public float getTileHeight() { return tileHeight; }
}
