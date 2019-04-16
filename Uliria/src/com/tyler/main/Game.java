package com.tyler.main;

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

    int screenWidth = 800;
    int screenHeight = 600;

    boolean AisPressed = false;
    boolean SisPressed = false;
    boolean DisPressed = false;
    boolean WisPressed = false;

    double boxXVelocity = 0;
    double boxYVelocity = 0;
    double boxX = 50;
    double boxY = 50;
    double speed = 5;

    Rectangle box;
    Label label;


    @Override
    public void start (Stage stage) throws Exception {
        timer = new GameTimer(this);

        Pane pane = new Pane();
        Scene scene = new Scene(pane, screenWidth, screenHeight);
        stage.setScene(scene);
        stage.setTitle("Uliria");
        stage.setResizable(false);
        stage.show();

        label = new Label("FPS: " + timer.FPS);
        box = new Rectangle(50, 100, Color.RED);
        pane.getChildren().addAll(box, label);

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
        boxX += boxXVelocity;
        boxY += boxYVelocity;

        box.setX(boxX);
        box.setY(boxY);
    }

    public void inputTick() {
        if (AisPressed || DisPressed) {
            if (AisPressed) {
                boxXVelocity = -speed;
            }
            if (DisPressed) {
                boxXVelocity = speed;
            }
        } else {
            boxXVelocity = 0;
        }

        if (WisPressed || SisPressed) {
            if (WisPressed) {
                boxYVelocity = -speed;
            }
            if (SisPressed) {
                boxYVelocity = speed;
            }
        } else {
            boxYVelocity = 0;
        }

        if (AisPressed && DisPressed) {
            boxXVelocity = 0;
        }
        if (WisPressed && SisPressed) {
            boxYVelocity = 0;
        }

        if (boxXVelocity != 0 && boxYVelocity != 0) {
            boxXVelocity /= Math.sqrt(2);
            boxYVelocity /= Math.sqrt(2);
        }
    }

    public void gameStateTick() {

    }

    public void physicsTick() {

    }
}
