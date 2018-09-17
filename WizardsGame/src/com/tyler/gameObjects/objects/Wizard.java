package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;

import java.awt.*;

public class Wizard extends GameObject {

    // VARIABLES
    Handler handler;


    // CONSTRUCTOR
    public Wizard(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }


    // IMPLEMENTED METHODS
    public void tick() {
        x += velX;
        y += velY;

        if(handler.isUp()) velY = -5;
        else if (!handler.isDown()) velY = 0;

        if(handler.isDown()) velY = 5;
        else if (!handler.isUp()) velY = 0;

        if(handler.isRight()) velX = 5;
        else if (!handler.isLeft()) velX = 0;

        if(handler.isLeft()) velX = -5;
        else if (!handler.isRight()) velX = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 32, 48);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
}