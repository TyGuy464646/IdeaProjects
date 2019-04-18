package com.tyler.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;

public class Game extends Application {



    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc= canvas.getGraphicsContext2D();

        // Graphics Start
        gc.setFill(LinearGradient.valueOf("red, blue"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Graphics End

        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
