package timeKenosh.API.swagger.petStore;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasicTest {

    PetStoreAPIMethods petStoreAPIMethods = new PetStoreAPIMethods();

    @BeforeClass
    public void setUpWorkspace() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://petstore.swagger.io/v2/pet/")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    @BeforeMethod
    public void setUp() {
        petStoreAPIMethods
                .addNewPet();
    }

    @AfterMethod
    public void cleanUp() {
        petStoreAPIMethods
                .deleteThePetById();
    }
}
