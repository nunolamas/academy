package com.ctw.workstation.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloAcademyTest {

    HelloAcademy helloAcademy;
    private static final Logger log = Logger.getLogger(HelloAcademyTest.class.getName());

    @BeforeAll
    void init() {
        helloAcademy = new HelloAcademy();
        log.info("Starting tests");
    }

    @BeforeEach
    void setUp() {
        log.info("Starting a single test");
    }

    @AfterEach
    void tearDown() {
        log.info("Finished test");
    }

    @AfterAll
    void finish() {
        log.info("Finished all tests");
    }


    @Test
    @Order(6)
    @DisplayName("When providing a null name just Hello should be returned")
    void provide_null_name() {
        //given
        String name = null;

        //when
        String actualName = helloAcademy.sayHello(name);

        //then
        assertNull(name);
        assertEquals("Hello", actualName, "Returned name should be just Hello when providing null name");
    }

    @Test
    @Order(5)
    @DisplayName("When providing an empty name just 'Hello ' should be returned")
    void provide_empty_name() {
        String name = "";

        String actualName = helloAcademy.sayHello(name);

        assertEquals("Hello ", actualName, "Returned name should be 'Hello ' when providing empty String name");
    }

    @Test
    @Order(3)
    @DisplayName("When providing a valid name 'Hello ' + name should be returned")
    void provide_actual_name() {
        String name = "Nuno";

        String actualName = helloAcademy.sayHello(name);

        assertEquals("Hello Nuno", actualName, "Returned name should be 'Hello ' + name when providing empty String name");
    }

    @Test
    @Order(4)
    @DisplayName("When providing a number 'Hello ' + number should be returned")
    void provide_number_as_name() {
        String name = "123";

        String actualName = helloAcademy.sayHello(name);

        assertEquals("Hello 123", actualName, "Returned name should be 'Hello ' + number when providing empty String name");
    }

    @Test
    @Order(1)
    @DisplayName("When providing a special character 'Hello ' + special character should be returned")
    void provide_special_character() {
        String name = "#";

        String actualName = helloAcademy.sayHello(name);

        assertEquals("Hello #", actualName, "Returned name should be 'Hello ' + special character when providing empty String name");

        assertThat(actualName)
                .isNotNull()
                .isNotEmpty()
                .startsWith("Hello ");
    }

    public static Stream<Arguments> provide_actual_names() {
        return Stream.of(
                Arguments.of("Nuno", "Hello Nuno"),
                Arguments.of("João", "Hello João"),
                Arguments.of("Pedro", "Hello Pedro")
        );
    }

    @ParameterizedTest
    @Order(2)
    @MethodSource("provide_actual_names")
    @DisplayName("When providing a null name just Hello should be returned")
    void provide_actual_names(String name, String expected) {
        //when
        String actualName = helloAcademy.sayHello(name);

        //then
        assertAll(
                () -> assertNotNull(actualName, "Returned name should not be null"),
                () -> assertEquals(expected, actualName, "Returned name should be just Hello when providing null name")
        );
    }
}