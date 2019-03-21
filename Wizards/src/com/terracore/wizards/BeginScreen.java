package com.terracore.wizards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.terracore.storages.Colorer;
import com.terracore.storages.Textures;

public class BeginScreen {

	private int fontSizeChkBoxDef = 25;
	private int fontSizeChkBox = fontSizeChkBoxDef;

	public void paint(Graphics g) {

		fontSizeChkBox = Wizards.compareToWidth(fontSizeChkBoxDef);

		// Background
		g.setColor(new Color(255, 250, 150));
		g.fillRect(0, 0, Wizards.WIDTH, Wizards.HEIGHT);
		
		Textures.HordeBackground.render(g, 275, 100);

		// Top Bar
		g.setColor(new Color(244, 231, 129));
		g.fillRect(0, 0, Wizards.WIDTH, Wizards.compareToHeight(100));

		g.setColor(Colorer.Tan0);
		g.fillRect(0, Wizards.compareToWidth(100), 275, Wizards.HEIGHT - Wizards.compareToWidth(100));
		g.fillRect(0, Wizards.HEIGHT - Wizards.compareToWidth(100), Wizards.WIDTH, Wizards.compareToWidth(100));

		g.setColor(Colorer.LightBrown);
		g.drawLine(Wizards.compareToWidth(275), Wizards.compareToWidth(100), Wizards.WIDTH,
				Wizards.compareToWidth(100));
		g.drawLine(275, Wizards.compareToHeight(100), 275, Wizards.HEIGHT - Wizards.compareToWidth(100));
		g.drawLine(Wizards.compareToWidth(275), Wizards.HEIGHT - Wizards.compareToWidth(100), Wizards.WIDTH,
				Wizards.HEIGHT - Wizards.compareToWidth(100));

		// Buttons
		Textures.btnBackState.render(g, Wizards.compareToWidth(20), Wizards.compareToHeight(40));
		Textures.btnBeginState.render(g, Wizards.centerToWidth(150), Wizards.compareToHeight(520));

		// Check Boxes
		Textures.chkBoxState4.render(g, Wizards.compareToWidth(10), Wizards.compareToHeight(245));
		Textures.chkBoxState3.render(g, Wizards.compareToWidth(10), Wizards.compareToHeight(210));
		Textures.chkBoxState2.render(g, Wizards.compareToWidth(10), Wizards.compareToHeight(175));
		Textures.chkBoxState1.render(g, Wizards.compareToWidth(10), Wizards.compareToHeight(140));

		// Check Box Text
		g.setColor(Colorer.MediumBrown);
		g.setFont(new Font("ZapfDingbats", Font.BOLD, fontSizeChkBox));

		g.drawString("Free For All", Wizards.compareToWidth(50), Wizards.compareToHeight(165));
		g.drawString("Team Deathmatch", Wizards.compareToWidth(50), Wizards.compareToHeight(200));
		g.drawString("Horde", Wizards.compareToWidth(50), Wizards.compareToHeight(235));
		g.drawString("Endless Horde", Wizards.compareToWidth(50), Wizards.compareToHeight(270));

	}

}
