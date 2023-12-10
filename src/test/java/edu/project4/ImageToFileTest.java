package edu.project4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImageToFileTest {
    @Test
    @DisplayName("Проверка создания файла")
    void fileCreation() {
        // given
        int width = 16;
        int height = 16;
        int iterations = 100;
        int num = 100;
        int numberOfAffine = 4;
        int symmetry = 1;
        String path = "src/main/resources/project4/flame3.bmp";
        FractalFlameRenderer renderer = new MultiThreadRenderer(4);
        List<NonLinearTransformation> nonLinearTransformations = new ArrayList<>();
        nonLinearTransformations.add(new SinusoidalTransformation());


        // when
        Pixel[][] pixels = renderer.render(
            num, iterations,
            width, height,
            numberOfAffine,
            nonLinearTransformations,
            symmetry);
        BufferedImage image = ImageDrawer.createImage(pixels, width, height);
        ImageToFile.saveImage(image, path, ImageToFile.ImageFormat.BMP);
        File answer = new File(path);

        // then
        assertTrue(answer.exists());
    }
}
