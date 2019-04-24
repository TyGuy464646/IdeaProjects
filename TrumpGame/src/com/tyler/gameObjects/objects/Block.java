package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;
import com.tyler.gameState.screens.GameScreen;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends GameObject {

    // Initialize Screens
    private GameScreen gameScreen;

    // Initialize Block
    private Rectangle block;

    // Initialize Block Variables
    public Color blockColor = Color.GREY;


    public Block(GameScreen gameScreen, float x, float y, int width, int height, ID id) {
        super(x, y, width, height, id);
        this.gameScreen = gameScreen;

        block = new Rectangle(width, height, blockColor);
        gameScreen.addGameSpritePane(block);
    }

    public void tick() {
        block.setX(x);
        block.setY(y);
    }
    public void inputTick () {

    }
    public void physicsTick () {

    }

}
