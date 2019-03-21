package com.tyler.main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class main extends Application {

    Label outLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        root.setAlignment(Pos.TOP_CENTER);


        outLabel = new Label("file output here");

        Button browseButton = new Button("browse");
        browseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FileChooser fc = new FileChooser();
                    File file = fc.showOpenDialog(stage);
                    FileInputStream inStream = new FileInputStream(file);
                    Scanner scanner = new Scanner(inStream);
                    scanner.useDelimiter(",|\\n");
                    String fileOut = "";
                    while(scanner.hasNext()){
                        String xStr = scanner.next();
                        String yStr = scanner.next();

                        double x = Double.valueOf(xStr);
                        double y = Double.valueOf(yStr);

                        fileOut += String.format("x:%.3f     y:%f.3\n",x,y);
                    }
                    outLabel.setText(fileOut);
                } catch(Exception ex){
                    System.err.println(ex);
                }

            }
        });

        root.getChildren().addAll(browseButton, outLabel);

        Scene scn = new Scene(root, 300, 700);
        stage.setScene(scn);
        stage.setTitle("CSV File Browser");
        stage.show();
    }
}