package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {

    // VARIABLES
    Handler handler;
    Random r = new Random();
    int choose = 0;
    int hp = 100;


    // CONSTRUCTOR
    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }


    // IMPLEMENTED METHODS
    public void tick() {
        x += velX;
        y += velY;

        choose = r.nextInt(10);

        // Check bounds if hitting wall
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Block) {
                if(getBoundsBig().intersects(tempObject.getBounds())) {
                    x += (velX * 5) * -1;
                    y += (velY * 5) * -1;
                    velX *= -1;
                    velY *= -1;
                } else if(choose == 0) { // if the random number is 0, switch direction
                    velX = (r.nextInt(4 - -4) + -4);
                    velY = (r.nextInt(4 - -4) + -4);
                }
            }

            // Killing them
            if(tempObject.getId() == ID.Bullet) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hp -= 50;
                    handler.removeObject(tempObject);
                }
            }
        }

        if(hp <= 0)
            handler.removeObject(this);
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 32, 32);

        // DRAW BOUNDS
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.GREEN);
        g2d.draw(getBoundsBig());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public Rectangle getBoundsBig() {
        return new Rectangle(x - 16, y - 16, 64, 64);
    }

}
