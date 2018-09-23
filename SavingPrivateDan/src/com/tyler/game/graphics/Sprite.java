package com.tyler.game.graphics;

import com.tyler.game.util.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sprite {

    // Variables
    private BufferedImage SPRITESHEET = null;
    private BufferedImage[][] spriteArray;

    private final int TILE_SIZE = 32;
    public int width,
            height;
    public int widthSprite,
            heightSprite;


    // Constructor
    public Sprite(String file) {
        width = TILE_SIZE;
        height = TILE_SIZE;

        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        widthSprite = SPRITESHEET.getWidth() / width;
        heightSprite = SPRITESHEET.getHeight() / height;

        loadSpriteArray();
    }

    public Sprite(String file, int width, int height) {
        this.width = width;
        this.height = height;

        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        widthSprite = SPRITESHEET.getWidth() / width;
        heightSprite = SPRITESHEET.getHeight() / height;

        loadSpriteArray();
    }


    // Methods
    private BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        } catch(Exception e) {
            System.out.println("ERROR: Could not load file: " + file);
        }

        return sprite;
    }

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[widthSprite][heightSprite];

        for(int x = 0; x < widthSprite; x++) {
            for(int y = 0; y < heightSprite; y++) {
                spriteArray[x][y] = getSprite(x, y);
            }
        }
    }

    public BufferedImage getSpriteSheet() {
        return SPRITESHEET;
    }

    public BufferedImage getSprite(int x, int y) {
        return SPRITESHEET.getSubimage(x * width, y * height, width, height);
    }

    // Used for Animation
    public BufferedImage[] getSpriteArray(int i) {
        return spriteArray[i];
    }

    public BufferedImage[][] getSpriteArray2(int i) {
        return spriteArray;
    }

    // Used for Fonts
    public static void drawArray(Graphics g, ArrayList<BufferedImage> img, Vector2f pos, int width, int height, int xOffset, int yOffset) {
        float x = pos.x;
        float y = pos.y;

        for(int i = 0; i < img.size(); i++) {
            if(img.get(i) != null) {
                g.drawImage(img.get(i), (int) x, (int) y, width, height, null);
            }

            x += xOffset;
            y += yOffset;
        }
    }

    public static void drawArray(Graphics g, Font f, String word, Vector2f pos, int width, int height, int xOffset, int yOffset) {
        float x = pos.x;
        float y = pos.y;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != 32) { // 32 is the special number for space
                g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
            }
        }

        x += xOffset;
        y += yOffset;
    }


    // Getters / Setters
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) {
        width = i;
        widthSprite = SPRITESHEET.getWidth() / width;
    }

    public void setHeight(int i) {
        height = i;
        heightSprite = SPRITESHEET.getHeight() / height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
