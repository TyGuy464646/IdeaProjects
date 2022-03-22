package com.tyler.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.tyler.utils.Constants.PPM;

public class Game extends ApplicationAdapter {

	private boolean DEBUG = false;
	private final float GRAVITY = -9.8f;

	private float playerWidth = 32f;
	private float playerHeight = 32f;

	private OrthographicCamera camera;

	// Box2d variables
	private Box2DDebugRenderer b2dr;
	private World world;
	private Body player;
	private Body platform;

	
	@Override
	public void create () {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, width / 2, height / 2);

		// Box2d stuff
		world = new World(new Vector2(0, GRAVITY), false);
		b2dr = new Box2DDebugRenderer();

		player = createBox(0, 10, playerWidth, playerHeight, false);
		platform = createBox(0, 0, 64, 32, true);
	}

	public Body createBox(int x, int y, float width, float height, boolean isStatic) {
		Body pBody;
		BodyDef bdef = new BodyDef();

		if (isStatic)
			bdef.type = BodyDef.BodyType.StaticBody;
		else
			bdef.type = BodyDef.BodyType.DynamicBody;

		bdef.position.set(x / PPM, y / PPM);
		bdef.fixedRotation = true;
		pBody = world.createBody(bdef);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

		pBody.createFixture(shape, 1.0f);
		shape.dispose();

		return pBody;
	}

	public void cameraUpdate(float delta) {
		Vector3 position = camera.position;
		position.x = player.getPosition().x * PPM;
		position.y = player.getPosition().y * PPM;
		camera.position.set(position);

		camera.update();
	}

	public void inputUpdate(float delta) {
		int horizontalForce = 0;

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			horizontalForce -= 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			horizontalForce += 1;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			player.applyForceToCenter(0, 300, false);
		}

		player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);
	}

	public void update(float delta) {
		world.step(1/60f, 6, 2);

		inputUpdate(delta);
		cameraUpdate(delta);
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());

		ScreenUtils.clear(0, 0, 0, 1);
		b2dr.render(world, camera.combined.scl(PPM));
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width / 2, height / 2);
	}

	@Override
	public void dispose () {
		world.dispose();
		b2dr.dispose();
	}
}
