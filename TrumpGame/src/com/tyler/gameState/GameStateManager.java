package com.tyler.gameState;

public class GameStateManager {

    // Initialize Scene Booleans
    public boolean playTitleScreen = false;
    public boolean playGameScreen = true;
    public boolean playPauseScreen = false;

    // Getters and Setters
    public boolean isPlayTitleScreen () {
        return playTitleScreen;
    }
    public void setPlayTitleScreen (boolean playTitleScreen) {
        this.playTitleScreen = playTitleScreen;
    }

    public boolean isPlayGameScreen () {
        return playGameScreen;
    }
    public void setPlayGameScreen (boolean playGameScreen) {
        this.playGameScreen = playGameScreen;
    }

    public boolean isPlayPauseScreen () {
        return playPauseScreen;
    }
    public void setPlayPauseScreen (boolean playPauseScreen) {
        this.playPauseScreen = playPauseScreen;
    }
}
