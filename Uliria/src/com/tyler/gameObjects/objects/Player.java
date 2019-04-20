package com.tyler.gameObjects.objects;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.main.Game;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    // Initialize Classes
    private Game game;
    private Handler handler;

    // Initialize player
    Rectangle player;

    // Initialize Player Variables
    public Color playerColor = Color.RED;
    public int playerBaseSpeed,
               playerSpeed;


    public Player(Game game, Handler handler, int x, int y, int width, int height, int speed, ID id) {
        super(x, y, width, height, id);
        this.game = game;
        this.handler = handler;

        this.playerBaseSpeed = speed;
        this.playerSpeed = this.playerBaseSpeed;

        player = new Rectangle(width, height, playerColor);
        game.gameSpritePane.getChildren().add(player);
    }

    public void tick() {
        x += velX;
        y += velY;

        player.setX(x);
        player.setY(y);
    }

    public void inputTick() {
        if (handler.isLeft() || handler.isRight()) {
            if (handler.isLeft()) {
                velX = -playerSpeed;
            }
            if (handler.isRight()) {
                velX = playerSpeed;
            }
        } else {
            velX = 0;
        }

        if (handler.isUp() || handler.isDown()) {
            if (handler.isUp()) {
                velY = -playerSpeed;
            }
            if (handler.isDown()) {
                velY = playerSpeed;
            }
        } else {
            velY = 0;
        }

        if (handler.isLeft() && handler.isRight()) {
            velX = 0;
        }
        if (handler.isUp() && handler.isDown()) {
            velY = 0;
        }

        if (velX != 0 && velY != 0) {
            velX /= Math.sqrt(2);
            velY /= Math.sqrt(2);
        }
    }

    public void physicsTick() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            // If Player collides with Block
            if (tempObject.getId() == ID.Block) {
                double xOverlap = Math.min(x + width, tempObject.getX() + tempObject.getWidth()) - Math.max(x, tempObject.getX());
                double yOverlap = Math.min(y + height, tempObject.getY() + tempObject.getHeight()) - Math.max(y, tempObject.getY());

                if (xOverlap > 0 && yOverlap > 0) {
                    if (xOverlap > yOverlap) {
                        double playerCenter = y + height / 2;
                        double blockCenter = tempObject.getY() + tempObject.getHeight() / 2;

                        if (playerCenter < blockCenter) {
                            y = tempObject.getY() - height;
                        } else {
                            y = tempObject.getY() + tempObject.getHeight();
                        }
                    }
                    if (yOverlap > xOverlap) {
                        double playerCenter = x + width / 2;
                        double blockCenter = tempObject.getX() + tempObject.getWidth() / 2;

                        if (playerCenter < blockCenter) {
                            x = tempObject.getX() - width;
                        } else if (playerCenter > blockCenter) {
                            x = tempObject.getX() + tempObject.getWidth();
                        }
                    }
                }
            }
        }
    }

}
