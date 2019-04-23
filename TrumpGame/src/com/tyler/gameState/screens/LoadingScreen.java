package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.main.Game;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LoadingScreen {

    // Import Classes
    Game game;
    Handler handler;
    GameStateManager gsm;

    // Initialize Scene
    public Scene loadingScene;

    // Initialize Panes
    private StackPane loadingPane;

    // Initialize Label
    private Label loading;


    // Constructor
    public LoadingScreen(Game game, Handler handler, GameStateManager gsm) {
        this.game = game;
        this.handler = handler;
        this.gsm = gsm;

        // Call Panes
        loadingPane = new StackPane();

        // Call Label
        loading = new Label("Loading...");
        loading.setStyle("-fx-text-fill: black; -fx-font-size: 100px");

        loadingPane.getChildren().add(loading);

        // Call Scene
        loadingScene = new Scene(loadingPane, game.getScreenWidth(), game.getScreenHeight(), Color.WHITE);

    }

    public Scene setScene() { return loadingScene; }

}
