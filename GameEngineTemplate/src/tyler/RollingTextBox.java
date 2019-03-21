package tyler;

import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class RollingTextBox {

    // Variables
    Main game;

    public String message;
    public boolean active;
    public int framesPerChar;
    public int cursorPos;

    public int frameCount = 0;

    StackPane stackPane;

    Rectangle rectangle;
    Label label;

    public double width, height;
    public double x, y;
    public double margin;


    // Constructor
    public RollingTextBox(Main game, double x, double y, double width, double height, String font, int fontSize, String message) {
        this.message = message;
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        margin = 20;
        framesPerChar = 2;
        cursorPos = 0;

        label = new Label();
        label.setTextFill(Color.WHITE);
        label.setWrapText(true);
        label.setMaxWidth(width);
        label.setMaxWidth(width - margin);
        label.setMaxHeight(height - margin);
        label.setLayoutX(margin / 2);
        label.setLayoutY(margin / 2);
        label.setTextOverrun(OverrunStyle.LEADING_ELLIPSIS);
        label.setFont(new Font(font, fontSize));

        rectangle = new Rectangle(width, height, LinearGradient.valueOf("rgba(0,0,200,.4), rgba(0,0,100,.4)"));
        rectangle.setStrokeWidth(3);
        rectangle.setStroke(Color.WHITE);
        rectangle.setArcWidth(width*.1);
        rectangle.setArcHeight(height*.1);

        stackPane = new StackPane();
        Pane pane = new Pane();

        stackPane.getChildren().add(rectangle);
        stackPane.getChildren().add(pane);
        pane.getChildren().add(label);
        game.userInterfacePane.getChildren().add(stackPane);

        stackPane.setLayoutX(x);
        stackPane.setLayoutY(y);

        active = true;

    }

    public void update() {
        frameCount++;

        if(frameCount >= framesPerChar) {
            cursorPos++;
            cursorPos = Math.min(cursorPos, message.length());
            label.setText(message.substring(0, cursorPos));
            frameCount = 0;
        }
    }
}
