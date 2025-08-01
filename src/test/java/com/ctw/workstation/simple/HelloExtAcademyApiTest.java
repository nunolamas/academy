package com.ctw.workstation.simple;

import com.ctw.workstation.config.CommodoreTestConfig;
import com.ctw.workstation.config.WiremockResource;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(WiremockResource.class)
class HelloExtAcademyApiTest {

    @Inject
    HelloExtAcademy helloExtAcademy;

    @Test
    @DisplayName("Say hello with valid name")
    void say_hello_with_valid_name() {
        //give
        String name = "Nuno";
        WireMock.stubFor(WireMock.post(WireMock.urlPathEqualTo("/external/hello"))
        .willReturn(WireMock.aResponse()
        .withHeader("Content-Type", "application/json")
                .withStatus(200)
                .withBody("{ \"message\": \"Hello Nuno\" }")));
        //when
        String actualHello = helloExtAcademy.sayHello(name);
        //then
        Assertions.assertThat(actualHello)
                .isNotNull();
    }

}