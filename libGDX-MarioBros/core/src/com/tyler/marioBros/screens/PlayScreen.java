package com.tyler.marioBros.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tyler.marioBros.MarioBros;

public class PlayScreen implements Screen {

    private MarioBros game;
    Texture texture;

    public PlayScreen(MarioBros game) {
        this.game = game;
        texture = new Texture("badlogic.jpg");
    }

    @Override
    public void show () {

    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        game.batch.begin();
        // DRAW TEXTURES ////////////////////////////////////////////////////////////////////////////////////////////

        Gdx.graphics.setTitle("Mario Bros | FPS: " + Gdx.graphics.getFramesPerSecond());
        game.batch.draw(texture, 0, 0);

        // DRAW TEXTURES ////////////////////////////////////////////////////////////////////////////////////////////
        game.batch.end();
    }

    @Override
    public void resize (int width, int height) {

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {

    }
}
