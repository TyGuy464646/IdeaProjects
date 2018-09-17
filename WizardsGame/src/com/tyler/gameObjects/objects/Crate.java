package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;
import com.tyler.image.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Crate extends GameObject {

    // VARIABLES
    private BufferedImage crate_image = null;


    // CONSTRUCTOR
    public Crate(int x, int y, ID id, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);

        crate_image = spriteSheet.grabImage(6, 2, 32, 32);
    }


    // IMPLEMENTED METHODS
    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(crate_image, x, y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }


}
