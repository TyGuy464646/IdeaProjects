package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.image.Animation;
import com.tyler.image.SpriteSheet;
import com.tyler.main.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wizard extends GameObject {

    // VARIABLES
    private Handler handler;
    private Main game;
    private Animation animation;

    private BufferedImage[] wizard_image = new BufferedImage[3];


    // CONSTRUCTOR
    public Wizard(int x, int y, ID id, Handler handler, Main game, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        this.handler = handler;
        this.game = game;

        wizard_image[0] = spriteSheet.grabImage(1, 1, 32, 48);
        wizard_image[1] = spriteSheet.grabImage(2, 1, 32, 48);
        wizard_image[2] = spriteSheet.grabImage(3, 1, 32, 48);

        animation = new Animation(3, wizard_image);
    }


    // IMPLEMENTED METHODS
    public void tick() {
        x += velX;
        y += velY;

        collision();

        // movement
        if(handler.isUp()) velY = -5;
        else if(!handler.isDown()) velY = 0;

        if(handler.isDown()) velY = 5;
        else if(!handler.isUp()) velY = 0;

        if(handler.isRight()) velX = 5;
        else if(!handler.isLeft()) velX = 0;

        if(handler.isLeft()) velX = -5;
        else if(!handler.isRight()) velX = 0;

        animation.runAnimation();
    }

    public void render(Graphics g) {
        if(velX == 0 && velY == 0) {
            g.drawImage(wizard_image[0], x, y, null);
        } else {
            animation.drawAnimation(g, x, y, 0);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }


    // METHODS
    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Block) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    x += velX * -1;
                    y += velY * -1;

                }
            }

            if(tempObject.getId() == ID.Crate) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    game.ammo += 10;
                    handler.removeObject(tempObject);

                }
            }
        }
    }
}
