package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.ID;

import java.awt.*;

public class Block extends GameObject {

    // CONSTRUCTOR
    public Block(int x, int y, ID id) {
        super(x, y, id);
    }


    // IMPLEMENTED METHODS
    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 32, 32);

        // DRAW BOUNDS
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.GREEN);
        g2d.draw(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
