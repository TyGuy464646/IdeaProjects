package com.tyler.game.util;

import com.tyler.game.entity.Entity;

public class AABB {

    // Variables
    private Vector2f pos;
    private Entity entity;

    private float xOffset = 0, yOffset = 0;
    private float width, height;
    private float detectionRadius;
    private int size;


    // Constructor
    public AABB(Vector2f pos, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;

        size = Math.max(width, height);
    }

    public AABB(Vector2f pos, int detectionRadius, Entity e) {
        this.pos = pos;
        this.detectionRadius = detectionRadius;
        this.entity = e;
        size = detectionRadius;
    }


    // Methods
    public void setBox(Vector2f pos, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;

        size = Math.max(width, height);
    }

    public void setCircle(Vector2f pos, int radius) {
        this.pos = pos;
        this.detectionRadius = radius;

        size = radius;
    }

    public boolean collides(AABB bBox) {
        float aX = ((pos.getWorldVar().x + (xOffset)) + (width / 2));
        float aY = ((pos.getWorldVar().y + (yOffset)) + (height / 2));
        float bX = ((bBox.pos.getWorldVar().x + (bBox.xOffset / 2)) + (width / 2));
        float bY = ((bBox.pos.getWorldVar().y + (bBox.yOffset / 2)) + (height / 2));

        if(Math.abs(aX - bX) < (this.width / 2) + (bBox.width / 2)) {
            if(Math.abs(aY - bY) < (this.height / 2) + (bBox.height / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean colCirlceBox(AABB aBox) {
        float cX = (float) (pos.getWorldVar().x + detectionRadius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));
        float cY = (float) (pos.getWorldVar().y + detectionRadius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));

        float xDelta = cX - Math.max(aBox.getPos().getWorldVar().x + (aBox.getWidth() / 2), Math.min(cX, aBox.pos.getWorldVar().x));
        float yDelta = cY - Math.max(aBox.getPos().getWorldVar().y + (aBox.getWidth() / 2), Math.min(cY, aBox.pos.getWorldVar().y));

        if((xDelta * xDelta * yDelta * yDelta) < ((this.detectionRadius / Math.sqrt(2)) * (this.detectionRadius / Math.sqrt(2)))) {
            return true;
        }

        return false;
    }


    // Getters
    public Vector2f getPos() { return pos; }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getDetectionRadius() {
        return detectionRadius;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
