package com.tyler.gameState.screens;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameObjects.objects.Block;
import com.tyler.gameObjects.objects.Player;
import com.tyler.handlers.Textures;
import com.tyler.main.Game;
import com.tyler.userInterface.HealthBar;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameScreen {

    // Initialize Objects
    private GameObject player;

    // Health Bar
    private HealthBar healthBar = new HealthBar(5, 5);

    // Initialize Scene
    private Scene gameScene;

    // Initialize Panes
    private StackPane gamePane, rootPane;
    private Pane gameBackgroundPane, gameSpritePane, gameUserInterfacePane;

    // Variables
    private static int blockWidth = 40, blockHeight = 40;
    private static int playerWidth = 60, playerHeight = 76;


    // Constructor
    public GameScreen (Game game, Handler handler, Textures textures) {

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

        // Level Image Reader
        Image level1 = new Image("Levels/level1.png");
        PixelReader pr = level1.getPixelReader();
        for (int yy = 0; yy < level1.getHeight(); yy++) {
            for (int xx = 0; xx < level1.getWidth(); xx++) {
                switch (pr.getArgb(xx, yy)) {
                    case red:
                        Block block = new Block(game, this, xx * blockWidth, yy * blockWidth, blockWidth, blockHeight, ID.Block);
                        handler.addObject(block);

                        // Disable collision
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
                        player = new Player(game, handler, this, xx * blockWidth, yy * blockWidth, playerWidth, playerHeight, ID.Player);
                        game.cameraTarget = player;
                        handler.addObject(player);
                        break;
                }
            }
        }

        gameUserInterfacePane.getChildren().add(healthBar);

    }

    // Methods
    public void addGameBackgroundPane(Node node) {
        gameBackgroundPane.getChildren().add(node);
    }
    public void removeGameBackgroundPane(Node node) {
        gameBackgroundPane.getChildren().remove(node);
    }

    public void addGameSpritePane(Node node) {
        gameSpritePane.getChildren().add(node);
    }
    public void removeGameSpritePane(Node node) {
        gameSpritePane.getChildren().remove(node);
    }

    public void addGameUserInterfacePane(Node node) {
        gameUserInterfacePane.getChildren().add(node);
    }
    public void removeGameUserInterfacePane(Node node) {
        gameUserInterfacePane.getChildren().remove(node);
    }

    public Scene setScene() {
        return gameScene;
    }

}
