package com.tyler.tileMap;

import com.tyler.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {

    // Variables
    private BufferedImage image;

    private double x, y, dx, dy;
    private double moveScale;


    // Constructor
    public Background(String s, double moveScale) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
            moveScale = moveScale;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Methods
    public void setPosition(double x, double y) {
        this.x = (x * moveScale) % GamePanel.WIDTH;
        this.y = (y * moveScale) % GamePanel.HEIGHT;
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void draw(Graphics2D g) {

        g.drawImage(image, (int) x, (int) y, null);

        if (x < 0) {
            g.drawImage(image, (int) x + GamePanel.WIDTH, (int) y, null);
        }
        if (x > 0) {
            g.drawImage(image, (int) x - GamePanel.WIDTH, (int) y, null);
        }
    }

}
