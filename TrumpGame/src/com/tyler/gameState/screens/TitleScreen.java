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
    private Handler handler;

    // Initialize Scene
    private Scene titleScene;

    // Initialize Buttons
    private Button startButton = new Button("titleScreen", "Start", Button.titleScreenStyle, Game.screenWidth / 2 - 100, 100);
    private Button quitButton = new Button("titleScreen", "Quit", Button.titleScreenStyle, Game.screenWidth / 2 - 100, 160);
    private Image trumpImage = new Image("/Sprites/TitleScreen/trump.jpg");
    private ImageView imageView;
    private Rectangle backgroundColor;

    // Initialize Panes
    private StackPane titlePane;
    private Pane titleBackgroundPane;
    private Pane titleUserInterfacePane;


    // Constructor
    public TitleScreen (Handler handler) {
        this.handler = handler;

        // Call Rectangle
        imageView = new ImageView(trumpImage);
        imageView.setX((Game.screenWidth / 2) - 310);
        imageView.setY(50);

        backgroundColor = new Rectangle(Game.screenWidth, Game.screenHeight, Color.rgb(155, 162, 165));

        // Call Panes
        titlePane = new StackPane();
        titleBackgroundPane = new Pane();
        titleUserInterfacePane = new Pane();

        // Add the sub-panes to the main pane
        titlePane.getChildren().addAll(titleBackgroundPane, titleUserInterfacePane);

        // Call Scene
        titleScene = new Scene(titlePane, Game.screenWidth, Game.screenHeight, Color.RED);

        // Add Buttons
        startButton.setAction(() -> {
            Game.paused = false;
            GameStateManager.playTitleScreen = false;
            GameStateManager.playGameScreen = true;
        });
        quitButton.setAction(Platform :: exit);

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
