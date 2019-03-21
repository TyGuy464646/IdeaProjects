package com.terracore.handlers;

import java.awt.event.*;

import com.terracore.storages.Textures;
import com.terracore.wizards.*;

public class HordeKeyHandler implements KeyListener {

	public HordeKeyHandler() {

		PauseMenuScreen.startY = Wizards.compareToHeight(-400);
		PauseMenuScreen.y = PauseMenuScreen.startY;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (Wizards.showPlayScreenHorde) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE && Wizards.showPauseMenuScreen == false) {
				Wizards.showPauseMenuScreen = true;
				PauseMenuScreen.scrollVel = 20;
			}
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE && Wizards.showPauseMenuScreen == true && PauseMenuScreen.y >= 10) {
				PauseMenuScreen.scrollVel = -20;
				Textures.btnExitState = Textures.btnExitDef;
			}
		}
	}

}
