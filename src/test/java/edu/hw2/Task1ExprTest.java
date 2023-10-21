package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1ExprTest {
    @Test
    @DisplayName("Проверка констант")
    void constant() {
        // given
        var two = new Expr.Constant(2);

        // when
        double answer = two.evaluate();

        // then
        assertThat(answer).isEqualTo(2);
    }

    @Test
    @DisplayName("Проверка отрицательных чисел")
    void negate() {
        // given
        var negOne = new Expr.Negate(new Expr.Constant(1));

        // when
        double answer = negOne.evaluate();

        // then
        assertThat(answer).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка суммы")
    void sum() {
        // given
        var negSeven = new Expr.Negate(new Expr.Constant(7));
        var four = new Expr.Constant(4);
        var sumFourNegSeven = new Expr.Addition(negSeven, four);

        // when
        double answer = sumFourNegSeven.evaluate();

        // then
        assertThat(answer).isEqualTo(-3);
    }

    @Test
    @DisplayName("Проверка умножения")
    void multiplicate() {
        // given
        var negThree = new Expr.Negate(new Expr.Constant(3));
        var six = new Expr.Constant(6);
        var multiplicateFourNegSeven = new Expr.Multiplication(six, negThree);

        // when
        double answer = multiplicateFourNegSeven.evaluate();

        // then
        assertThat(answer).isEqualTo(-18);
    }

    @Test
    @DisplayName("Проверка степени с отрицательным значением")
    void expNegative() {
        // given
        var negTwo = new Expr.Negate(new Expr.Constant(2));
        var expMinus2and3 = new Expr.Exponent(negTwo, 3);

        // when
        double answer = expMinus2and3.evaluate();

        // then
        assertThat(answer).isEqualTo(-8);
    }

    @Test
    @DisplayName("Проверка степени")
    void exp() {
        // given
        var negTwo = new Expr.Negate(new Expr.Constant(2));
        var expMinus2and4 = new Expr.Exponent(negTwo, 4);

        // when
        double answer = expMinus2and4.evaluate();

        // then
        assertThat(answer).isEqualTo(16);
    }
}
