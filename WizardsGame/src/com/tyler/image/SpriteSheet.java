package com.tyler.image;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    // VARIABLES
    private BufferedImage image;
    private int spriteIncrement = 32;


    // CONSTRUCTOR
    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }


    // METHODS
    public BufferedImage grabImage(int col, int row, int width, int height) {
        return image.getSubimage((col * spriteIncrement) - spriteIncrement, (row * spriteIncrement) - spriteIncrement, width, height);
    }
}
