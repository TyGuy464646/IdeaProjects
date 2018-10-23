package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;

import java.net.URL;

public class Controller {
    @FXML
    Label tenthsLabel, secLabel, minLabel;
    @FXML
    Rectangle tenthsMeter, secondsMeter;

    AudioClip countSong;

    AnimationTimer timer;
    long startNanoTime = 0;
    long timeOffset = 0;

    final long nanosPerTenth = 100000000;

    int tenths = 0;
    int seconds = 0;
    int minutes = 0;

    boolean watchIsRunning = false;


    public void initialize() {
        URL soundURL = getClass().getResource("/sound/countClip.wav");
        countSong = new AudioClip(soundURL.toString());
        countSong.play();

        timer = new AnimationTimer() {
            public void handle(long now) {
                long nanosElapsed = now - startNanoTime - timeOffset;

                if(nanosElapsed >= nanosPerTenth) {
                    if(watchIsRunning) tenths++;
                    timeOffset += nanosPerTenth;
                }
                if(tenths >= 10) {
                    seconds++;
                    tenths -= 10;
                }
                if(seconds >= 60) {
                    minutes++;
                    seconds -= 60;
                }

                tenthsLabel.setText(String.valueOf(tenths));
                secLabel.setText(String.valueOf(seconds));
                minLabel.setText(String.valueOf(minutes));

                double percentTenths = (double) tenths / 10.0 * 600;
                tenthsMeter.setWidth(percentTenths);

                double percentSeconds = (double) seconds / 60.0 * 600;
                secondsMeter.setWidth(percentSeconds);
            }
        };
        startNanoTime = System.nanoTime();
        timer.start();
    }


    @FXML
    public void startStopAction() {
        watchIsRunning = !watchIsRunning;
    }

    @FXML
    public void resetAction() {
        tenths = 0;
        seconds = 0;
        minutes = 0;
        watchIsRunning = false;
    }
}
