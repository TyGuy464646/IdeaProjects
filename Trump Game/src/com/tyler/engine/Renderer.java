package com.tyler.engine;

import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.tyler.engine.gfx.*;

public class Renderer {

    // VARIABLES
    private Font font = Font.STANDARD;
    private ArrayList<ImageRequest> imageRequest = new ArrayList<ImageRequest>();
    private ArrayList<LightRequest> lightRequest = new ArrayList<LightRequest>();


	private int pixelWidth, pixelHeight;
	private int[] pixels;
	private int[] zBuffer;
	private int[] lightMap;
	private int[] lightBlock;

	private int ambientColor = 0xff232323;
	private int zDepth = 0;
	private boolean processing = false;
	private int camX, camY;


	// CONSTRUCTOR
	public Renderer(GameContainer gc) {
		pixelWidth = gc.getWidth();
		pixelHeight = gc.getHeight();
		pixels = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();

		zBuffer = new int[pixels.length];

		lightMap = new int[pixels.length];
		lightBlock = new int[pixels.length];
	}


	// METHODS
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
			zBuffer[i] = 0;
			lightMap[i] = ambientColor;
			lightBlock[i] = 0;
		}
	}

	public void process() {
	    processing = true;

        Collections.sort(imageRequest, new Comparator<ImageRequest>() {

            public int compare(ImageRequest i0, ImageRequest i1) {
                if(i0.zDepth < i1.zDepth)
                    return -1;
                if(i0.zDepth > i1.zDepth)
                    return 1;
                return 0;
            }

        });

	    for(int i = 0; i < imageRequest.size(); i++) {
	        ImageRequest ir = imageRequest.get(i);
	        setzDepth(ir.zDepth);
	        drawImage(ir.image, ir.offX, ir.offY);
        }

        // DRAW LIGHTING
        for(int i = 0; i < lightRequest.size(); i++) {
            LightRequest l = lightRequest.get(i);
            drawLightRequest(l.light, l.locX, l.locY);
        }

        for(int i = 0; i < pixels.length; i++) {
            float red = ((lightMap[i] >> 16) & 0xff) / 255f;
            float green = ((lightMap[i] >> 8) & 0xff) / 255f;
            float blue = (lightMap[i] & 0xff) / 255f;

            pixels[i] = ((int)(((pixels[i] >> 16) & 0xff) * red) << 16 | (int)(((pixels[i] >> 8) & 0xff) * green) << 8 | (int)((pixels[i] & 0xff) * blue));
        }

        imageRequest.clear();
        lightRequest.clear();
	    processing = false;
    }

	public void setPixel(int x, int y, int value) {
		int alpha = ((value >> 24) & 0xff);

	    if((x < 0  || x >= pixelWidth || y < 0 || y >= pixelHeight) || alpha == 0) {
			return;
		}

		int index = x + y * pixelWidth;

		// ALPHA BLENDING
		if(zBuffer[index] > zDepth)
		    return;

		zBuffer[index] = zDepth;

		if(alpha == 255) {
		    pixels[index] = value;
        } else {
            int pixelColor = pixels[index];

            int newRed = ((pixelColor >> 16) & 0xff) - (int)((((pixelColor >> 16) & 0xff) - ((value >> 16) & 0xff)) * (alpha / 255f));
            int newGreen = ((pixelColor >> 8) & 0xff) - (int)((((pixelColor >> 8) & 0xff) - ((value >> 8) & 0xff)) * (alpha / 255f));
            int newBlue = (pixelColor & 0xff) - (int)(((pixelColor & 0xff) - (value & 0xff)) * (alpha / 255f));

		    pixels[x + y * pixelWidth] = (newRed << 16 | newGreen << 8 | newBlue);
        }

	}

	public void setLightMap(int x, int y, int value) {

	    if((x < 0  || x >= pixelWidth || y < 0 || y >= pixelHeight)) {
            return;
        }

        int index = x + y * pixelWidth;
        int baseColor = lightMap[index];

        int maxRed = Math.max((baseColor >> 16) & 0xff, (value >> 16) & 0xff);
        int maxGreen = Math.max((baseColor >> 8) & 0xff, (value >> 8) & 0xff);
        int maxBlue = Math.max(baseColor & 0xff, value & 0xff);

        lightMap[index] = (maxRed << 16 | maxGreen << 8 | maxBlue);
    }

    public void setLightBlock(int x, int y, int value) {

	    if((x < 0  || x >= pixelWidth || y < 0 || y >= pixelHeight)) {
            return;
        }

        if(zBuffer[x + y * pixelWidth] > zDepth)
            return;

        lightBlock[x + y * pixelWidth] = value;
    }

	public void drawText(String text, int offX, int offY, int color) {
        offX -= camX;
        offY -= camY;

        int offset = 0;

        for(int i = 0; i < text.length(); i++) {
            int unicode = text.codePointAt(i);

            for(int y = 0; y < font.getFontImage().getHeight(); y++) {
                for(int x = 0; x < font.getWidths()[unicode]; x++) {
                    if(font.getFontImage().getPixels()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getWidth()] == 0xffffffff) {
                        setPixel(x + offX + offset, y + offY, color);
                    }
                }
            }

            offset += font.getWidths()[unicode];
        }
    }
	
	public void drawImage(Image image, int offX, int offY) {
        offX -= camX;
        offY -= camY;

        if(image.isAlpha() && !processing) {
		    imageRequest.add(new ImageRequest(image, zDepth, offX, offY));
		    return;
        }

	    // DONT RENDER CODE
		if(offX < -image.getWidth()) return;
		if(offY < -image.getHeight()) return;
		if(offX >= pixelWidth) return;
		if(offY >= pixelHeight) return;

		int newX = 0;
		int newY = 0;
		int newWidth = image.getWidth();
		int newHeight = image.getHeight();

		// CLIPPING CODE
		if(offX < 0) newX -= offX;
		if(offY < 0) newY -= offY;
		if(newWidth + offX >= pixelWidth) newWidth -= newWidth + offX - pixelWidth;
		if(newHeight + offY >= pixelHeight) newHeight -= newHeight + offY - pixelHeight;
		
		// DRAW EACH PIXEL
		for(int y = newY; y < newHeight; y++) {
			for(int x = newX; x < newWidth; x++) {
                setPixel(x + offX, y + offY, image.getPixels()[x + y * image.getWidth()]);
                setLightBlock(x + offX, y + offY, image.getLightBlock());
            }
		}
	}

	public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) {
        offX -= camX;
        offY -= camY;

        if(image.isAlpha() && !processing) {
            imageRequest.add(new ImageRequest(image.getTileImage(tileX, tileY), zDepth, offX, offY));
            return;
        }

	    // DONT RENDER CODE
        if(offX < -image.getTileWidth()) return;
        if(offY < -image.getTileHeight()) return;
        if(offX >= pixelWidth) return;
        if(offY >= pixelHeight) return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileWidth();
        int newHeight = image.getTileHeight();

        // CLIPPING CODE
        if(offX < 0) newX -= offX;
        if(offY < 0) newY -= offY;
        if(newWidth + offX >= pixelWidth) newWidth -= newWidth + offX - pixelWidth;
        if(newHeight + offY >= pixelHeight) newHeight -= newHeight + offY - pixelHeight;

        // DRAW EACH PIXEL
        for(int y = newY; y < newHeight; y++) {
            for(int x = newX; x < newWidth; x++) {
                setPixel(x + offX, y + offY, image.getPixels()[(x + tileX * image.getTileWidth()) + (y + tileY * image.getTileHeight()) * image.getWidth()]);
                setLightBlock(x + offX, y + offY, image.getLightBlock());
            }
        }
    }

    public void drawRect(int offX, int offY, int width, int height, int color) {
        offX -= camX;
        offY -= camY;

        for(int y = 0; y <= height; y++) {
	        setPixel(offX, y + offY, color);
            setPixel(offX + width, y + offY, color);
        }
        for(int x = 0; x <= width; x++) {
            setPixel(x + offX, offY, color);
            setPixel(x + offX, offY + height, color);
        }
    }

    public void fillRect(int offX, int offY, int width, int height, int color) {

	    offX -= camX;
	    offY -= camY;

        // DON'T RENDER CODE
        if(offX < -width) return;
        if(offY < -height) return;
        if(offX >= pixelWidth) return;
        if(offY >= pixelHeight) return;

	    for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                setPixel(x + offX, y + offY, color);
            }
        }
    }

    public void drawLight(Light l, int offX, int offY) {
	    lightRequest.add(new LightRequest(l, offX, offY));
    }

    private void drawLightRequest(Light l, int offX, int offY) {
        offX -= camX;
        offY -= camY;

        for(int i = 0; i <= l.getDiameter(); i++) {
            drawLightLine(l, l.getRadius(), l.getRadius(), i, 0, offX, offY);
            drawLightLine(l, l.getRadius(), l.getRadius(), i, l.getDiameter(), offX, offY);
            drawLightLine(l, l.getRadius(), l.getRadius(), 0, i, offX, offY);
            drawLightLine(l, l.getRadius(), l.getRadius(), l.getDiameter(), i, offX, offY);
        }
    }

    private void drawLightLine(Light l, int x0, int y0, int x1, int y1, int offX, int offY) {
	    int dx = Math.abs(x1 - x0);
	    int dy = Math.abs(y1 - y0);

	    int sx = x0 < x1 ? 1 : -1;
	    int sy = y0 < y1 ? 1 : -1;

	    int err = dx - dy;
	    int e2;

	    while(true) {
	        int screenX = x0 - l.getRadius() + offX;
	        int screenY = y0 - l.getRadius() + offY;

	        if(screenX < 0 || screenX >= pixelWidth || screenY < 0 || screenY >= pixelHeight)
	            return;

	        int lightColor = l.getLightValue(x0, y0);
	        if(lightColor == 0)
	            return;

	        if(lightBlock[screenX + screenY * pixelWidth] == Light.FULL)
	            return;

	        setLightMap(screenX, screenY, lightColor);

	        if(x0 == x1 && y0 == y1)
	            break;

	        e2 = 2 * err;

	        if(e2 > -1 * dy) {
	            err -= dy;
	            x0 += sx;
            }

            if(e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }


    // GETTERS AND SETTERS
    public int getzDepth() {
        return zDepth;
    }
    public void setzDepth(int zDepth) {
        this.zDepth = zDepth;
    }

    public int getAmbientColor() {
        return ambientColor;
    }
    public void setAmbientColor(int ambientColor) {
        this.ambientColor = ambientColor;
    }

    public int getCamX() {
        return camX;
    }
    public void setCamX(int camX) {
        this.camX = camX;
    }

    public int getCamY() {
        return camY;
    }
    public void setCamY(int camY) {
        this.camY = camY;
    }
}
