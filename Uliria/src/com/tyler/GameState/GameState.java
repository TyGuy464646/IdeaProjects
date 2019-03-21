package com.tyler.GameState;

public class GameState {

    enum GameStateType {
        TITLE_STATE,
        GAME_STATE,
        PAUSE_STATE,
        EXIT_STATE
    }

    GameStateType type = GameStateType.TITLE_STATE;



}
