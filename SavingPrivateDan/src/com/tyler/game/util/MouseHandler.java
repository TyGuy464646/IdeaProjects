package com.tyler.game.util;

import com.tyler.game.GameLauncher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    // Variables
    private static int  mouseX = -1,
                        mouseY = -1;
    private static int  mouseButton = -1;


    // Constructor
    public MouseHandler(GameLauncher game) {
        game.addMouseListener(this);
    }


    // Methods
    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }

    public int getButton() {
        return mouseButton;
    }


    // Implemented Methods
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        mouseButton = e.getButton();
    }

    public void mouseReleased(MouseEvent e) {
        mouseButton = -1;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
