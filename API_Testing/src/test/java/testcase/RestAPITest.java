package testcase;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RestAPITest {
    @Test
    public void test1() {
        RestAssured.baseURI = "https://api.restful-api.dev";

        given()
                .header("Content-Type", "application/json")
                .pathParam("id","7")
                .when()
                .get("/objects/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .time(lessThan(5000L))
                .body("data.year", equalTo(2019))
                .body("data.price", equalTo(1849.99F))
                .body("name", equalTo("Apple MacBook Pro 16"))
                .body("id", equalTo("7"));
    }
}
