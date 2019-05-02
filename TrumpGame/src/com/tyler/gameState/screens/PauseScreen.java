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

    // Variables
    private Color backgroundColor = Color.rgb(60, 60, 60, 0.9);

    // Import Classes
    Game game;
    Handler handler;

    // Initialize Buttons
    Button resumeButton = new Button("pauseScreen", "Resume", Button.pauseScreenStyle, 60, 100);
    Button exitButton = new Button("pauseScreen", "Exit", Button.pauseScreenStyle, 60, 135);

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
        resumeButton.setAction(() -> {
            game.paused = false;
        });
        exitButton.setAction(() -> {
            game.paused = true;
            game.gsm.setPlayGameScreen(false);
            game.gsm.setPlayTitleScreen(true);
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

    // Getters and Setters
    public StackPane getPausePane () {
        return pausePane;
    }
}
