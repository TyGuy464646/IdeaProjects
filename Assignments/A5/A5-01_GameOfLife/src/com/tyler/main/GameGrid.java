package com.tyler.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameGrid extends GridPane {

    double cellSize;
    int numColumns;
    int numRows;
    GameCell[][] cells;

    public GameGrid (int rows, int cols, double cellSize) {
        this.cellSize = cellSize;
        this.numColumns = cols;
        this.numRows = rows;
        this.cells = new GameCell[cols][rows];

        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                cells[i][j] = new GameCell(cellSize);
                add(cells[i][j], i, j);
            }
        }

        setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                startFullDrag();
            }
        });
    }

    public void clear () {
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < this.numRows; j++) {
                cells[i][j].makeDead();
            }
        }
    }

    public void step () {
        countCellNeighbors();
        setAliveOrDead();
    }

    public void countCellNeighbors () {
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                int number = 0;
                // Upper Right
                if (j - 1 >= 0 && i + 1 < numColumns) {
                    if (cells[i + 1][j - 1].alive) {
                        number++;
                    }
                }
                // Upper Middle
                if (j - 1 >= 0) {
                    if (cells[i][j-1].alive) {
                        number++;
                    }
                }
                // Upper Left
                if (j - 1 >= 0 && i - 1 >= 0) {
                    if (cells[i-1][j-1].alive) {
                        number++;
                    }
                }
                // Middle Left
                if (i - 1 >= 0) {
                    if (cells[i-1][j].alive) {
                        number++;
                    }
                }
                // Middle Right
                if (i + 1 < numColumns) {
                    if (cells[i+1][j].alive) {
                        number++;
                    }
                }
                // Bottom Left
                if (i - 1 >= 0 && j + 1 < numRows) {
                    if (cells[i-1][j+1].alive) {
                        number++;
                    }
                }
                // Bottom Middle
                if (j + 1 < numRows) {
                    if (cells[i][j+1].alive) {
                        number++;
                    }
                }
                // Bottom Right
                if (i + 1 < numColumns && j + 1 < numRows) {
                    if (cells[i+1][j+1].alive) {
                        number++;
                    }
                }

                cells[i][j].numAliveNeighbors = number;
            }
        }
    }

    public void setAliveOrDead () {
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                int number = cells[i][j].numAliveNeighbors;
                if (number < 2) {
                    cells[i][j].makeDead();
                }
                if (number == 3) {
                    cells[i][j].makeAlive();
                }
                if (number > 3) {
                    cells[i][j].makeDead();
                }
            }
        }
    }

}
