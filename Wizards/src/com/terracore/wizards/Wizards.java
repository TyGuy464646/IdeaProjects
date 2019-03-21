package com.terracore.wizards;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.terracore.handlers.*;

public class Wizards extends Canvas implements Runnable {

	public static final String TITLE = "Wizards";
	public static int WIDTH = 800;
	public static int HEIGHT = WIDTH / 4 * 3;

	public static int Gamemode = 3;

	public static boolean loading;
	private static boolean running;

	public static String currentScreen = "";
	public static boolean showTitleScreen = false;
	public static boolean showBeginScreen = false;
	public static boolean showPlayScreenHorde = false;
	public static boolean showPauseMenuScreen = false;
	public static boolean showBuildScreen = false;
	public static boolean showHelpScreen = false;
	public static boolean showCreditsScreen = false;
	public static boolean showSettingsScreen = false;
	public static boolean showLoadingScreen = true;

	public static int loadCounter = 80;

	public static boolean volumeOn = true;
	public static boolean musicOn = true;

	private TitleScreen titleScreen = new TitleScreen();
	private BeginScreen beginScreen = new BeginScreen();
	private PlayScreenHorde playScreen = new PlayScreenHorde();
	private PauseMenuScreen pauseMenuScreen = new PauseMenuScreen();
	private BuildScreen buildScreen = new BuildScreen();
	private HelpScreen helpScreen = new HelpScreen();
	private CreditsScreen creditsScreen = new CreditsScreen();
	private LoadingScreen loadingScreen = new LoadingScreen();

	private AudioHandler audioHandler = new AudioHandler();
	static MouseHandler mouseHandler = new MouseHandler();
	static HordeMouseHandler mouseHandlerHorde = new HordeMouseHandler();
	static PauseMenuMouseHandler mouseHandlerPauseMenu = new PauseMenuMouseHandler();
	static HordeKeyHandler keyHandlerHorde = new HordeKeyHandler();

	static JFrame frame = new JFrame(TITLE);

	private void preRender() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		///////////////////////////////////////////

		// LOADING SCREEN
		if (showLoadingScreen) {
			currentScreen = "Loading";
			loadingScreen.paint(g);
		}

		///////////////////////////////////////////
		g.dispose();
		bs.show();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		///////////////////////////////////////////

		// TITLE SCREEN
		if (showTitleScreen) {
			if (showSettingsScreen) {
				currentScreen = "Title (Settings)";
			} else {
				currentScreen = "Title";
			}

			titleScreen.paint(g);
		}

		// BEGIN SCREEN
		if (showBeginScreen) {
			currentScreen = "Begin";
			beginScreen.paint(g);
		}

		// PLAY SCREEN
		if (showPlayScreenHorde) {
			currentScreen = "Play";
			playScreen.paint(g);
		}

		// Pause Menu Screen
		if (showPauseMenuScreen) {
			currentScreen = "Pause";
			pauseMenuScreen.paint(g);
		}

		// BUILD SCREEN
		if (showBuildScreen) {
			currentScreen = "Build";
			buildScreen.paint(g);
		}

		// HELP SCREEN
		if (showHelpScreen) {
			currentScreen = "Help (" + HelpScreen.pageNumber + ")";
			helpScreen.paint(g);
		}

		// CREDITS SCREEN
		if (showCreditsScreen) {
			currentScreen = "Credits";
			creditsScreen.paint(g);
		}

		///////////////////////////////////////////
		g.dispose();
		bs.show();
	}

	private void tick() {

	}

	private void start() {
		if (!running) {
			audioHandler.playTrack1();
			loading = true;
			running = true;
			new Thread(this, "Thread-WizardsMain").start();
			System.err.println("Starting Thread");
		}
	}

	public static void stop() {
		if (!running) {
			return;
		}
		running = false;
	}

	public static void exit() {
		if (!running) {
			return;
		}
		running = false;
		System.err.println("\nExiting Game");
		// stop threads
		Wizards.stop();
		System.exit(0);
	}

	public static int compareToWidth(int value) {
		value = WIDTH * value / 800;
		return value;
	}

	public static int compareToHeight(int value) {
		value = HEIGHT * value / 600;
		return value;
	}

	public static int centerToWidth() {
		return WIDTH / 2;
	}

	public static int centerToHeight() {
		return HEIGHT / 2;
	}

	public static int centerToWidth(int value) {
		value = (WIDTH - value) / 2;
		return value;
	}

	public static int centerToHeight(int value) {
		value = (HEIGHT - value) / 2;
		return value;
	}

	public static void changeSize(int WIDTH) {
		Wizards.WIDTH = WIDTH;
		Wizards.HEIGHT = WIDTH / 4 * 3;
		frame.setSize(Wizards.WIDTH, Wizards.HEIGHT);
		frame.setLocationRelativeTo(null);
	}

	public static String getScreen() {
		return currentScreen;
	}

	@Override
	public void run() {
		double targetFPS = 60.0;
		double nsPerTick = 1000000000.0 / targetFPS;
		long previousTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double unprocessed = 0.0;
		int FPS = 0;
		int TPS = 0;
		int runtime = 0;
		boolean canRender = false;
		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - previousTime) / nsPerTick;
			previousTime = now;

			if (unprocessed >= 1.0) {
				tick();
				unprocessed--;
				TPS++;
				canRender = true;
			} else {
				canRender = false;
			}

			// Thread.sleep(1);

			if (canRender) {
				if (loading) {
					preRender();
				} else {
					render();
				}

				FPS++;
				if (FPS >= targetFPS && LoadingScreen.isDone && loading) {
					showLoadingScreen = false;
					showTitleScreen = true;
					loading = false;
					System.err.println("\nStarting Game\n");
				}
			}

			if (System.currentTimeMillis() - 1000 > timer) {
				timer += 1000;
				runtime++;
				System.out.println(
						"FPS: " + FPS + " | TPS: " + TPS + " | Run Time: " + runtime + " | Screen: " + currentScreen);
				FPS = 0;
				TPS = 0;
			}
		}
	}

	public static void main(String[] args) {
		Wizards game = new Wizards();
		frame.add(game);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Wizards.exit();
			}
		});

		frame.setSize(Wizards.WIDTH, Wizards.HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocus();

		game.addMouseListener(mouseHandler);
		game.addMouseMotionListener(mouseHandler);
		game.addMouseListener(mouseHandlerHorde);
		game.addMouseMotionListener(mouseHandlerHorde);
		game.addMouseListener(mouseHandlerPauseMenu);
		game.addMouseMotionListener(mouseHandlerPauseMenu);
		game.addKeyListener(keyHandlerHorde);

		game.start();
	}

}
