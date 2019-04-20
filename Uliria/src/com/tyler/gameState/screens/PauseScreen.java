package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.main.Game;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class PauseScreen {

    // Import Classes
    Game game;
    Handler handler;

    // Initialize Scene
    public Scene pauseScene;

    // Initialize Panes
    private StackPane pausePane;
    private Pane pauseBackgroundPane, pauseUserInterfacePane;


    // Constructor
    public PauseScreen (Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        // Call Panes
        pausePane = new StackPane();
        pauseBackgroundPane = new Pane();
        pauseUserInterfacePane = new Pane();

        pausePane.getChildren().addAll(pauseBackgroundPane, pauseUserInterfacePane);

        // Call Scene
        pauseScene = new Scene(pausePane, game.getScreenWidth(), game.getScreenHeight(), Color.WHITE);
    }

    // Methods
    public void addPauseBackgroundPane(Node node) {
        pauseBackgroundPane.getChildren().add(node);
    }
    public void addPauseBackgroundPane(Node[] nodes) {
        pauseBackgroundPane.getChildren().addAll(nodes);
    }
    public void removePauseBackgroundPane(Node node) {
        pauseBackgroundPane.getChildren().remove(node);
    }

    public void addPauseUserInterfacePane(Node node) {
        pauseUserInterfacePane.getChildren().add(node);
    }
    public void addPauseUserInterfacePane(Node[] nodes) { pauseUserInterfacePane.getChildren().addAll(nodes); }
    public void removePauseUserInterfacePane(Node node) {
        pauseUserInterfacePane.getChildren().remove(node);
    }

    public Scene setScene() { return pauseScene; }

}
