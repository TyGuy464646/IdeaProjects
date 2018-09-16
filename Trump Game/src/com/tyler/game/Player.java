package com.tyler.game;

import com.tyler.engine.GameContainer;
import com.tyler.engine.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player extends GameObject {

    // VARIABLES
    private int tileX, tileY;
    private float offX, offY;

    private Renderer r;

    private float speed = 100;
    private float fallSpeed = 10;
    private float jump = -4;
    private boolean isOnGround = false;

    private float fallDistance = 0;


    // CONSTRUCTOR
    public Player(int posX, int posY) {
        this.tag = "player";
        this.tileX = posX;
        this.tileY = posY;
        this.offX = 0;
        this.offY = 0;
        this.posX = posX * GameManager.TS;
        this.posY = posY * GameManager.TS;
        this.width = GameManager.TS;
        this.height = GameManager.TS;
    }


    // IMPLEMENTED METHODS
    public void update(GameContainer gc, GameManager gm, float deltaTime) {

        // BEGINNING OF LEFT AND RIGHT COLLISION

        // RIGHT
        if(gc.getInput().isKey(KeyEvent.VK_D)) {
            if(gm.getCollision(tileX + 1, tileY) || gm.getCollision(tileX + 1, tileY + (int)Math.signum((int)offY))) {
                if(offX < 0) {
                    offX += deltaTime * speed;
                    if(offX > 0) {
                        offX = 0;
                    }
                } else {
                    offX = 0;
                }
            } else {
                offX += deltaTime * speed;
            }
        }

        // LEFT
        if(gc.getInput().isKey(KeyEvent.VK_A)) {
            if(gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int)Math.signum((int)offY))) {
                if(offX > 0) {
                    offX -= deltaTime * speed;
                    if(offX < 0) {
                        offX = 0;
                    }
                } else {
                    offX = 0;
                }
            } else {
                offX -= deltaTime * speed;
            }
        }

        // END OF LEFT AND RIGHT COLLISION


        // BEGINNING OF JUMP AND GRAVITY
        fallDistance += deltaTime * fallSpeed;

        if(gc.getInput().isKeyDown(KeyEvent.VK_SPACE) && isOnGround) {
            fallDistance = jump;
            isOnGround = false;
        }

        offY += fallDistance;

        if(fallDistance < 0) {
            if ((gm.getCollision(tileX, tileY - 1) || gm.getCollision(tileX + (int) Math.signum((int) offX), tileY - 1)) && offY < 0) {
                fallDistance = 0;
                offY = 0;
            }
        }

        if(fallDistance > 0) {
            if ((gm.getCollision(tileX, tileY + 1) || gm.getCollision(tileX + (int) Math.signum((int) offX), tileY + 1)) && offY > 0) {
                fallDistance = 0;
                offY = 0;
                isOnGround = true;
            }
        }
        // END OF JUMP AND GRAVITY


        // FINAL POSITION
        if(offY > GameManager.TS / 2) {
            tileY++;
            offY -= GameManager.TS;
        }
        if(offY < -GameManager.TS / 2) {
            tileY--;
            offY += GameManager.TS;
        }

        if(offX > GameManager.TS / 2) {
            tileX++;
            offX -= GameManager.TS;
        }
        if(offX < -GameManager.TS / 2) {
            tileX--;
            offX += GameManager.TS;
        }

        posX = tileX * GameManager.TS + offX;
        posY = tileY * GameManager.TS + offY;

        // SHOOTING
        if(gc.getInput().isButtonDown(MouseEvent.BUTTON1)) {
            double playerScreenX = posX - gc.getRenderer().getCamX();
            double playerScreenY = posY - gc.getRenderer().getCamY();

            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2,
                    Math.atan2(gc.getInput().getMouseX() - playerScreenX, gc.getInput().getMouseY() - playerScreenY)));
        }


    }

    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX, (int)posY, width, height, 0xff00ff00);
    }
}
