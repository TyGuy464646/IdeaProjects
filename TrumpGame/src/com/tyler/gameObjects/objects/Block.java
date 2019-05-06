package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;
import com.tyler.gameState.GameStateManager;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.handlers.Textures;
import com.tyler.image.SpriteSheet;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends GameObject {

    // Variables
    public boolean disableCollisionUp = false;
    public boolean disableCollisionLeft = false;
    public boolean disableCollisionBottom = false;
    public boolean disableCollisionRight = false;

    // Initialize Screens
    private GameScreen gameScreen;

    // Initialize Block
    private ImageView dirt = textures.blockSprite.grabImage(4, 2, width, height);
    private Rectangle rectangle;


    // Constructor
    public Block(GameScreen gameScreen, Textures textures, float x, float y, int width, int height, ID id) {
        super(x, y, width, height, id, textures);
        this.gameScreen = gameScreen;

        gameScreen.addGameSpritePane(dirt);
    }

    public void tick() {
        dirt.setX(x);
        dirt.setY(y);
    }
    public void inputTick () {

    }
    public void physicsTick () {

    }

}
