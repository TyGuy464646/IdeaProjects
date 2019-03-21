package com.tyler.Input.keyInput;

import com.tyler.main.Main;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class KeyInputManager {

    Main game;

    boolean spaceKeyPressed = false;
    boolean leftKeyPressed = false;
    boolean rightKeyPressed = false;
    boolean upKeyPressed = false;
    boolean downKeyPressed = false;


    public KeyInputManager(Main game) {
        this.game = game;
    }

    public void setupInput(Stage stage) {
        EventHandler<KeyEvent> gameKeyEventHandler = new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                // Key Pressed
                if(event.getEventType() == KeyEvent.KEY_PRESSED) {
                    if(event.getCode() == KeyCode.SPACE) {
                        spaceKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.A) {
                        leftKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.D) {
                        rightKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.W) {
                        upKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.S) {
                        downKeyPressed = true;
                    }
                }

                // Key_Released events
                if(event.getEventType() == KeyEvent.KEY_RELEASED) {
                    if(event.getCode() == KeyCode.SPACE) {
                        spaceKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.A) {
                        leftKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.D) {
                        rightKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.W) {
                        upKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.S) {
                        downKeyPressed = false;
                    }
                }
            }
        };
    }

}
