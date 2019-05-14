package com.tyler.userInterface;


import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthBar extends Pane {

    // Initiate HealthBar
    private Rectangle healthBarBorder;
    private Rectangle healthBarBackground;
    public Rectangle healthBar;
    public Label label;

    // Variables
    private static int width = 200, height = 32;
    public static int hp = 100;
    private static String healthBarStyle = "-fx-text-fill: black; -fx-font-size: 15px;";


    // Constructor
    public HealthBar(int x, int y) {
        healthBarBorder = new Rectangle(x, y, width, height);
        healthBarBorder.setFill(Color.TRANSPARENT);
        healthBarBorder.setStroke(Color.BLACK);
        healthBarBorder.setStrokeWidth(2.0);

        healthBarBackground = new Rectangle(x, y, width, height);
        healthBarBackground.setFill(Color.GREY);

        healthBar = new Rectangle(x, y, hp * 2, height);
        healthBar.setFill(Color.GREEN);

        label = new Label("HP: " + hp);
        label.setStyle(healthBarStyle);
        label.setLayoutX(x + 75);
        label.setLayoutY(y + 5);

        getChildren().addAll(healthBarBackground, healthBar, healthBarBorder, label);
        setLayoutX(x);
        setLayoutY(y);
    }

}
