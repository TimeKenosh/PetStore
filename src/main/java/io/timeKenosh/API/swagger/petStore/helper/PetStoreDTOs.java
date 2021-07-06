package io.timeKenosh.API.swagger.petStore.helper;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import io.timeKenosh.API.swagger.petStore.DTO.CategoryDTO;
import io.timeKenosh.API.swagger.petStore.DTO.PetIdResponseDTO;
import io.timeKenosh.API.swagger.petStore.DTO.PetStoreDTO;
import com.github.*;
import io.timeKenosh.API.swagger.petStore.DTO.TagsDTO;

import java.util.ArrayList;
import java.util.List;

public class PetStoreDTOs {

    Faker faker = new Faker();

    public PetStoreDTO createRandomPetStoreDTO() {

        int id = 42;
        String name = faker.animal().name();
        CategoryDTO category = new CategoryDTO(id, name);
        String []photoUrls = {};
        List<TagsDTO> tags = new ArrayList<TagsDTO>();
        String status = PetStatus.SPECIAL;

        return new PetStoreDTO(id, category, name, photoUrls, tags, status);
    }

    public PetIdResponseDTO createPetIdResponseDTO(String id) {
        return new PetIdResponseDTO(200, "unknown", id);
    }
}
