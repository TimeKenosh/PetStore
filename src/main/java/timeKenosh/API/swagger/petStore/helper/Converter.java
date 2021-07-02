package timeKenosh.API.swagger.petStore.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import timeKenosh.API.swagger.petStore.PetStoreDTO;

import java.io.IOException;

public class Converter {

    @Step("Converting response body as string to object")
    public PetStoreDTO convertResponseBodyAsStringToPetStoreDTO(String responseBodyAsString) throws IOException {

        return new ObjectMapper().readValue(responseBodyAsString, PetStoreDTO.class);
    }
}

