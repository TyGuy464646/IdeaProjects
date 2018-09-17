package com.tyler.gameObjects;

import java.awt.*;

public abstract class GameObject {

    // VARIABLES
    protected int x, y;
    protected float velX = 0, velY = 0;


    // CONSTRUCTOR
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }


    // METHODS
    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();


    // GETTERS AND SETTERS
    public int getX() {
        return x;
    }
    public void setX(int posX) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int posY) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }
    public void setVelY(float velY) {
        this.velY = velY;
    }
}
