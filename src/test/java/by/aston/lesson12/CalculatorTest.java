package by.aston.lesson12;

import by.aston.lesson13.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    void sum() {
        int expected = 5;
        int actual = calculator.sum(2, 3);
        org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void multiply() {
        int expected = 6;
        int actual = calculator.multiply(2, 3);
        org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void substact() {
        int expected = 5;
        int actual = calculator.substract(10, 5);
        org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("integerProviderFactory")
    void sumWithDifferentNumbers(int a, int b, int expected) {
        int actual = calculator.sum(a, b);
        org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected);
//        org.junit.jupiter.api.Assertions.assertThrows(Exception.class,() -> calculator.sum(a,b));
    }

    static Stream<Arguments> integerProviderFactory() {
        return Stream.of(Arguments.of(1, 2, 3),
                Arguments.of(5, 5, 10),
                Arguments.of(123, 200, 323),
                Arguments.of(Integer.MAX_VALUE, 1, Integer.MIN_VALUE));
    }




}