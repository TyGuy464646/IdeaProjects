package com.tyler.main;

import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.gameState.screens.LoadingScreen;
import com.tyler.gameState.screens.PauseScreen;
import com.tyler.gameState.screens.TitleScreen;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game extends Application {

    // Initialize Stage
    public Stage stage;

    // Initialize Screen Width / Height
    public static int screenHeight = 600;
    public static int screenWidth = 800;

    // Initialize Paused
    public static boolean paused = true;

    // Import Classes
    private GameTimer timer;
    private Handler handler;
    private GameStateManager gsm;

    // Initialize Screens
    public TitleScreen titleScreen;
    public GameScreen gameScreen;
    public PauseScreen pauseScreen;
    public LoadingScreen loadingScreen;

    // Initialize FPS Label
    public Label fpsLabel;


    @Override
    public void start (Stage stage) throws Exception {
        // Universal Stage
        this.stage = stage;

        // Call the Classes
        timer = new GameTimer(this);
        handler = new Handler();
        gsm = new GameStateManager(this, handler);

        // Call Screens
        titleScreen = new TitleScreen(this, handler, gsm);
        pauseScreen = new PauseScreen(this, handler, gsm);
        gameScreen = new GameScreen(this, handler, gsm);
        loadingScreen = new LoadingScreen(this, handler, gsm);

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
                    case SPACE:
                        handler.setSpace(true);
                        break;
                    case ESCAPE:
                        handler.setEscape(true);
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
                    case SPACE:
                        handler.setSpace(false);
                        break;
                    case ESCAPE:
                        handler.setEscape(false);
                        break;
                }
            }
        });

        stage.setScene(titleScreen.setScene());

        // Show the Stage
        stage.setTitle("Trump Game");
        stage.setResizable(false);
        stage.show();
    }

    // Tick Methods
    public void tick () {
        handler.tick();
    }

    public void gsmTick () {
        gsm.tick();
    }

    // Getters
    public int getScreenHeight () {
        return screenHeight;
    }

    public int getScreenWidth () {
        return screenWidth;
    }
}
