package com.tyler.main;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, Main game) {
        JFrame frame = new JFrame(title);

        Dimension windowSize = new Dimension(width, height);
        frame.setPreferredSize(windowSize);
        frame.setMaximumSize(windowSize);
        frame.setMinimumSize(windowSize);

        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
