package com.tyler.gameObjects;

import com.tyler.handlers.Textures;

public abstract class GameObject {

    // Variables
    protected float x, y;
    protected int width, height;
    protected double velX, velY;
    protected ID id;
    protected Textures textures;

    // Constructor
    public GameObject (float x, float y, int width, int height, ID id, Textures textures) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.textures = textures;
    }

    // Methods
    public abstract void tick ();
    public abstract void inputTick ();
    public abstract void physicsTick ();

    // Getters and Setters
    public float getX () {
        return x;
    }
    public void setX (int x) {
        this.x = x;
    }

    public float getY () {
        return y;
    }
    public void setY (int y) {
        this.y = y;
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public double getVelX () {
        return velX;
    }
    public void setVelX (double velX) {
        this.velX = velX;
    }

    public double getVelY () {
        return velY;
    }
    public void setVelY (double velY) {
        this.velY = velY;
    }

    public ID getId () {
        return id;
    }
    public void setId (ID id) {
        this.id = id;
    }

    public Textures getTextures () {
        return textures;
    }
    public void setTextures (Textures textures) {
        this.textures = textures;
    }
}
