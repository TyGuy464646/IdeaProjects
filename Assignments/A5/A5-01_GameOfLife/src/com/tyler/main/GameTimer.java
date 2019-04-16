package com.tyler.main;

import javafx.animation.AnimationTimer;

public class GameTimer extends AnimationTimer {

    GameGrid grid;

    int stepsPerSecond = 10;
    long nanosPerStep;
    long lastStepTime;

    boolean paused;

    GameTimer(GameGrid grid) {
        this.grid = grid;
        setStepsPerSecond(20);
        paused = true;
        start();

    }

    public void start() {
        lastStepTime = System.nanoTime();
        super.start();
    }

    @Override
    public void handle (long now) {
        long te = now - lastStepTime;
        if (te > nanosPerStep && !paused) {
            lastStepTime = now;
            grid.step();
        }
    }

    public void increaseSpeed() {
        int newSpeed = stepsPerSecond + 5;
        this.setStepsPerSecond(newSpeed);
    }

    public void decreaseSpeed() {
        int newSpeed = stepsPerSecond - 5;
        if (newSpeed < 1) {
            newSpeed = 1;
        }

        this.setStepsPerSecond(newSpeed);
    }

    public void togglePause() {
        paused = !paused;
    }

    void setStepsPerSecond(int stepsPerSecond) {
        this.stepsPerSecond = stepsPerSecond;
        nanosPerStep = (long)(1000000000 / stepsPerSecond);
    }

}
