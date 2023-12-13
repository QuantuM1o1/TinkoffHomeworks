package edu.project4.Renderer;

import edu.project4.Image.Pixel;

public class Corrector {
    private Corrector() {
    }

    private static final double GAMMA_CORRECTION = 2.2;

    public static void correction(Pixel[][] pixels, double xRes, double yRes) {
        double max = 0.0;
        for (int row = 0; row < xRes; row++) {
            for (int col = 0; col < yRes; col++) {
                if (pixels[row][col].getHitCount() != 0) {
                    pixels[row][col].setNormal(Math.log10(pixels[row][col].getHitCount()));
                    if (pixels[row][col].getNormal() > max) {
                        max = pixels[row][col].getNormal();
                    }
                }
            }
        }
        for (int row = 0; row < xRes; row++) {
            for (int col = 0; col < yRes; col++) {
                if (pixels[row][col].getHitCount() != 0) {
                    pixels[row][col].setNormal(pixels[row][col].getNormal() / max);
                    pixels[row][col].setRed((int) (pixels[row][col].getRed()
                        * Math.pow(pixels[row][col].getNormal(), 1.0 / GAMMA_CORRECTION)));
                    pixels[row][col].setGreen((int) (pixels[row][col].getGreen()
                        * Math.pow(pixels[row][col].getNormal(), 1.0 / GAMMA_CORRECTION)));
                    pixels[row][col].setBlue((int) (pixels[row][col].getBlue()
                        * Math.pow(pixels[row][col].getNormal(), 1.0 / GAMMA_CORRECTION)));
                }
            }
        }
    }
}
