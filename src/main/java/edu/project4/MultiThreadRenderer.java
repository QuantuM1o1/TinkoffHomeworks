package edu.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadRenderer implements FractalFlameRenderer {
    private final int numberOfThreads;
    private int n;
    private int it;
    private int xRes;
    private int yRes;
    private int count;
    private List<NonLinearTransformation> nonLinearTransformations;
    private int symmetry;


    public MultiThreadRenderer(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public Pixel[][] render(
        int n,
        int it,
        int xRes,
        int yRes,
        int count,
        List<NonLinearTransformation> nonLinearTransformations,
        int symmetry) {
        this.n = n;
        this.it = it;
        this.xRes = xRes;
        this.yRes = yRes;
        this.count = count;
        this.nonLinearTransformations = nonLinearTransformations;
        this.symmetry = symmetry;
        Pixel[][] pixels;
        try (ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads)) {
            List<Future<Void>> futures = new ArrayList<>();
            pixels = new Pixel[xRes][yRes];
            for (int i = 0; i < xRes; i++) {
                for (int j = 0; j < yRes; j++) {
                    pixels[i][j] = new Pixel();
                }
            }
            for (int threadNum = 0; threadNum < numberOfThreads; threadNum++) {
                Future<Void> future = executorService.submit(() -> {
                    renderPart(pixels);
                    return null;
                });
                futures.add(future);
            }
            for (Future<Void> future : futures) {
                try {
                    future.get();
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
        }
        Corrector.correction(pixels, xRes, yRes);
        return pixels;
    }

    private void renderPart(Pixel[][] pixels) {
        List<AffineTransformation> transformations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            transformations.add(new AffineTransformation());
        }
        Random random = ThreadLocalRandom.current();
        for (int num = 0; num < n / numberOfThreads; num++) {
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
    }
}
