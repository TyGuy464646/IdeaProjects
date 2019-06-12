package com.tyler.main;

import com.tyler.gameObjects.GameObject;

public class Camera {

    // Import Classes
    private Game game;

    // Variables
    public float x = 0,
            y = 0;
    private double vX = 0,
            vY = 0;
    private double speedX = 2;
    private double speedY = 1;


    // Constructor
    Camera (Game game) {
        this.game = game;
    }

    // Methods
    void tick (GameObject object) {
        double targetX = object.getX() - (game.getScreenWidth() / 2.0);
        double targetY = object.getY() - (game.getScreenHeight() / 2.0);
        double distance = Math.sqrt(((targetX - x) * (targetX - x)) + ((targetY - y) * (targetY - y)));

        if (distance >= 5) {
            speedX = (distance - 5);
            speedY = (distance - 5);
            vX = ((targetX - x) / distance) * speedX;
            vY = ((targetY - y) / distance) * speedY;
        } else {
            vX = 0;
            vY = 0;
        }

        x += vX;
        y += vY;

//        x = object.getX() - (game.getScreenWidth() / 2);
//        y = object.getY() - (game.getScreenHeight() / 2);
    }
}
