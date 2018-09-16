package com.tyler.engine.gfx;

public class ImageRequest {

    // VARIABLES
    public Image image;
    public int zDepth;
    public int offX, offY;


    // CONSTRUCTOR
    public ImageRequest(Image image, int zDepth, int offX, int offY) {
        this.image = image;
        this.zDepth = zDepth;
        this.offX = offX;
        this.offY = offY;
    }

}
