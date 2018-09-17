package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;

import java.awt.*;

public class Box extends GameObject {

    // CONSTRUCTOR
    public Box(int x, int y) {
        super(x, y);
    }


    // IMPLEMENTED METHODS
    public void tick() {
        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return null;
    }
}
