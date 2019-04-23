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


    // Initiate Images
    private static Image defaultImage, hoverImage, pressedImage;
    private static boolean initialized = false;

    // Variables
    public static String titleScreenStyle = "-fx-text-fill: white; -fx-font-size: 30px;";


    // Constructor
    public Button(String text, String style, int x, int y) {
        if (!initialized) {
            loadImages();
        }

        imageView = new ImageView(defaultImage);
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    imageView.setImage(pressedImage);
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
                    imageView.setImage(hoverImage);
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                imageView.setImage(hoverImage);
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                imageView.setImage(defaultImage);
            }
        });

        label = new Label(text);
        label.setStyle(style);

        getChildren().addAll(imageView, label);
        setLayoutX(x);
        setLayoutY(y);
    }

    private static void loadImages() {
        defaultImage = new Image("/TemplateButton/ButtonDefault.png");
        hoverImage = new Image("/TemplateButton/ButtonHover.png");
        pressedImage = new Image("/TemplateButton/ButtonPressed.png");

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
}
