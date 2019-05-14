package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.main.Game;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LoadingScreen {

    // Import Classes
    private Game game;
    private Handler handler;

    // Initialize Scene
    private Scene loadingScene;

    // Initialize Panes
    private StackPane loadingPane;

    // Initialize Label
    private Label loading;
    private Rectangle rectangle;

    // Variables
    public static boolean isLoading = true;


    // Constructor
    public LoadingScreen (Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        // Call Panes
        loadingPane = new StackPane();

        // Call Label
        loading = new Label("Loading...");
        loading.setStyle("-fx-text-fill: black; -fx-font-size: 100px");

        rectangle = new Rectangle(0, 0, game.getScreenWidth(), game.getScreenHeight());
        rectangle.setFill(Color.rgb(155, 162, 165));

        loadingPane.getChildren().addAll(rectangle, loading);

        // Call Scene
        loadingScene = new Scene(loadingPane, game.getScreenWidth(), game.getScreenHeight(), Color.rgb(155, 162, 165));

    }

    public Scene setScene() { return loadingScene; }

}
