package io.timeKenosh.API.swagger.petStore;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.timeKenosh.API.swagger.petStore.DTO.PetStoreDTO;

import static io.restassured.RestAssured.*;

public class PetStoreAPIMethods {

//    @Step("Upload an image")
//    public String uploadAnImage() {
//
//        final String IMAGE_FULL_PATH_ON_COMPUTER = "C:\\Users\\apecho\\Pictures\\Saved Pictures\\профіль.jpg";
//        File file = new File(IMAGE_FULL_PATH_ON_COMPUTER);
//
//        return given().
//                contentType(ContentType.MULTIPART).
//                body(file).
//                when().
//                post(petStoreDTOs.basicPetStoreDTO().id + "/uploadImage").
//                then().
//                statusCode(200).
//                extract().
//                response().
//                getBody().
//                asString();
//    }

    @Step("Add a new pet to the store")
    public String addNewPet(PetStoreDTO petStoreDTO) {

        return given().
                body(petStoreDTO).
                when().
                post().
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Update an existing pet")
    public String updatePetsData(PetStoreDTO petStoreDTO) {

        return given().
                body(petStoreDTO).
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
                get("findByStatus?status=special").
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Find pet by ID")
    public String getPetsDataById(String id) {

        return when().
                get(id).
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Updates a pet in the store by form data")
    public String updatePetsDataById(String id) {

        return given().
                contentType(ContentType.URLENC).
                body("").
                when().
                post(id).
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }

    @Step("Delete the pet by ID")
    public String deleteThePetById(PetStoreDTO petStoreDTO) {

        return when().
                delete(petStoreDTO.getId().toString()).
                then().
                statusCode(200).
                extract().
                response().
                getBody().
                asString();
    }
}