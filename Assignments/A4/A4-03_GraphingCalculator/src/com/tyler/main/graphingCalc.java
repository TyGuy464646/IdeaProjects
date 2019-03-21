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
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class graphingCalc extends Application {

    double winWidth = 800;
    double winHeight = 600;

    Canvas canvas;
    GraphicsContext gc;

    ArrayList<Double> xCoordinates = new ArrayList<>();
    ArrayList<Double> yCoordinates = new ArrayList<>();

    ArrayList<Double> xCanCoordinates = new ArrayList<>();
    ArrayList<Double> yCanCoordinates = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        canvas = new Canvas(winWidth - 16, winHeight - 90);
        gc = canvas.getGraphicsContext2D();
        StackPane canvasCenterStackPane = new StackPane();
        canvasCenterStackPane.getChildren().add(canvas);
        canvasCenterStackPane.setBorder(new Border(
                new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
        Button browseBtn = new Button("browse");

        Label fileName = new Label("file: none");
        fileName.setTextFill(Color.RED);
        fileName.setTextAlignment(TextAlignment.CENTER);

        StackPane fileNameCenterPane = new StackPane(fileName);
        fileNameCenterPane.setPrefWidth(winWidth * .7);

        HBox hBox = new HBox(browseBtn, fileNameCenterPane);
        hBox.setAlignment(Pos.CENTER);

        browseBtn.setBackground(new Background(new BackgroundFill(Color.RED,
                new CornerRadii(4), null)));
        browseBtn.setTextFill(Color.LIGHTGRAY);
        browseBtn.setFont(new Font(16));

        /**
         *  Assignment A4_3
         *  Create the action for the browse button here.
         *  Read-in a csv file with x,y pairs plot the data.
         *  Use gc.strokeLine() and gc.fillText() to draw x and y axes
         *  and plot the curve.
         *
         *  Also don't forget to complete the methods below, you will need them.
         * **/

        browseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /**define the button action here**/
                clearCanvas(gc, 800, 600);
                xCoordinates.clear();
                yCoordinates.clear();

                xCanCoordinates.clear();
                yCanCoordinates.clear();

                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(stage);

                try {
                    FileInputStream inStream = new FileInputStream(file);
                    Scanner scanner = new Scanner(inStream);
                    scanner.useDelimiter(",|\\n");
                    while (scanner.hasNext()) {
                        String xStr = scanner.next();
                        String yStr = scanner.next();

                        double x = Double.valueOf(xStr);
                        double y = Double.valueOf(yStr);
                        xCoordinates.add(x);
                        yCoordinates.add(y);

                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                }

                try {
                    // Graph
                    double xMax = xMax(file);
                    double xMin = xMin(file);
                    double xAxisSize = xMax - xMin;

                    double yMax = yMax(file);
                    double yMin = yMin(file);
                    double yAxisSize = yMax - yMin;

                    for (int i = 0; i < xCoordinates.size(); i++) {
                        double xRaw = xCoordinates.get(i);
                        double scaleX = scaleXCoordinate(xRaw, xMin, xAxisSize, canvas.getWidth());
                        xCanCoordinates.add(scaleX);
                    }

                    for (int i = 0; i < yCoordinates.size(); i++) {
                        double yRaw = yCoordinates.get(i);
                        double scaleY = scaleYCoordinate(yRaw, yMin, yAxisSize, canvas.getHeight());
                        yCanCoordinates.add(scaleY);
                    }

                    gc.setStroke(Color.RED);
                    for (int i = 0; i < xCanCoordinates.size() - 1; i++) {
                        gc.strokeLine(xCanCoordinates.get(i), yCanCoordinates.get(i), xCanCoordinates.get(i+1), yCanCoordinates.get(i+1));
                    }

                    // Axis
                    double x0, y0;
                    x0 = scaleXCoordinate(0, xMin, xAxisSize, canvas.getWidth());
                    y0 = scaleYCoordinate(0, yMin, yAxisSize, canvas.getHeight());
                    gc.setStroke(Color.AQUA);
                    gc.strokeLine(x0, 0, x0, canvas.getHeight());
                    gc.strokeLine(0, y0, canvas.getWidth(), y0);

                    // Ticks
                    ArrayList<Double> xTick = new ArrayList<>();
                    ArrayList<Double> yTick = new ArrayList<>();
                    int numTicks = 10;
                    double deltaX = xAxisSize / numTicks;
                    double deltaY = yAxisSize / numTicks;
                    ArrayList<Double> xTickCanvas = new ArrayList<>();
                    ArrayList<Double> yTickCanvas = new ArrayList<>();

                    for (int i = 0; i < numTicks; i++) {
                        double xT = xMin + i * deltaX;
                        xTick.add(xT);

                        double yT = yMin + i * deltaY;
                        yTick.add(yT);

                        xTickCanvas.add(scaleXCoordinate(xT, xMin, xAxisSize, canvas.getWidth()));
                        yTickCanvas.add(scaleYCoordinate(yT, yMin, yAxisSize, canvas.getHeight()));
                    }

                    for (int i = 0; i < xTick.size(); i++) {
                        gc.strokeLine(xTickCanvas.get(i), y0 + 3, xTickCanvas.get(i), y0 - 3);
                        gc.strokeLine(x0 + 3, yTickCanvas.get(i), x0 - 3, yTickCanvas.get(i));

                        gc.setFill(Color.PINK);
                        String tickxString = String.format("%.2f", xTick.get(i));
                        String tickyString = String.format("%.2f", yTick.get(i));
                        gc.fillText(tickxString, xTickCanvas.get(i), y0);
                        gc.fillText(tickyString, x0, yTickCanvas.get(i));
                    }

                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        });

        VBox vBox = new VBox(canvasCenterStackPane, hBox);
        vBox.setMargin(canvasCenterStackPane, new Insets(10));
        vBox.setMargin(hBox, new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(45, 45, 45), null, null)));

        Scene scene = new Scene(vBox, winWidth, winHeight);
        stage.setScene(scene);
        stage.setTitle("CSV Data Plot");
        stage.show();
    }

    static void clearCanvas(GraphicsContext gc, double canvasWidth, double canvasHeight) {
        gc.setFill(Color.rgb(45, 45, 45));
        gc.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    static double scaleXCoordinate(double xRaw, double xMin, double xAxisSize, double canvasWidth) {
        /**define this method**/
        return (xRaw - xMin) / xAxisSize * canvasWidth;
    }

    static double scaleYCoordinate(double yRaw, double yMin, double yAxisSize, double canvasHeight) {
        /**define this function**/
        return (1.0 - ((yRaw - yMin) / yAxisSize)) * canvasHeight;
    }

    static double xMax(File file) throws FileNotFoundException {
        /**define this function**/
        ArrayList<Double> xCoordinates = new ArrayList<>();
        ArrayList<Double> yCoordinates = new ArrayList<>();

        try {
            FileInputStream inStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inStream);
            scanner.useDelimiter(",|\\n");
            while(scanner.hasNext()) {
                String xStr = scanner.next();
                String yStr = scanner.next();

                double x = Double.valueOf(xStr);
                double y = Double.valueOf(yStr);
                xCoordinates.add(x);
                yCoordinates.add(y);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        double xMax = Collections.max(xCoordinates);
        return xMax;
    }

    static double xMin(File file) throws FileNotFoundException {
        /**define this function**/
        ArrayList<Double> xCoordinates = new ArrayList<>();
        ArrayList<Double> yCoordinates = new ArrayList<>();

        try {
            FileInputStream inStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inStream);
            scanner.useDelimiter(",|\\n");
            while(scanner.hasNext()) {
                String xStr = scanner.next();
                String yStr = scanner.next();

                double x = Double.valueOf(xStr);
                double y = Double.valueOf(yStr);
                xCoordinates.add(x);
                yCoordinates.add(y);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        double xMin = Collections.min(xCoordinates);
        return xMin;
    }

    static double yMax(File file) throws FileNotFoundException {
        /**define this function**/
        ArrayList<Double> xCoordinates = new ArrayList<>();
        ArrayList<Double> yCoordinates = new ArrayList<>();

        try {
            FileInputStream inStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inStream);
            scanner.useDelimiter(",|\\n");
            while(scanner.hasNext()) {
                String xStr = scanner.next();
                String yStr = scanner.next();

                double x = Double.valueOf(xStr);
                double y = Double.valueOf(yStr);
                xCoordinates.add(x);
                yCoordinates.add(y);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        double yMax = Collections.max(yCoordinates);
        return yMax;
    }

    static double yMin(File file) throws FileNotFoundException {
        /**define this function**/
        ArrayList<Double> xCoordinates = new ArrayList<>();
        ArrayList<Double> yCoordinates = new ArrayList<>();

        try {
            FileInputStream inStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inStream);
            scanner.useDelimiter(",|\\n");
            while(scanner.hasNext()) {
                String xStr = scanner.next();
                String yStr = scanner.next();

                double x = Double.valueOf(xStr);
                double y = Double.valueOf(yStr);
                xCoordinates.add(x);
                yCoordinates.add(y);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        double yMin = Collections.min(yCoordinates);
        return yMin;
    }

}