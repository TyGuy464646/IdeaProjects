package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;

import java.awt.*;

public class Box extends GameObject {

    // CONSTRUCTOR
    public Box(int x, int y, ID id) {
        super(x, y, id);
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
