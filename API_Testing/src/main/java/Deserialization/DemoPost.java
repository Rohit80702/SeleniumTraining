package Deserialization;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DemoPost {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://api.restful-api.dev/objects";

        String requestBody = "{\n" +
                "  \"name\": \"New Product\",\n" +
                "  \"data\": {\n" +
                "    \"cpuModel\": \"Intel Core i9\",\n" +
                "    \"price\": 1299.99\n" +
                "  }\n" +
                "}";

        ProductPost product =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)  // Attach the request body
                        .when()
                        .post()
                        .then()
                        .extract()
                        .as(ProductPost.class);  // Deserialize JSON response into POJO

        System.out.println("Product ID: " + product.getId());
        System.out.println("Product Name: " + product.getName());
        System.out.println("CPU Model: " + product.getData().getCpuModel());
        System.out.println("Price: " + product.getData().getPrice());
    }
}
