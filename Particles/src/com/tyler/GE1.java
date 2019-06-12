/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyler;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mwolverton
 */
public class GE1 extends Application {
    long currentTime;
    long previousTime;
    float timeElapsed;
    
    int particleCount = 250 ;
    ArrayList<Particle> particleList;
    Group root;
    
    @Override
    public void start(Stage primaryStage) {
        
        root = new Group();
        Scene scene = new Scene(root, 1000, 700, Color.BLACK);
        
        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        particleList = new ArrayList();     

        
        scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                float X = (float)event.getX();
                float Y = (float)event.getY();
                makeParticleGroup(X, Y);
            }
            
        });
        
        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                currentTime = System.nanoTime();
                timeElapsed = (currentTime - previousTime)/10000000000f;
                
                if(!particleList.isEmpty()){
                    for (int i=0; i< particleList.size(); i++){      
                        if (particleList.get(i).isExpired){ particleList.remove(i); }
                    }
                    for (int i=0; i< particleList.size(); i++){      
                        particleList.get(i).step(timeElapsed);
                    }
                      
                }
                                
                previousTime = currentTime;
            }
            
        };
        
        previousTime = System.nanoTime();
        timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void makeParticleGroup(float spawnCenterX, float spawnCenterY) {        
        Random randGen = new Random();
        
        for (int i=0; i<particleCount; i++){        
            particleList.add(i, new Particle( spawnCenterX, spawnCenterY, 3000*(randGen.nextFloat()), (float)Math.PI*2f*(randGen.nextFloat()), 4, .25f*(.5f-randGen.nextFloat()), root));
        }
    }
    
}
