package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;
import com.tyler.image.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends GameObject {

    // VARIABLES
    private BufferedImage block_image = null;


    // CONSTRUCTOR
    public Block(int x, int y, ID id, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);

        block_image = spriteSheet.grabImage(5, 2, 32, 32);
    }


    // IMPLEMENTED METHODS
    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(block_image, x, y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
