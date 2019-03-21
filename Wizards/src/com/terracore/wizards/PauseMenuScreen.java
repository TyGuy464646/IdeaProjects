package com.terracore.wizards;

import java.awt.*;

import com.terracore.handlers.*;
import com.terracore.storages.*;

public class PauseMenuScreen {

	// Variables
	public static int startY;
	public static int y = startY;
	public static int scrollVel = 20;

	void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());

	}

	// Paint Method
	public void paint(Graphics g) {

		y += scrollVel;
		if (y >= 10) {
			scrollVel = 0;
		}
		if (y <= -400) {
			scrollVel = 0;
			Wizards.showPauseMenuScreen = false;
		}

		// Outline background
		g.setColor(Colorer.LightBrown);
		g.fillRect(Wizards.centerToWidth(600), y, 600, 400);

		// Light Background
		g.setColor(Colorer.Tan1);
		g.fillRect(Wizards.centerToWidth(580), y + 10, 580, 380);

		// Text
		g.setColor(Colorer.MediumBrown);
		g.drawString("PAUSE", Wizards.centerToWidth(115), y + 50);
		drawString(g, "Note: This does actually prevent\nthe player from hitting the buttons\nin the game.",
				Wizards.centerToWidth(570), y + 100);

		// Buttons
		Textures.btnExitState.render(g, Wizards.centerToWidth(150), y + 325);
	}

}
