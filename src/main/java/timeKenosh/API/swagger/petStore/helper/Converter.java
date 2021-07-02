package timeKenosh.API.swagger.petStore.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import timeKenosh.API.swagger.petStore.PetStoreDTO;

import java.io.IOException;

public class Converter {

    public PetStoreDTO convertResponseBodyAsStringToPetStoreDTO(String responseBodyAsString) throws IOException {

        return new ObjectMapper().readValue(responseBodyAsString, PetStoreDTO.class);
    }
}

