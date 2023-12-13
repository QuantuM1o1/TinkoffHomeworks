package edu.project4;

import edu.project4.LInearTransformations.AffineTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AffineTest {
    @Test
    @DisplayName("Проверка генерации афинных преобразований")
    void randomAffine() {
        // given
        AffineTransformation transformation = new AffineTransformation();

        // when
        boolean condition1 = transformation.getA() * transformation.getA() + transformation.getD() *
            transformation.getD() < 1;
        boolean condition2 = transformation.getB() * transformation.getB() + transformation.getE() *
            transformation.getE() < 1;
        boolean condition3 = transformation.getA() * transformation.getA() + transformation.getB() *
            transformation.getB() + transformation.getD() * transformation.getD() + transformation.getE() *
            transformation.getE() < 1 + (transformation.getA() * transformation.getE() - transformation.getB() *
            transformation.getD()) * (transformation.getA() * transformation.getE() - transformation.getB() *
            transformation.getD());

        // then
        assertTrue(condition1);
        assertTrue(condition2);
        assertTrue(condition3);
    }
}
