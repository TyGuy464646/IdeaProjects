package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.image.Animation;
import com.tyler.image.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject {

    // VARIABLES
    private Handler handler;
    private Random r;
    private Animation animation;

    private int hp = 100;

    private BufferedImage[] enemy_image = new BufferedImage[3];


    // CONSTRUCTOR
    public Enemy(int x, int y, ID id, Handler handler, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        this.handler = handler;
        r = new Random();

        enemy_image[0] = spriteSheet.grabImage(4, 1, 32, 32);
        enemy_image[1] = spriteSheet.grabImage(5, 1, 32, 32);
        enemy_image[2] = spriteSheet.grabImage(6, 1, 32, 32);

        animation = new Animation(3, enemy_image);
    }


    // IMPLEMENTED METHODS
    public void tick() {
        x += velX;
        y += velY;

        // TODO: Better Random Movement
        int choose = r.nextInt(10);

        // Check bounds if hitting wall
        // TODO: Better Collision
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

        animation.runAnimation();
    }

    public void render(Graphics g) {
        if(velX == 0 && velY == 0) {
            g.drawImage(enemy_image[0], x, y, null);
        } else {
            animation.drawAnimation(g, x, y, 0);
        }

        // DRAW BOUNDS
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.GREEN);
        g2d.draw(getBoundsBig());
        g2d.draw(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    private Rectangle getBoundsBig() {
        return new Rectangle(x - 16, y - 16, 64, 64);
    }

}
