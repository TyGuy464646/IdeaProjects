package com.terracore.storages;

import com.terracore.handlers.Texture;
import com.terracore.wizards.LoadingScreen;

public class Textures {

	public static Texture TitleImage;
	
	public static Texture HordeBackground;

	public static Texture btnBeginDef, btnBeginPress, btnBeginHov, btnBeginState;
	public static Texture btnBuildDef, btnBuildPress, btnBuildHov, btnBuildState;
	public static Texture btnHelpDef, btnHelpPress, btnHelpHov, btnHelpState;
	public static Texture btnCreditDef, btnCreditPress, btnCreditHov, btnCreditState;
	public static Texture btnExitDef, btnExitPress, btnExitHov, btnExitState;
	public static Texture btnSettingsDef, btnSettingsPress, btnSettingsHov, btnSettingsPressHov, btnSettingsState;
	public static Texture btnVolumeDef, btnVolumeMute, btnVolumeHov, btnVolumeMuteHov, btnVolumeState;
	public static Texture btnMusicDef, btnMusicMute, btnMusicHov, btnMusicMuteHov, btnMusicState;
	public static Texture btnBackDef, btnBackPress, btnBackHov, btnBackState;
	

	public static Texture btnPrevDef, btnPrevPress, btnPrevHov, btnPrevState;
	public static Texture btnNextDef, btnNextPress, btnNextHov, btnNextState;

	public static Texture btnAttackDef, btnAttackPress, btnAttackHov, btnAttackState;
	public static Texture btnUseDef,btnUsePress,btnUseHov,btnUseState;
	public static Texture btnCancelDef, btnCancelPress, btnCancelHov, btnCancelState;

	public static Texture chkBox, chkBoxChk, chkBoxHov, chkBoxChkHov, chkBoxState1, chkBoxState2, chkBoxState3,
			chkBoxState4;

	public static Texture cardSlot1, cardSlot2, cardSlot3, cardSlot4, cardSlot5;

	public static Texture blankSpellCard, blankCreatureCard;

	public static Texture cardOverlay;

	public static Texture spellCardFireball, spellCardLightning, spellCardBlind, spellCardMassBlind, spellCardWind;

	public static Texture creatureCardFireTruck, creatureCardWatermelon;

