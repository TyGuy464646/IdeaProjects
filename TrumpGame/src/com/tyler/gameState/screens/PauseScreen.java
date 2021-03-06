package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.gameState.GameStateManager;
import com.tyler.main.Game;
import com.tyler.userInterface.Button;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PauseScreen {

    // Import Classes
    private Game game;
    private Handler handler;

    // Variables
    private Color backgroundColor = Color.rgb(60, 60, 60, 0.9);

    // Initialize Buttons
    private Button resumeButton = new Button("pauseScreen", "Resume", Button.pauseScreenStyle, 60, 100);
    private Button exitButton = new Button("pauseScreen", "Exit", Button.pauseScreenStyle, 60, 135);

    // Initialize Nodes
    private Label label;
    private Rectangle rectangle;

    // Initialize Panes
    private StackPane pausePane;
    private Pane pauseBackgroundPane, pauseUserInterfacePane;


    // Constructor
    public PauseScreen (Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        // Call Panes
        pausePane = new StackPane();
        pauseUserInterfacePane = new Pane();
        pauseBackgroundPane = new Pane();

        // Call Background Rectangle
        rectangle = new Rectangle(game.getScreenWidth(), game.getScreenHeight(), backgroundColor);

        // Call label
        label = new Label("Paused");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 30px;");
        label.setLayoutX(50);
        label.setLayoutY(50);

        // Call Button
        resumeButton.setAction(() -> Game.paused = false);
        exitButton.setAction(() -> {
            Game.paused = true;
            GameStateManager.playGameScreen = false;
            GameStateManager.playTitleScreen = true;
        });
        pauseUserInterfacePane.getChildren().addAll(resumeButton, exitButton);

        // Add nodes to root pane
        pauseBackgroundPane.getChildren().add(rectangle);
        pauseUserInterfacePane.getChildren().add(label);
        pausePane.getChildren().addAll(pauseBackgroundPane, pauseUserInterfacePane);
        pausePane.setVisible(false);
    }

    // Methods
    public void addPauseBackgroundPane(Node node) {
        pauseBackgroundPane.getChildren().add(node);
    }
    public void removePauseBackgroundPane(Node node) {
        pauseBackgroundPane.getChildren().remove(node);
    }

    public void addPauseUserInterfacePane(Node node) {
        pauseUserInterfacePane.getChildren().add(node);
    }
    public void removePauseUserInterfacePane(Node node) {
        pauseUserInterfacePane.getChildren().remove(node);
    }

    // Getters and Setters
    public StackPane getPausePane () {
        return pausePane;
    }
}
