package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.image.SpriteSheet;

import java.awt.*;

public class Bullet extends GameObject {

    // VARIABLES
    private Handler handler;
    private float scale;
    private int shotSpeed = 10;


    // CONSTRUCTOR
    public Bullet(int x, int y, ID id, Handler handler, int mouseX, int mouseY, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        this.handler = handler;

        scale = (float) ((shotSpeed) / (Math.sqrt(((mouseX - x) * (mouseX - x)) + ((mouseY - y) * (mouseY - y)))));

        velX = (mouseX - x) * scale;
        velY = (mouseY - y) * scale;

    }


    // IMPLEMENTED METHODS
    public void tick() {
        x += velX;
        y += velY;

        // Collision
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Block) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(this);
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 8, 8);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 8, 8);
    }
}
