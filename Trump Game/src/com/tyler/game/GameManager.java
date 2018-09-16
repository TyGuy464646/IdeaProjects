package com.tyler.game;

import java.util.ArrayList;

import com.tyler.engine.AbstractGame;
import com.tyler.engine.GameContainer;
import com.tyler.engine.Renderer;
import com.tyler.engine.gfx.Image;

public class GameManager extends AbstractGame {

	// VARIABLES
    public static final int TS = 16;

    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private Camera camera;

    private boolean[] collision;
    private int levelWidth, levelHeight;


	// CONSTRUCTOR
	public GameManager() {
        objects.add(new Player(6, 4));
        loadLevel("/levels/level1.png");
        camera = new Camera("player");
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
    public void init(GameContainer gc) {
        gc.getRenderer().setAmbientColor(-1);
    }

    public void update(GameContainer gc, float deltaTime) {
	    for(int i = 0; i < objects.size(); i++) {
            objects.get(i).update(gc, this, deltaTime);
            if(objects.get(i).isDead()) {
                objects.remove(i);
                i--;
            }
        }
        camera.update(gc, this, deltaTime);
	}

	public void render(GameContainer gc, Renderer r) {
        camera.render(r);

	    for(int y = 0; y < levelHeight; y++) {
            for(int x = 0; x < levelWidth; x++) {
                if(collision[x + y * levelWidth] == true) {
                    r.fillRect(x * TS, y * TS, TS, TS, 0xff0f0f0f);
                } else {
                    r.fillRect(x * TS, y * TS, TS, TS, 0xfff9f9f9);
                }
            }
        }

	    for(GameObject object : objects) {
            object.render(gc, r);
        }
	}

	public void loadLevel(String path) {
	    Image levelImage = new Image(path);

	    levelWidth = levelImage.getWidth();
	    levelHeight = levelImage.getHeight();
	    collision = new boolean[levelWidth * levelHeight];

	    for(int y = 0; y < levelImage.getHeight(); y++) {
	        for(int x = 0; x < levelImage.getWidth(); x++) {
	            if(levelImage.getPixels()[x + y * levelImage.getWidth()] == 0xff000000) {
	                collision[x + y * levelImage.getWidth()] = true;
                } else {
	                collision[x + y * levelImage.getWidth()] = false;
                }
            }
        }
    }

    public void addObject(GameObject object) {
	    objects.add(object);
    }
    public GameObject getObject(String tag) {
	    for(int i = 0; i < objects.size(); i++) {
	        if(objects.get(i).getTag().equals(tag)) {
	            return objects.get(i);
            }
        }

        return null;
    }

    public boolean getCollision(int x, int y) {
	    if(x < 0 || x >= levelWidth || y < 0 || y >= levelHeight) {
	        return true;
        }
	    return collision[x + y * levelWidth];
    }

}
