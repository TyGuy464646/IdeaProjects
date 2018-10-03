package com.tyler.robocode;

import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class TylerIsGod extends Robot {

    public void run() {
        this.setBodyColor(new Color(0, 200, 0));
        this.setGunColor(new Color(0, 150, 50));
        this.setRadarColor(new Color(0, 100, 100));
        this.setBulletColor(new Color(255, 255, 100));
        this.setScanColor(new Color(255, 200, 200));


        while (true) {
            turnRight(90);
        }
    }

    public void onHitWall(HitWallEvent e) {

    }

    public void onScannedRobot(ScannedRobotEvent e) {

    }

    public void onHitRobot(HitRobotEvent e) {

    }

}
