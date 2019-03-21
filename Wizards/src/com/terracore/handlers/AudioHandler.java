package com.terracore.handlers;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.terracore.wizards.Wizards;

public class AudioHandler {

	Clip player;
	
	public void playButtonHoverSound() {
		if (Wizards.volumeOn) {
			try {
				AudioInputStream buttonHoverSound = AudioSystem
						.getAudioInputStream(new File("resources/audio/sounds/ButtonHover.wav"));
				player = AudioSystem.getClip();
				player.open(buttonHoverSound);
				player.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
		}
	}

	public void playButtonClickSound() {
		if (Wizards.volumeOn) {
			try {
				AudioInputStream buttonHoverSound = AudioSystem
						.getAudioInputStream(new File("resources/audio/sounds/ButtonClick.wav"));
				player = AudioSystem.getClip();
				player.open(buttonHoverSound);
				player.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
		}
	}

	public void playTrack1() {
		if (Wizards.musicOn) {
			try {
				AudioInputStream buttonHoverSound = AudioSystem
						.getAudioInputStream(new File("resources/audio/music/WizardsT1.wav"));
				player = AudioSystem.getClip();
				player.open(buttonHoverSound);
				player.loop(Clip.LOOP_CONTINUOUSLY);;
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
		}
	}

}
