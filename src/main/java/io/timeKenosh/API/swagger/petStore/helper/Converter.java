package io.timeKenosh.API.swagger.petStore.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.timeKenosh.API.swagger.petStore.DTO.PetIdResponseDTO;
import io.timeKenosh.API.swagger.petStore.DTO.PetStoreDTO;

import java.io.IOException;

public class Converter {

    @Step("Converting response body as string to object")
    public static PetStoreDTO convertStringToPetStoreDTO(String responseBodyAsString) throws IOException {

        return new ObjectMapper().readValue(responseBodyAsString, PetStoreDTO.class);
    }

    @Step("Converting response body as string to object")
    public static PetIdResponseDTO convertStringToPetIdResponseDTO(String responseBodyAsString) throws IOException {

        return new ObjectMapper().readValue(responseBodyAsString, PetIdResponseDTO.class);
    }
}

