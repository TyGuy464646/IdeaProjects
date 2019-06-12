package com.tyler.image;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteSheet {

    // Variables
    private int spriteIncrementX;
    private int spriteIncrementY;

    private final String url;
    private Image image;


    // Constructor
    public SpriteSheet (String url) {
        this.url = url;

        image = new Image(url);
    }

    // Methods
    public ImageView grabImage(int column, int row, int width, int height) {
        spriteIncrementX = width;
        spriteIncrementY = height;
        ImageView imageView = new ImageView(image);
        imageView.setViewport(new Rectangle2D((column * spriteIncrementX) - spriteIncrementX,
                (row * spriteIncrementY) - spriteIncrementY,
                width, height));
        return imageView;
    }

    // Getters
    public Image getImage () {
        return image;
    }
}
