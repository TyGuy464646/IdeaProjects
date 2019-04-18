package com.tyler.main;

import com.tyler.entities.Block;
import com.tyler.entities.Player;
import javafx.animation.ParallelTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {

    GameTimer timer;
    public Player player;
    public Block block;

    public Pane pane;
    public Label label;

    int screenWidth = 800;
    int screenHeight = 600;

    public boolean AisPressed = false;
    public boolean SisPressed = false;
    public boolean DisPressed = false;
    public boolean WisPressed = false;



    @Override
    public void start (Stage stage) throws Exception {
        timer = new GameTimer(this);

        pane = new Pane();
        Scene scene = new Scene(pane, screenWidth, screenHeight);
        stage.setScene(scene);
        stage.setTitle("Uliria");
        stage.setResizable(false);
        stage.show();

        // FPS Label
        label = new Label();
        pane.getChildren().add(label);

        // Add Entities
        block = new Block(this, 200, 100, 50, 50, Color.GRAY);
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
