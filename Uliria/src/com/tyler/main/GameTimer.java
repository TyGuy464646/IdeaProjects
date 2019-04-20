package com.tyler.main;

import javafx.animation.AnimationTimer;

public class GameTimer extends AnimationTimer {

    double targetFrameRate = 65;
    long lastFrameNanoTime;
    long targetFrameTime;
    double FPS;
    double frameDuration;
    int frameCount;

    Game game;

    GameTimer (Game game) {
        this.game = game;
        start();
    }

    @Override
    public void handle (long now) {
        // check for target framerate
        if (now - lastFrameNanoTime > targetFrameTime) {
            game.gameStateTick();
            game.tick();

            frameDuration +=  (now - lastFrameNanoTime) / 1000000000.0;
            frameCount++;
            if (frameDuration > 1) {
                FPS = frameCount / frameDuration;
                frameDuration = 0;
                frameCount = 0;

                game.fpsLabel.setText(String.format("FPS: %.2f ", FPS));
            }


            lastFrameNanoTime = now;
        }

    }

    public void start () {
        targetFrameTime = 1000000000 / (long) targetFrameRate;
        lastFrameNanoTime = System.nanoTime();
        super.start();
    }

}
