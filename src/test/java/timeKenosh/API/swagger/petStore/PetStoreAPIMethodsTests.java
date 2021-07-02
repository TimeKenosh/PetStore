package timeKenosh.API.swagger.petStore;

import org.testng.Assert;
import org.testng.annotations.Test;
import timeKenosh.API.swagger.petStore.helper.Converter;
import timeKenosh.API.swagger.petStore.helper.PetStoreDTOs;

import java.io.*;

public class PetStoreAPIMethodsTests extends BasicTest{

    PetStoreDTOs petStoreDTOs = new PetStoreDTOs();
    Converter converter = new Converter();

//    @Test(priority = 1, description = "Check the addition of a new pet")
//    public void verifyAddNewPetMethod() throws IOException {
//
//        PetStoreDTO expectedAddNewPetResult = petStoreDTOs.basicPetStoreDTO();
//
//        String actualAddNewPetResponseBodyAsString = new PetStoreAPIMethods().
//                addNewPet();
//
//        PetStoreDTO actualAddNewPetResult = converter.convertResponseBodyAsStringToPetStoreDTO(actualAddNewPetResponseBodyAsString);
//
//        Assert.assertEquals(actualAddNewPetResult, expectedAddNewPetResult);
//    }

    @Test(priority = 2, description = "Check the updating of a new pet")
    public void verifyUpdatePetsData() throws IOException {

        String actualUpdatePetsDataResponseBodyAsString =
                new PetStoreAPIMethods().
                        updatePetsData();

        PetStoreDTO actualUpdatePetsDataResultAsPetStoreDTO = converter.convertResponseBodyAsStringToPetStoreDTO(actualUpdatePetsDataResponseBodyAsString);
        PetStoreDTO expectedUpdatePetsDataResultAsPetStoreDTO = petStoreDTOs.basicPetStoreDTOWithChanges();


        Assert.assertEquals(actualUpdatePetsDataResultAsPetStoreDTO, expectedUpdatePetsDataResultAsPetStoreDTO);
    }

    @Test(priority = 3, description = "Check the adding image to the pet")
    public void verifyUploadAnImage() {

        String s = new PetStoreAPIMethods().uploadAnImage();

        System.out.println(s);
    }

    @Test(priority = 4, description = "Check the search pets by status")
    public void verifyGetPetsByStatus() throws IOException {

        String actualGetPetsByStatusResponseAsString = new PetStoreAPIMethods().getPetsByStatus();

        File file = new File("src\\main\\resources\\texts\\statusPending.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String expectedGetPetsByStatusResponseAsString = bufferedReader.readLine();

        Assert.assertEquals(actualGetPetsByStatusResponseAsString, expectedGetPetsByStatusResponseAsString);
    }

    @Test(priority = 5, description = "Check the search pets by ID")
    public void verifyGetPetsDataById() throws IOException {

        PetStoreDTO expectedGetPetsByIdResponseAsString = petStoreDTOs.basicPetStoreDTO();

        PetStoreDTO actualGetPetsByIdResponseAsString = converter.
                convertResponseBodyAsStringToPetStoreDTO(
                        petStoreAPIMethods.
                                getPetsDataById());

        Assert.assertEquals(actualGetPetsByIdResponseAsString, expectedGetPetsByIdResponseAsString);
    }

    @Test(priority = 6, description = "Check the updating pet in the store with form data")
    public void verifyUpdatePetsDataById() {

        String actualUpdatePetsDataByIdResponseAsString = petStoreAPIMethods.updatePetsDataById();

        String expectedUpdatePetsDataByIdResponseAsString = "{\"code\":200,\"type\":\"unknown\",\"message\":\"42\"}";

        Assert.assertEquals(actualUpdatePetsDataByIdResponseAsString, expectedUpdatePetsDataByIdResponseAsString);
    }

//    @Test(priority = 7, description = "Check the deleting pet from the store by ID")
//    public void verifyDeleteThePetById() {
//
//        PetStoreAPIMethods petStoreAPIMethods = new PetStoreAPIMethods();
//        petStoreAPIMethods.addNewPet();
//
//        String actualDeleteThePetByIdResponseAsString = petStoreAPIMethods.deleteThePetById();
//
//        String expectedDeleteThePetByIdResponseAsString = "{\"code\":200,\"type\":\"unknown\",\"message\":\"42\"}";
//
//        Assert.assertEquals(actualDeleteThePetByIdResponseAsString, expectedDeleteThePetByIdResponseAsString);
//    }
}