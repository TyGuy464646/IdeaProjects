package com.tyler.robocode;

import robocode.Robot;

import java.awt.*;

public class AimAndTurn extends Robot {

    public void run() {

        setScanColor(Color.RED);

        double cX = getBattleFieldWidth()/2.0;
        double cY = getBattleFieldHeight()/2.0;

        turnRight(Math.random()*360);
        ahead(Math.random()*100);
        turnGunRight(Math.random()*360);

        aimBase(cX,cY);
        aimGun(cX,cY);
        aimRadar(cX,cY);

        turnRadarRight(.1);

        while(true) {
            fire(1);
        }

    }





    void aimGun(double targetX, double targetY){
        double vX = getX() - targetX;
        double vY = getY() - targetY;
        double theta = Math.toDegrees(Math.atan2(vY, -1.0*vX)) + 90.0;
        turnGunRight(theta - (getGunHeading()));
    }
    void aimRadar(double targetX, double targetY){
        double vX = getX() - targetX;
        double vY = getY() - targetY;
        double theta = Math.toDegrees(Math.atan2(vY, -1.0*vX)) + 90.0;
        turnRadarRight(theta - (getRadarHeading()));
    }
    void aimBase(double targetX, double targetY){
        double vX = getX() - targetX;
        double vY = getY() - targetY;
        double theta = Math.toDegrees(Math.atan2(vY, -1.0*vX)) + 90.0;
        turnRight(theta - (getHeading()));
    }

}
