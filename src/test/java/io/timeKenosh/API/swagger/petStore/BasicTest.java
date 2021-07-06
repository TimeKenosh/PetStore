package io.timeKenosh.API.swagger.petStore;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.timeKenosh.API.swagger.petStore.DTO.PetStoreDTO;
import io.timeKenosh.API.swagger.petStore.helper.PetStoreDTOs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

class BasicTest {

    PetStoreAPIMethods petStoreAPIMethods;
    PetStoreDTOs petStoreDTOs;
    PetStoreDTO petStoreDTO;

    @BeforeClass
    public void setUpWorkspace() {
        petStoreDTOs = new PetStoreDTOs();
        petStoreAPIMethods = new PetStoreAPIMethods();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://petstore.swagger.io/v2/pet/")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    @BeforeMethod
    void setUp() {

        petStoreDTO = new PetStoreDTOs().createRandomPetStoreDTO();
        petStoreAPIMethods
                .addNewPet(petStoreDTO);
    }

    @AfterMethod
    void cleanUp() {
        petStoreAPIMethods
                .deleteThePetById(petStoreDTO);
    }
}
