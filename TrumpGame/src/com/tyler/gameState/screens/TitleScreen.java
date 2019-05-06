package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.main.Game;
import com.tyler.userInterface.Button;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TitleScreen {

    // Import Classes
    Game game;
    Handler handler;

    // Initialize Scene
    public Scene titleScene;

    // Initialize Buttons
    private Button startButton = new Button("titleScreen", "Start", Button.titleScreenStyle, game.screenWidth / 2 - 100, 100);
    private Button quitButton = new Button("titleScreen", "Quit", Button.titleScreenStyle, game.screenWidth / 2 - 100, 160);
    private Image trumpImage = new Image("/Sprites/TitleScreen/trump.jpg");
    private ImageView imageView;
    private Rectangle backgroundColor;

    // Initialize Panes
    private StackPane titlePane;
    private Pane titleBackgroundPane, titleUserInterfacePane;


    // Constructor
    public TitleScreen(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        // Call Rectangle
        imageView = new ImageView(trumpImage);
        imageView.setX((game.getScreenWidth() / 2) - 200);
        imageView.setY(200);

        backgroundColor = new Rectangle(game.getScreenWidth(), game.getScreenHeight(), Color.RED);

        // Call Panes
        titlePane = new StackPane();
        titleBackgroundPane = new Pane();
        titleUserInterfacePane = new Pane();

        // Add the sub-panes to the main pane
        titlePane.getChildren().addAll(titleBackgroundPane, titleUserInterfacePane);

        // Call Scene
        titleScene = new Scene(titlePane, game.getScreenWidth(), game.getScreenHeight(), Color.RED);

        // Add Buttons
        startButton.setAction(() -> {
            game.paused = false;
            game.gsm.setPlayTitleScreen(false);
            game.gsm.setPlayGameScreen(true);
        });
        quitButton.setAction(() -> {
            Platform.exit();
        });

        // Add nodes to panes
        titleBackgroundPane.getChildren().addAll(backgroundColor, imageView);
        titleUserInterfacePane.getChildren().addAll(startButton, quitButton);
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
