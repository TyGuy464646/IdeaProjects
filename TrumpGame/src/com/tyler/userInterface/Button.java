package com.tyler.userInterface;

import com.tyler.handlers.Textures;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    public Button (String screen, Textures textures, String text, String style, int x, int y) {
        this.screen = screen;

        switch (screen) {
            case "titleScreen":
                imageView = new ImageView(textures.titleDefaultImage);
                break;
            case "pauseScreen":
                imageView = new ImageView(textures.pauseDefaultImage);
                break;
        }
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    switch (screen) {
                        case "titleScreen":
                            imageView.setImage(textures.titlePressedImage);
                            break;
                        case "pauseScreen":
                            imageView.setImage(textures.pausePressedImage);
                            break;
                    }

                }
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if (action != null) {
                        action.run();
                    }
                    switch (screen) {
                        case "titleScreen":
                            imageView.setImage(textures.titleHoverImage);
                            break;
                        case "pauseScreen":
                            imageView.setImage(textures.pauseHoverImage);
                    }
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                switch (screen) {
                    case "titleScreen":
                        imageView.setImage(textures.titleHoverImage);
                        break;
                    case "pauseScreen":
                        imageView.setImage(textures.pauseHoverImage);
                        break;
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                switch (screen) {
                    case "titleScreen":
                        imageView.setImage(textures.titleDefaultImage);
                        break;
                    case "pauseScreen":
                        imageView.setImage(textures.pauseDefaultImage);
                        break;
                }
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
