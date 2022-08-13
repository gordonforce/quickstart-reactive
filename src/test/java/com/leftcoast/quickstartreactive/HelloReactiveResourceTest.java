package com.leftcoast.quickstartreactive;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloReactiveResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/helloreactive/dude")
                .then()
                .statusCode(200)
                .body(is("hello dude"));
    }

}