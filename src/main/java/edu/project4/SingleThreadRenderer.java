package edu.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SingleThreadRenderer implements FractalFlameRenderer {
    private final Random random;

    public SingleThreadRenderer() {
        random = ThreadLocalRandom.current();
    }

    @Override
    public Pixel[][] render(
        int n, int it,
        int xRes, int yRes,
        int count,
        List<NonLinearTransformation> nonLinearTransformations,
        int symmetry) {
        List<AffineTransformation> transformations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            transformations.add(new AffineTransformation());
        }
        Pixel[][] pixels = new Pixel[xRes][yRes];
        for (int i = 0; i < xRes; i++) {
            for (int j = 0; j < yRes; j++) {
                pixels[i][j] = new Pixel();
            }
        }
        for (int num = 0; num < n; num++) {
            double newX = random.nextDouble() * (XMAX - XMIN) + XMIN;
            double newY = random.nextDouble() * (YMAX - YMIN) + YMIN;
            for (int step = NUMBER_OF_STEPS_TO_SKIP; step < it; step++) {
                int i = random.nextInt(transformations.size());
                int j = random.nextInt(nonLinearTransformations.size());
                double x = transformations.get(i).getA() * newX
                    + transformations.get(i).getB() * newY
                    + transformations.get(i).getC();
                double y = transformations.get(i).getD() * newX
                    + transformations.get(i).getE() * newY
                    + transformations.get(i).getF();
                newX = nonLinearTransformations.get(j).getX(x, y);
                newY = nonLinearTransformations.get(j).getY(x, y);
                if (step >= 0 && newX >= XMIN && newX <= XMAX && newY >= YMIN && newY <= YMAX) {
                    int x1 = (int) (xRes - ((XMAX - newX) / (XMAX - XMIN)) * xRes);
                    int y1 = (int) (yRes - ((YMAX - newY) / (YMAX - YMIN)) * yRes);
                    if (x1 < xRes && y1 < yRes) {
                        paintPixel(x1, y1, pixels, transformations.get(i));
                        if (symmetry > 1) {
                            rotateAndPaint(x1, y1, symmetry, xRes, yRes, pixels, transformations.get(i));
                        }
                    }
                }
            }
        }
        Corrector.correction(pixels, xRes, yRes);
        return pixels;
    }
}
