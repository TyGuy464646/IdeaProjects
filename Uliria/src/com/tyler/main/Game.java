package com.tyler.main;

import com.tyler.entities.Block;
import com.tyler.entities.Player;
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

    GameTimer timer;
    public Player player;
    public Block block;

    public StackPane root;
    public Pane backgroundPane;
    public Pane spritePane;
    public Pane userInterfacePane;


    public Label fpsLabel;

    int screenWidth = 800;
    int screenHeight = 600;

    public boolean AisPressed = false;
    public boolean SisPressed = false;
    public boolean DisPressed = false;
    public boolean WisPressed = false;



    @Override
    public void start (Stage stage) throws Exception {
        // Initialize the Timer
        timer = new GameTimer(this);

        // Initialize all the panes
        root = new StackPane();
        backgroundPane = new Pane();
        spritePane = new Pane();
        userInterfacePane = new Pane();

        // Set the scene and show the stage
        Scene scene = new Scene(root, screenWidth, screenHeight, Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("Uliria");
        stage.setResizable(false);
        stage.show();

        // Add all panes to the root
        root.getChildren().addAll(backgroundPane, spritePane, userInterfacePane);

        // FPS Label
        fpsLabel = new Label();
        userInterfacePane.getChildren().add(fpsLabel);

        // Add Entities
        block = new Block(this, 200, 100, 50, 50, Color.GREY);
        player = new Player(this, 50, 50, 25, 25, 5, Color.RED);

        // Handlers
        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                        AisPressed = true;
                        break;
                    case D:
                        DisPressed = true;
                        break;
                    case W:
                        WisPressed = true;
                        break;
                    case S:
                        SisPressed = true;
                        break;
                }
            }
        });
        stage.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                        AisPressed = false;
                        break;
                    case D:
                        DisPressed = false;
                        break;
                    case W:
                        WisPressed = false;
                        break;
                    case S:
                        SisPressed = false;
                        break;
                }
            }
        });
    }

    // Tick Methods
    public void tick() {
        player.tick();
        block.tick();
    }
    public void inputTick() {
        player.inputTick();
    }
    public void gameStateTick() {

    }
    public void physicsTick() {
        player.physicsTick();
    }
}
