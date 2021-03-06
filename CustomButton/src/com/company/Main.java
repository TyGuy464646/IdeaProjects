package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
<<<<<<< HEAD
=======
//      b.setRotate(45);
>>>>>>> 5435b6843a10e90c6628b4802fa295fa4e95ef3c
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
                                    b.setImage(hoverImage);
                                }
                            });
                            t.cancel();
                            t.purge();
                        }
                    };
                    t.schedule(revert, 100);
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
