package tyler;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {

    // Variables
    Main game;

    double x, y, velocityX, velocityY, size, baseSpeed, speed;

    Circle circle;


    // Constructor
    public Player(Main game) {
        this.game = game;

        x = game.screenWidth / 2;
        y = game.screenHeight / 2;
        velocityX = 0;
        velocityY = 0;
        baseSpeed = 20;
        size = game.screenHeight * 0.025;
        circle = new Circle(size, Color.RED);

        updateGraphics();
        game.spritePane.getChildren().add(circle);
    }


    // Methods
    public void updateGraphics() {
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public void updatePhysics() {
        x += velocityX;
        y += velocityY;

        // boundary collision
        if(x < size) {
            x = size;
        }
        if(x > game.screenWidth - size) {
            x = game.screenWidth - size;
        }

        if(y < size) {
            y = size;
        }
        if(y > game.screenHeight - size) {
            y = game.screenHeight - size;
        }
    }

    public void updateInput() {
        if(game.spaceKeyPressed) {
            speed = baseSpeed * 4;
        } else {
            speed = baseSpeed;
        }

        if(game.leftKeyPressed && game.rightKeyPressed) {
            velocityX = 0;
        } else {
            if(game.leftKeyPressed) {
                velocityX = -speed;
            } else if(game.rightKeyPressed) {
                velocityX = speed;
            } else {
                velocityX = 0;
            }
        }

        if(game.upKeyPressed && game.downKeyPressed) {
            velocityY = 0;
        } else {
            if(game.upKeyPressed) {
                velocityY = -speed;
            } else if(game.downKeyPressed) {
                velocityY = speed;
            } else {
                velocityY = 0;
            }
        }

        if(velocityX != 0 && velocityY != 0) {
            velocityX /= Math.sqrt(2);
            velocityY /= Math.sqrt(2);
        }
    }
}
