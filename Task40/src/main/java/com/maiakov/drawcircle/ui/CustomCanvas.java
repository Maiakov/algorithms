package com.maiakov.drawcircle.ui;

import com.maiakov.drawcircle.algorithm.DrawCircleAlgorithm;

import java.awt.*;
import java.awt.dnd.DragGestureEvent;


public class CustomCanvas extends Canvas {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 700;

    private int radius;

    public CustomCanvas() {
        setSize(WIDTH,HEIGHT);
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        DrawCircleAlgorithm.drawCircle(radius, WIDTH/2, HEIGHT/2, g);
    }

    public void repaint(int radius) {
        this.radius=radius;
        super.repaint();
    }


}
