package com.terracore.storages;

import java.util.Random;

import com.terracore.cards.CreatureCard;
import com.terracore.cards.SpellCard;

public class Cards {

	private static final int CreatureCardNum = 2;
	private static final int SpellCardNum = 5;

	public static CreatureCard CCard1;
	public static CreatureCard CCard2;
	public static CreatureCard CCard3;
	public static CreatureCard CCard4;

	public static SpellCard SCard1;
	public static SpellCard SCard2;
	public static SpellCard SCard3;
	public static SpellCard SCard4;

	public static boolean Card1IsC;
	public static boolean Card2IsC;
	public static boolean Card3IsC;
	public static boolean Card4IsC;

	private static Random r = new Random();

	private static CreatureCard Firetruck = new CreatureCard(0, 100, 10, 10, 5, 10, 9, 7, 4, "Soak", "Water",
			"CreatureCard", "Firetruck", Textures.creatureCardFireTruck);

	private static SpellCard Fireball = new SpellCard(1, 8, 12, 10, 9, 10, 8, 3, 2, false, "Fire", "Fire", "SpellCard",
			"Fireball", Textures.spellCardFireball);

	private static SpellCard Lightning = new SpellCard(2, 15, 17, 10, 8, 10, 5, 7, 3, false, "Paralyze", "Dark",
			"SpellCard", "Lightning", Textures.spellCardLightning);

	private static CreatureCard Watermelon = new CreatureCard(3, 50, 0, 0, 0, 0, 0, 13, 3, "Draw Focus", "Physical",
			"CreatureCard", "Watermelon", Textures.creatureCardWatermelon);

	private static SpellCard Blind = new SpellCard(4, 1, 1, 1, 1, 100, 75, 2, 1, false, "Blind", "Light", "SpellCard",
			"Blind", Textures.spellCardBlind);

	private static SpellCard MassBlind = new SpellCard(5, 1, 1, 1, 1, 100, 75, 10, 4, true, "Blind", "Light",
			"SpellCard", "MassBlind", Textures.spellCardMassBlind);

	private static SpellCard Wind = new SpellCard(6, 17, 17, 10, 10, 10, 9, 9, 3, true, "None", "Ethereal", "SpellCard",
			"Wind", Textures.spellCardWind);

	public static CreatureCard getCardCreature() {
		switch (r.nextInt(CreatureCardNum)) {
		case (0):
			return Firetruck;
		case (1):
			return Watermelon;
		default:
			return null;
		}
	}

	public static SpellCard getCardSpell() {
		switch (r.nextInt(SpellCardNum)) {
		case (0):
			return Fireball;
		case (1):
			return Lightning;
		case (2):
			return Blind;
		case (3):
			return MassBlind;
		case (4):
			return Wind;
		default:
			return null;
		}
	}

}
