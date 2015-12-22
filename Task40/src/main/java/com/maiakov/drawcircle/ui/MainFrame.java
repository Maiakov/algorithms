package com.maiakov.drawcircle.ui;

import com.maiakov.drawcircle.ui.utils.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int LIMIT = 3;
    private static JTextField radiusInputField;
    private static JButton buttonDraw;

    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createPanel());
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        addComponentsToPanel(panel);
        return panel;
    }

    private static void addComponentsToPanel(JPanel panel) {
        CustomCanvas comp = new CustomCanvas();
        panel.add(createButtonDraw(comp));
        panel.add(createRadiusInputField());
        panel.add(comp);
    }

    private static JButton createButtonDraw(final CustomCanvas s) {
        buttonDraw = new JButton("Draw");
        buttonDraw.addActionListener(e -> s.repaint(Integer.valueOf(radiusInputField.getText())));
        return buttonDraw;
    }

    private static JTextField createRadiusInputField(){
        radiusInputField = new JTextField();
        radiusInputField.setDocument(new JTextFieldLimit(LIMIT));
        radiusInputField.setColumns(LIMIT);
        return radiusInputField;

    }


}
