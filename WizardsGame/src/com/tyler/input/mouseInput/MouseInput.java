package com.tyler.input.mouseInput;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameObjects.objects.Bullet;
import com.tyler.main.Camera;
import com.tyler.main.Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    // VARIABLES
    private Handler handler;
    private Camera camera;
    private Main game;


    // CONSTRUCTOR
    public MouseInput(Handler handler, Camera camera, Main game) {
        this.handler = handler;
        this.camera = camera;
        this.game = game;
    }


    // IMPLEMENTED METHODS
    public void mousePressed(MouseEvent e) {
        int mouseX = (int) (e.getX() + camera.getX());
        int mouseY = (int) (e.getY() + camera.getY());

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player && game.ammo >= 1) {
                handler.addObject(new Bullet(tempObject.getX()+ 16, tempObject.getY() + 24, ID.Bullet, handler, mouseX, mouseY));
                game.ammo--;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

}
