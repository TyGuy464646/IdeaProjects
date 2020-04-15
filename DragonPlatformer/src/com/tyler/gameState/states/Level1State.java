package com.tyler.gameState.states;

import com.tyler.gameState.GameState;
import com.tyler.gameState.GameStateManager;
import com.tyler.tileMap.TileMap;

import java.awt.*;

public class Level1State extends GameState {

    // Variables
    private TileMap tilemap;


    // Constructor
    public Level1State(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }


    // Implemented Methods
    public void init() {

        //tileMap = new TileMap(30);

    }

    public void update() {

    }

    public void draw(Graphics2D g) {

    }

    public void keyPressed(int k) {

    }

    public void keyReleased(int k) {

    }
}
