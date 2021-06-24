import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class APIMethods {

    private static final String baseUrl = "https://petstore.swagger.io/v2/pet/";
    private static final String contentTypeJson = "application/json";

    @Step("Post the post")
    public APIMethods postNewPost(int id, String name, String status) {

        given().
                contentType(contentTypeJson).body(json(id, name, status)).
                when().
                post(baseUrl).
                then().
                statusCode(200);
        return this;
    }

    @Step("Change the post data")
    public APIMethods changeTheNameInPost(int id, String name, String status) {

        given().
                contentType(contentTypeJson).body(json(id, name, status)).
                when().
                put(baseUrl).
                then().
                statusCode(200);
        return this;
    }

    @Step("Verify the name in post by id")
    public APIMethods getName(String name, int id) {

        when().
                get(baseUrl+id).
                then().
                statusCode(200).
                assertThat().body("name", equalTo(name));
        return this;
    }

    @Step("Delete the post by id")
    public APIMethods deleteThePost(int id) {

        when().
                delete(baseUrl+id).
                then().
                statusCode(200);
        return this;
    }

    public String json(int id, String name, String status){
        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": " + id + ",\n" +
                "    \"name\": \"" + name + "\"\n" +
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": " + id + ",\n" +
                "      \"name\": \"" + name + "\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }
}