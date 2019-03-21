package com.terracore.handlers;

import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


public class Texture {
	
	private final static Map<String, TextureHandler> textMap = new HashMap<String, TextureHandler>();
	private TextureHandler manager;
	private String fileName;

	public Texture(String fileName) {
		this.fileName = fileName;
		TextureHandler oldTexture = textMap.get(fileName);
		if (oldTexture != null) {
			manager = oldTexture;
			manager.addReference();
		} else {
			try {
				//LoadingScreen.LoadingMessage = "Loading texture:" + fileName;
				System.out.println("Loading texture: " + fileName);
				manager = new TextureHandler(ImageIO.read(new File("resources/images/" + fileName + ".png")));
				textMap.put(fileName, manager);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void finalize() throws Throwable {
		if (manager.removeReference() && !fileName.isEmpty())
			textMap.remove(fileName);
		System.out.println("Removing from memory:" + fileName);
		super.finalize();
	}

	public void render(Graphics g, double x, double y) {
		g.drawImage(manager.getImage(), (int) x, (int) y, null);
	}
	
	public void renderRotated(Graphics g, int x, int y, int width, int height, int rotated) {
		AffineTransform at = AffineTransform.getTranslateInstance(x, y);
		at.rotate(Math.toRadians(rotated), width/2, height/2);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(manager.getImage(), at, null);
	}

}
