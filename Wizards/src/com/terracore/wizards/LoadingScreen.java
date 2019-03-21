package com.terracore.wizards;

import java.awt.Font;
import java.awt.Graphics;

import com.terracore.storages.Colorer;
import com.terracore.storages.Textures;

public class LoadingScreen {
	
	public static boolean isDone = false;
	
	public static String LoadingMessage = "";
	
	public void paint(Graphics g) {
		// Wizards.preLoad = false;
		g.setColor(Colorer.Tan0);
		g.fillRect(0, 0, Wizards.WIDTH, Wizards.HEIGHT);
		g.setColor(Colorer.MediumBrown);
		g.setFont(new Font("ZapfDingbats", Font.BOLD, 50));
		if (Wizards.loadCounter < 80 && Wizards.loadCounter >= 60) {
			g.drawString("Loading", Wizards.centerToWidth(200), Wizards.centerToHeight());
		} else if (Wizards.loadCounter < 60 && Wizards.loadCounter >= 40) {
			g.drawString("Loading.", Wizards.centerToWidth(200), Wizards.centerToHeight());
		} else if (Wizards.loadCounter < 40 && Wizards.loadCounter >= 20) {
			g.drawString("Loading..", Wizards.centerToWidth(200), Wizards.centerToHeight());
		} else if (Wizards.loadCounter < 20 && Wizards.loadCounter >= 0) {
			g.drawString("Loading...", Wizards.centerToWidth(200), Wizards.centerToHeight());
			if (Wizards.loadCounter == 0) {
				Wizards.loadCounter = 80;
			}
		}
		
		g.setFont(new Font("ZapfDingbats", Font.BOLD, 30));
		g.drawString(LoadingMessage, Wizards.centerToWidth(200), Wizards.centerToHeight(-200));
		
		Wizards.loadCounter--;

		if(!isDone){
			@SuppressWarnings("unused")
			Textures Textures = new Textures();
		}
	
	}
}