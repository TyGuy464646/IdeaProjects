package com.tyler.engine;

public abstract class AbstractGame {

	public abstract void init(GameContainer gc);
	public abstract void update(GameContainer gc, float deltaTime);
	public abstract void render(GameContainer gc, Renderer r);
	
}
