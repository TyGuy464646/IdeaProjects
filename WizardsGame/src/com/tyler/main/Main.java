package com.tyler.main;

import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameObjects.objects.Block;
import com.tyler.gameObjects.objects.Wizard;
import com.tyler.image.BufferedImageLoader;
import com.tyler.input.keyInput.KeyInput;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Main extends Canvas implements Runnable {

    // VARIABLES
    private int     width = 1000,
                    height = 563;
    private String  title = "Wizard Game";

    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;

    private BufferedImage level = null;


    // CONSTRUCTOR
    public Main() {
        new Window(width, height, title, this);
        start();

        // initialize classes
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/levels/level1.png");

        loadLevel(level);
    }


    // METHODS
    private void start() {
        isRunning = true;

        thread = new Thread(this);
        thread.start(); // calls run method
    }

    private void stop() {
        isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();

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

    public void tick() {
        handler.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        // If Buffer Strategy is null, create 3 buffers
        if(bs==null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ///////////////////////////////////////////////////////// START RENDER

        // background
        g.setColor(Color.RED);
        g.fillRect(0, 0, width, height);

        // class renderers
        handler.render(g);

        ///////////////////////////////////////////////////////// END   RENDER
        g.dispose();
        bs.show();
    }

    // loading the level
    private void loadLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        for(int yy = 0; yy < h; yy++) {
            for(int xx = 0; xx < w; xx++) {
                int pixel = image.getRGB(xx, yy);
                int red     =      (pixel >> 16) & 0xff;
                int green   =      (pixel >> 8) & 0xff;
                int blue    =      pixel & 0xff;

                if(red == 255)
                    handler.addObject(new Block(xx*32, yy*32, ID.Block));
                if(blue == 255)
                    handler.addObject(new Wizard(xx*32, yy*32, ID.Player, handler));
            }
        }
    }


    // MAIN METHOD
    public static void main(String[] args) {
	    new Main();
    }

}
