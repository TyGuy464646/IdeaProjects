package com.tyler.userInterface;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

    // Initiate Images
    private static Image titleDefaultImage, titleHoverImage, titlePressedImage;
    private static Image pauseDefaultImage, pauseHoverImage, pausePressedImage;
    private static boolean initialized = false;

    // Variables
    public static String titleScreenStyle = "-fx-text-fill: white; -fx-font-size: 30px;";
    public static String pauseScreenStyle = "-fx-text-fill: white; -fx-font-size: 15px;";


    // Constructor
    public Button(String screen, String text, String style, int x, int y) {
        this.screen = screen;

        if (!initialized) {
            loadImages();
        }

        switch (screen) {
            case "titleScreen":
                imageView = new ImageView(titleDefaultImage);
                break;
            case "pauseScreen":
                imageView = new ImageView(pauseDefaultImage);
                break;
        }
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    switch (screen) {
                        case "titleScreen":
                            imageView.setImage(titlePressedImage);
                            break;
                        case "pauseScreen":
                            imageView.setImage(pausePressedImage);
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
                            imageView.setImage(titleHoverImage);
                            break;
                        case "pauseScreen":
                            imageView.setImage(pauseHoverImage);
                    }
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                switch (screen) {
                    case "titleScreen":
                        imageView.setImage(titleHoverImage);
                        break;
                    case "pauseScreen":
                        imageView.setImage(pauseHoverImage);
                        break;
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                switch (screen) {
                    case "titleScreen":
                        imageView.setImage(titleDefaultImage);
                        break;
                    case "pauseScreen":
                        imageView.setImage(pauseDefaultImage);
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

    private static void loadImages() {
        titleDefaultImage = new Image("/Button/TitleButton/ButtonDefault.png");
        titleHoverImage = new Image("/Button/TitleButton/ButtonHover.png");
        titlePressedImage = new Image("/Button/TitleButton/ButtonPressed.png");

        pauseDefaultImage = new Image("Button/PauseButton/ButtonDefault.png");
        pauseHoverImage = new Image("Button/PauseButton/ButtonHover.png");
        pausePressedImage = new Image("Button/PauseButton/ButtonPressed.png");

        initialized = true;
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
