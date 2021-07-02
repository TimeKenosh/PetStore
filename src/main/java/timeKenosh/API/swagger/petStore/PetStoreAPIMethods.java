package timeKenosh.API.swagger.petStore;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import timeKenosh.API.swagger.petStore.helper.PetStoreDTOs;

import java.io.File;

import static io.restassured.RestAssured.*;

public class PetStoreAPIMethods {

    PetStoreDTOs petStoreDTOs = new PetStoreDTOs();

    @Step("Upload an image")
    public String uploadAnImage() {

        final String IMAGE_FULL_PATH_ON_COMPUTER = "C:\\Users\\apecho\\Pictures\\Saved Pictures\\профіль.jpg";
        File file = new File(IMAGE_FULL_PATH_ON_COMPUTER);

        return given().
                contentType(ContentType.MULTIPART).
                body(file).
                when().
                post(petStoreDTOs.basicPetStoreDTO().id + "/uploadImage").
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Add a new pet to the store")
    public String addNewPet() {

        return given().
                body(petStoreDTOs.basicPetStoreDTO()).
                when().
                post().
                then().
                assertThat().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Update an existing pet")
    public String updatePetsData() {

        return given().
                body(petStoreDTOs.basicPetStoreDTOWithChanges()).
                when().
                put().
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Finds Pets by status")
    public String getPetsByStatus() {

        return when().
                get("findByStatus?status=indefinite").
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Find pet by ID")
    public String getPetsDataById() {

        return when().
                get(petStoreDTOs.basicPetStoreDTO().id.toString()).
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Updates a pet in the store by form data")
    public String updatePetsDataById() {

        return given().
                contentType(ContentType.URLENC).
                body("name=Jora&status=pending").
                when().
                post(petStoreDTOs.basicPetStoreDTO().id.toString()).
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Delete the pet by ID")
    public String deleteThePetById() {

        return when().
                delete(petStoreDTOs.basicPetStoreDTOWithChanges().id.toString()).
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }
}