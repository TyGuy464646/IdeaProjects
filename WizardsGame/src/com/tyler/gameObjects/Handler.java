package com.tyler.gameObjects;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {

    // VARIABLES
    public ArrayList<GameObject> object = new ArrayList<GameObject>(); // Array of objects

    private boolean up = false,
                    down = false,
                    right = false,
                    left = false;


    // METHODS
    public void tick() {
        // STORE EACH OBJECT INTO TEMP OBJECT, THEN TICKS IT
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        // STORE EACH OBJECT INTO TEMP OBJECT, THEN RENDERS IT
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }


    // GETTERS AND SETTERS
    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }
    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }
    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
}
