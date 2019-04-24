package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameObjects.objects.Block;
import com.tyler.gameObjects.objects.Player;
import com.tyler.gameState.GameStateManager;
import com.tyler.main.Game;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameScreen {

    // Import Classes
    Game game;
    Handler handler;
    GameStateManager gsm;

    // Initialize Scene
    public Scene gameScene;

    // Initialize Panes
    private StackPane gamePane;
    private Pane gameBackgroundPane, gameSpritePane, gameUserInterfacePane;


    // Constructor
    public GameScreen (Game game, Handler handler, GameStateManager gsm) {
        this.game = game;
        this.handler = handler;
        this.gsm = gsm;

        // Call Panes
        gamePane = new StackPane();
        gameBackgroundPane = new Pane();
        gameSpritePane = new Pane();
        gameUserInterfacePane = new Pane();

        gamePane.getChildren().addAll(gameBackgroundPane, gameSpritePane, gameUserInterfacePane);

        // Call Scene
        gameScene = new Scene(gamePane, game.getScreenWidth(), game.getScreenHeight(), Color.WHITE);

        // Add Objects
        for (int i = 0; i <= game.screenWidth - 50; i += 50) {
            handler.addObject(new Block(this, i, 540, 50, 50, ID.Block));
        }
        handler.addObject(new Player(handler, this, 50, 50, 25, 25, 7, ID.Player));

    }

    // Methods
    public void addGameBackgroundPane(Node node) {
        gameBackgroundPane.getChildren().add(node);
    }
    public void addGameBackgroundPane(Node[] nodes) {
        gameBackgroundPane.getChildren().addAll(nodes);
    }
    public void removeGameBackgroundPane(Node node) {
        gameBackgroundPane.getChildren().remove(node);
    }

    public void addGameSpritePane(Node node) {
        gameSpritePane.getChildren().add(node);
    }
    public void addGameSpritePane(Node[] nodes) { gameSpritePane.getChildren().addAll(nodes); }
    public void removeGameSpritePane(Node node) {
        gameSpritePane.getChildren().remove(node);
    }

    public void addGameUserInterfacePane(Node node) {
        gameUserInterfacePane.getChildren().add(node);
    }
    public void addGameUserInterfacePane(Node[] nodes) { gameUserInterfacePane.getChildren().addAll(nodes); }
    public void removeGameUserInterfacePane(Node node) {
        gameUserInterfacePane.getChildren().remove(node);
    }

    public Scene setScene() {
        return gameScene;
    }

}
