package edu.project4;

import java.util.ArrayList;
import java.util.List;
import edu.project4.Image.Pixel;
import edu.project4.NonLinearTransformations.HeartTransformation;
import edu.project4.NonLinearTransformations.HorseshoeTransformation;
import edu.project4.NonLinearTransformations.NonLinearTransformation;
import edu.project4.Renderer.FractalFlameRenderer;
import edu.project4.Renderer.MultiThreadRenderer;
import edu.project4.Renderer.SingleThreadRenderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RendererTest
{
    @Test
    @DisplayName("Проверка многопоточого рендерера")
    void multiThread() {
        // given
        int width = 3;
        int height = 3;
        int iterations = 100;
        int num = 100;
        int numberOfAffine = 4;
        int symmetry = 3;
        FractalFlameRenderer renderer = new MultiThreadRenderer(4);
        List<NonLinearTransformation> nonLinearTransformations = new ArrayList<>();
        nonLinearTransformations.add(new HorseshoeTransformation());

        // when
        Pixel[][] pixels = renderer.render(
            num, iterations,
            width, height,
            numberOfAffine,
            nonLinearTransformations,
            symmetry);
        int answer = pixels[0][0].getHitCount() + pixels[1][1].getHitCount() + pixels[2][2].getHitCount();

        // then
        assertThat(answer).isGreaterThan(0);
    }

    @Test
    @DisplayName("Проверка однопоточого рендерера")
    void oneThread() {
        // given
        int width = 3;
        int height = 3;
        int iterations = 100;
        int num = 100;
        int numberOfAffine = 4;
        int symmetry = 3;
        FractalFlameRenderer renderer = new SingleThreadRenderer();
        List<NonLinearTransformation> nonLinearTransformations = new ArrayList<>();
        nonLinearTransformations.add(new HeartTransformation());

        // when
        Pixel[][] pixels = renderer.render(
            num, iterations,
            width, height,
            numberOfAffine,
            nonLinearTransformations,
            symmetry);
        int answer = pixels[0][0].getHitCount() + pixels[1][1].getHitCount() + pixels[2][2].getHitCount();

        // then
        assertThat(answer).isGreaterThan(0);
    }
}
