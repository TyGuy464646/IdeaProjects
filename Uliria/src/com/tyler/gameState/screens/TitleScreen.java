package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.main.Game;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TitleScreen {

    // Import Classes
    Game game;
    Handler handler;

    // Initialize Scene
    public Scene titleScene;

    // Initialize Panes
    private StackPane titlePane;
    private Pane titleBackgroundPane, titleUserInterfacePane;


    // Constructor
    public TitleScreen(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        // Call Panes
        titlePane = new StackPane();
        titleBackgroundPane = new Pane();
        titleUserInterfacePane = new Pane();

        titlePane.getChildren().addAll(titleBackgroundPane, titleUserInterfacePane);

        // Call Scene
        titleScene = new Scene(titlePane, game.getScreenWidth(), game.getScreenHeight(), Color.WHITE);
    }

    // Methods
    public void addTitleBackgroundPane(Node node) {
        titleBackgroundPane.getChildren().add(node);
    }
    public void addTitleBackgroundPane(Node[] nodes) {
        titleBackgroundPane.getChildren().addAll(nodes);
    }
    public void removeTitleBackgroundPane(Node node) {
        titleBackgroundPane.getChildren().remove(node);
    }

    public void addTitleUserInterfacePane(Node node) {
        titleUserInterfacePane.getChildren().add(node);
    }
    public void addTitleUserInterfacePane(Node[] nodes) { titleUserInterfacePane.getChildren().addAll(nodes); }
    public void removeTitleUserInterfacePane(Node node) {
        titleUserInterfacePane.getChildren().remove(node);
    }

    public Scene setScene() {
        return titleScene;
    }

}