	public Textures() {
		// Create Textures
		TitleImage = new Texture("WizardTitle");
		
		HordeBackground = new Texture("HordeBackground");

		btnBeginDef = new Texture("buttons/buttonbegin/ButtonBeginDefault");
		btnBeginPress = new Texture("buttons/buttonbegin/ButtonBeginPressed");
		btnBeginHov = new Texture("buttons/buttonbegin/ButtonBeginHovered");
		btnBeginState = btnBeginDef;

		btnBuildDef = new Texture("buttons/buttonbuild/ButtonBuildDefault");
		btnBuildPress = new Texture("buttons/buttonbuild/ButtonBuildPressed");
		btnBuildHov = new Texture("buttons/buttonbuild/ButtonBuildHovered");
		btnBuildState = btnBuildDef;

		btnHelpDef = new Texture("buttons/buttonhelp/ButtonHelpDefault");
		btnHelpPress = new Texture("buttons/buttonhelp/ButtonHelpPressed");
		btnHelpHov = new Texture("buttons/buttonhelp/ButtonHelpHovered");
		btnHelpState = btnHelpDef;

		btnCreditDef = new Texture("buttons/buttonCredits/ButtonCreditsDefault");
		btnCreditPress = new Texture("buttons/buttonCredits/ButtonCreditsPressed");
		btnCreditHov = new Texture("buttons/buttonCredits/ButtonCreditsHovered");
		btnCreditState = btnCreditDef;

		btnExitDef = new Texture("buttons/buttonexit/ButtonExitDefault");
		btnExitPress = new Texture("buttons/buttonexit/ButtonExitPressed");
		btnExitHov = new Texture("buttons/buttonexit/ButtonExitHovered");
		btnExitState = btnExitDef;

		btnSettingsDef = new Texture("buttons/buttonsettings/ButtonSettingsDefault");
		btnSettingsPress = new Texture("buttons/buttonsettings/ButtonSettingsPressed");
		btnSettingsHov = new Texture("buttons/buttonsettings/ButtonSettingsHovered");
		btnSettingsPressHov = new Texture("buttons/buttonsettings/ButtonSettingsPressedHovered");
		btnSettingsState = btnSettingsDef;

		btnVolumeDef = new Texture("buttons/buttonvolume/ButtonVolumeDefault");
		btnVolumeMute = new Texture("buttons/buttonvolume/ButtonVolumeMuted");
		btnVolumeHov = new Texture("buttons/buttonvolume/ButtonVolumeHovered");
		btnVolumeMuteHov = new Texture("buttons/buttonvolume/ButtonVolumeMutedHovered");
		btnVolumeState = btnVolumeDef;

		btnMusicDef = new Texture("buttons/buttonmusic/ButtonMusicDefault");
		btnMusicMute = new Texture("buttons/buttonmusic/ButtonMusicMuted");
		btnMusicHov = new Texture("buttons/buttonmusic/ButtonMusicHovered");
		btnMusicMuteHov = new Texture("buttons/buttonmusic/ButtonMusicMutedHovered");
		btnMusicState = btnMusicDef;

		btnBackDef = new Texture("buttons/buttonback/ButtonBackDefault");
		btnBackPress = new Texture("buttons/buttonback/ButtonBackPressed");
		btnBackHov = new Texture("buttons/buttonback/ButtonBackHovered");
		btnBackState = btnBackDef;

		btnPrevDef = new Texture("buttons/buttonprevious/ButtonPreviousDefault");
		btnPrevPress = new Texture("buttons/buttonprevious/ButtonPreviousPressed");
		btnPrevHov = new Texture("buttons/buttonprevious/ButtonPreviousHovered");
		btnPrevState = btnPrevPress;

		btnNextDef = new Texture("buttons/buttonnext/ButtonNextDefault");
		btnNextPress = new Texture("buttons/buttonnext/ButtonNextPressed");
		btnNextHov = new Texture("buttons/buttonnext/ButtonNextHovered");
		btnNextState = btnNextDef;
		
		btnAttackDef = new Texture("buttons/buttonattack/ButtonAttackDefault");
		btnAttackPress = new Texture("buttons/buttonattack/ButtonAttackPressed");
		btnAttackHov = new Texture("buttons/buttonattack/ButtonAttackHovered");
		btnAttackState = btnAttackDef;
		
		btnUseDef = new Texture("buttons/buttonuse/ButtonUseDefault");
		btnUsePress = new Texture("buttons/buttonuse/ButtonUsePressed");
		btnUseHov = new Texture("buttons/buttonuse/ButtonUseHovered");
		btnUseState = btnUsePress;

		btnCancelDef = new Texture("buttons/buttoncancel/ButtonCancelDefault");
		btnCancelPress = new Texture("buttons/buttoncancel/ButtonCancelPressed");
		btnCancelHov = new Texture("buttons/buttoncancel/ButtonCancelHovered");
		btnCancelState = btnCancelPress;

		chkBox = new Texture("checkbox/CheckBox");
		chkBoxChk = new Texture("checkbox/CheckBoxChecked");
		chkBoxHov = new Texture("checkbox/CheckBoxHovered");
		chkBoxChkHov = new Texture("checkbox/CheckBoxCheckedHovered");
		chkBoxState1 = chkBox;
		chkBoxState2 = chkBox;
		chkBoxState3 = chkBoxChk;
		chkBoxState4 = chkBox;

		blankSpellCard = new Texture("cards/BlankSpellCard");
		blankCreatureCard = new Texture("cards/BlankCreatureCard");

		cardOverlay = new Texture("cards/CardOverlay");

		spellCardFireball = new Texture("cards/spells/SpellFireball");
		spellCardLightning = new Texture("cards/spells/SpellLightning");
		spellCardBlind = new Texture("cards/spells/SpellBlind");
		spellCardMassBlind = new Texture("cards/spells/SpellMassBlind");
		spellCardWind = new Texture("cards/spells/SpellWind");

		creatureCardFireTruck = new Texture("cards/creatures/CreatureFiretruck");
		creatureCardWatermelon = new Texture("cards/creatures/CreatureWatermelon");

		LoadingScreen.isDone = true;
	}
}
