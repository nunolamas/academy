package com.ctw.workstation.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HelloExtAcademyTest {

    @InjectMocks
    HelloExtAcademy  helloExtAcademy;

    @Spy
    ExternalMessageServiceImpl externalMessageServiceSpy;

    @Spy
    ExternalMessageService externalMessageServiceInterface;

    @BeforeEach
    void setUp() {
        // Deixam de ser necessários por causa das anotações
        //externalMessageServiceSpy = spy(new ExternalMessageServiceImpl());
        //helloExtAcademy = new HelloExtAcademy(externalMessageServiceSpy);
    }

//    @Test
//    @DisplayName("When providing a null name, a message from outerspace returns")
//    void provide_null_message_from_outerspace() {
//        //given
//        String name = null;
//        Mockito.doNothing()
//                .when(externalMessageServiceSpy)
//                .fazAlgo();
//        //when
//        String finalName = helloExtAcademy.sayHello(name);
//        //then
//        //assertEquals("Hello from outer space!", finalName);
//        assertThat(finalName)
//                .as("Valid message is returned even when providing a null name")
//                .isEqualTo("Hello from outer space Academy");
//    }

//    @Test
//    @DisplayName("When providing a valid name a hello from outer space for the given name is returned")
//    void provide_valid_name_a_hello_from_outer_space() {
//        String name = "Nuno";
//        String outroNome = "Diogo";
//        when(externalMessageServiceSpy.sayHelloFromOuterSpace(Mockito.anyString()))
//                .thenReturn("Hello from outer space " + outroNome);
//
//        String finalName = helloExtAcademy.sayHello(name);
//
//        assertThat(finalName)
//                .as("Valid message is returned")
//                .isEqualTo("Hello from outer space " + outroNome);
//    }

    @Test
    void spy_test() {
        ArrayList<String> listaReal = new ArrayList<>();
        List<String> spiedList = spy(listaReal);

        //when(spiedList.get(20)).thenReturn("Hello");

        doReturn("Hello").when(spiedList).get(0);

        System.out.println(spiedList.get(0));
    }

//    @Test
//    void test_number_4() {
//        //given
//        String name = null;
//        doThrow(NullPointerException.class)
//                .when(externalMessageServiceSpy)
//                .sayHelloFromOuterSpace();
//        //when
//        String finalName = helloExtAcademy.sayHello(name);
//        //then
//        //assertEquals("Hello from outer space!", finalName);
//        assertThat(finalName)
//                .as("A message show when an exception is thrown")
//                .isEqualTo("Houston we have a problem");
//    }
//
//    @Test
//    void test_number_5() {
//        //given
//        String name = null;
//        //when
//        Mockito.doNothing()
//                .when(externalMessageServiceSpy)
//                .fazAlgo();
//        String finalName = helloExtAcademy.sayHello(name);
//        //then
//        //assertEquals("Hello from outer space!", finalName);
//        assertThat(finalName)
//                .as("An example of how to for the test not to run parts of the code that might break teh test")
//                .isEqualTo("Hello from outer space Academy");
//    }

}