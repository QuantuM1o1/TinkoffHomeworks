package edu.hw2.Task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);
        assertThat(rect.area()).isEqualTo(200.0);
    }

    @Test
    @DisplayName("Проверка стандартного поведения прямоугольника")
    void rectangle() {
        // given
        Rectangle rectangle = new Rectangle();

        // when
        rectangle = rectangle.setHeight(20);
        rectangle = rectangle.setWidth(10);
        double answer = rectangle.area();

        // then
        assertThat(answer).isEqualTo(200);
        assertEquals(rectangle.getClass(), Rectangle.class);
    }

    @Test
    @DisplayName("Проверка стандартного поведения квадрата")
    void square() {
        // given
        Square square = new Square();

        // when
        square = square.setSide(20);
        double answer = square.area();

        // then
        assertThat(answer).isEqualTo(400);
        assertEquals(square.getClass(), Square.class);
    }

    @Test
    @DisplayName("Квадрат, который превращается в прямоугольник")
    void squareToRectangle() {
        // given
        Rectangle square = new Square();

        // when
        square = square.setHeight(20);
        double answer = square.area();

        // then
        assertThat(answer).isEqualTo(400);
        assertEquals(square.getClass(), Square.class);

        // when we change class
        square = square.setWidth(10);
        answer = square.area();

        // then new rectangle created
        assertThat(answer).isEqualTo(200);
        assertEquals(square.getClass(), Rectangle.class);
    }
}
