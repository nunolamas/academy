package com.ctw.workstation.simple;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MathOperationsTest {

    MathOperations  mathOperations;

    @BeforeAll
    void init() {
        mathOperations  = new MathOperations();
    }

    public static Stream<Arguments> add_negative() {
        return Stream.of(
                Arguments.of(1, -56, -55),
                Arguments.of(2, -2, 0),
                Arguments.of(3, -78, -75)
        );
    }

    @ParameterizedTest
    @MethodSource
    @Order(1)
    @DisplayName("When providing a negative value it should be subtracted")
    void add_negative(int a, int b, int result) {
        assertEquals(result, mathOperations.add(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, -2, -3})
    @DisplayName("When dividing a value by zero, an ArithmeticException should be thrown")
    @Order(2)
    void divide_zero(int a) {
        assertThrows(ArithmeticException.class, () -> mathOperations.div(a, 0));
    }

}