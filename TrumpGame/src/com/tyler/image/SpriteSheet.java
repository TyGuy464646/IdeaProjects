package com.tyler.image;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteSheet {

    // Variables
    private int spriteIncrementX = 60;
    private int spriteIncrementY = 76;

    private final Image image;
    private ImageView imageView;


    // Constructor
    public SpriteSheet (Image image) {
        this.image = image;

        imageView = new ImageView(image);
    }

    // Methods
    public void grabImage(int column, int row, int width, int height) {
        imageView.setViewport(new Rectangle2D((column * spriteIncrementX) - spriteIncrementX, (row * spriteIncrementY) - spriteIncrementY, width, height));
    }

    // Getters
    public Image getImage () {
        return image;
    }

    public ImageView getImageView () {
        return imageView;
    }
}
