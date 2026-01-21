package testcase;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class RestAPITest1 {
    @Test
    public void test1(){
        String payload = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";

        RestAssured.baseURI="https://api.restful-api.dev/";
        given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/objects")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("data.year", equalTo(2019));

    }

    @Test
    public void test2(){
        String payload = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";
        RestAssured.baseURI="https://api.restful-api.dev";
        given()
                .header("content-type","application/json")
                .body(payload)
                .when()
                .post("/objects")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("data.year", equalTo(2019))
                .assertThat().body(matchesJsonSchemaInClasspath("schema1.json"));
    }

}
