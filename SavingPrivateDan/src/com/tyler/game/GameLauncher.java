package com.tyler.game;

import com.tyler.game.states.GameStateManager;
import com.tyler.game.util.KeyHandler;
import com.tyler.game.util.MouseHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameLauncher extends Canvas implements Runnable {

    // Variables
    public static int width = 1280;
    public static int height = 720;
    public String title = "Saving Private Dan";

    private boolean isRunning = false;
    private Thread thread;
    private GameStateManager gsm;

    private MouseHandler mouse;
    private KeyHandler key;


    // Constructor
    public GameLauncher() {
        new Window(width, height, title, this);

        gsm = new GameStateManager();

        // Handlers
        mouse = new MouseHandler(this);
        key = new KeyHandler(this);

        start();
    }


    // Methods
    private void start() {
        isRunning = true;

        thread = new Thread(this);
        thread.start(); // calls run method
    }

    private void stop() {
        isRunning = false;

        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                tick();
                input(mouse, key);
                delta--;
            }
            render();
            input(mouse, key);
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {
        gsm.tick();
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        gsm.input(mouse, key);
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        // If Buffer Strategy is null, create 3 buffers
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        ///////////////////////////////////////////////////////// START RENDER

        // Background
        g.setColor(new Color(66, 134, 244));
        g.fillRect(0, 0, width, height);

        // Game State Manager
        gsm.render(g);

        ///////////////////////////////////////////////////////// END   RENDER
        g.dispose();
        bs.show();
    }


    // Main Method
    public static void main(String[] args) {
        new GameLauncher();
    }


    // Getters / Setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
