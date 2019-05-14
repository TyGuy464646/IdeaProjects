package com.tyler.gameState;

import com.tyler.gameObjects.Handler;
import com.tyler.main.Game;

public class GameStateManager {

    // Call Classes
    private Game game;
    private Handler handler;

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

        playTitleScreen = false;
        playGameScreen = false;
        playLoadingScreen = true;
    }

    // Methods
    public void tick () {
        if (playTitleScreen) {
            game.stage.setScene(game.titleScreen.setScene());
            Game.paused = true;
        } else if (playGameScreen) {
            game.stage.setScene(game.gameScreen.setScene());
        } else if (playLoadingScreen) {
            game.stage.setScene(game.loadingScreen.setScene());
            Game.paused = true;
        }

        if (playGameScreen) {
            if (handler.isEscape() && !isPressed) {
                Game.paused = !Game.paused;
                isPressed = true;
            }
            if (!handler.isEscape()) {
                isPressed = false;
            }
        }

        if (Game.paused) {
            game.pauseScreen.getPausePane().setVisible(true);
            game.fpsLabel.setVisible(false);
        } else {
            game.pauseScreen.getPausePane().setVisible(false);
            game.fpsLabel.setVisible(true);
        }
    }
}
