package com.ctw.workstation.team;

import com.ctw.workstation.rack.boundary.RackDTOInput;
import com.ctw.workstation.team.boundary.TeamDTOInput;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(TeamResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamResourceTest {

    private static ArrayList<UUID> teamUUID;

    @Test
    @DisplayName("Create Team")
    @Order(1)
    void create_team() {
        //given
        TeamDTOInput input = new TeamDTOInput(
                "Windbreakers",
                "LISBON",
                "Windshields"
        );
        //when
        //then
        given()
                    .contentType(JSON)
                    .body(input)
                    .post()
                .then()
                    .assertThat().statusCode(HttpStatus.SC_CREATED);

        teamUUID = given()
                .when()
                .get()
                .then()
                .extract()
                .path("id");
    }

    @Test
    @DisplayName("Get Team")
    @Order(2)
    void get_team() {
        RestAssured.get()
                .then()
                    .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Delete Team")
    @Order(3)
    void delete_team() {
        RestAssured
                .given()
                .delete("/remove/{id}", teamUUID.getFirst())
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);

    }
}