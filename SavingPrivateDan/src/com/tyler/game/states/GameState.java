package com.tyler.game.states;

import com.tyler.game.util.KeyHandler;
import com.tyler.game.util.MouseHandler;

import java.awt.*;

public abstract class GameState {

    private GameStateManager gsm;


    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }


    public abstract void tick();

    public abstract void input(MouseHandler mouse, KeyHandler key);

    public abstract void render(Graphics g);
}
