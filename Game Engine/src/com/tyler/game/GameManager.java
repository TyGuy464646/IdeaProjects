package com.tyler.game;

import java.awt.event.KeyEvent;

import com.tyler.engine.AbstractGame;
import com.tyler.engine.GameContainer;
import com.tyler.engine.Renderer;
import com.tyler.engine.audio.SoundClip;
import com.tyler.engine.gfx.Image;
import com.tyler.engine.gfx.ImageTile;
import com.tyler.engine.gfx.Light;

public class GameManager extends AbstractGame {

	// VARIABLES
	private Image image;
	private ImageTile image2;
	private Light light;


	// CONSTRUCTOR
	public GameManager() {
		image = new Image("/test.png");
		image.setLightBlock(Light.FULL);
		image.setAlpha(true);
		image2 = new ImageTile("/test2.png", 16, 16);
		image2.setAlpha(true);
		light = new Light(100, 0xff00ffff);
	}


	// MAIN METHOD
	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new GameManager());
		gc.setWidth(320);
		gc.setHeight(240);
		gc.setScale(3f);
		gc.start();
	}


	// METHODS
	float temp = 0;

	public void update(GameContainer gc, float deltaTime) {

	}

	public void render(GameContainer gc, Renderer r) {
	    r.setzDepth(0);
	    r.drawImage(image2, 0, 0);
	    r.drawImage(image, 100, 100);

        r.drawLight(light, gc.getInput().getMouseX(), gc.getInput().getMouseY());
	}

	public void reset() {

	}

}
