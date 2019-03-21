package com.terracore.cards;

import java.util.Random;

import com.terracore.handlers.Texture;

public class SpellCard {

	private int CardID;
	private int DMGMin;
	private int DMGMax;
	private int HRMaxNum;
	private int HRMinHit;
	private int MPCost;
	private int CardLevel;
	private String Effect;
	private String Element;
	private String CardType;
	private String Name;
	private Texture Texture;
	private int SRMaxNum;
	private int SRMinSuccess;
	private boolean AOE;

	Random r = new Random();

	public SpellCard(int CardID, int DMGMin, int DMGMax, int HRMaxNum, int HRMinHit, int SRMaxNum, int SRMinSuccess,
			int MPCost, int CardLevel, boolean AOE, String Effect, String Element, String CardType, String Name, Texture Texture) {
		this.CardID = CardID;
		this.DMGMin = DMGMin;
		this.DMGMax = DMGMax;
		this.HRMaxNum = HRMaxNum;
		this.HRMinHit = HRMinHit;
		this.MPCost = MPCost;
		this.CardLevel = CardLevel;
		this.AOE = AOE;
		this.Effect = Effect;
		this.Element = Element;
		this.CardType = CardType;
		this.Name = Name;
		this.Texture = Texture;
		this.SRMaxNum = SRMaxNum;
		this.SRMinSuccess = SRMinSuccess;
	}

	public int getSR() {
		return SRMaxNum / SRMinSuccess;
	}

	public int getCardID() {
		return CardID;
	}

	public int getDMG() {
		return r.nextInt(DMGMax - DMGMin + 1) + DMGMin;
	}

	public int getHR() {
		return HRMaxNum / HRMinHit;
	}

	public int getMPCost() {
		return MPCost;
	}
	
	public int getCardLevel() {
		return CardLevel;
	}

	public boolean getAOE(){
		return AOE;
	}
	
	public String getEffect() {
		return Effect;
	}

	public String getElement() {
		return Element;
	}
	
	public String getCardType() {
		return CardType;
	}

	public String getName() {
		return Name;
	}

	public Texture getTexture() {
		return Texture;
	}

	public boolean hit() {
		int hit = r.nextInt(HRMaxNum + 1);
		int success = r.nextInt(SRMaxNum + 1);
		if (hit <= HRMinHit && success <= SRMinSuccess) {
			return true;
		}
		return false;
	}

}
