package com.tyler.main;

import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.gameState.screens.PauseScreen;
import com.tyler.gameState.screens.TitleScreen;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game extends Application {

    // Initialize Screen Width / Height
    public int screenHeight = 600;
    public int screenWidth = 800;

    // Import Classes
    private GameTimer timer;
    private Handler handler;
    private GameStateManager gsm;

    // Initialize Screens
    private TitleScreen titleScreen;
    private GameScreen gameScreen;
    private PauseScreen pauseScreen;

    // Initialize FPS Label
    public Label fpsLabel;


    @Override
    public void start (Stage stage) throws Exception {
        // Call the Classes
        timer = new GameTimer(this);
        handler = new Handler();
        gsm = new GameStateManager();

        // Call Screens
        titleScreen = new TitleScreen(this, handler);
        gameScreen = new GameScreen(this, handler);
        pauseScreen = new PauseScreen(this, handler);

        // FPS Label
        fpsLabel = new Label();
        gameScreen.addGameUserInterfacePane(fpsLabel);

        // Key Input Handler
        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                        handler.setLeft(true);
                        break;
                    case D:
                        handler.setRight(true);
                        break;
                    case W:
                        handler.setUp(true);
                        break;
                    case S:
                        handler.setDown(true);
                        break;
                    case F1:
                        handler.setF1(true);
                        break;
                }
            }
        });
        stage.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                        handler.setLeft(false);
                        break;
                    case D:
                        handler.setRight(false);
                        break;
                    case W:
                        handler.setUp(false);
                        break;
                    case S:
                        handler.setDown(false);
                        break;
                    case F1:
                        handler.setF1(false);
                        break;
                }
            }
        });

        // Set Scene
        if (gsm.isPlayTitleScreen()) {
            stage.setScene(titleScreen.setScene());
        } else if (gsm.isPlayPauseScreen()) {
            stage.setScene(pauseScreen.setScene());
        } else {
            stage.setScene(gameScreen.setScene());
        }

        // Show the Stage
        stage.setTitle("Uliria");
        stage.setResizable(false);
        stage.show();
    }

    // Tick Methods
    public void tick() {
        handler.tick();
    }

    // Getters
    public int getScreenHeight () {
        return screenHeight;
    }
    public int getScreenWidth () {
        return screenWidth;
    }
}
