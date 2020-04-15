package com.tyler.tileMap;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.org.apache.bcel.internal.generic.DRETURN;

import java.awt.image.BufferedImage;

public class Tile {

    // Variables
    private BufferedImage image;
    private int type;

    public static final int NORMAL = 0;
    public static final int BLOCKED = 1;


    // Constructor
    public Tile(BufferedImage image,  int type) {
        this.image = image;
        this.type = type;
    }


    // Methods
    public BufferedImage getImage() {
        return image;
    }

    public int getType() {
        return type;
    }

}
