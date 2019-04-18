package com.tyler.entities;

import com.tyler.main.Game;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block {

    Game game;

    Rectangle block;

    public int blockWidth, blockHeight;
    public Color blockColor;
    public int blockX, blockY;

    public Block(Game game, int x, int y, int width, int height, Color color) {
        this.game = game;
        this.blockX = x;
        this.blockY = y;
        this.blockWidth = width;
        this.blockHeight = height;
        this.blockColor = color;

        block = new Rectangle(width, height, color);
        game.spritePane.getChildren().add(block);
    }

    public void tick() {
        block.setX(blockX);
        block.setY(blockY);
    }

}
