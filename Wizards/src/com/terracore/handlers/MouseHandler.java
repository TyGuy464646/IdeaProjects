package com.terracore.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import com.terracore.storages.Textures;
import com.terracore.wizards.BeginScreen;
import com.terracore.wizards.CreditsScreen;
import com.terracore.wizards.HelpScreen;
import com.terracore.wizards.Wizards;

public class MouseHandler implements MouseListener, MouseMotionListener {

	String currentButton;

	private boolean btnBeginHover = false;
	private boolean btnHelpHover = false;
	private boolean btnBuildHover = false;
	private boolean btnCreditHover = false;
	private boolean btnExitHover = false;
	private boolean btnSettingsHover = false;
	private boolean btnVolumeHover = false;
	private boolean btnMusicHover = false;
	private boolean btnBackHover = false;
	private boolean btnPrevHover = false;
	private boolean btnNextHover = false;

	private boolean chk1Hover = false;
	private boolean chk2Hover = false;
	private boolean chk3Hover = false;
	private boolean chk4Hover = false;

	private int currentResolution = 800;

	private AudioHandler audioHandler = new AudioHandler();

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (Wizards.showTitleScreen) {

				// TITLESCREEN BUTTONS
				// Button Begin
				if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
						&& e.getY() >= Wizards.compareToHeight(225) && e.getY() <= Wizards.compareToHeight(225) + 50) {
					Textures.btnBeginState = Textures.btnBeginPress;
					currentButton = "Begin";
				}

