package com.tyler.game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameLauncher extends Canvas implements Runnable {

    private int width = 1280, height = 720;
    private String title = "Saving Private Dan";

    private boolean isRunning = false;
    private Thread thread;


    public GameLauncher() {
        new Window(width, height, title, this);
        start();
    }


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
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {

    }

    private void render() {
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

        ///////////////////////////////////////////////////////// END   RENDER
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new GameLauncher();
    }


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
