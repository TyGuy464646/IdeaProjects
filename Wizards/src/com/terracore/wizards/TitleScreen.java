package com.terracore.wizards;

import java.awt.Font;
import java.awt.Graphics;
import com.terracore.storages.Colorer;
import com.terracore.storages.Textures;

public class TitleScreen {

	private int fontSizeSettingsTitleDef = 18;
	private int fontSizeSettingsTextDef = 15;
	private int fontSizeSettingsTitle = fontSizeSettingsTitleDef;
	private int fontSizeSettingsText = fontSizeSettingsTextDef;

	public static String currentResolutionText = Wizards.WIDTH + "X" + Wizards.HEIGHT;

	public void paint(Graphics g) {
		
		// Background
		g.setColor(Colorer.Tan0);
		g.fillRect(0, 0, Wizards.WIDTH, Wizards.HEIGHT);

		// Title Screen Image
		Textures.TitleImage.render(g, Wizards.centerToWidth(800), Wizards.compareToHeight(10));

		// Title Screen Buttons
		Textures.btnBeginState.render(g, Wizards.centerToWidth(150), Wizards.compareToHeight(225));
		Textures.btnBuildState.render(g, Wizards.centerToWidth(150), Wizards.compareToHeight(280));
		Textures.btnHelpState.render(g, Wizards.centerToWidth(150), Wizards.compareToHeight(335));
		Textures.btnCreditState.render(g, Wizards.centerToWidth(150), Wizards.compareToHeight(390));
		Textures.btnExitState.render(g, Wizards.centerToWidth(150), Wizards.compareToHeight(445));

		// Title Screen Settings Buttons
		Textures.btnSettingsState.render(g, Wizards.compareToWidth(730), Wizards.compareToHeight(510));
		Textures.btnVolumeState.render(g, Wizards.compareToWidth(680), Wizards.compareToHeight(510));
		Textures.btnMusicState.render(g, Wizards.compareToWidth(630), Wizards.compareToHeight(510));

		if (Wizards.showSettingsScreen) {

			fontSizeSettingsTitle = Wizards.compareToWidth(fontSizeSettingsTitleDef);
			fontSizeSettingsText = Wizards.compareToWidth(fontSizeSettingsTextDef);
			
			currentResolutionText = Wizards.WIDTH + "X" + Wizards.HEIGHT;
			
			// Background
			g.setColor(Colorer.LightBrown);
			g.fillRect(Wizards.compareToWidth(550), Wizards.compareToHeight(220), Wizards.compareToWidth(230),
					Wizards.compareToHeight(280));

			// Top Bar
			g.setColor(Colorer.Tan1);
			g.fillRect(Wizards.compareToWidth(555), Wizards.compareToHeight(225), Wizards.compareToWidth(220),
					Wizards.compareToHeight(30));
			// Title
			g.setColor(Colorer.MediumBrown);
			g.setFont(new Font("ZapfDingbats", Font.BOLD, fontSizeSettingsTitle));
			g.drawString("Settings", Wizards.compareToWidth(625), Wizards.compareToHeight(245));

			// Resolution
			g.setColor(Colorer.Tan1);
			g.setFont(new Font("ZapfDingbats", Font.BOLD, fontSizeSettingsText));
			g.drawString("Resolution:", Wizards.compareToWidth(565), Wizards.compareToHeight(275));

			g.fillRoundRect(Wizards.compareToWidth(655), Wizards.compareToHeight(260), Wizards.compareToWidth(110),
					Wizards.compareToHeight(20), 5, 5);

			g.setColor(Colorer.MediumBrown);
			g.setFont(new Font("ZapfDingbats", Font.BOLD, fontSizeSettingsText));
			g.drawString(currentResolutionText, Wizards.compareToWidth(660), Wizards.compareToHeight(275));
		}
	}
}
