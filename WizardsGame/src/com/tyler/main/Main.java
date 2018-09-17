package com.tyler.main;

import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.objects.Box;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    // VARIABLES
    private int     width = 1000,
                    height = 563;
    private String  title = "Wizard Game";

    private boolean isRunning = false;
    private Thread thread;

    private Handler handler;


    // CONSTRUCTOR
    public Main() {
        new Window(width, height, title, this);
        start();

        // initialize classes
        handler = new Handler();
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
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, width, height);

        // class renderers
        handler.render(g);

        ///////////////////////////////////////////////////////// END   RENDER
        g.dispose();
        bs.show();
    }


    // MAIN METHOD
    public static void main(String[] args) {
	    new Main();
    }

}
