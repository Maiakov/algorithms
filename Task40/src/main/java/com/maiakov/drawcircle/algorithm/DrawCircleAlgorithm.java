package com.maiakov.drawcircle.algorithm;

import java.awt.*;

/**
 * Write a routine to draw a circle (x ** 2 + y ** 2 = r ** 2) without making use of any floating point
 * <p>
 * computations at all.
 */
public class DrawCircleAlgorithm {

    public static void drawCircle(int radius, int centerX, int centerY, Graphics g) {
        int y = radius;
        int x = 0;

        int delta = calculateStartDelta(radius);
        while (y >= x) {
            drawPixelAndReflect(centerX, centerY, x, y, g);

            if (delta < 0) {
                delta = calculateDeltaForHorizontalPixel(delta, x);
            } else {
                delta = calculateDeltaForDiagonalPixel(delta, x, y);
                y--;
            }
            x++;
        }
    }

    private static int calculateStartDelta(int radius) {
        return 3 - 2 * radius;
    }

    private static int calculateDeltaForHorizontalPixel(int oldDelta, int x) {
        return oldDelta + 4 * x + 6;
    }

    private static int calculateDeltaForDiagonalPixel(int oldDelta, int x, int y) {
        return oldDelta + 4 * (x - y) + 10;
    }

    private static void drawPixelAndReflect(int centerX, int centerY, int x, int y, Graphics g) {
        g.drawLine(centerX + x, centerY + y, centerX + x, centerY + y);
        g.drawLine(centerX + x, centerY - y, centerX + x, centerY - y);
        g.drawLine(centerX - x, centerY + y, centerX - x, centerY + y);
        g.drawLine(centerX - x, centerY - y, centerX - x, centerY - y);

        g.drawLine(centerX - y, centerY + x, centerX - y, centerY + x);
        g.drawLine(centerX - y, centerY - x, centerX - y, centerY - x);
        g.drawLine(centerX + y, centerY + x, centerX + y, centerY + x);
        g.drawLine(centerX + y, centerY - x, centerX + y, centerY - x);
    }
}
