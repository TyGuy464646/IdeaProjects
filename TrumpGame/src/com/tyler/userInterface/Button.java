package com.tyler.userInterface;

import com.tyler.handlers.Textures;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;

public class Button extends StackPane {

    // Initiate Button Stuff
    private ImageView imageView;
    private Label label;
    private Runnable action;

    // Variables
    private String screen;

    // Variables
    public static String titleScreenStyle = "-fx-text-fill: white; -fx-font-size: 30px;";
    public static String pauseScreenStyle = "-fx-text-fill: white; -fx-font-size: 15px;";


    // Constructor
    public Button (String screen, String text, String style, int x, int y) {
        this.screen = screen;

        switch (screen) {
            case "titleScreen":
                imageView = new ImageView(Textures.titleDefaultImage);
                break;
            case "pauseScreen":
                imageView = new ImageView(Textures.pauseDefaultImage);
                break;
        }
        setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                switch (screen) {
                    case "titleScreen":
                        imageView.setImage(Textures.titlePressedImage);
                        break;
                    case "pauseScreen":
                        imageView.setImage(Textures.pausePressedImage);
                        break;
                }

            }
        });
        setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                if (action != null) {
                    action.run();
                }
                switch (screen) {
                    case "titleScreen":
                        imageView.setImage(Textures.titleHoverImage);
                        break;
                    case "pauseScreen":
                        imageView.setImage(Textures.pauseHoverImage);
                }
            }
        });
        setOnMouseEntered(event -> {
            switch (screen) {
                case "titleScreen":
                    imageView.setImage(Textures.titleHoverImage);
                    break;
                case "pauseScreen":
                    imageView.setImage(Textures.pauseHoverImage);
                    break;
            }
        });
        setOnMouseExited(event -> {
            switch (screen) {
                case "titleScreen":
                    imageView.setImage(Textures.titleDefaultImage);
                    break;
                case "pauseScreen":
                    imageView.setImage(Textures.pauseDefaultImage);
                    break;
            }
        });

        label = new Label(text);
        label.setStyle(style);

        getChildren().addAll(imageView, label);
        setLayoutX(x);
        setLayoutY(y);
    }

    // Getters and Setters
    public void setAction(Runnable action) {
        this.action = action;
    }

    public void setText(String text) {
        label.setText(text);
    }

    public String getTitleScreenStyle () {
        return titleScreenStyle;
    }

    public String getPauseScreenStyle () {
        return pauseScreenStyle;
    }
}
