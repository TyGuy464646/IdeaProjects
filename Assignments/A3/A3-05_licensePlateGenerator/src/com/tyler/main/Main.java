package com.tyler.main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    GraphicsContext gc;
    Canvas canvas;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        canvas = new Canvas(400, 150);
        gc = canvas.getGraphicsContext2D();

        Button button = new Button("Generate Random License Plate");
        button.setBackground(new Background(new BackgroundFill(Color.DARKGREEN,new CornerRadii(4),null)));
        button.setTextFill(Color.WHITESMOKE);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());

                gc.setFill(Color.YELLOW);
                gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

                gc.setFont(new Font(80));
                gc.setFill(Color.DARKRED);


                /** generate a license plate string and print it with gc.fillText() **/
                // Assignment A3-5 code goes here.

                char charArray[] = new char[10];
                char charAlphabetArray[] = new char[26];

                String numbers = "", letters = "";

                Random random = new Random();

                for (int i = 48; i < 58; i++) {
                    charArray[i - 48] = (char) i;
                }

                for (int i = 65; i < 91; i++) {
                    charAlphabetArray[i - 65] = (char) i;
                }

                for (int i = 0; i < 3; i++) {
                    int a = random.nextInt(10);

                    numbers += charArray[a];
                }

                for (int i = 0; i < 3; i++) {
                    int a = random.nextInt(26);

                    letters += charAlphabetArray[a];
                }

                boolean toggle = random.nextBoolean();

                if (toggle) {
                    gc.fillText(letters + "   " + numbers, 10, 100);
                } else {
                    gc.fillText(numbers + "   " + letters, 10, 100);
                }

                /** end license plate text generation **/

                //red zia
                gc.setStroke(Color.DARKRED);
                gc.setLineWidth(4);
                gc.setLineCap(StrokeLineCap.ROUND);
                gc.strokeLine(192, 50, 192, 80);
                gc.strokeLine(197, 45, 197, 85);
                gc.strokeLine(203, 45, 203, 85);
                gc.strokeLine(208, 50, 208, 80);

                gc.strokeLine(185, 57, 215, 57);
                gc.strokeLine(180, 62, 220, 62);
                gc.strokeLine(180, 68, 220, 68);
                gc.strokeLine(185, 73, 215, 73);

                gc.setFill(Color.YELLOW);
                gc.setStroke(Color.DARKRED);
                gc.setLineWidth(4);
                gc.fillOval(187,52,26,26);
                gc.strokeOval(187,52,26,26);

                //New Mexico identifiers
                gc.setFill(Color.DARKRED);
                gc.setFont(new Font(20));
                gc.fillText("New Mexico USA",110,128, 250);

                gc.setFill(Color.DARKGREEN);
                gc.setFont(new Font(14));
                gc.fillText("Land of Enchantment",118,144, 250);

            }
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(canvas,button);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(45,45,45), null,null)));

        Scene scene = new Scene(vBox);
        stage.setScene(scene);

        stage.setTitle("License Plate Generator");

        stage.show();


    }

}
