package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.main.Game;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends GameObject {

    // Initialize Classes
    private Game game;

    // Initialize Screens
    private GameScreen gameScreen;

    // Initialize Block
    private Rectangle block;

    // Initialize Block Variables
    public Color blockColor = Color.GREY;


    public Block(Game game, GameScreen gameScreen, int x, int y, int width, int height, ID id) {
        super(x, y, width, height, id);
        this.game = game;
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
