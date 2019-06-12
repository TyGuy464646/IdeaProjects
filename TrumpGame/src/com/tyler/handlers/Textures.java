package com.tyler.handlers;

import com.tyler.image.SpriteSheet;
import javafx.scene.image.Image;

public class Textures {

    // Buttons
    public static Image titleDefaultImage, titleHoverImage, titlePressedImage;
    public static Image pauseDefaultImage, pauseHoverImage, pausePressedImage;

    // Title Screen Image
    private static Image titleBackgroundImage;

    // Player Sprite
    public static SpriteSheet playerSprite;

    // Block Sprite
    public static SpriteSheet blockSprite;

    // Constructor
    public Textures() {
        titleDefaultImage = new Image("/Button/TitleButton/ButtonDefault.png");
        titleHoverImage = new Image("/Button/TitleButton/ButtonHover.png");
        titlePressedImage = new Image("/Button/TitleButton/ButtonPressed.png");

        pauseDefaultImage = new Image("Button/PauseButton/ButtonDefault.png");
        pauseHoverImage = new Image("Button/PauseButton/ButtonHover.png");
        pausePressedImage = new Image("Button/PauseButton/ButtonPressed.png");

        titleBackgroundImage = new Image("/Sprites/TitleScreen/trump.jpg");

        playerSprite = new SpriteSheet("/Sprites/Trump/TrumpSprite.png");

        blockSprite = new SpriteSheet("/Sprites/Tiles/spriteSheet.png");


        System.out.println("All Resources Loaded!");
    }

}
