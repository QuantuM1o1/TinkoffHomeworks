package edu.project4;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import edu.project4.Image.ImageDrawer;
import edu.project4.Image.Pixel;
import edu.project4.NonLinearTransformations.NonLinearTransformation;
import edu.project4.NonLinearTransformations.SwirlTransformation;
import edu.project4.Renderer.FractalFlameRenderer;
import edu.project4.Renderer.MultiThreadRenderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ImageDrawerTest {
    @Test
    @DisplayName("Проверка создания картинки")
    void wordCheck()
    {
        // given
        int width = 10;
        int height = 5;
        int iterations = 100;
        int num = 100;
        int numberOfAffine = 4;
        int symmetry = 3;
        FractalFlameRenderer renderer = new MultiThreadRenderer(4);
        List<NonLinearTransformation> nonLinearTransformations = new ArrayList<>();
        nonLinearTransformations.add(new SwirlTransformation());


        // when
        Pixel[][] pixels = renderer.render(
            num, iterations,
            width, height,
            numberOfAffine,
            nonLinearTransformations,
            symmetry);
        BufferedImage image = ImageDrawer.createImage(pixels, width, height);

        // then
        assertThat(image).isNotNull();
        assertThat(image.getHeight()).isEqualTo(5);
        assertThat(image.getWidth()).isEqualTo(10);
    }
}
