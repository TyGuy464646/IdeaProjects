package com.terracore.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.terracore.storages.Textures;
import com.terracore.wizards.PauseMenuScreen;
import com.terracore.wizards.Wizards;

public class PauseMenuMouseHandler implements MouseListener, MouseMotionListener {

	String currentButton;

	private boolean btnExitHover = false;

	private AudioHandler audioHandler = new AudioHandler();

	@Override
	public void mousePressed(MouseEvent e) {
		if (Wizards.showPauseMenuScreen) {
			// PAUSEMENU BUTTONS
			// Button Exit

			// / Wizards.centerToWidth(150), y + 325

			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(PauseMenuScreen.y + 325)
					&& e.getY() <= Wizards.compareToHeight(PauseMenuScreen.y + 325) + 50) {
				Textures.btnExitState = Textures.btnExitPress;
				currentButton = "Exit";
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (Wizards.showPauseMenuScreen) {
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(PauseMenuScreen.y + 325)
					&& e.getY() <= Wizards.compareToHeight(PauseMenuScreen.y + 325) + 50) {
				Wizards.showBeginScreen = false;
				Wizards.showPlayScreenHorde = false;
				Wizards.showPauseMenuScreen = false;
				Wizards.showBuildScreen = false;
				Wizards.showHelpScreen = false;
				Wizards.showCreditsScreen = false;
				Wizards.showSettingsScreen = false;
				Wizards.showLoadingScreen = false;
				Wizards.showTitleScreen = true;
				Textures.btnExitState = Textures.btnExitDef;
				audioHandler.playButtonClickSound();
				PauseMenuScreen.y = PauseMenuScreen.startY;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (Wizards.showPauseMenuScreen) {
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(PauseMenuScreen.y + 325)
					&& e.getY() <= Wizards.compareToHeight(PauseMenuScreen.y + 325) + 50) {
				Textures.btnExitState = Textures.btnExitHov;
				if (!btnExitHover) {
					audioHandler.playButtonHoverSound();
					btnExitHover = true;
				}
			} else {
				Textures.btnExitState = Textures.btnExitDef;
				btnExitHover = false;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}
}
