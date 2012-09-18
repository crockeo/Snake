package org.crockeo.snake.timing;

/*
 * Class: Timer
 * 
 * Purpose:
 *  General timing implementation.
 */

public class Timer {
	private volatile long lastTime;
	private volatile long currTime;
	private boolean running;
	
	public Timer() {
		start();
	}
	
	// Starting and stopping
	public void start() {
		reset();
		running = true;
		
		Thread t = new Thread(new TimerLoop());
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
	}
	
	public void stop() { running = false; }
	
	// Resetting the timer to zero
	public void reset() {
		lastTime = System.currentTimeMillis();
		currTime = System.currentTimeMillis();
	}
	
	// Accessors
	public long getElapsedTimeInMillis() { return currTime - lastTime; }
	public double getElapsedTimeInSeconds() { return getElapsedTimeInMillis() / 1000.0; }
	
	// Timer Loop
	private class TimerLoop
			implements Runnable {
		public void run() {
			while (running) {
				currTime = System.currentTimeMillis();
			}
		}
	}
}
