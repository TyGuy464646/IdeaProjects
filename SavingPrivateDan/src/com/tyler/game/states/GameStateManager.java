package com.tyler.game.states;

import com.tyler.game.GameLauncher;
import com.tyler.game.util.KeyHandler;
import com.tyler.game.util.MouseHandler;
import com.tyler.game.util.Vector2f;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    // Variables
    private ArrayList<GameState> states;

    public static Vector2f map;

    public static final int PLAY = 0,
                            MENU = 1,
                            PAUSE = 2,
                            GAMEOVER = 3;


    // Constructor
    public GameStateManager() {
        map = new Vector2f(GameLauncher.width, GameLauncher.height);
        Vector2f.setWorldVariable(map.x, map.y);

        states = new ArrayList<GameState>();

        states.add(new PlayState(this));
    }


    // Methods
    public void remove(int state) {
        states.remove(state);
    }


    public void add(int state) {
        if(state == PLAY) {
            states.add(new PlayState(this));
        }
        if(state == MENU) {
            states.add(new MenuState(this));
        }
        if(state == PAUSE) {
            states.add(new PauseState(this));
        }
        if(state == GAMEOVER) {
            states.add(new GameOverState(this));
        }
    }

    public void addAndRemove(int state) {
        states.remove(0);
        add(state);
    }

    public void tick() {
        Vector2f.setWorldVariable(map.x, map.y);
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
