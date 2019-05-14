package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameState.screens.GameScreen;
import com.tyler.handlers.Textures;
import com.tyler.main.Game;
import javafx.scene.image.ImageView;

public class Player extends GameObject {

    // Initialize Classes
    private Game game;
    private Handler handler;

    // Initialize Screens
    private GameScreen gameScreen;

    // Initialize Player
    private ImageView player = Textures.playerSprite.grabImage(1, 1, width, height);

    // Initialize Player Variables
    private float runRate = .5f;
    private final float maxRunSpeed = 5f;
    private float accelX = 0, accelY = 0;
    private static float gravity = 0.5f;
    private float stoppingThreshold = 0.05f;
    private float drag = 0.2f;
    private boolean canJump = true;


    // Constructor
    public Player(Game game, Handler handler, GameScreen gameScreen, float x, float y, int width, int height, ID id) {
        super(x, y, width, height, id);
        this.game = game;
        this.handler = handler;
        this.gameScreen = gameScreen;

        gameScreen.addGameSpritePane(player);
    }

    public void tick() {
        player.setX(x - game.camera.x);
        player.setY(y - game.camera.y);
    }

    public void inputTick() {
        if (handler.isLeft() || handler.isRight()) {
            if (handler.isLeft() && velX >= -maxRunSpeed) {
                accelX = -runRate;
            } else if (handler.isRight() && velX <= maxRunSpeed) {
                accelX = runRate;
            } else {
                accelX = 0;
            }
        } else {
            accelX = 0;
            velX *= 1 - drag;
            if (Math.abs(velX) < stoppingThreshold) {
                velX = 0;
            }
        }
        if (handler.isLeft() && handler.isRight()) {
            accelX = 0;
            velX *= 1 - drag;
            if (Math.abs(velX) < stoppingThreshold) {
                velX = 0;
            }
        }

        if (handler.isSpace() && canJump) {
            velY = -14;
            canJump = false;
        }
    }

    public void physicsTick() {
        velX += accelX;
        velY += accelY;

        velY += gravity;

        x += velX;
        y += velY;

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            // If Player collides with Block
            if (tempObject.getId() == ID.Block) {
                double xOverlap = Math.min(x + width, tempObject.getX() + tempObject.getWidth()) - Math.max(x, tempObject.getX());
                double yOverlap = Math.min(y + height, tempObject.getY() + tempObject.getHeight()) - Math.max(y, tempObject.getY());

                Block block = (Block) tempObject;

                if (xOverlap > 0 && yOverlap > 0) {
                    if (xOverlap > yOverlap) {
                        double playerCenter = y + height / 2;
                        double blockCenter = tempObject.getY() + tempObject.getHeight() / 2;

                        // Top of platform
                        if (playerCenter < blockCenter) {
                            if (!block.disableCollisionUp) {
                                y = tempObject.getY() - height;
                                velY = 0;
                                canJump = true;
                            }
                        } else { // Bottom of platform
                            if (!block.disableCollisionBottom) {
                                y = tempObject.getY() + tempObject.getHeight();
                                velY = 0;
                            }
                        }
                    }
                    if (yOverlap > xOverlap) {
                        double playerCenter = x + width / 2;
                        double blockCenter = tempObject.getX() + tempObject.getWidth() / 2;

                        // Left of Platform
                        if (playerCenter < blockCenter) {
                            if (!block.disableCollisionLeft) {
                                x = tempObject.getX() - width;
                            }
                        } else { // Right of Platforms
                            if (!block.disableCollisionRight) {
                                x = tempObject.getX() + tempObject.getWidth();
                            }
                        }
                    }
                }
            }
        }
    }

}
