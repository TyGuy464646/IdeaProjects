package com.tyler.main;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class NonogramPanel extends JPanel implements MouseListener {

    Nonogram puzzle;

    public NonogramPanel(Nonogram puzzle) {
        this.puzzle = puzzle;
        this.addMouseListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // compute space needed for the numbers.
        int totalRows = 2 + puzzle.height + puzzle.maxColGroups;
        int totalCols = 2 + puzzle.width + puzzle.maxRowGroups;

        double width = getWidth();
        double height = getHeight();

        double xDivider = width*(1+puzzle.maxRowGroups)/totalCols;
        double yDivider = height*(1+puzzle.maxColGroups)/totalRows;

        double cellWidth = width/totalCols;
        double cellHeight = height/totalRows;

        Graphics2D gg = (Graphics2D)g;   // Need to upcast to get double-precision graphics.

        // draw a heavy box around the puzzle array
        Stroke s = gg.getStroke();
        gg.setStroke(new BasicStroke(3.0f));
        Rectangle2D r = new Rectangle2D.Double(xDivider,yDivider,cellWidth*puzzle.width,cellHeight*puzzle.height);
        gg.draw(r);
        gg.setStroke(s);

        // draw the puzzle array
        for (int i=0; i<puzzle.height; i++) {
            for (int j=0; j<puzzle.width; j++) {
                Rectangle2D cell = new Rectangle2D.Double(xDivider+j*cellWidth,yDivider+i*cellHeight,cellWidth,cellHeight);
                gg.draw(cell);
                if (puzzle.guess[i][j]) {
                    gg.fill(cell);
                }
            }
        }

        // draw the numbers for the groups in each row.
        for (int i=0; i<puzzle.height; i++) {
            for (int j=0; j<puzzle.rowGroupLength[i].length; j++) {
                int val = puzzle.rowGroupLength[i][j];
                Rectangle2D cell = new Rectangle2D.Double(xDivider-(puzzle.rowGroupLength[i].length-j)*cellWidth,
                        yDivider+i*cellHeight,cellWidth,cellHeight);
                gg.draw(cell);
                gg.drawString(""+val, (float) (xDivider - cellWidth*(puzzle.rowGroupLength[i].length - j-0.5)),
                        (float) (yDivider+(i+0.5)*cellHeight));
            }
        }

        // draw the numbers for the groups in each column.
        for (int j=0; j<puzzle.width; j++) {
            for (int k=0; k<puzzle.colGroupLength[j].length; k++) {
                int val = puzzle.colGroupLength[j][k];
                Rectangle2D cell = new Rectangle2D.Double(xDivider+j*cellWidth,
                        yDivider-(puzzle.colGroupLength[j].length-k)*cellHeight,
                        cellWidth,cellHeight);
                gg.draw(cell);
                gg.drawString(""+val, (float) (xDivider+cellWidth*(j+0.5)),
                        (float) (yDivider-cellHeight*(puzzle.colGroupLength[j].length-k-0.5)));
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int totalRows = 2 + puzzle.height + puzzle.maxColGroups;
        int totalCols = 2 + puzzle.width + puzzle.maxRowGroups;
        double width = getWidth();
        double height = getHeight();
        int xCount = (int)(x*totalCols/width);
        int yCount = (int)(y*totalRows/height);
        xCount = xCount - 1 - puzzle.maxRowGroups;
        yCount = yCount - 1 - puzzle.maxColGroups;
        System.out.println("click: "+xCount+","+yCount);
//        puzzle.guess[yCount][xCount] = !puzzle.guess[yCount][xCount];
        puzzle.handleMouseClickAt(yCount,xCount);
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int totalRows = 2 + puzzle.height + puzzle.maxColGroups;
        int totalCols = 2 + puzzle.width + puzzle.maxRowGroups;
        double width = getWidth();
        double height = getHeight();
        int xCount = (int)(x*totalCols/width);
        int yCount = (int)(y*totalRows/height);
        xCount = xCount - 1 - puzzle.maxRowGroups;
        yCount = yCount - 1 - puzzle.maxColGroups;
        System.out.println("mousePress: "+xCount+","+yCount);
        puzzle.handleMousePressAt(yCount, xCount);
        repaint();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int totalRows = 2 + puzzle.height + puzzle.maxColGroups;
        int totalCols = 2 + puzzle.width + puzzle.maxRowGroups;
        double width = getWidth();
        double height = getHeight();
        int xCount = (int)(x*totalCols/width);
        int yCount = (int)(y*totalRows/height);
        xCount = xCount - 1 - puzzle.maxRowGroups;
        yCount = yCount - 1 - puzzle.maxColGroups;
        System.out.println("mouseUp: "+xCount+","+yCount);
        puzzle.handleMouseReleaseAt(yCount, xCount);
        repaint();

    }

}