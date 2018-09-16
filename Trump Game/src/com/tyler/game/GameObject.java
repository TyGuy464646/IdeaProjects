package com.tyler.game;

import com.tyler.engine.GameContainer;
import com.tyler.engine.Renderer;

public abstract class GameObject {

    // VARIABLES
    protected String tag;

    protected float posX, posY;
    protected int width, height;
    protected boolean dead = false;

    public abstract void update(GameContainer gc, GameManager gm, float deltaTime);
    public abstract void render(GameContainer gc, Renderer r);


    // GETTERS AND SETTERS
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public float getPosX() {
        return posX;
    }
    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }
    public void setPosY(float posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
