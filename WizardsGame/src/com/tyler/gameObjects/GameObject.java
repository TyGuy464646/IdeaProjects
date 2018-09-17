package com.tyler.gameObjects;

import com.tyler.image.SpriteSheet;

import java.awt.*;

public abstract class GameObject {

    // VARIABLES
    protected int x, y;
    protected float velX = 0, velY = 0;
    protected ID id;
    protected SpriteSheet spriteSheet;


    // CONSTRUCTOR
    public GameObject(int x, int y, ID id, SpriteSheet spriteSheet) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.spriteSheet = spriteSheet;
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

    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }
}
