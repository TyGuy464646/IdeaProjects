package com.tyler.game.entity;

import com.tyler.game.graphics.Animation;
import com.tyler.game.graphics.Sprite;
import com.tyler.game.util.KeyHandler;
import com.tyler.game.util.MouseHandler;
import com.tyler.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    // Variables
    private final int   UP = 0,
                        DOWN = 1,
                        RIGHT = 2,
                        LEFT = 3;

    protected int currentAnimation;
    protected Animation animation;
    protected Sprite sprite;
    protected Vector2f pos;
    protected int size;

    protected boolean up, down, right, left, attack;
    protected int attackSpeed, attackDuration;
    protected float directionX, directionY;
    protected float maxSpeed;
    protected float acceleration, deacceleration;


    // Constructor
    public Entity(Sprite sprite, Vector2f origin, int size) {
        this.sprite = sprite;
        pos = origin;
        this.size = size;

        animation = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }


    // Methods
    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    public void animate() {
        if(up) {
            if(currentAnimation != UP || animation.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP), 5);
            }
        }
        else if(down) {
            if(currentAnimation != DOWN || animation.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
            }
        }
        else if(left) {
            if(currentAnimation != LEFT || animation.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
            }
        }
        else if(right) {
            if(currentAnimation != RIGHT || animation.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }

    public void update() {
        animate();
        setHitBoxDirection();
        animation.update();
    }

    public abstract void render(Graphics g);
    public void input(KeyHandler key, MouseHandler mouse) {}

}
