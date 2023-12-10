package edu.project4;

import java.util.List;

public interface FractalFlameRenderer {
    double XMIN = -1.0;
    double XMAX = 1.0;
    double YMIN = -1.0;
    double YMAX = 1.0;
    int NUMBER_OF_STEPS_TO_SKIP = -20;

    Pixel[][] render(
        int n, int it,
        int xRes, int yRes,
        int count,
        List<NonLinearTransformation> nonLinearTransformations,
        int symmetry);

    default void paintPixel(int x, int y, Pixel[][] pixels, AffineTransformation transformation) {
        if (pixels[x][y].getHitCount() == 0) {
            pixels[x][y].setRed(transformation.getRed());
            pixels[x][y].setGreen(transformation.getGreen());
            pixels[x][y].setBlue(transformation.getBlue());
        } else {
            pixels[x][y].setRed((pixels[x][y].getRed() + transformation.getRed()) / 2);
            pixels[x][y].setGreen((pixels[x][y].getGreen() + transformation.getGreen()) / 2);
            pixels[x][y].setBlue((pixels[x][y].getBlue() + transformation.getBlue()) / 2);
        }
        pixels[x][y].incrementHitCount();
    }

    default void rotateAndPaint(
        int x, int y, int symmetry, int xRes, int yRes, Pixel[][] pixels, AffineTransformation transformation) {
        int rotationSteps = symmetry / 2;
        for (int k = 1; k <= rotationSteps; k++) {
            double angle = 2 * Math.PI * k / symmetry;
            int rotatedX = (int) (Math.cos(angle) * (x - xRes / 2) - Math.sin(angle) * (y - yRes / 2) + xRes / 2);
            int rotatedY = (int) (Math.sin(angle) * (x - xRes / 2) + Math.cos(angle) * (y - yRes / 2) + yRes / 2);
            if (rotatedX >= 0 && rotatedX < xRes && rotatedY >= 0 && rotatedY < yRes) {
                paintPixel(rotatedX, rotatedY, pixels, transformation);
            }
        }
    }
}
