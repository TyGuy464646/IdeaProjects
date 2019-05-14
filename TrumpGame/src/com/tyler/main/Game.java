package com.tyler.main;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.gameState.screens.LoadingScreen;
import com.tyler.gameState.screens.PauseScreen;
import com.tyler.gameState.screens.TitleScreen;
import com.tyler.handlers.Textures;
import javafx.application.Application;
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
    private Handler handler;
    public Camera camera;
    public GameStateManager gsm;
    private Textures textures;

    // Initialize Screens
    public TitleScreen titleScreen;
    public GameScreen gameScreen;
    public PauseScreen pauseScreen;
    public LoadingScreen loadingScreen;

    // Camera Lock
    public GameObject cameraTarget;

    // Initialize FPS Label
    public Label fpsLabel;


    @Override
    public void start (Stage stage) {
        // Universal Stage
        this.stage = stage;

        // Call the Classes
        new GameTimer(this);
        handler = new Handler();
        gsm = new GameStateManager(this, handler);
        camera = new Camera(this);

        // Load Textures
        loadingScreen = new LoadingScreen(this, handler, gsm);
        if (LoadingScreen.isLoading) {
            gsm.setPlayLoadingScreen(true);
            textures = new Textures();
            gsm.setPlayLoadingScreen(false);
            gsm.setPlayTitleScreen(true);
            LoadingScreen.isLoading = false;
        }

        // Call Screens
        titleScreen = new TitleScreen(handler);
        pauseScreen = new PauseScreen(this, handler);
        gameScreen = new GameScreen(this, handler, textures);

        // FPS Label
        fpsLabel = new Label();
        fpsLabel.setLayoutX(700);
        gameScreen.addGameUserInterfacePane(fpsLabel);

        // Key Input Handler
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
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
        });
        stage.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
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
        });

        // Show the Stage
        stage.setTitle("Trump's Revenge");
        stage.setResizable(false);
        stage.show();
    }

    // Tick Methods
    void tick () {
        handler.tick();
        camera.tick(cameraTarget);
    }

    void gsmTick () {
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
