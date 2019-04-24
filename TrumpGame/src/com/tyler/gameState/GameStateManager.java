package com.tyler.gameState;

import com.tyler.gameObjects.Handler;
import com.tyler.main.Game;

public class GameStateManager {

    // Call Classes
    Game game;
    Handler handler;

    // Initialize Scene Booleans
    public static boolean playTitleScreen;
    public static boolean playGameScreen;
    public static boolean playLoadingScreen;

    // Variables
    private boolean isPressed = false;

    // Constructor
    public GameStateManager (Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        playTitleScreen = true;
        playGameScreen = false;
        playLoadingScreen = false;
    }

    // Methods
    public void tick () {
        if (playGameScreen) {
            if (handler.isEscape() && !isPressed) {
                game.paused = !game.paused;
                isPressed = true;
            }
            if (!handler.isEscape()) {
                isPressed = false;
            }
        }

        if (game.paused) {
            game.pauseScreen.getPausePane().setVisible(true);
            game.fpsLabel.setVisible(false);
        } else {
            game.paused = false;
            game.pauseScreen.getPausePane().setVisible(false);
            game.fpsLabel.setVisible(true);
        }

        if (playTitleScreen) {
            game.stage.setScene(game.titleScreen.setScene());
        } else if (playGameScreen) {
            game.stage.setScene(game.gameScreen.setScene());
        } else {
            game.pauseScreen.getPausePane().setVisible(false);
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

    public boolean isPlayLoadingScreen () {
        return playLoadingScreen;
    }

    public void setPlayLoadingScreen (boolean playLoadingScreen) {
        this.playLoadingScreen = playLoadingScreen;
    }
}
