package io.timeKenosh.API.swagger.petStore;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.timeKenosh.API.swagger.petStore.DTO.PetIdResponseDTO;
import io.timeKenosh.API.swagger.petStore.DTO.PetStoreDTO;
import io.timeKenosh.API.swagger.petStore.helper.PetStoreDTOs;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.timeKenosh.API.swagger.petStore.helper.Converter;

import java.io.*;


public class PetStoreAPIMethodsTests extends BasicTest {

//    @Test(priority = 1, description = "Check the addition of a new pet")
//    public void verifyAddNewPetMethod() throws IOException {
//
//        PetStoreDTO expectedAddNewPetResult = petStoreDTOs.basicPetStoreDTO();
//
//        String actualAddNewPetResponseBodyAsString =
//        new PetStoreAPIMethods().                                               ***taken out to BasicTest***
//                addNewPet();
//
//        PetStoreDTO actualAddNewPetResult =
//        converter.convertResponseBodyAsStringToPetStoreDTO(actualAddNewPetResponseBodyAsString);
//
//        Assert.assertEquals(actualAddNewPetResult, expectedAddNewPetResult);
//    }

    @Test(priority = 1, description = "Check the updating of a new pet")
    public void verifyUpdatePetsData() throws IOException {

        petStoreDTO = new PetStoreDTOs().createRandomPetStoreDTO();
        String response = new PetStoreAPIMethods().
                updatePetsData(petStoreDTO);
        PetStoreDTO actualResult = Converter.convertStringToPetStoreDTO(response);
        PetStoreDTO expectedResult = petStoreDTO;
        Assert.assertEquals(actualResult, expectedResult, "verifyUpdatePetsData working wrong");
    }

//    @Test(priority = 2, description = "Check the adding image to the pet")
//    public void verifyUploadAnImage() {
//
//        String s = new PetStoreAPIMethods().uploadAnImage();                  ***Add image method does`not working***
//
//        System.out.println(s);
//    }

    @Test(priority = 3, description = "Check the search pets by status")
    public void verifyGetPetsByStatus() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String actualResult = new PetStoreAPIMethods().
                getPetsByStatus();
        String expectedResult = "[" + mapper.writeValueAsString(petStoreDTO) + "]";
        Assert.assertEquals(actualResult, expectedResult,"verifyGetPetsByStatus working wrong");
    }

    @Test(priority = 4, description = "Check the search pets by ID")
    public void verifyGetPetsDataById() throws IOException {

        PetStoreDTO actualResult = Converter.convertStringToPetStoreDTO(petStoreAPIMethods.
                getPetsDataById(
                        petStoreDTO.
                                getId().
                                toString()));
        PetStoreDTO expectedResult = petStoreDTO;
        Assert.assertEquals(actualResult, expectedResult, "verifyGetPetsDataById working wrong");
    }

    @Test(priority = 5, description = "Check the updating pet in the store with form data")
    public void verifyUpdatePetsDataById() throws IOException {

        String response = petStoreAPIMethods.updatePetsDataById(petStoreDTO.getId().toString());
        System.out.println(response);
        PetIdResponseDTO actualResult = Converter.convertStringToPetIdResponseDTO(response);
        PetIdResponseDTO expectedResult = petStoreDTOs.createPetIdResponseDTO(petStoreDTO.getId().toString());
        Assert.assertEquals(actualResult, expectedResult, "verifyUpdatePetsDataById working wrong");
    }

//    @Test(priority = 7, description = "Check the deleting pet from the store by ID")
//    public void verifyDeleteThePetById() {
//
//        PetStoreAPIMethods petStoreAPIMethods = new PetStoreAPIMethods();         ***taken out to BasicTest***
//        petStoreAPIMethods.addNewPet();
//
//        String actualDeleteThePetByIdResponseAsString = petStoreAPIMethods.deleteThePetById();
//
//        String expectedDeleteThePetByIdResponseAsString = "{\"code\":200,\"type\":\"unknown\",\"message\":\"42\"}";
//
//        Assert.assertEquals(actualDeleteThePetByIdResponseAsString, expectedDeleteThePetByIdResponseAsString);
//    }
}