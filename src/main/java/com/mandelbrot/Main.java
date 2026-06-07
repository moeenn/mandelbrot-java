package com.mandelbrot;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    static void run() throws Exception {
        int height = 2_000;
        int width = 2_000;
        var filename = String.format("plot_%dx%d.png", width, height);

        var image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        var mandelbrot = new Mandelbrot(width, height, 50);
        mandelbrot.plot(graphics);

        graphics.dispose();
        ImageIO.write(image, "png", new File(filename));
        System.out.printf("%10s | image written to disk.\n", "info");
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            Main.run();
        } catch (Exception ex) {
            System.err.printf("error: %s.\n", ex.getMessage());
        }

        long elapsed = (System.currentTimeMillis() - start);
        System.out.printf("%10s | %d ms\n", "elapsed", elapsed);
    }
}