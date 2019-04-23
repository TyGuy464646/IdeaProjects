package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.main.Game;
import com.tyler.userInterface.Button;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TitleScreen {

    // Import Classes
    Game game;
    Handler handler;
    GameStateManager gsm;

    // Initialize Scene
    public Scene titleScene;

    // Initialize Buttons
    Button startButton = new Button("Start", Button.titleScreenStyle, game.screenWidth / 2 - 100, 100);
    Button exitButton = new Button("Exit", Button.titleScreenStyle, game.screenWidth / 2 - 100, 175);

    // Initialize Panes
    private StackPane titlePane;
    private Pane titleBackgroundPane, titleUserInterfacePane;


    // Constructor
    public TitleScreen(Game game, Handler handler, GameStateManager gsm) {
        this.game = game;
        this.handler = handler;
        this.gsm = gsm;

        // Call Panes
        titlePane = new StackPane();
        titleBackgroundPane = new Pane();
        titleUserInterfacePane = new Pane();

        titlePane.getChildren().addAll(titleBackgroundPane, titleUserInterfacePane);

        // Call Scene
        titleScene = new Scene(titlePane, game.getScreenWidth(), game.getScreenHeight(), Color.WHITE);

        // Add Buttons
        startButton.setAction(() -> {
            gsm.setPlayTitleScreen(false);
            gsm.setPlayGameScreen(true);
        });
        exitButton.setAction(() -> {
            Platform.exit();
        });
        titleUserInterfacePane.getChildren().addAll(startButton, exitButton);
    }

    // Methods
    public void addTitleBackgroundPane(Node node) {
        titleBackgroundPane.getChildren().add(node);
    }
    public void removeTitleBackgroundPane(Node node) {
        titleBackgroundPane.getChildren().remove(node);
    }

    public void addTitleUserInterfacePane(Node node) {
        titleUserInterfacePane.getChildren().add(node);
    }
    public void removeTitleUserInterfacePane(Node node) {
        titleUserInterfacePane.getChildren().remove(node);
    }

    public Scene setScene() {
        return titleScene;
    }

}
