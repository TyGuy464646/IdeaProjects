package com.tyler.gameObjects;

import java.util.ArrayList;

public class Handler {

    // Initialize Array of All Objects
    public ArrayList<GameObject> object = new ArrayList<GameObject>();

    // Initialize Input Booleans
    public static boolean left = false;
    public static boolean down = false;
    public static boolean right = false;
    public static boolean up = false;
    public static boolean space = false;
    public static boolean escape = false;

    public boolean primaryClick = false;
    public boolean secondaryClick = false;


    // Methods
    public void tick() {
        // Store Each Object into Temp Object, then Tick it
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.inputTick();
            tempObject.tick();
            tempObject.physicsTick();
        }

    }

    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }
    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }

    // Getters and Setters
    public boolean isLeft () {
        return left;
    }
    public void setLeft (boolean left) {
        this.left = left;
    }

    public boolean isDown () {
        return down;
    }
    public void setDown (boolean down) {
        this.down = down;
    }

    public boolean isRight () {
        return right;
    }
    public void setRight (boolean right) {
        this.right = right;
    }

    public boolean isUp () {
        return up;
    }
    public void setUp (boolean up) {
        this.up = up;
    }

    public boolean isSpace () {
        return space;
    }
    public void setSpace (boolean space) {
        this.space = space;
    }

    public boolean isEscape () {
        return escape;
    }
    public void setEscape (boolean escape) {
        this.escape = escape;
    }
}
