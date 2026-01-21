package Deserialization;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DemoGet {
    public static void main(String[] args) {

        RestAssured.baseURI="https://api.restful-api.dev/objects/7";
        ProductGet product =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get()
                        .then()
                        .extract()
                        .as(ProductGet.class);  // <-- JSON to POJO
        System.out.println("Product ID: " + product.getId());
        System.out.println("Product Name: " + product.getName());
        System.out.println("CPU Model: " + product.getData().getCpuModel());
        System.out.println("Price: " + product.getData().getPrice());
    }

}