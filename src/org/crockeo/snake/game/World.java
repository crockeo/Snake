package org.crockeo.snake.game;

import org.crockeo.snake.game.components.snake.Snake;
import org.crockeo.snake.game.components.Tile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

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
	public World(int width, int height,
				 GameContainer gc) {
		this.width = width;
		this.height = height;
		
		tileWidth = gc.getWidth() / (float)width;
		tileHeight = gc.getHeight() / (float)height;
	}
	
	// Game functions
	public void init() {
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		snake.render(g);
		food.render(g, this);
	}
	
	

	// Accessors
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public float getTileWidth() { return tileWidth; }
	public float getTileHeight() { return tileHeight; }
}
