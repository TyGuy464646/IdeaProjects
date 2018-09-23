package com.tyler.game.states;

import com.tyler.game.graphics.Font;
import com.tyler.game.graphics.Sprite;
import com.tyler.game.util.KeyHandler;
import com.tyler.game.util.MouseHandler;
import com.tyler.game.util.Vector2f;

import java.awt.*;

public class PlayState extends GameState {

    // Variables
    private Font font;


    // Constructor
    public PlayState(GameStateManager gsm) {
        super(gsm);

        font = new Font("font/ZeldaFont.png", 16, 16);
    }


    // Methods
    public void tick() {

    }

    public void input(MouseHandler mouse, KeyHandler key) {

    }

    public void render(Graphics g) {
        Sprite.drawArray(g, font, "I Love You", new Vector2f(100,100), 32, 32, 16, 0);
    }
}
