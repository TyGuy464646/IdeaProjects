package com.tyler.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	// VARIABLES
	private int width, height;
	private int[] pixels;
	private boolean alpha = false;
	private int lightBlock = Light.NONE;


	// CONSTRUCTOR
	public Image(String path) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(Image.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		width = image.getWidth();
		height = image.getHeight();
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
		
		image.flush();
	}

	public Image(int[] pixels, int width, int height) {
	    this.pixels = pixels;
	    this.width = width;
	    this.height = height;
    }

	// GETTERS AND SETTERS
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int[] getPixels() {
		return pixels;
	}
	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}


	// GETTERS AND SETTERS
    public boolean isAlpha() {
        return alpha;
    }
    public void setAlpha(boolean alpha) {
        this.alpha = alpha;
    }

    public int getLightBlock() {
        return lightBlock;
    }
    public void setLightBlock(int lightBlock) {
        this.lightBlock = lightBlock;
    }
}
