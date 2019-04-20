package com.tyler.main;

import com.tyler.entities.Handler;
import com.tyler.entities.ID;
import com.tyler.entities.objects.Block;
import com.tyler.entities.objects.Player;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {

    // Initialize Screen Width / Height
    public int screenHeight = 600;
    public int screenWidth = 800;

    // Import Classes
    private GameTimer timer;
    private Handler handler;

    // Initialize Panes
    public StackPane titlePane, gamePane;
    public Pane titleBackgroundPane, titleUserInterfacePane;
    public Pane gameBackgroundPane, gameSpritePane, gameUserInterfacePane;

    // Initialize FPS Label
    public Label fpsLabel;

    // Initialize Scene Booleans
    public boolean playTitleScreen = false;
    public boolean playGameScrene = true;


    @Override
    public void start (Stage stage) throws Exception {
        // Call the Timer and Handler
        timer = new GameTimer(this);
        handler = new Handler();

        // Call Scene Panes
        gamePane = new StackPane();
        titlePane = new StackPane();

        // Call Graphic Panes
        gameBackgroundPane = new Pane();
        gameSpritePane = new Pane();
        gameUserInterfacePane = new Pane();

        titleBackgroundPane = new Pane();
        titleUserInterfacePane = new Pane();

        // Set the Scene
        Scene titleScene = new Scene(titlePane, screenWidth, screenHeight, Color.WHITE);
        Scene gameScene = new Scene(gamePane, screenWidth, screenHeight, Color.WHITE);

        // Add All Panes to the Root
        gamePane.getChildren().addAll(gameBackgroundPane, gameSpritePane, gameUserInterfacePane);
        titlePane.getChildren().addAll(titleBackgroundPane, titleUserInterfacePane);

        // FPS Label
        fpsLabel = new Label();
        gameUserInterfacePane.getChildren().add(fpsLabel);

        // Add Entities
        if (playGameScrene) {
            handler.addObject(new Block(this, 200, 100, 50, 50, ID.Block));
            handler.addObject(new Player(this, handler, 50, 50, 25, 25, 5, ID.Player));
        }

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
                }
            }
        });

        // Set Scene
        if (playTitleScreen) {
            stage.setScene(titleScene);
        } else {
            stage.setScene(gameScene);
        }

        // Show the Stage
        stage.setTitle("Uliria");
        stage.setResizable(false);
        stage.show();
    }

    // Tick Methods
    public void gameStateTick() {

    }
    public void tick() {
        handler.tick();
    }
}
