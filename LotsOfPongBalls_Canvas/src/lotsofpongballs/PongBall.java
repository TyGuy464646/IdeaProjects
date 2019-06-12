/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotsofpongballs;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author administrator
 */
public class PongBall {
    double x, y, vx, vy, ay, size, maxX, maxY;
    Color color;
    
    PongBall(double maxX, double maxY, double speed, Pane continer) {
        size = 8;
        x = Math.random() * (maxX-size)+size;
        y = Math.random() * (maxY-size)+size;
        
        this.maxX = maxX;
        this.maxY = maxY;
        
        double theta = Math.random() * 2 * Math.PI;
        
        vx = Math.cos(theta)*speed;
        vy = Math.sin(theta)*speed;     
        
        ay = 0;
        
        color = Color.rgb((int)Math.round(Math.random()*20),(int)Math.round(Math.random()*255),(int)Math.round(Math.random()*255));
    }
    
    void update(double t, GraphicsContext gc){
        vy += ay * t;
        x += vx * t;
        y += vy * t;
        
        if ((x < (0)) || ((x+size) > maxX)) {
            x -= vx*t;
            vx = -1.0 * vx;
        }
        
        if ((y < (0)) || ((y+size) > maxY)) {
            y -= vy*t;
            vy = -1.0 * vy;
        }
        gc.setFill(color);
        gc.fillRect(x, y, size, size);
    }
    
}
