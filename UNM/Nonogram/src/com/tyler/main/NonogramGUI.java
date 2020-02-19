package com.tyler.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NonogramGUI implements ActionListener {

    Nonogram puzzle;
    NonogramPanel panel;

    public NonogramGUI(Nonogram puzzle) {
        this.puzzle = puzzle;
        this.panel = new NonogramPanel(puzzle);
        JFrame f = new JFrame("My Nonogram App");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container p = f.getContentPane();

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        p.add(resetButton, BorderLayout.WEST);
        p.add(panel, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }

    // handle a button click event.
    public void actionPerformed(ActionEvent e) {
        System.out.println("Reset button pressed.");
        puzzle.handleResetButtonClick();
        panel.repaint();
    }

    public static void main(String[] args) {
        String pic = "..XXX..\n.XX.XX.\nXX...XX\nX.....X\nXX...XX\n.XX.XX.\n..XXX..";
        Nonogram nono = new Nonogram(pic);
        NonogramGUI inst = new NonogramGUI(nono);
    }

}
