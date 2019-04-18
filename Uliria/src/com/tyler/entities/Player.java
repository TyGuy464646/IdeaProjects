package com.tyler.entities;

import com.tyler.main.Game;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {

    Game game;

    Rectangle player;

    public int playerWidth, playerHeight;
    public Color playerColor;
    public int playerX, playerY;
    public double playerVelX, playerVelY;
    public int playerBaseSpeed, playerSpeed;

    public Player(Game game, int x, int y, int width, int height, int speed, Color color) {
        this.game = game;
        this.playerX = x;
        this.playerY = y;
        this.playerWidth = width;
        this.playerHeight = height;
        this.playerBaseSpeed = speed;
        this.playerColor = color;

        this.playerSpeed = this.playerBaseSpeed;

        player = new Rectangle(width, height, color);
        game.spritePane.getChildren().add(player);
    }

    public void tick() {
        playerX += playerVelX;
        playerY += playerVelY;

        player.setX(playerX);
        player.setY(playerY);
    }

    public void inputTick() {
        if (game.AisPressed || game.DisPressed) {
            if (game.AisPressed) {
                playerVelX = -playerSpeed;
            }
            if (game.DisPressed) {
                playerVelX = playerSpeed;
            }
        } else {
            playerVelX = 0;
        }

        if (game.WisPressed || game.SisPressed) {
            if (game.WisPressed) {
                playerVelY = -playerSpeed;
            }
            if (game.SisPressed) {
                playerVelY = playerSpeed;
            }
        } else {
            playerVelY = 0;
        }

        if (game.AisPressed && game.DisPressed) {
            playerVelX = 0;
        }
        if (game.WisPressed && game.SisPressed) {
            playerVelY = 0;
        }

        if (playerVelX != 0 && playerVelY != 0) {
            playerVelX /= Math.sqrt(2);
            playerVelY /= Math.sqrt(2);
        }
    }

    public void physicsTick() {
        double xOverlap = Math.min(playerX + playerWidth, game.block.blockX + game.block.blockWidth) - Math.max(playerX, game.block.blockX);
        double yOverlap = Math.min(playerY + playerHeight, game.block.blockY + game.block.blockHeight) - Math.max(playerY, game.block.blockY);

        if (xOverlap > 0 && yOverlap > 0) {
            if (xOverlap > yOverlap) {
                double playerCenter = playerY + playerHeight / 2;
                double blockCenter = game.block.blockY + game.block.blockHeight / 2;

                if (playerCenter < blockCenter) {
                    playerY = game.block.blockY - playerHeight;
                } else {
                    playerY = game.block.blockY + game.block.blockHeight;
                }
            }
            if (yOverlap > xOverlap) {
                double playerCenter = playerX + playerWidth / 2;
                double blockCenter = game.block.blockX + game.block.blockWidth / 2;

                if (playerCenter < blockCenter) {
                    playerX = game.block.blockX - playerWidth;
                } else if (playerCenter > blockCenter) {
                    playerX = game.block.blockX + game.block.blockWidth;
                }
            }
        }
    }

}
