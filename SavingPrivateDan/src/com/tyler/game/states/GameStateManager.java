package com.tyler.game.states;

import com.tyler.game.util.KeyHandler;
import com.tyler.game.util.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    // Variables
    private ArrayList<GameState> states;


    // Constructor
    public GameStateManager() {
        states = new ArrayList<GameState>();

        states.add(new PlayState(this));
    }


    // Methods
    public void tick() {
        for(int i = 0; i < states.size(); i++) {
            states.get(i).tick();
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        for(int i = 0; i < states.size(); i++) {
            states.get(i).input(mouse, key);
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < states.size(); i++) {
            states.get(i).render(g);
        }
    }
}
