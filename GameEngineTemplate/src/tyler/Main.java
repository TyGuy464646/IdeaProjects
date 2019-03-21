package tyler;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

// refactor the class name to the name of your game
public class Main extends Application {

    // main game loop timer
    AnimationTimer timer;
    double targetFrameRate;

    // main game graphics container
    Pane backgroundPane;
    Pane spritePane;
    Pane userInterfacePane;

    // These sizes will be obtained when the game goes fullscreen.
    double screenWidth;
    double screenHeight;

    // key monitoring variables.
    // Add or remove variables to suit your game's needs.
    boolean spaceKeyPressed = false;
    boolean leftKeyPressed = false;
    boolean rightKeyPressed = false;
    boolean upKeyPressed = false;
    boolean downKeyPressed = false;

    // Player
    Player player;
    RollingTextBox testText;

    // Main simply launches the game triggering start()
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Note: change stage title in this method
        setupScreen(stage);

        // Note: add or remove booleans to track keyboard keys
        setupInput(stage);

        // Set target Frames Per Second on this value
        // Remember to reconfigure the update functions called by the timer
        setupTimer(60);

        //
        /////////////////
        player = new Player(this);

        // text window test
        testText = new RollingTextBox(this, 50, 50, 500, 300, "sans-serif", 12,
                "For much of my academic career, I feel that my grades were a good indication of my ability. " +
                        "During Middle School and most of High School, I grew very eager to learn and maintain good " +
                        "grades for a good future. I had just figured out what I wanted to do job-wise for the rest of " +
                        "my professional career, and I knew that to achieve it, I needed to study and learn as much as " +
                        "I could about math and science. There was an occasion, however, where I struggled. During my " +
                        "junior year of High School, I decided to challenge myself by signing up for five AP classes. " +
                        "Unfortunately, it created a workload for which I wasn’t wholly prepared: every night I would " +
                        "come home and have at least four hours of work to do. There was also a lot of social drama — " +
                        "within my peer group — going on that put additional stress on top of my already-heavy workload. " +
                        "My grades started to suffer, and I began to realize that I was digging a hole for myself. Towards " +
                        "the end of the semester, I had to work hard to play catch up and tune out the other distractions " +
                        "around me. Since that time, I feel that I have matured and learned better how to cope with different " +
                        "stresses and to better manage my time to accomplish my most important goals. Being a senior now, " +
                        "I am taking three AP classes and am balancing my other commitments. I feel like I’m finally reaching " +
                        "my full potential once again.");

        // Let's Go.
        timer.start();
    }

    /**
     * Sets up the main game window and makes it fullscreen.
     * Also makes the escape key shut the game down.
     *
     * @param stage - the main game window
     */
    private void setupScreen(Stage stage) {

        // setup root container - a stack pane. Make it the same size as the fullscreen resolution
        screenWidth = Screen.getPrimary().getBounds().getWidth();
        screenHeight = Screen.getPrimary().getBounds().getHeight();
        StackPane root = new StackPane();
        Scene scn = new Scene(root, screenWidth, screenHeight, Color.BLACK);
        stage.setScene(scn);

        // add game layers, same size as fullscreen resolution
        backgroundPane = new Pane();
        spritePane = new Pane();
        userInterfacePane = new Pane();
        root.getChildren().addAll(backgroundPane, spritePane, userInterfacePane);
        setBackgroundPanePaint(LinearGradient.valueOf("black,rgb(20,20,60),black"));

        // set app title, switch to full screen, make Esc key exit game, turn off mouse cursor
        scn.setCursor(Cursor.NONE);
        stage.setTitle("CircleDash");
        stage.show();
        stage.setFullScreenExitHint("Press Esc to Exit Game");
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.fullScreenProperty().addListener((observable) -> {
            if(timer != null) {
                timer.stop();
            }
            Platform.exit();
        });
    }

    /**
     * Changes background color of background layer.
     * Pass in a Color.rgb(), Color.rgba(), or LinearGradient.valueOf("gradient css text")
     *
     * @param p a paint, commonly a Color or LinearGradient for instance.
     */
    public void setBackgroundPanePaint(Paint p) {
        Background b = new Background(new BackgroundFill(p, null, null));
        backgroundPane.setBackground(b);
    }

    /**
     * Sets up input handling and key use through boolean variables that track whether each key is pressed.
     * Add boolean variables to track the input states of any buttons you want to use for gameplay.
     * To use them during gameplay use conditionals that reference each boolean in updateInput().
     *
     * @param stage - the main game window.
     */
    private void setupInput(Stage stage) {
        EventHandler<KeyEvent> gameKeyEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                // Key_Pressed events
                if(event.getEventType() == KeyEvent.KEY_PRESSED) {
                    if(event.getCode() == KeyCode.SPACE) {
                        spaceKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.A) {
                        leftKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.D) {
                        rightKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.W) {
                        upKeyPressed = true;
                    }
                    if(event.getCode() == KeyCode.S) {
                        downKeyPressed = true;
                    }
                }

                // Key_Released events
                if(event.getEventType() == KeyEvent.KEY_RELEASED) {
                    if(event.getCode() == KeyCode.SPACE) {
                        spaceKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.A) {
                        leftKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.D) {
                        rightKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.W) {
                        upKeyPressed = false;
                    }
                    if(event.getCode() == KeyCode.S) {
                        downKeyPressed = false;
                    }
                }
            }
        };

        stage.addEventHandler(KeyEvent.ANY, gameKeyEventHandler);
    }


    /**
     * The AnimationTimer 'timer' is the primary game loop.
     * This is setup target a specific frame rate.
     * Note that the update functions - updatePhysics(), updateInput(), updateGamestate() updateVisuals(
     * will need to be coded much further to the specifics of your game.
     */
    private void setupTimer(double targetFramesPerSecond) {
        targetFrameRate = targetFramesPerSecond;

        timer = new AnimationTimer() {
            long lastFrameNanoTime;
            long targetFrameTime = 1000000000 / (long) targetFrameRate;

            @Override
            public void start() {
                lastFrameNanoTime = System.nanoTime();
                super.start();
            }

            @Override
            public void handle(long now) {
                // check for target framerate, don't update game until sufficient time passes
                if(now - lastFrameNanoTime > targetFrameTime) {
                    updateInput();
                    updatePhysics();
                    updateGameStates();
                    updateVisuals();

                    // record time stamp since a game engine step was taken and a frame was drawn
                    lastFrameNanoTime = now;
                }
            }
        };
    }


    void updateInput() {
        player.updateInput();
    }

    void updatePhysics() {
        player.updatePhysics();
    }

    void updateGameStates() {

    }

    void updateVisuals() {
        player.updateGraphics();
        testText.update();
    }
}
