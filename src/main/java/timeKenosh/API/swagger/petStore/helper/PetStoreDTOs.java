package timeKenosh.API.swagger.petStore.helper;

import timeKenosh.API.swagger.petStore.CategoryDTO;
import timeKenosh.API.swagger.petStore.PetStoreDTO;
import timeKenosh.API.swagger.petStore.TagsDTO;

import java.util.ArrayList;
import java.util.List;

public class PetStoreDTOs {

    int id = 42;
    String name = "Samson";
    CategoryDTO category = new CategoryDTO(id, name);
    String[] photoUrls = {"String"};
    List<TagsDTO> tags = new ArrayList<TagsDTO>();
    String status = "indefinite";

    public PetStoreDTO basicPetStoreDTO() {

        return new PetStoreDTO(id, category, name, photoUrls, tags, status);
    }

    public PetStoreDTO basicPetStoreDTOWithChanges() {

        this.name = "Jora";
        this.category = new CategoryDTO(id, name);

        return new PetStoreDTO(id, category, name, photoUrls, tags, status);
    }
}
