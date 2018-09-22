package com.tyler.game.states;

import com.tyler.game.util.KeyHandler;
import com.tyler.game.util.MouseHandler;

import java.awt.*;

public class PlayState extends GameState {

    // Constructor
    public PlayState(GameStateManager gsm) {
        super(gsm);
    }


    // Methods
    public void tick() {

    }

    public void input(MouseHandler mouse, KeyHandler key) {
        if(key.up.isDown) {
            System.out.println("W is being pressed");
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(100, 100, 64, 64);
    }
}
