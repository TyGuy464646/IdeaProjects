package com.tyler.main;

import com.tyler.gameObjects.GameObject;

public class Camera {

    // VARIABLES
    private float x, y;
    private Main game;


    // CONSTRUCTOR
    public Camera(float x, float y, Main game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }


    // METHODS
    public void tick(GameObject object) {
        x += ((object.getX() - x) - game.getWidth()/2) * 0.05f; // makes camera smooth
        y += ((object.getY() - y) - game.getHeight()/2) * 0.05f; // makes camera smooth

        // clamp
        if(x <= 0) x = 0;
        if(x >= game.getWidth() + 32) x = game.getWidth() + 32;

        if(y <= 0) y = 0;
        if(y >= game.getHeight() + 48) y = game.getHeight() + 48;
    }


    // GETTERS AND SETTERS
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
}
