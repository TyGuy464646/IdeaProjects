/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyler;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

/**
 *
 * @author mwolverton
 */
public class Particle {
    
    Circle circle;
    Group group;

    //position
    float deltaX, deltaY, vx, vy, r, endLifeTime, currentLifeTime;
    boolean isExpired = false;    
    
    Particle(float initialX, float initialY, float velocity, float angle, float radius, float lifeTime, Group group){
        
        deltaX = deltaY = 0;
        vx = velocity * (float)Math.cos(angle);
        vy = velocity * (float)Math.sin(angle);
        r = radius;
        this.group = group;
       
        
        currentLifeTime = 0;
        endLifeTime = lifeTime;
        
        circle = new Circle(initialX,initialY, r, new RadialGradient( 0, 0, initialX, initialY, r, false, CycleMethod.REPEAT, new Stop[]{
            new Stop(0, Color.CYAN),
            new Stop(radius, Color.BLUEVIOLET)
        }) );
        group.getChildren().add(circle);
        
    }
    
    public void step(float timeStep){
        deltaX += vx * timeStep;
        deltaY += vy * timeStep;
        circle.setTranslateX(deltaX);
        circle.setTranslateY(deltaY);
        circle.setRadius(r*(1-currentLifeTime/endLifeTime));
        
        currentLifeTime += timeStep;
        
        if (currentLifeTime >= endLifeTime){
            terminate();
        }
    }
    
    public void terminate(){
        group.getChildren().remove(this.circle);
        isExpired = true;
    }
    
}
