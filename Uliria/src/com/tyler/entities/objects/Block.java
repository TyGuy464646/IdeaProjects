package com.tyler.entities.objects;

import com.tyler.entities.GameObject;
import com.tyler.entities.Handler;
import com.tyler.entities.ID;
import com.tyler.main.Game;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends GameObject {

    // Initialize Classes
    Game game;

    // Initialize Block
    Rectangle block;

    // Initialize Block Variables
    public Color blockColor = Color.GREY;


    public Block(Game game, int x, int y, int width, int height, ID id) {
        super(x, y, width, height, id);
        this.game = game;

        block = new Rectangle(width, height, blockColor);
        game.gameSpritePane.getChildren().add(block);
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
