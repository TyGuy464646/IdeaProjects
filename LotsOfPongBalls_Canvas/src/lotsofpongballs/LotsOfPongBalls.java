/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotsofpongballs;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LotsOfPongBalls extends Application {
    
    double windowWidth = 800;
    double windowHeight = 600;
    ArrayList<PongBall> ball;
    int numberBalls;
    AnimationTimer timer;
    long then;
    GraphicsContext gc;
    LinearGradient backgroundGradient;
    long frameCount = 0;
    double countDown = 30;
    
    
    @Override
    public void start(Stage primaryStage) {
        numberBalls = 20000;
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(windowWidth,windowHeight);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        Stop[] stops = new Stop[] {new Stop(0, Color.rgb(45,45,45)), new Stop(.5, Color.rgb(60,60,90)), new Stop(1, Color.rgb(45,45,45))};
        backgroundGradient = new LinearGradient(0,0,0,1, true, CycleMethod.REFLECT, stops);
        
        Scene scene = new Scene(root, windowWidth, windowHeight);
        primaryStage.setTitle("PONG BALLS! - Canvas");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        
        ball = new ArrayList<PongBall>();
        for (int i = 0; i < numberBalls; i++){
            ball.add(new PongBall(windowWidth, windowHeight, 50, root));
        }

        timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                double time = (now - then) / 1000000000.0;
                backgroundDraw();
                for (int i = 0; i < ball.size(); i++){
                    ball.get(i).update(time,gc);
                }                
                then = now;
                frameCount++;
            }
        };
        
        then = System.nanoTime();
        timer.start();
        primaryStage.show();
    }

    void backgroundDraw(){
        gc.setFill(backgroundGradient);
        gc.fillRect(0, 0, windowWidth, windowHeight);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
