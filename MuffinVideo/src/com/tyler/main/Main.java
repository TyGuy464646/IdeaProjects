package com.tyler.main;

import com.tyler.Input.keyInput.KeyInputManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    // Variables
    AnimationTimer timer;
    double targetFrameRate;

    Pane backgroundPane;
    Pane spritePane;
    Pane userInterfacePane;

    double screenWidth;
    double screenHeight;

    KeyInputManager keyInputManager;


    // Main Method
    public static void main(String[] args) {
	    launch(args);
    }


    // Start Method
    public void start(Stage stage) throws Exception {
        setupScreen(stage);
        keyInputManager = new KeyInputManager(this);
        keyInputManager.setupInput(stage);
        setupTimer(60);

        // TODO: Initialize
        setBackgroundMedia("mp4/muffinSong.mp4");

        timer.start();
    }


    // Methods
    private void setupScreen(Stage stage) {
        // Setup root container - a stack pane
        screenWidth = 800;
        screenHeight = 600;
        StackPane root = new StackPane();
        Scene scene = new Scene(root, screenWidth, screenHeight, Color.BLACK);
        stage.setScene(scene);

        // add game layers
        backgroundPane = new Pane();
        spritePane = new Pane();
        userInterfacePane = new Pane();
        root.getChildren().addAll(backgroundPane, spritePane, userInterfacePane);

        // set app title, switch to full screen, make Esc key exit game
        String title = "Uliria";
        stage.setTitle(title);
        stage.show();
        stage.setResizable(false);
        stage.fullScreenProperty().addListener((observable) -> {
            if(timer != null) {
                timer.stop();
            }
            Platform.exit();
        });
    }

    public void setBackgroundMedia(String path) {
        String file = getClass().getClassLoader().getResource(path).getFile();
//      System.out.println(file);
        Media video = new Media("file://" + file);
        MediaPlayer mp = new MediaPlayer(video);
        MediaView mv = new MediaView(mp);
        backgroundPane.getChildren().add(mv);
        mv.getMediaPlayer().play();
        mv.setPreserveRatio(false);
        mv.setFitWidth(screenWidth);
        mv.setFitHeight(screenHeight);
    }

    private void setupTimer(double targetFramesPerSecond) {
        targetFrameRate = targetFramesPerSecond;
        
        timer = new AnimationTimer() {
            long lastFrameNanoTime;
            long targetFrameTime = 1000000000 / (long) targetFrameRate;

            public void start() {
                lastFrameNanoTime = System.nanoTime();
                super.start();
            }

            public void handle(long now) {
                // check for target framerate
                if(now - lastFrameNanoTime > targetFrameTime) {
                    updateInput();
                    updatePhysics();
                    updateGameStates();
                    updateVisuals();

                    lastFrameNanoTime = now;
                }
            }
        };
    }


    void updateInput() {

    }

    void updatePhysics() {

    }

    void updateGameStates() {

    }

    void updateVisuals() {

    }

}
