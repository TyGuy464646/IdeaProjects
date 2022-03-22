package com.tyler.marioBros.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tyler.marioBros.MarioBros;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.backgroundFPS = 60;
		config.foregroundFPS = 60;
		config.vSyncEnabled = true;

		new LwjglApplication(new MarioBros(), config);
	}
}
