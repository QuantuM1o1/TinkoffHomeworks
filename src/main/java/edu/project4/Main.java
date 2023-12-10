package edu.project4;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        int width = 1_000;
        int height = 1_000;
        int iterations = 1_000;
        int num = 10_000;
        int numberOfAffine = 4;
        int symmetry = 3;
        String path = "src/main/resources/project4/flame2.bmp";
        FractalFlameRenderer renderer = new MultiThreadRenderer(4);
        List<NonLinearTransformation> nonLinearTransformations = new ArrayList<>();
        nonLinearTransformations.add(new SwirlTransformation());
        Pixel[][] pixels = renderer.render(
            num, iterations,
            width, height,
            numberOfAffine,
            nonLinearTransformations,
            symmetry);
        BufferedImage image = ImageDrawer.createImage(pixels, width, height);
        ImageToFile.saveImage(image, path, ImageToFile.ImageFormat.BMP);
    }
}
