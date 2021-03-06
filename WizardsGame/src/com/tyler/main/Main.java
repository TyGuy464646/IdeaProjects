package com.tyler.main;

import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameObjects.objects.Block;
import com.tyler.gameObjects.objects.Crate;
import com.tyler.gameObjects.objects.Enemy;
import com.tyler.gameObjects.objects.Wizard;
import com.tyler.image.BufferedImageLoader;
import com.tyler.image.SpriteSheet;
import com.tyler.input.keyInput.KeyInput;
import com.tyler.input.mouseInput.MouseInput;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Main extends Canvas implements Runnable {

    // VARIABLES
    private int width = 1000,
                height = 563;
    private String title = "Wizard Game";

    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private Camera camera;
    private SpriteSheet spriteSheet;

    BufferedImage floor;

    public int ammo = 100;
    public int hp = 100;


    // CONSTRUCTOR
    private Main() {
        new Window(width, height, title, this);
        start();

        // initialize classes
        handler = new Handler();
        camera = new Camera(0, 0, this);


        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage level = loader.loadImage("/levels/level1.png");
        BufferedImage sprite_sheet = loader.loadImage("/sprites/sprite_sheet.png");

        spriteSheet = new SpriteSheet(sprite_sheet);

        floor = spriteSheet.grabImage(4, 2, 32, 32);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler, camera, this, spriteSheet));

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
        } catch(InterruptedException e) {
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

    private void tick() {
        // Camera lock onto player
        for(int i = 0; i < handler.object.size(); i++) {
            if(handler.object.get(i).getId() == ID.Player) {
                camera.tick(handler.object.get(i));
            }
        }

        handler.tick();
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
        // TODO: Game State Manager

        g2d.translate(-camera.getX(), -camera.getY());
        //////////////////////////////////////////////////// translate camera start

        // Background
        for(int xx = 0; xx < 30 * 72; xx += 32) {
            for(int yy = 0; yy < 30 * 72; yy += 32) {
                g.drawImage(floor, xx, yy, null);
            }
        }

        // class renderers
        handler.render(g);

        //////////////////////////////////////////////////// translate camera stop
        g2d.translate(camera.getX(), camera.getY());

        // HP
        g.setColor(Color.GRAY);
        g.fillRect(5, 5, 200, 32);
        g.setColor(Color.GREEN);
        g.fillRect(5, 5, hp*2, 32);
        g.setColor(Color.BLACK);
        g.drawRect(5, 5, 200, 32);
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.BOLD, 14));
        g.drawString("HP: " + hp, 70, 25);

        // AMMO
        g.setColor(Color.WHITE);
        g.drawString("Ammo: " + ammo, 5, 50);


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
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                if(red == 255)
                    handler.addObject(new Block(xx * 32, yy * 32, ID.Block, spriteSheet));
                if(blue == 255 && green == 0)
                    handler.addObject(new Wizard(xx * 32, yy * 32, ID.Player, handler, this, spriteSheet));
                if(green == 255 && blue == 0)
                    handler.addObject(new Enemy(xx * 32, yy * 32, ID.Enemy, handler, spriteSheet));
                if(green == 255 && blue == 255)
                    handler.addObject(new Crate(xx * 32, yy * 32, ID.Crate, spriteSheet));
            }
        }
    }


    // MAIN METHOD
    public static void main(String[] args) {
        new Main();
    }


    // GETTERS AND SETTERS
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
