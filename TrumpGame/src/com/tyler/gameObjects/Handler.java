package com.tyler.gameObjects;

import java.util.ArrayList;

public class Handler {

    // Initialize Array of All Objects
    public ArrayList<GameObject> object = new ArrayList<>();

    // Initialize Input Booleans
    private static boolean left = false;
    private static boolean down = false;
    private static boolean right = false;
    private static boolean up = false;
    private static boolean space = false;
    private static boolean escape = false;

    public boolean primaryClick = false;
    public boolean secondaryClick = false;


    // Methods
    public void tick() {
        // Store Each Object into Temp Object, then Tick it
        for (GameObject tempObject : object) {
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

    public void setLeft (boolean x) {
        left = x;
    }

    public boolean isDown () {
        return down;
    }

    public void setDown (boolean x) {
        down = x;
    }

    public boolean isRight () {
        return right;
    }

    public void setRight (boolean x) {
        right = x;
    }

    public boolean isUp () {
        return up;
    }

    public void setUp (boolean x) {
        up = x;
    }

    public boolean isSpace () {
        return space;
    }

    public void setSpace (boolean x) {
        space = x;
    }

    public boolean isEscape () {
        return escape;
    }

    public void setEscape (boolean x) {
        escape = x;
    }
}
