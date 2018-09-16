package com.tyler.javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    // VARIABLES
    Button button;


    // MAIN METHOD
    public static void main(String[] args) {
        launch(args); // calls start method
    }


    // IMPLEMENTED METHODS
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX");

        button = new Button("Click Me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
