package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.image.SpriteSheet;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Block extends GameObject {

    // Variables
    public boolean disableCollisionUp = false;
    public boolean disableCollisionLeft = false;
    public boolean disableCollisionBottom = false;
    public boolean disableCollisionRight = false;

    // Initialize Screens
    private GameScreen gameScreen;
    private SpriteSheet spriteSheet;

    // Initialize Block
    private Image image = new Image("/Sprites/Tiles/spriteSheet.png");
    private ImageView dirt;


    // Constructor
    public Block(GameScreen gameScreen, float x, float y, int width, int height, ID id) {
        super(x, y, width, height, id);
        this.gameScreen = gameScreen;

        spriteSheet = new SpriteSheet(image);
        dirt = spriteSheet.grabImage(1, 1, width, height);

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
