package com.tyler.game;

import com.tyler.engine.GameContainer;
import com.tyler.engine.Renderer;

public class Bullet extends GameObject {

    // VARIABLES
    private double speed = 200;

    private double xVelocity;
    private double yVelocity;

    private int tileX, tileY;
    private float offX, offY;

    private double angle;


    // CONSTRUCTOR
    public Bullet(int tileX, int tileY, float offX, float offY, double angle) {
        this.angle = angle;
        posX = tileX * GameManager.TS + offX;
        posY = tileY * GameManager.TS + offY;
        this.tileX = tileX;
        this.tileY = tileY;

        double xVelocity = speed * Math.cos(angle);
        double yVelocity = speed * Math.sin(angle);

        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;

        System.out.println("xVelocity:" + xVelocity);
        System.out.println("yVelocity: " + yVelocity);

        this.offX = offX;
        this.offY = offY;

    }


    // IMPLEMENTED METHODS
    public void update(GameContainer gc, GameManager gm, float deltaTime) {
//        switch (direction) {
//            case 0:
//                offY += speed * deltaTime;
//                break;
//            case 1:
//                offX += speed * deltaTime;
//                break;
//            case 2:
//                offY -= speed * deltaTime;
//                break;
//            case 3:
//                offX -= speed * deltaTime;
//                break;
//        }

        offX += xVelocity * deltaTime;
        offY += yVelocity * deltaTime;

        // FINAL POSITION
        if(offY > GameManager.TS / 2) {
            tileY++;
            offY -= GameManager.TS;
        }
        if(offY < 0) {
            tileY--;
            offY += GameManager.TS;
        }

        if(offX > GameManager.TS / 2) {
            tileX++;
            offX -= GameManager.TS;
        }
        if(offX < 0) {
            tileX--;
            offX += GameManager.TS;
        }

        if(gm.getCollision(tileX, tileY)) {
            this.dead = true;
        }

        posX = tileX * GameManager.TS + offX;
        posY = tileY * GameManager.TS + offY;
    }

    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX - 2, (int)posY - 2, 4, 4, 0xffff0000);
    }


    // METHODS
    public void shootBullet(GameContainer gc) {

    }
}
