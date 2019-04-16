package com.tyler.main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Graphics extends Application {

    boolean AisPressed = false, SisPressed = false, DisPressed = false, WisPressed = false, clockTurn = false, counterTurn = false;

    double boxXVelocity = 0;
    double boxYVelocity = 0;
    double boxX = 50;
    double boxY = 50;

    double boxTheta = 0;
    double thetaDot = 0;

    double speed = 2;
    double thetaSpeed = 1;

    @Override
    public void start (Stage stage) throws Exception {

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Graphics");
        stage.setResizable(false);
        stage.show();


        Rectangle box = new Rectangle(50, 100, LinearGradient.valueOf("red, blue"));
        pane.getChildren().add(box);

//        box.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                switch(event.getButton()) {
//                    case PRIMARY:
//                        boxXVelocity += speed;
//                        break;
//                    case SECONDARY:
//                        boxXVelocity -= speed;
//                        break;
//                }
//            }
//        });

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
                    case Q:
                        counterTurn = true;
                        break;
                    case E:
                        clockTurn = true;
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
                    case Q:
                        counterTurn = false;
                        break;
                    case E:
                        clockTurn = false;
                        break;
                }
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle (long now) {
                boxX += boxXVelocity;
                boxY += boxYVelocity;
                boxTheta += thetaDot;

                HandleInput();

                box.setX(boxX);
                box.setY(boxY);
                box.setRotate(boxTheta);
            }
        };

        timer.start();

    }

    void HandleInput () {
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

        if (clockTurn || counterTurn) {
            if (clockTurn) {
                thetaDot = thetaSpeed;
            }
            if (counterTurn) {
                thetaDot = -thetaSpeed;
            }
        } else {
            thetaDot = 0;
        }

        if (clockTurn && counterTurn) {
            thetaDot = 0;
        }

        if (boxXVelocity != 0 && boxYVelocity != 0) {
            boxXVelocity /= Math.sqrt(2);
            boxYVelocity /= Math.sqrt(2);
        }
    }
}
