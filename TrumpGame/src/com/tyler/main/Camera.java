package com.tyler.main;

import com.tyler.gameObjects.GameObject;

public class Camera {

    // Import Classes
    Game game;

    // Variables
    public float x = 0,
            y = 0;
    public double vX = 0,
            vY = 0;
    public double speed = 2;


    // Constructor
    public Camera (Game game) {
        this.game = game;
    }

    // Methods
    public void tick (GameObject object) {
        double targetX = object.getX() - (game.getScreenWidth() / 2.0);
        double targetY = object.getY() - (game.getScreenHeight() / 2.0);
        double distance = Math.sqrt(((targetX - x) * (targetX - x)) + ((targetY - y) * (targetY - y)));

        if (distance >= 20) {
            speed = (distance - 20);
            vX = ((targetX - x) / distance) * speed;
            vY = ((targetY - y) / distance) * speed;
        } else {
            vX = 0;
            vY = 0;
        }

        x += vX;
        y += vY;
    }
}
