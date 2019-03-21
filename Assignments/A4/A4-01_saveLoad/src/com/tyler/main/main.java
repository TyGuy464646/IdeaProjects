package com.tyler.main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class main extends Application {

    Button saveButton, loadButton;

    TextField boxTextField;
    Slider fontSizeSlider, heightSlider, widthSlider, borderWidthSlider, cornerRadiusSlider, rotationSlider;
    CheckBox boldCheckBox, italicCheckBox;
    ColorPicker fillColorPicker, borderColorPicker;

    Rectangle box;
    Label boxLabel;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        buildGUI(stage);

        /**
         * Add code to make the two buttons work. Save data in a configuration file within
         * the project resources directory so that a built JAR file will still save configuration
         */


        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /** add save button action code here **/
                try {
                    makePropFile(
                            boxTextField.getText(), String.valueOf(fontSizeSlider.getValue()), String.valueOf(heightSlider.getValue()),
                            String.valueOf(widthSlider.getValue()), String.valueOf(borderWidthSlider.getValue()), String.valueOf(cornerRadiusSlider.getValue()),
                            String.valueOf(rotationSlider.getValue()), String.valueOf(boldCheckBox.isSelected()), String.valueOf(italicCheckBox.isSelected()),
                            String.valueOf(fillColorPicker.getValue()), String.valueOf(borderColorPicker.getValue())
                    );
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });

        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /** add load button action code here **/
                try {
                    boxTextField.setText(readPropFile("boxTextField"));
                    fontSizeSlider.setValue(Double.parseDouble(readPropFile("fontSizeSlider")));
                    heightSlider.setValue(Double.parseDouble(readPropFile("heightSlider")));
                    widthSlider.setValue(Double.parseDouble(readPropFile("widthSlider")));
                    borderWidthSlider.setValue(Double.parseDouble(readPropFile("borderWidthSlider")));
                    cornerRadiusSlider.setValue(Double.parseDouble(readPropFile("cornerRadiusSlider")));
                    rotationSlider.setValue(Double.parseDouble(readPropFile("rotationSlider")));
                    boldCheckBox.setSelected(Boolean.parseBoolean(readPropFile("boldCheckBox")));
                    italicCheckBox.setSelected(Boolean.parseBoolean(readPropFile("italicCheckBox")));
                    fillColorPicker.setValue(Color.valueOf(readPropFile("fillColorPicker")));
                    borderColorPicker.setValue(Color.valueOf(readPropFile("borderColorPicker")));
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    static void makePropFile(String boxTextField, String fontSizeSlider, String heightSlider, String widthSlider, String borderWidthSlider, String cornerRadiusSlider, String rotationSlider, String boldCheckBox, String italicCheckBox, String fillColorPicker, String borderColorPicker) throws Exception {
        File file = new File("./settings.properties");
        FileOutputStream fos = new FileOutputStream(file);

        Properties prop = new Properties();
        prop.setProperty("boxTextField", boxTextField);
        prop.setProperty("fontSizeSlider", fontSizeSlider);
        prop.setProperty("heightSlider", heightSlider);
        prop.setProperty("widthSlider", widthSlider);
        prop.setProperty("borderWidthSlider", borderWidthSlider);
        prop.setProperty("cornerRadiusSlider", cornerRadiusSlider);
        prop.setProperty("rotationSlider", rotationSlider);
        prop.setProperty("boldCheckBox", boldCheckBox);
        prop.setProperty("italicCheckBox", italicCheckBox);
        prop.setProperty("fillColorPicker", fillColorPicker);
        prop.setProperty("borderColorPicker", borderColorPicker);
        prop.store(fos, null);
    }

    static String readPropFile(String key) throws Exception {
        File file = new File("./settings.properties");
        FileInputStream fis = new FileInputStream(file);

        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        return value;
    }

    void updateBox() {
        box.setWidth(widthSlider.getValue());
        box.setHeight(heightSlider.getValue());
        box.setFill(fillColorPicker.getValue());
        box.setArcHeight(cornerRadiusSlider.getValue());
        box.setArcWidth(cornerRadiusSlider.getValue());
        box.setStrokeWidth(borderWidthSlider.getValue());
        box.setStroke(borderColorPicker.getValue());
        boxLabel.setTextFill(borderColorPicker.getValue());
        boxLabel.setText(boxTextField.getText());
        box.setRotate(rotationSlider.getValue());
        boxLabel.setRotate(rotationSlider.getValue());
        FontWeight fontWeight = boldCheckBox.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL;
        FontPosture fontPosture = italicCheckBox.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR;
        boxLabel.setFont(Font.font("", fontWeight, fontPosture, fontSizeSlider.getValue()));
    }

    void buildGUI(Stage stage) {

        GridPane root = new GridPane();

        int rowCount = 0;


        saveButton = new Button("save");
        loadButton = new Button("load");
        root.addRow(rowCount, saveButton, loadButton);
        rowCount++;

        Label nameLabel = new Label("Box Name");
        boxTextField = new TextField("CS-152");
        root.addRow(rowCount, nameLabel, boxTextField);
        rowCount++;

        Label fontSizeLabel = new Label("Font Size");
        fontSizeSlider = new Slider(8, 32, 16);
        fontSizeSlider.setMajorTickUnit(6);
        fontSizeSlider.setMinorTickCount(2);
        fontSizeSlider.setSnapToTicks(true);
        fontSizeSlider.setShowTickMarks(true);
        fontSizeSlider.setShowTickLabels(true);
        root.addRow(rowCount, fontSizeLabel, fontSizeSlider);
        rowCount++;

        boldCheckBox = new CheckBox("bold");
        italicCheckBox = new CheckBox("italic");
        root.addRow(rowCount, boldCheckBox, italicCheckBox);
        rowCount++;

        Label heightLabel = new Label("Height");
        heightSlider = new Slider(20, 240, 20);
        heightSlider.setMajorTickUnit(40);
        heightSlider.setMinorTickCount(1);
        heightSlider.setSnapToTicks(true);
        heightSlider.setShowTickMarks(true);
        heightSlider.setShowTickLabels(true);
        root.addRow(rowCount, heightLabel, heightSlider);
        rowCount++;

        Label widthLabel = new Label("Width");
        widthSlider = new Slider(20, 240, 80);
        widthSlider.setMajorTickUnit(40);
        widthSlider.setMinorTickCount(1);
        widthSlider.setSnapToTicks(true);
        widthSlider.setShowTickMarks(true);
        widthSlider.setShowTickLabels(true);
        root.addRow(rowCount, widthLabel, widthSlider);
        rowCount++;

        Label colorLabel = new Label("Fill Color");
        fillColorPicker = new ColorPicker(Color.LIMEGREEN);
        root.addRow(rowCount, colorLabel, fillColorPicker);
        rowCount++;

        Label borderWidthLabel = new Label("Border Width");
        borderWidthSlider = new Slider(0, 10, 2);
        borderWidthSlider.setMajorTickUnit(5);
        borderWidthSlider.setMinorTickCount(4);
        borderWidthSlider.setSnapToTicks(true);
        borderWidthSlider.setShowTickMarks(true);
        borderWidthSlider.setShowTickLabels(true);
        root.addRow(rowCount, borderWidthLabel, borderWidthSlider);
        rowCount++;

        Label borderColorLabel = new Label("Border/Font Color");
        borderColorPicker = new ColorPicker(Color.BLUE);
        root.addRow(rowCount, borderColorLabel, borderColorPicker);
        rowCount++;

        Label cornerRadiusLabel = new Label("Corner Radius");
        cornerRadiusSlider = new Slider(0, 25, 10);
        cornerRadiusSlider.setMajorTickUnit(5);
        cornerRadiusSlider.setMinorTickCount(4);
        cornerRadiusSlider.setSnapToTicks(true);
        cornerRadiusSlider.setShowTickMarks(true);
        cornerRadiusSlider.setShowTickLabels(true);
        root.addRow(rowCount, cornerRadiusLabel, cornerRadiusSlider);
        rowCount++;

        Label rotationLabel = new Label("Rotation");
        rotationSlider = new Slider(0, 360, 0);
        rotationSlider.setMajorTickUnit(120);
        rotationSlider.setMinorTickCount(3);
        rotationSlider.setSnapToTicks(true);
        rotationSlider.setShowTickMarks(true);
        rotationSlider.setShowTickLabels(true);
        root.addRow(rowCount, rotationLabel, rotationSlider);
        rowCount++;

        StackPane previewPane = new StackPane();
        previewPane.setPrefSize(280, 280);
        box = new Rectangle();
        previewPane.getChildren().add(box);
        GridPane.setColumnSpan(previewPane, 2);
        root.addRow(rowCount, previewPane);
        boxLabel = new Label("box");
        previewPane.getChildren().add(boxLabel);
        boxLabel.setTextFill(borderColorPicker.getValue());
        rowCount++;

        for (Node n : root.getChildren()) {
            root.setMargin(n, new Insets(12));
            GridPane.setHalignment(n, HPos.CENTER);
        }

        AnimationTimer boxUpdateTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                updateBox();
            }
        };
        boxUpdateTimer.start();

        Scene scn = new Scene(root);
        stage.setScene(scn);
        stage.setTitle("Box-O-Matic");
        stage.setResizable(false);
        stage.show();
    }
}
