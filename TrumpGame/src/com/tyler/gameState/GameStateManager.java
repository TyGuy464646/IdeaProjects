package com.tyler.gameState;

import com.tyler.gameObjects.Handler;
import com.tyler.main.Game;

public class GameStateManager {

    // Call Classes
    Game game;
    Handler handler;

    // Initialize Scene Booleans
    public boolean playTitleScreen;
    public boolean playGameScreen;
    public boolean playPauseScreen;
    public boolean playLoadingScreen;


    // Constructor
    public GameStateManager(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        playTitleScreen = true;
        playGameScreen = false;
        playPauseScreen = false;
        playLoadingScreen = false;
    }

    // Methods
    public void tick() {
        if (handler.isEscape()) {
            if (!game.paused) {
                game.paused = true;
            } else {
                game.paused = false;
            }
        }

        if (playTitleScreen) {
            game.stage.setScene(game.titleScreen.setScene());
        } else if (playGameScreen) {
            game.stage.setScene(game.gameScreen.setScene());
        } else if (playPauseScreen){
            game.stage.setScene(game.pauseScreen.setScene());
        } else {
            game.stage.setScene(game.loadingScreen.setScene());
        }

    }

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

    public boolean isPlayLoadingScreen () {
        return playLoadingScreen;
    }
    public void setPlayLoadingScreen (boolean playLoadingScreen) {
        this.playLoadingScreen = playLoadingScreen;
    }
}
