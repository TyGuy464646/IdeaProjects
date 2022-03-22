package com.tyler.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class GameScreen implements Screen {

    final Drop game;

    Texture dropImage, bucketImage;
    Sound dropSound;
    Music rainMusic;

    OrthographicCamera camera;

    Rectangle bucket;
    Array<Rectangle> raindrops;
    long lastDropTime;
    int dropsGathered;

    public GameScreen(final Drop game) {
        this.game = game;

        // Load images for droplet and bucket, 64x64 pixels each
        dropImage = new Texture(Gdx.files.internal("droplet.png"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));

        // Load drop sound effect and rain background music
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        rainMusic.setLooping(true);

        // Create the camera and SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Create a Rectangle to represent bucket
        bucket = new Rectangle();
        bucket.width = 64;
        bucket.height = 64;

        bucket.x = 800 / 2 - bucket.width / 2;
        bucket.y = 20;

        // Create raindrops array and spawn first raindrop
        raindrops = new Array<Rectangle>();
        spawnRaindrop();
    }

    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.width = 64;
        raindrop.height = 64;
        raindrop.x = MathUtils.random(0, 800 - raindrop.width);
        raindrop.y = 480;

        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void show() {
        rainMusic.play();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        // BEGIN    RENDER ///////////////////////////////////////////

        Gdx.graphics.setTitle("Drop | FPS: " + Gdx.graphics.getFramesPerSecond());

        game.font.draw(game.batch, "Drops Collected: " + dropsGathered, 0, 480);

        game.batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);

        for (Rectangle raindrop : raindrops) {
            game.batch.draw(dropImage, raindrop.x, raindrop.y);
        }

        // END      RENDER ///////////////////////////////////////////
        game.batch.end();

        // Process User Input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            bucket.x = touchPos.x - bucket.width / 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            bucket.x -= 200 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            bucket.x += 200 * delta;

        // Make sure bucket stays in screen bounds
        if (bucket.x < 0)
            bucket.x = 0;
        if (bucket.x > 800 - bucket.width)
            bucket.x = 800 - bucket.width;

        // Check if we need to create a new raindrop
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
            spawnRaindrop();

        // Move raindrops and remove any that are beneath bottom edge or hit bucket
        Iterator<Rectangle> iter = raindrops.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 200 * delta;

            if (raindrop.y + raindrop.height < 0)
                iter.remove();
            if (raindrop.overlaps(bucket)) {
                dropsGathered++;
                dropSound.play();
                iter.remove();
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        dropImage.dispose();
        bucketImage.dispose();
        dropSound.dispose();
        rainMusic.dispose();
    }
}
