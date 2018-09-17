package com.tyler.gameObjects;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    // VARIABLES
    LinkedList<GameObject> object = new LinkedList<GameObject>(); // Array of objects


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

}
