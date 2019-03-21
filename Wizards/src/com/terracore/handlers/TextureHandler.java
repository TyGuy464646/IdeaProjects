package com.terracore.handlers;

import java.awt.image.BufferedImage;

public class TextureHandler extends ResourceManager{

	private BufferedImage image;

	public TextureHandler(BufferedImage image){
	this.image = image;
}

	public BufferedImage getImage() {
		return image;
	}

}
