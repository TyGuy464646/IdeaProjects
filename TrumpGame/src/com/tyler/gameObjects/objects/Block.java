package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.handlers.Textures;
import com.tyler.main.Game;
import javafx.scene.image.ImageView;

public class Block extends GameObject {

    // Import Classes
    private Game game;

    // Variables
    public boolean disableCollisionUp = false;
    public boolean disableCollisionLeft = false;
    public boolean disableCollisionBottom = false;
    public boolean disableCollisionRight = false;

    // Initialize Block
    private ImageView dirt = Textures.blockSprite.grabImage(4, 2, width, height);


    // Constructor
    public Block (Game game, GameScreen gameScreen, float x, float y, int width, int height, ID id) {
        super(x, y, width, height, id);
        this.game = game;

        gameScreen.addGameSpritePane(dirt);
    }

    public void tick() {
        dirt.setX(x - game.camera.x);
        dirt.setY(y - game.camera.y);
    }
    public void inputTick () {

    }
    public void physicsTick () {

    }

}
