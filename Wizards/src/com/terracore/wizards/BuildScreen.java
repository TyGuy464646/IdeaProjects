package com.terracore.wizards;

import java.awt.Color;
import java.awt.Graphics;

import com.terracore.storages.Textures;

public class BuildScreen {
	
	public void paint(Graphics g) {
		// Background
		g.setColor(new Color(255, 250, 150));
		g.fillRect(0, 0, Wizards.WIDTH, Wizards.HEIGHT);

		// Top Bar
		g.setColor(new Color(244, 231, 129));
		g.fillRect(0, 0, Wizards.WIDTH, Wizards.compareToHeight(100));

		// Buttons
		Textures.btnBackState.render(g, Wizards.compareToWidth(20), Wizards.compareToHeight(40));
	}

}
