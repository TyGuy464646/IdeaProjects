package com.tyler.game;

import com.tyler.engine.GameContainer;
import com.tyler.engine.Renderer;

public class Camera {

    // VARIABLES
    private float offX, offY;

    private GameObject target = null;
    private String targetTag;


    // CONSTRUCTOR
    public Camera(String tag) {
        this.targetTag = tag;
    }

    public void update(GameContainer gc, GameManager gm, float dt) {
        if(target == null) {
            target = gm.getObject(targetTag);
        }

        if(target == null) {
            return;
        }

        float targetX = (target.getPosX() + target.getWidth() / 2) - gc.getWidth() / 2;
        float targetY = (target.getPosY() + target.getHeight() / 2) - gc.getHeight() / 2;

        offX -= dt * (offX - targetX) * 8;
        offY -= dt * (offY - targetY) * 8;
    }

    public void render(Renderer r) {
        r.setCamX((int) offX);
        r.setCamY((int) offY);
    }


    // GETTERS AND SETTERS
    public float getOffX() {
        return offX;
    }
    public void setOffX(float offX) {
        this.offX = offX;
    }

    public float getOffY() {
        return offY;
    }
    public void setOffY(float offY) {
        this.offY = offY;
    }

    public GameObject getTarget() {
        return target;
    }
    public void setTarget(GameObject target) {
        this.target = target;
    }

    public String getTargetTag() {
        return targetTag;
    }
    public void setTargetTag(String targetTag) {
        this.targetTag = targetTag;
    }
}
