package com.tyler.game.util;

import com.tyler.game.GameLauncher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener {

    // Classes
    public class Key {

        // Variables
        public boolean isDown, isClicked;
        public int presses, absorbs;

        // Constructor
        public Key() {
            // Constructor
            keys.add(this);
        }


        // Methods
        public void toggle(boolean pressed) {
            if(pressed != isDown) {
                isDown = pressed;
            }
            if(pressed) {
                presses++;
            }
        }

        public void tick() {
            if(absorbs < presses) {
                absorbs++;
                isClicked = true;
            } else {
                isClicked = false;
            }
        }
    }


    // Variables
    public static List<Key> keys = new ArrayList<Key>();

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();

    public Key attack = new Key();

    public Key menu = new Key();
    public Key enter = new Key();
    public Key escape = new Key();


    // Constructor
    public KeyHandler(GameLauncher game) {
        game.addKeyListener(this);
    }


    // Methods
    public void releaseAll() {
        for(int i = 0; i < keys.size(); i++) {
            keys.get(i).isDown = false;
        }
    }

    public void tick() {
        for(int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }

    public void toggle(KeyEvent e, boolean pressed) {
        if(e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);

        if(e.getKeyCode() == KeyEvent.VK_SPACE) attack.toggle(pressed);

        if(e.getKeyCode() == KeyEvent.VK_M) menu.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);
    }


    // Implemented Methods
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
}
