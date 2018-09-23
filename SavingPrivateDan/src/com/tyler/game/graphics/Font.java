package com.tyler.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Font {
    // Variables
    private BufferedImage FONTSHEET = null;
    private BufferedImage[][] spriteArray;

    private final int TILE_SIZE = 32;
    public int  width,
                height;
    public int  widthLetter,
                heightLetter;


    // Constructor
    public Font(String file) {
        width = TILE_SIZE;
        height = TILE_SIZE;

        System.out.println("Loading: " + file + "...");
        FONTSHEET = loadFont(file);

        widthLetter = FONTSHEET.getWidth() / width;
        heightLetter = FONTSHEET.getHeight() / height;

        loadSpriteArray();
    }

    public Font(String file, int width, int height) {
        this.width = width;
        this.height = height;

        System.out.println("Loading: " + file + "...");
        FONTSHEET = loadFont(file);

        widthLetter = FONTSHEET.getWidth() / width;
        heightLetter = FONTSHEET.getHeight() / height;

        loadSpriteArray();
    }


    // Methods
    private BufferedImage loadFont(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        } catch(Exception e) {
            System.out.println("ERROR: Could not load file: " + file);
        }

        return sprite;
    }

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[widthLetter][heightLetter];

        for(int x = 0; x < widthLetter; x++) {
            for(int y = 0; y < heightLetter; y++) {
                spriteArray[x][y] = getLetter(x, y);
            }
        }
    }

    public BufferedImage getFontSheet() {
        return FONTSHEET;
    }

    public BufferedImage getLetter(int x, int y) {
        return FONTSHEET.getSubimage(x * width, y * height, width, height);
    }

    public BufferedImage getFont(char letter) {
        int value = letter - 65;
        System.out.println(value);
        int x = value % widthLetter;
        int y = value / widthLetter;

        return getLetter(x, y);
    }


    // Getters / Setters
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) {
        width = i;
        widthLetter = FONTSHEET.getWidth() / width;
    }

    public void setHeight(int i) {
        height = i;
        heightLetter = FONTSHEET.getHeight() / height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
