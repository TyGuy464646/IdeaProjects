package com.tyler.game;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, GameLauncher game) {
        JFrame frame = new JFrame(title);

        Dimension windowSize = new Dimension(width, height);
        frame.setPreferredSize(windowSize);
        frame.setMaximumSize(windowSize);
        frame.setMinimumSize(windowSize);

        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setFocusable(true);
        frame.requestFocus();

        frame.pack();
        frame.setVisible(true);
    }
}
