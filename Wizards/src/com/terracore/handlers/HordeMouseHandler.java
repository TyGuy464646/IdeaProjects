package com.terracore.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.terracore.storages.Cards;
import com.terracore.storages.Textures;
import com.terracore.wizards.Wizards;

public class HordeMouseHandler implements MouseListener, MouseMotionListener {

	public String currentButton = "null";
	public String currentCard = "null";
	public boolean cardIsSelected = false;
	public boolean cancelOption = false;
	public boolean cancel = false;
	public boolean useOption = false;
	public boolean use = false;
	public boolean attackAvailable = true;
	public boolean attack = false;
	public boolean targetSelectable = false;
	public boolean summonSpot = false;
	public boolean canChooseCard = true;
	private boolean btnAttackHover = false;
	private boolean btnCancelHover = false;
	private boolean btnUseHover = false;

	public int overlayX = 2000;
	public int overlayY = 2000;
	public int overlayX2 = 2000;
	public int overlayY2 = 2000;
	public int overlayX3 = 2000;
	public int overlayY3 = 2000;
	public int overlayX4 = 2000;
	public int overlayY4 = 2000;

	public String cardType;

	private AudioHandler audioHandler = new AudioHandler();

	@Override
	public void mousePressed(MouseEvent e) {
		if (Wizards.showPlayScreenHorde && Wizards.showPauseMenuScreen == false) {

			if (canChooseCard && e.getX() >= Wizards.compareToWidth(640)
					&& e.getX() <= Wizards.compareToWidth(640) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				currentButton = "card1";
				cancelOption = true;
				useOption = true;
				attackAvailable = false;
				canChooseCard = true;
				
			}
			if (canChooseCard && e.getX() >= Wizards.compareToWidth(485)
					&& e.getX() <= Wizards.compareToWidth(485) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				currentButton = "card2";
				cancelOption = true;
				useOption = true;
				attackAvailable = false;
				canChooseCard = true;
			}
			if (canChooseCard && e.getX() >= Wizards.compareToWidth(330)
					&& e.getX() <= Wizards.compareToWidth(330) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				currentButton = "card3";
				cancelOption = true;
				useOption = true;
				attackAvailable = false;
				canChooseCard = true;
			}
			if (canChooseCard && e.getX() >= Wizards.compareToWidth(175)
					&& e.getX() <= Wizards.compareToWidth(175) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				currentButton = "card4";
				cancelOption = true;
				useOption = true;
				attackAvailable = false;
				canChooseCard = true;
			}
			if (cancelOption == true && e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(190)
					&& e.getY() <= Wizards.compareToHeight(190) + 50) {
				Textures.btnCancelState = Textures.btnCancelPress;
				cancel = true;
			}
			if (attackAvailable && e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(50)
					&& e.getY() <= Wizards.compareToHeight(50) + 50) {
				Textures.btnAttackState = Textures.btnAttackPress;
				attack = true;
			}
			if (useOption && e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(120) && e.getY() <= Wizards.compareToHeight(120) + 50) {
				Textures.btnUseState = Textures.btnUsePress;
				use = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (Wizards.showPlayScreenHorde && Wizards.showPauseMenuScreen == false) {
			if (currentButton == "card1" && e.getX() >= Wizards.compareToWidth(640)
					&& e.getX() <= Wizards.compareToWidth(640) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				Textures.btnCancelState = Textures.btnCancelDef;
				Textures.btnAttackState = Textures.btnAttackPress;

				if (useOption) {
					Textures.btnUseState = Textures.btnUseDef;
				}
				currentCard = "card1";
				overlayX = Wizards.compareToWidth(638);
				overlayY = Wizards.compareToHeight(318);
			}
			if (currentButton == "card2" && e.getX() >= Wizards.compareToWidth(485)
					&& e.getX() <= Wizards.compareToWidth(485) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				Textures.btnCancelState = Textures.btnCancelDef;
				Textures.btnAttackState = Textures.btnAttackPress;
				if (useOption) {
					Textures.btnUseState = Textures.btnUseDef;
				}
				currentCard = "card2";
				overlayX = Wizards.compareToWidth(483);
				overlayY = Wizards.compareToHeight(318);
			}
			if (currentButton == "card3" && e.getX() >= Wizards.compareToWidth(330)
					&& e.getX() <= Wizards.compareToWidth(330) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				Textures.btnCancelState = Textures.btnCancelDef;
				Textures.btnAttackState = Textures.btnAttackPress;
				if (useOption) {
					Textures.btnUseState = Textures.btnUseDef;
				}
				currentCard = "card3";
				overlayX = Wizards.compareToWidth(328);
				overlayY = Wizards.compareToHeight(318);
			}
			if (currentButton == "card4" && e.getX() >= Wizards.compareToWidth(175)
					&& e.getX() <= Wizards.compareToWidth(175) + 151 && e.getY() >= Wizards.compareToHeight(320)
					&& e.getY() <= Wizards.compareToHeight(320) + 201) {
				Textures.btnCancelState = Textures.btnCancelDef;
				Textures.btnAttackState = Textures.btnAttackPress;
				if (useOption) {
					Textures.btnUseState = Textures.btnUseDef;
				}
				currentCard = "card4";
				overlayX = Wizards.compareToWidth(173);
				overlayY = Wizards.compareToHeight(318);
			}
			if (cancel == true && (e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(190)
					&& e.getY() <= Wizards.compareToHeight(190) + 50)) {
				overlayX = 2000;
				overlayY = 2000;
				overlayX2 = 2000;
				overlayY2 = 2000;
				overlayX3 = 2000;
				overlayY3 = 2000;
				overlayX4 = 2000;
				overlayY4 = 2000;
				audioHandler.playButtonClickSound();
				cancelOption = false;
				cancel = false;
				useOption = false;
				use = false;
				attackAvailable = true;
				attack = false;
				canChooseCard = true;
				summonSpot = false;
				currentButton = "null";
				Textures.btnUseState = Textures.btnUsePress;
				Textures.btnAttackState = Textures.btnAttackDef;
			}
			if (attack && e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(50) && e.getY() <= Wizards.compareToHeight(50) + 50) {
				cancelOption = true;
				attackAvailable = false;
				targetSelectable = true;
				canChooseCard = false;
				overlayX2 = 598;
				overlayY2 = 58;
				Textures.btnAttackState = Textures.btnAttackPress;
				Textures.btnCancelState = Textures.btnCancelDef;
			}
			if (use && e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(120) && e.getY() <= Wizards.compareToHeight(120) + 50) {
				cancelOption = true;
				useOption = false;
				canChooseCard = false;

				Textures.btnUseState = Textures.btnUsePress;
				if (currentCard == "card1" && Cards.Card1IsC == false) {
					targetSelectable = true;
					overlayX2 = 598;
					overlayY2 = 58;
				}
				if (currentCard == "card2" && Cards.Card2IsC == false) {
					targetSelectable = true;
					overlayX2 = 598;
					overlayY2 = 58;
				}
				if (currentCard == "card3" && Cards.Card3IsC == false) {
					targetSelectable = true;
					overlayX2 = 598;
					overlayY2 = 58;
				}
				if (currentCard == "card4" && Cards.Card4IsC == false) {
					targetSelectable = true;
					overlayX2 = 598;
					overlayY2 = 58;
				}
				
				if (currentCard == "card1" && Cards.Card1IsC == true) {
					summonSpot = true;
					overlayX3 = 220;
					overlayY3 = 60;
					overlayX4 = 400;
					overlayY4 = 60;
				}
				if (currentCard == "card2" && Cards.Card2IsC) {
					summonSpot = true;
					overlayX3 = 220;
					overlayY3 = 60;
					overlayX4 = 400;
					overlayY4 = 60;
				}
				if (currentCard == "card3" && Cards.Card3IsC) {
					summonSpot = true;
					overlayX3 = 220;
					overlayY3 = 60;
					overlayX4 = 400;
					overlayY4 = 60;
				}
				if (currentCard == "card4" && Cards.Card4IsC) {
					summonSpot = true;
					overlayX3 = 220;
					overlayY3 = 60;
					overlayX4 = 400;
					overlayY4 = 60;
				}
			}

		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (Wizards.showPlayScreenHorde && Wizards.showPauseMenuScreen == false) {
			if (cancelOption && (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(190) && e.getY() <= Wizards.compareToHeight(190) + 50)) {
				Textures.btnCancelState = Textures.btnCancelHov;
				if (!btnCancelHover) {
					audioHandler.playButtonHoverSound();
					btnCancelHover = true;
				}
			} else {
				if (cancelOption) {
					Textures.btnCancelState = Textures.btnCancelDef;
				} else {
					Textures.btnCancelState = Textures.btnCancelPress;
				}
				btnCancelHover = false;
			}

			if (attackAvailable && e.getX() >= Wizards.compareToWidth(20)
					&& e.getX() <= Wizards.compareToWidth(20) + 150 && e.getY() >= Wizards.compareToHeight(50)
					&& e.getY() <= Wizards.compareToHeight(50) + 50) {
				Textures.btnAttackState = Textures.btnAttackHov;
				if (!btnAttackHover) {
					audioHandler.playButtonHoverSound();
					btnAttackHover = true;
				}
			} else {
				if (attackAvailable) {
					Textures.btnAttackState = Textures.btnAttackDef;
					btnAttackHover = false;
				}

			}

			if (useOption && (e.getX() >= Wizards.compareToWidth(20) && e.getX() <= Wizards.compareToWidth(20) + 150
					&& e.getY() >= Wizards.compareToHeight(120) && e.getY() <= Wizards.compareToHeight(120) + 50)) {
				Textures.btnUseState = Textures.btnUseHov;
				if (!btnUseHover) {
					audioHandler.playButtonHoverSound();
					btnUseHover = true;
				}
			} else {
				if (useOption) {
					Textures.btnUseState = Textures.btnUseDef;
				} else {
					Textures.btnUseState = Textures.btnUsePress;
				}
				btnUseHover = false;
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

}
