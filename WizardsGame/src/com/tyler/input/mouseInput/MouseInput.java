package com.tyler.input.mouseInput;

import com.tyler.gameObjects.GameObject;
import com.tyler.gameObjects.Handler;
import com.tyler.gameObjects.ID;
import com.tyler.gameObjects.objects.Bullet;
import com.tyler.main.Camera;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    // VARIABLES
    private Handler handler;
    private Camera camera;


    // CONSTRUCTOR
    public MouseInput(Handler handler, Camera camera) {
        this.handler = handler;
        this.camera = camera;
    }


    // IMPLEMENTED METHODS
    public void mousePressed(MouseEvent e) {
        int mouseX = (int) (e.getX() + camera.getX());
        int mouseY = (int) (e.getY() + camera.getY());

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player) {
                handler.addObject(new Bullet(tempObject.getX()+ 16, tempObject.getY() + 24, ID.Bullet, handler, mouseX, mouseY));
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

}
