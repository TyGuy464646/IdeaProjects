package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    Image defaultImage, hoverImage, pressedImage;


    @Override
    public void start(Stage stage) throws Exception {
        defaultImage = new Image("/TEST_BUTTONS/ButtonRegular.png");
        hoverImage = new Image("/TEST_BUTTONS/ButtonHover.png");
        pressedImage = new Image("/TEST_BUTTONS/ButtonPressed.png");

        StackPane p = new StackPane();
        Scene s = new Scene(p, 400, 100);
        stage.setScene(s);

        ImageView b = new ImageView();
        b.setImage(defaultImage);
        b.setRotate(45);
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.PRIMARY){
                    System.out.println("Pressed!");
                    b.setImage(pressedImage);
                    Timer t = new Timer();
                    TimerTask revert = new TimerTask() {
                        @Override
                        public void run() {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    b.setImage(defaultImage);
                                }
                            });
                            t.cancel();
                            t.purge();
                        }
                    };
                    t.schedule(revert, 200);
                }
            }
        });
        b.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                b.setImage(hoverImage);
            }
        });
        b.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                b.setImage(defaultImage);
            }
        });
        p.getChildren().add(b);



        stage.setTitle("custom buttons");
        stage.show();
        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
