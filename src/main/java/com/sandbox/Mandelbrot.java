package com.sandbox;

import java.awt.Color;
import java.awt.Graphics2D;

public class Mandelbrot {
    final int width;
    final int height;
    final int maxIter;

    public Mandelbrot(int width, int height, int maxIter) {
        this.width = width;
        this.height = height;
        this.maxIter = maxIter;
    }

    public void plot(Graphics2D graphics) {
        for (int y = 0; y < height; ++y) {
            double im = (y - (height / 2.f)) / height * 2.5f;

            for (int x = 0; x < width; ++x) {

                double re = ((x - (width / 2.f)) / width * 2.5f) - 0.5f;
                Complex z = new Complex(re, im);
                Complex c = z;

                for (int i = 0; i < maxIter; ++i) {
                    z = z.multiply(z).add(c);
                    if (z.absolute() > 2.5f) {
                        graphics.setColor(new Color(i, i, i));
                        graphics.fillRect(x, y, 1, 1);
                        break;
                    }
                }
            }
        }
    }
}
