package com.tyler.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameCell extends Rectangle {

    boolean alive = false;
    int numAliveNeighbors = 0;

    public GameCell(double cellSize) {
        super(cellSize, cellSize);
        makeDead();

        setStroke(Color.BLACK);
        setStrokeWidth(1.0D);

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    makeAlive();
                }

                if (event.getButton() == MouseButton.SECONDARY) {
                    makeDead();
                }
            }
        });
        setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle (MouseDragEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    makeAlive();
                }

                if (event.getButton() == MouseButton.SECONDARY) {
                    makeDead();
                }
            }
        });
    }

    public void makeAlive() {
        alive = true;
        setFill(Color.BLACK);
    }

    public void makeDead() {
        alive = false;
        setFill(Color.WHITE);
    }

}
