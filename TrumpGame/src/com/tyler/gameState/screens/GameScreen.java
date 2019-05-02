package com.tyler.gameState.screens;

import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameObjects.objects.Block;
import com.tyler.gameObjects.objects.Player;
import com.tyler.gameState.GameStateManager;
import com.tyler.main.Game;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameScreen {

    // Import Classes
    Game game;
    Handler handler;

    // Initialize Scene
    public Scene gameScene;

    // Initialize Panes
    private StackPane gamePane, rootPane;
    private Pane gameBackgroundPane, gameSpritePane, gameUserInterfacePane;


    // Constructor
    public GameScreen (Game game, Handler handler) {
        this.game = game;
        this.handler = handler;

        // Call Panes
        gamePane = new StackPane();
        rootPane = new StackPane();
        gameBackgroundPane = new Pane();
        gameSpritePane = new Pane();
        gameUserInterfacePane = new Pane();

        gamePane.getChildren().addAll(gameBackgroundPane, gameSpritePane, gameUserInterfacePane);
        rootPane.getChildren().addAll(gamePane, game.pauseScreen.getPausePane());

        // Call Scene
        gameScene = new Scene(rootPane, game.getScreenWidth(), game.getScreenHeight(), Color.WHITE);

        // Add Objects
        final int red = 0xffff0000;
        final int green = 0xff00ff00;
        final int blue = 0xff0000ff;

        Image level1 = new Image("Levels/level1.png");
        PixelReader pr = level1.getPixelReader();

        for (int yy = 0; yy < level1.getHeight(); yy++) {
            for (int xx = 0; xx < level1.getWidth(); xx++) {
                switch (pr.getArgb(xx, yy)) {
                    case red:
                        Block block = new Block(this, xx * 32, yy * 32, 32, 32, ID.Block);
                        handler.addObject(block);

                        if (xx + 1 < level1.getWidth() - 1) {
                            if (pr.getArgb(xx + 1, yy) == red) {
                                block.disableCollisionRight = true;
                            }
                        }
                        if (xx - 1 > 0) {
                            if (pr.getArgb(xx - 1, yy) == red) {
                                block.disableCollisionLeft = true;
                            }
                        }
                        if (yy + 1 < level1.getHeight() - 1) {
                            if (pr.getArgb(xx, yy + 1) == red) {
                                block.disableCollisionBottom = true;
                            }
                        }
                        if (yy - 1 > 0) {
                            if (pr.getArgb(xx, yy - 1) == red) {
                                block.disableCollisionUp = true;
                            }
                        }
                        break;
                    case blue:
                        handler.addObject(new Player(handler, this, xx * 32, yy * 32, 32, 48, ID.Player));
                        break;
                }
            }
        }

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