				// Button Build
				if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
						&& e.getY() >= Wizards.compareToHeight(280) && e.getY() <= Wizards.compareToHeight(280) + 50) {
					Textures.btnBuildState = Textures.btnBuildPress;
					currentButton = "Build";
				}

				// Button Help
				if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
						&& e.getY() >= Wizards.compareToWidth(335) && e.getY() <= Wizards.compareToWidth(335) + 50) {
					Textures.btnHelpState = Textures.btnHelpPress;
					currentButton = "Help";
				}

				// Button Credits
				if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
						&& e.getY() >= Wizards.compareToHeight(390) && e.getY() <= Wizards.compareToHeight(390) + 50) {
					Textures.btnCreditState = Textures.btnCreditPress;
					currentButton = "Credits";
				}

				// Button Exit
				if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
						&& e.getY() >= Wizards.compareToHeight(445) && e.getY() <= Wizards.compareToHeight(445) + 50) {
					Textures.btnExitState = Textures.btnExitPress;
					currentButton = "Exit";
				}

				// TITLE SETTING BUTTONS
				// Button Settings
				if (e.getX() >= Wizards.compareToWidth(730) && e.getX() <= Wizards.compareToWidth(730) + 40
						&& e.getY() >= Wizards.compareToHeight(510) && e.getY() <= Wizards.compareToHeight(510) + 40) {
					Textures.btnSettingsState = Textures.btnSettingsPress;
					currentButton = "Settings";
				}

				// SETTINGSSCREEN
				if (Wizards.showSettingsScreen) {

					// Resolution

					if (e.getX() >= Wizards.compareToWidth(655)
							&& e.getX() <= Wizards.compareToWidth(655) + Wizards.compareToWidth(110)
							&& e.getY() >= Wizards.compareToHeight(260)
							&& e.getY() <= Wizards.compareToHeight(260) + Wizards.compareToHeight(20)) {
						if (currentResolution == 700) {
							currentResolution = 800;
						} else if (currentResolution == 800) {
							currentResolution = 900;
						} else if (currentResolution == 900) {
							currentResolution = 1000;
						} else if (currentResolution == 1000) {
							currentResolution = 700;
						}

						Wizards.changeSize(currentResolution);

					}

				}

				// Button Volume
				if (e.getX() >= Wizards.compareToWidth(680) && e.getX() <= Wizards.compareToWidth(680) + 40
						&& e.getY() >= Wizards.compareToHeight(510) && e.getY() <= Wizards.compareToHeight(510) + 40) {
					currentButton = "Volume";
				}

				// Button Music
				if (e.getX() >= Wizards.compareToWidth(630) && e.getX() <= Wizards.compareToWidth(630) + 40
						&& e.getY() >= Wizards.compareToHeight(510) && e.getY() <= Wizards.compareToHeight(510) + 40) {
					currentButton = "Music";
				}

				// HELPSCREEN BUTTONS
			} else if (Wizards.showHelpScreen) {

				// Button Back
				if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
						&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
					Textures.btnBackState = Textures.btnBackPress;
					currentButton = "Back";
				}

				// Button Previous
				if (e.getX() >= Wizards.compareToWidth(550) && e.getX() <= Wizards.compareToWidth(550) + 40
						&& e.getY() >= Wizards.compareToHeight(50) && e.getY() <= Wizards.compareToHeight(50) + 40) {
					if (HelpScreen.pageNumber > 1) {
						Textures.btnPrevState = Textures.btnPrevPress;
					} else {
						Textures.btnPrevState = Textures.btnPrevPress;
					}
					currentButton = "Previous";
				}

				// Button Next
				if (e.getX() >= Wizards.compareToWidth(650) && e.getX() <= Wizards.compareToWidth(650) + 40
						&& e.getY() >= Wizards.compareToHeight(50) && e.getY() <= Wizards.compareToHeight(50) + 40) {
					if (HelpScreen.pageNumber < HelpScreen.maxPages) {
						Textures.btnNextState = Textures.btnNextPress;
					} else {
						Textures.btnNextState = Textures.btnNextPress;
					}
					currentButton = "Next";
				}

				// CREDITSSCREEN BUTTONS
			} else if (Wizards.showCreditsScreen) {

				// Button Back
				if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
						&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
					Textures.btnBackState = Textures.btnBackPress;
					currentButton = "Back";
				}

				// BEGINSCREEN BUTTONS
			} else if (Wizards.showBeginScreen) {

				// Button Back
				if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
						&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
					Textures.btnBackState = Textures.btnBackPress;
					currentButton = "Back";
				}

				// Button Begin
				if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
						&& e.getY() >= Wizards.compareToHeight(520) && e.getY() <= Wizards.compareToHeight(520) + 50) {
					Textures.btnBeginState = Textures.btnBeginPress;
					currentButton = "Begin";
				}

				// Check Box 1
				if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 150 + 28
						&& e.getY() >= Wizards.compareToHeight(140) && e.getY() <= Wizards.compareToHeight(140) + 28) {
					currentButton = "ChkBox1";
				}

				// Check Box 2
				if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 225 + 28
						&& e.getY() >= Wizards.compareToHeight(175) && e.getY() <= Wizards.compareToHeight(175) + 28) {
					currentButton = "ChkBox2";
				}

				// Check Box 3
				if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 85 + 28
						&& e.getY() >= Wizards.compareToHeight(210) && e.getY() <= Wizards.compareToHeight(210) + 28) {
					currentButton = "ChkBox3";
				}

				// Check Box 4
				if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 190 + 28
						&& e.getY() >= Wizards.compareToHeight(245) && e.getY() <= Wizards.compareToHeight(245) + 28) {
					currentButton = "ChkBox4";
				}

				// BUILDSCREEN BUTTONS
			} else if (Wizards.showBuildScreen) {

				// Button Back
				if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
						&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
					Textures.btnBackState = Textures.btnBackPress;
					currentButton = "Back";
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		// TITLESCREEN BUTTONS
		if (Wizards.showTitleScreen) {

			// MAKE RELEASED THINGY FOR UNCLICK BUTTONS SO PRESSED TEXTURE
			// RESETS

			// Settings Unclick (Checks if you click outside of the settings
			// box, exempts title settings buttons)
			if (Wizards.showSettingsScreen
					&& !(e.getX() >= Wizards.compareToWidth(550)
							&& e.getX() <= Wizards.compareToWidth(550) + Wizards.compareToWidth(230)
							&& e.getY() >= Wizards.compareToHeight(220)
							&& e.getY() <= Wizards.compareToHeight(220) + Wizards.compareToHeight(280))
					&& !(e.getX() >= Wizards.compareToWidth(730) && e.getX() <= Wizards.compareToWidth(730) + 40
							&& e.getY() >= Wizards.compareToHeight(510)
							&& e.getY() <= Wizards.compareToHeight(510) + 40)
					&& !(e.getX() >= Wizards.compareToWidth(680) && e.getX() <= Wizards.compareToWidth(680) + 40
							&& e.getY() >= Wizards.compareToHeight(510)
							&& e.getY() <= Wizards.compareToHeight(510) + 40)
					&& !(e.getX() >= Wizards.compareToWidth(630) && e.getX() <= Wizards.compareToWidth(630) + 40
							&& e.getY() >= Wizards.compareToHeight(510)
							&& e.getY() <= Wizards.compareToHeight(510) + 40)) {
				Wizards.showSettingsScreen = false;
				Textures.btnSettingsState = Textures.btnSettingsDef;
			}

			// Button Begin
			if (currentButton == "Begin" && e.getX() >= Wizards.centerToWidth(150)
					&& e.getX() <= Wizards.centerToWidth(150) + 150 && e.getY() >= Wizards.compareToHeight(225)
					&& e.getY() <= Wizards.compareToHeight(225) + 50) {
				Wizards.showTitleScreen = false;
				Wizards.showBeginScreen = true;
				Textures.btnBeginState = Textures.btnBeginDef;
				audioHandler.playButtonClickSound();
			}

			// Button Build
			if (currentButton == "Build" && e.getX() >= Wizards.centerToWidth(150)
					&& e.getX() <= Wizards.centerToWidth(150) + 150 && e.getY() >= Wizards.compareToHeight(280)
					&& e.getY() <= Wizards.compareToHeight(280) + 50) {
				Wizards.showTitleScreen = false;
				Wizards.showBuildScreen = true;
				Textures.btnBuildState = Textures.btnBuildDef;
				audioHandler.playButtonClickSound();
			}

			// Button Help
			if (currentButton == "Help" && e.getX() >= Wizards.centerToWidth(150)
					&& e.getX() <= Wizards.centerToWidth(150) + 150 && e.getY() >= Wizards.compareToWidth(335) / 600
					&& e.getY() <= Wizards.compareToWidth(335) + 50) {
				Wizards.showTitleScreen = false;
				Wizards.showHelpScreen = true;
				Textures.btnHelpState = Textures.btnHelpDef;
				audioHandler.playButtonClickSound();
			}

			// Button Credits
			if (currentButton == "Credits" && e.getX() >= Wizards.centerToWidth(150)
					&& e.getX() <= Wizards.centerToWidth(150) + 150 && e.getY() >= Wizards.compareToHeight(390)
					&& e.getY() <= Wizards.compareToHeight(390) + 50) {
				CreditsScreen.startY = Wizards.compareToHeight(600);
				CreditsScreen.y = CreditsScreen.startY;
				Wizards.showTitleScreen = false;
				Wizards.showCreditsScreen = true;
				Textures.btnCreditState = Textures.btnCreditDef;
				audioHandler.playButtonClickSound();
			}

			// Button Exit
			if (currentButton == "Exit" && e.getX() >= Wizards.centerToWidth(150)
					&& e.getX() <= Wizards.centerToWidth(150) + 150 && e.getY() >= Wizards.compareToHeight(445)
					&& e.getY() <= Wizards.compareToHeight(445) + 50) {
				Textures.btnExitState = Textures.btnExitDef;
				audioHandler.playButtonClickSound();
				Wizards.exit();
			}

			// Button Settings
			if (currentButton == "Settings" && e.getX() >= Wizards.compareToWidth(730)
					&& e.getX() <= Wizards.compareToWidth(730) + 40 && e.getY() >= Wizards.compareToHeight(510)
					&& e.getY() <= Wizards.compareToHeight(510) + 40) {
				Wizards.showSettingsScreen = !Wizards.showSettingsScreen;
				audioHandler.playButtonClickSound();
				if (Wizards.showSettingsScreen) {
					Textures.btnSettingsState = Textures.btnSettingsPressHov;
				} else {
					Textures.btnSettingsState = Textures.btnSettingsHov;
				}
			}

			// Button Volume
			if (currentButton == "Volume" && e.getX() >= Wizards.compareToWidth(680)
					&& e.getX() <= Wizards.compareToWidth(680) + 40 && e.getY() >= Wizards.compareToHeight(510)
					&& e.getY() <= Wizards.compareToHeight(510) + 40) {
				if (Wizards.volumeOn) {
					Textures.btnVolumeState = Textures.btnVolumeMuteHov;
				} else {
					Textures.btnVolumeState = Textures.btnVolumeHov;
				}
				Wizards.volumeOn = !Wizards.volumeOn;
				audioHandler.playButtonClickSound();
			}

			// Button Music
			if (currentButton == "Music" && e.getX() >= Wizards.compareToWidth(630)
					&& e.getX() <= Wizards.compareToWidth(630) + 40 && e.getY() >= Wizards.compareToHeight(510)
					&& e.getY() <= Wizards.compareToHeight(510) + 40) {
				if (Wizards.musicOn) {
					Textures.btnMusicState = Textures.btnMusicMuteHov;
				} else {
					Textures.btnMusicState = Textures.btnMusicHov;
				}
				Wizards.musicOn = !Wizards.musicOn;
				audioHandler.playButtonClickSound();

			}

			// HELPSCREEN BUTTONS
		} else if (Wizards.showHelpScreen) {

			// Button Back
			if (currentButton == "Back" && e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(40)
					&& e.getY() <= Wizards.compareToHeight(40) + 50) {
				Textures.btnPrevState = Textures.btnPrevPress;
				Textures.btnNextState = Textures.btnNextDef;
				HelpScreen.pageNumber = 1;
				Wizards.showHelpScreen = false;
				Wizards.showTitleScreen = true;
				Textures.btnBackState = Textures.btnBackDef;
				audioHandler.playButtonClickSound();
			}

			// Button Previous
			if (currentButton == "Previous" && e.getX() >= Wizards.compareToWidth(550)
					&& e.getX() <= Wizards.compareToWidth(550) + 40 && e.getY() >= Wizards.compareToHeight(50)
					&& e.getY() <= Wizards.compareToHeight(50) + 40) {
				if (HelpScreen.pageNumber > 1) {
					Textures.btnNextState = Textures.btnNextDef;
					HelpScreen.pageNumber--;
					audioHandler.playButtonClickSound();
				}
				if (HelpScreen.pageNumber > 1) {
					Textures.btnPrevState = Textures.btnPrevHov;
				}
			}

			// Button Next
			if (currentButton == "Next" && e.getX() >= Wizards.compareToWidth(650)
					&& e.getX() <= Wizards.compareToWidth(650) + 40 && e.getY() >= Wizards.compareToHeight(50)
					&& e.getY() <= Wizards.compareToHeight(50) + 40) {
				if (HelpScreen.pageNumber < HelpScreen.maxPages) {
					Textures.btnPrevState = Textures.btnPrevDef;
					HelpScreen.pageNumber++;
					audioHandler.playButtonClickSound();
				}
				if (HelpScreen.pageNumber < HelpScreen.maxPages) {
					Textures.btnNextState = Textures.btnNextHov;
				}
			}

			// CREDITSSCREEN BUTTONS
		} else if (Wizards.showCreditsScreen) {

			// Button Back
			if (currentButton == "Back" && e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(40)
					&& e.getY() <= Wizards.compareToHeight(40) + 50) {
				Wizards.showCreditsScreen = false;
				Wizards.showTitleScreen = true;
				Textures.btnBackState = Textures.btnBackDef;
				audioHandler.playButtonClickSound();
			}

			// BEGINSCREEN BUTTONS
		} else if (Wizards.showBeginScreen) {

			// Button Back
			if (currentButton == "Back" && e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(40)
					&& e.getY() <= Wizards.compareToHeight(40) + 50) {
				Wizards.showBeginScreen = false;
				Wizards.showTitleScreen = true;
				Textures.btnBackState = Textures.btnBackDef;
				audioHandler.playButtonClickSound();
			}

			// Button Begin
			if (currentButton == "Begin" && e.getX() >= Wizards.centerToWidth(150)
					&& e.getX() <= Wizards.centerToWidth(150) + 150 && e.getY() >= Wizards.compareToHeight(520)
					&& e.getY() <= Wizards.compareToHeight(520) + 50) {
				Wizards.showBeginScreen = false;
				if (Wizards.Gamemode == 3) {
					Wizards.showPlayScreenHorde = true;
				}
				Textures.btnBeginState = Textures.btnBeginDef;
				audioHandler.playButtonClickSound();
			}

			// Check Box 1
			if (currentButton == "ChkBox1" && e.getX() >= Wizards.compareToWidth(10)
					&& e.getX() <= Wizards.compareToWidth(10) + 150 + 28 && e.getY() >= Wizards.compareToHeight(140)
					&& e.getY() <= Wizards.compareToHeight(140) + 28) {
				Textures.chkBoxState1 = Textures.chkBoxChkHov;
				Textures.chkBoxState2 = Textures.chkBox;
				Textures.chkBoxState3 = Textures.chkBox;
				Textures.chkBoxState4 = Textures.chkBox;
				audioHandler.playButtonClickSound();

				Wizards.Gamemode = 1;
			}

			// Check Box 2
			if (currentButton == "ChkBox2" && e.getX() >= Wizards.compareToWidth(10)
					&& e.getX() <= Wizards.compareToWidth(10) + 225 + 28 && e.getY() >= Wizards.compareToHeight(175)
					&& e.getY() <= Wizards.compareToHeight(175) + 28) {
				Textures.chkBoxState1 = Textures.chkBox;
				Textures.chkBoxState2 = Textures.chkBoxChkHov;
				Textures.chkBoxState3 = Textures.chkBox;
				Textures.chkBoxState4 = Textures.chkBox;
				audioHandler.playButtonClickSound();

				Wizards.Gamemode = 2;
			}

			// Check Box 3
			if (currentButton == "ChkBox3" && e.getX() >= Wizards.compareToWidth(10)
					&& e.getX() <= Wizards.compareToWidth(10) + 85 + 28 && e.getY() >= Wizards.compareToHeight(210)
					&& e.getY() <= Wizards.compareToHeight(210) + 28) {
				Textures.chkBoxState1 = Textures.chkBox;
				Textures.chkBoxState2 = Textures.chkBox;
				Textures.chkBoxState3 = Textures.chkBoxChkHov;
				Textures.chkBoxState4 = Textures.chkBox;
				audioHandler.playButtonClickSound();

				Wizards.Gamemode = 3;
			}

			// Check Box 4
			if (currentButton == "ChkBox4" && e.getX() >= Wizards.compareToWidth(10)
					&& e.getX() <= Wizards.compareToWidth(10) + 190 + 28 && e.getY() >= Wizards.compareToHeight(245)
					&& e.getY() <= Wizards.compareToHeight(245) + 28) {
				Textures.chkBoxState1 = Textures.chkBox;
				Textures.chkBoxState2 = Textures.chkBox;
				Textures.chkBoxState3 = Textures.chkBox;
				Textures.chkBoxState4 = Textures.chkBoxChkHov;
				audioHandler.playButtonClickSound();

				Wizards.Gamemode = 4;
			}

			// BUILDSCREEN BUTTONS
		} else if (Wizards.showBuildScreen) {

			// Button Back
			if (currentButton == "Back" && e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(40)
					&& e.getY() <= Wizards.compareToHeight(40) + 50) {
				Wizards.showBuildScreen = false;
				Wizards.showTitleScreen = true;
				Textures.btnBackState = Textures.btnBackDef;
				audioHandler.playButtonClickSound();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		// TITLE SCREEN BUTTONS
		if (Wizards.showTitleScreen) {
			// Button Begin
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(225) && e.getY() <= Wizards.compareToHeight(225) + 50) {
				Textures.btnBeginState = Textures.btnBeginHov;
				if (!btnBeginHover) {
					audioHandler.playButtonHoverSound();
					btnBeginHover = true;
				}
			} else {
				Textures.btnBeginState = Textures.btnBeginDef;
				btnBeginHover = false;
			}

			// Button Build
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(280) && e.getY() <= Wizards.compareToHeight(280) + 50) {
				Textures.btnBuildState = Textures.btnBuildHov;
				if (!btnBuildHover) {
					audioHandler.playButtonHoverSound();
					btnBuildHover = true;
				}
			} else {
				Textures.btnBuildState = Textures.btnBuildDef;
				btnBuildHover = false;
			}

			// Button Help
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToWidth(335) && e.getY() <= Wizards.compareToWidth(335) + 50) {
				Textures.btnHelpState = Textures.btnHelpHov;
				if (!btnHelpHover) {
					audioHandler.playButtonHoverSound();
					btnHelpHover = true;
				}
			} else {
				Textures.btnHelpState = Textures.btnHelpDef;
				btnHelpHover = false;
			}

			// Button Credit
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(390) && e.getY() <= Wizards.compareToHeight(390) + 50) {
				Textures.btnCreditState = Textures.btnCreditHov;
				if (!btnCreditHover) {
					audioHandler.playButtonHoverSound();
					btnCreditHover = true;
				}
			} else {
				Textures.btnCreditState = Textures.btnCreditDef;
				btnCreditHover = false;
			}

			// Button Exit
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(445) && e.getY() <= Wizards.compareToHeight(445) + 50) {
				Textures.btnExitState = Textures.btnExitHov;
				if (!btnExitHover) {
					audioHandler.playButtonHoverSound();
					btnExitHover = true;
				}
			} else {
				Textures.btnExitState = Textures.btnExitDef;
				btnExitHover = false;
			}

			// TITLE SETTINGS BUTTONS
			// Button Settings
			if (e.getX() >= Wizards.compareToWidth(730) && e.getX() <= Wizards.compareToWidth(730) + 40
					&& e.getY() >= Wizards.compareToHeight(510) && e.getY() <= Wizards.compareToHeight(510) + 40) {

				if (Wizards.showSettingsScreen) {
					Textures.btnSettingsState = Textures.btnSettingsPressHov;
				} else {
					Textures.btnSettingsState = Textures.btnSettingsHov;
				}
				if (!btnSettingsHover) {
					audioHandler.playButtonHoverSound();
					btnSettingsHover = true;
				}
			} else {
				if (Wizards.showSettingsScreen) {
					Textures.btnSettingsState = Textures.btnSettingsPress;
				} else {
					Textures.btnSettingsState = Textures.btnSettingsDef;
				}
				btnSettingsHover = false;
			}

			// Button Volume
			if (e.getX() >= Wizards.compareToWidth(680) && e.getX() <= Wizards.compareToWidth(680) + 40
					&& e.getY() >= Wizards.compareToHeight(510) && e.getY() <= Wizards.compareToHeight(510) + 40) {

				if (!btnVolumeHover) {
					audioHandler.playButtonHoverSound();
					btnVolumeHover = true;
				}

				if (Wizards.volumeOn) {
					Textures.btnVolumeState = Textures.btnVolumeHov;
				} else {
					Textures.btnVolumeState = Textures.btnVolumeMuteHov;
				}
			} else {
				if (Wizards.volumeOn) {
					Textures.btnVolumeState = Textures.btnVolumeDef;
				} else {
					Textures.btnVolumeState = Textures.btnVolumeMute;
				}
				btnVolumeHover = false;
			}

			// Button Music
			if (e.getX() >= Wizards.compareToWidth(630) && e.getX() <= Wizards.compareToWidth(630) + 40
					&& e.getY() >= Wizards.compareToHeight(510) && e.getY() <= Wizards.compareToHeight(510) + 40) {

				if (!btnMusicHover) {
					audioHandler.playButtonHoverSound();
					btnMusicHover = true;
				}

				if (Wizards.musicOn) {
					Textures.btnMusicState = Textures.btnMusicHov;
				} else {
					Textures.btnMusicState = Textures.btnMusicMuteHov;
				}
			} else {
				if (Wizards.musicOn) {
					Textures.btnMusicState = Textures.btnMusicDef;
				} else {
					Textures.btnMusicState = Textures.btnMusicMute;
				}
				btnMusicHover = false;
			}

			// HELPSCREEN BUTTONS
		} else if (Wizards.showHelpScreen) {
			// Button Back
			if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
				Textures.btnBackState = Textures.btnBackHov;

				if (!btnBackHover) {
					audioHandler.playButtonHoverSound();
					btnBackHover = true;
				}
			} else {
				Textures.btnBackState = Textures.btnBackDef;
				btnBackHover = false;
			}

			// Button Previous
			if (HelpScreen.pageNumber > 1) {
				if (e.getX() >= Wizards.compareToWidth(550) && e.getX() <= Wizards.compareToWidth(550) + 40
						&& e.getY() >= Wizards.compareToHeight(50) && e.getY() <= Wizards.compareToHeight(50) + 40) {
					Textures.btnPrevState = Textures.btnPrevHov;
					if (!btnPrevHover) {
						audioHandler.playButtonHoverSound();
						btnPrevHover = true;
					}
				} else {
					btnPrevHover = false;
					Textures.btnPrevState = Textures.btnPrevDef;
				}
			} else {
				// Can probably be deleted?
				// HelpScreen.btnPrevState = HelpScreen.btnPrevPress;
			}

			// Button Next
			if (HelpScreen.pageNumber < HelpScreen.maxPages) {
				if (e.getX() >= Wizards.compareToWidth(650) && e.getX() <= Wizards.compareToWidth(650) + 40
						&& e.getY() >= Wizards.compareToHeight(50) && e.getY() <= Wizards.compareToHeight(50) + 40) {
					Textures.btnNextState = Textures.btnNextHov;
					if (!btnNextHover) {
						audioHandler.playButtonHoverSound();
						btnNextHover = true;
					}
				} else {
					btnNextHover = false;
					Textures.btnNextState = Textures.btnNextDef;
				}
			} else {
				// Can probably be deleted?
				// HelpScreen.btnNextState = HelpScreen.btnNextPress;
			}

			// CREDITSSCREEN BUTTONS
		} else if (Wizards.showCreditsScreen) {

			// Button Back
			if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
				Textures.btnBackState = Textures.btnBackHov;
				if (!btnBackHover) {
					audioHandler.playButtonHoverSound();
					btnBackHover = true;
				}
			} else {
				Textures.btnBackState = Textures.btnBackDef;
				btnBackHover = false;
			}

			// BEGINSCREEN BUTTONS
		} else if (Wizards.showBeginScreen) {

			// Button Back
			if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
				Textures.btnBackState = Textures.btnBackHov;
				if (!btnBackHover) {
					audioHandler.playButtonHoverSound();
					btnBackHover = true;
				}
			} else {
				Textures.btnBackState = Textures.btnBackDef;
				btnBackHover = false;
			}

			// Button Begin
			if (e.getX() >= Wizards.centerToWidth(150) && e.getX() <= Wizards.centerToWidth(150) + 150
					&& e.getY() >= Wizards.compareToHeight(520) && e.getY() <= Wizards.compareToHeight(520) + 50) {
				Textures.btnBeginState = Textures.btnBeginHov;
				if (!btnBeginHover) {
					audioHandler.playButtonHoverSound();
					btnBeginHover = true;
				}
			} else {
				Textures.btnBeginState = Textures.btnBeginDef;
				btnBeginHover = false;
			}

			// Check Box 1
			if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 150 + 28
					&& e.getY() >= Wizards.compareToHeight(140) && e.getY() <= Wizards.compareToHeight(140) + 28) {

				if (!chk1Hover) {
					audioHandler.playButtonHoverSound();
					chk1Hover = true;
				}

				if (Wizards.Gamemode == 1) {
					Textures.chkBoxState1 = Textures.chkBoxChkHov;
				} else {
					Textures.chkBoxState1 = Textures.chkBoxHov;
				}
			} else {
				if (Wizards.Gamemode == 1) {
					Textures.chkBoxState1 = Textures.chkBoxChk;
				} else {
					Textures.chkBoxState1 = Textures.chkBox;
				}
				chk1Hover = false;
			}

			// Check Box 2
			if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 225 + 28
					&& e.getY() >= Wizards.compareToHeight(175) && e.getY() <= Wizards.compareToHeight(175) + 28) {

				if (!chk2Hover) {
					audioHandler.playButtonHoverSound();
					chk2Hover = true;
				}

				if (Wizards.Gamemode == 2) {
					Textures.chkBoxState2 = Textures.chkBoxChkHov;
				} else {
					Textures.chkBoxState2 = Textures.chkBoxHov;
				}
			} else {
				if (Wizards.Gamemode == 2) {
					Textures.chkBoxState2 = Textures.chkBoxChk;
				} else {
					Textures.chkBoxState2 = Textures.chkBox;
				}
				chk2Hover = false;
			}

			// Check Box 3
			if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 85 + 28
					&& e.getY() >= Wizards.compareToHeight(210) && e.getY() <= Wizards.compareToHeight(210) + 28) {

				if (!chk3Hover) {
					audioHandler.playButtonHoverSound();
					chk3Hover = true;
				}

				if (Wizards.Gamemode == 3) {
					Textures.chkBoxState3 = Textures.chkBoxChkHov;
				} else {
					Textures.chkBoxState3 = Textures.chkBoxHov;
				}
			} else {
				if (Wizards.Gamemode == 3) {
					Textures.chkBoxState3 = Textures.chkBoxChk;
				} else {
					Textures.chkBoxState3 = Textures.chkBox;
				}
				chk3Hover = false;
			}

			// Check Box 4
			if (e.getX() >= Wizards.compareToWidth(10) && e.getX() <= Wizards.compareToWidth(10) + 190 + 28
					&& e.getY() >= Wizards.compareToHeight(245) && e.getY() <= Wizards.compareToHeight(245) + 28) {

				if (!chk4Hover) {
					audioHandler.playButtonHoverSound();
					chk4Hover = true;
				}

				if (Wizards.Gamemode == 4) {
					Textures.chkBoxState4 = Textures.chkBoxChkHov;
				} else {
					Textures.chkBoxState4 = Textures.chkBoxHov;
				}
			} else {
				if (Wizards.Gamemode == 4) {
					Textures.chkBoxState4 = Textures.chkBoxChk;
				} else {
					Textures.chkBoxState4 = Textures.chkBox;
				}
				chk4Hover = false;
			}

			// BUILDSCREEN BUTTONS
		} else if (Wizards.showBuildScreen) {

			// Button Back
			if (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(40) && e.getY() <= Wizards.compareToHeight(40) + 50) {
				Textures.btnBackState = Textures.btnBackHov;
				if (!btnBackHover) {
					audioHandler.playButtonHoverSound();
					btnBackHover = true;
				}
			} else {
				Textures.btnBackState = Textures.btnBackDef;
				btnBackHover = false;
			}
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
