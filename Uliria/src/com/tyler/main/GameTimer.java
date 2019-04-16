package com.tyler.main;

import javafx.animation.AnimationTimer;

public class GameTimer extends AnimationTimer {

    double targetFrameRate = 60;
    long lastFrameNanoTime;
    long targetFrameTime;
    int FPS;

    Game game;

    GameTimer (Game game) {
        this.game = game;
        start();
    }

    @Override
    public void handle (long now) {
        // check for target framerate
        if (now - lastFrameNanoTime > targetFrameTime) {
            game.tick();
            game.inputTick();
            game.physicsTick();
            game.gameStateTick();

            lastFrameNanoTime = now;
        }

    }

    public void start () {
        targetFrameTime = 1000000000 / (long) targetFrameRate;
        lastFrameNanoTime = System.nanoTime();
        super.start();
    }

}
