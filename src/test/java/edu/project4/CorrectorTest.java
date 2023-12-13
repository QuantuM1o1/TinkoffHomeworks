package edu.project4;

import edu.project4.Image.Pixel;
import edu.project4.Renderer.Corrector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CorrectorTest {
    @Test
    @DisplayName("Проверка гамма коррекции")
    void gammaCorrection() {
        // given
        Pixel[][] pixels = new Pixel[1][];
        pixels[0] = new Pixel[2];
        pixels[0][0] = new Pixel();
        pixels[0][1] = new Pixel();
        pixels[0][0].setBlue(200);
        pixels[0][0].setGreen(20);
        for (int i = 0; i < 10; i++) {
            pixels[0][0].incrementHitCount();
        }
        pixels[0][1].setGreen(100);
        pixels[0][1].setBlue(10);
        for (int i = 0; i < 7; i++) {
            pixels[0][1].incrementHitCount();
        }
        int sumB1 = pixels[0][0].getBlue() + pixels[0][1].getBlue();
        int sumG1 = pixels[0][0].getGreen() + pixels[0][1].getGreen();

        // when
        Corrector.correction(pixels, 1, 2);
        int sumB2 = pixels[0][0].getBlue() + pixels[0][1].getBlue();
        int sumG2 = pixels[0][0].getGreen() + pixels[0][1].getGreen();

        // then
        assertThat(sumB2).isLessThan(sumB1);
        assertThat(sumG2).isLessThan(sumG1);
    }
}
