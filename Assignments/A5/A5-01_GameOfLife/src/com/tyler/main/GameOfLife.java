package com.tyler.main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOfLife extends Application {

    GameGrid grid;
    GameTimer timer;

    @Override
    public void start (Stage stage) throws Exception {
        grid = new GameGrid(65, 110, 10.0D);
        timer = new GameTimer(grid);

        VBox root = new VBox();

        root.getChildren().add(grid);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                switch(event.getCode()) {
                    case UP:
                        timer.increaseSpeed();
                        break;
                    case DOWN:
                        timer.decreaseSpeed();
                        break;
                    case SPACE:
                        timer.togglePause();
                        break;
                    case C:
                        grid.clear();
                        break;
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("Game Of Life (Space = Pause Play / C = Clear / Up Arrow = Increase Speed / Down Arrow = Decrease Speed)");
        stage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}
