package timeKenosh.API.swagger.petStore;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class PetStoreDTO {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("category")
    CategoryDTO category;

    @JsonProperty("name")
    String name;

    @JsonProperty("photoUrls")
    String[] photoUrls;

    @JsonProperty("tags")
    List<TagsDTO> tags;

    @JsonProperty("status")
    String status;

    public PetStoreDTO() {
    }

    public PetStoreDTO(int id, CategoryDTO category, String name, String[] photoUrls, List<TagsDTO> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<TagsDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagsDTO> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("{id:%d,category:%s,name:%s,photoUrls:" + Arrays.toString(photoUrls) + ",tags:%s,status:%s}", id, category, name, tags, status);
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof PetStoreDTO)) {
            return false;
        }

        PetStoreDTO petStoreDTO = (PetStoreDTO) o;

        return petStoreDTO.id.equals(id) &&
                petStoreDTO.category.equals(category) &&
                petStoreDTO.name.equals(name) &&
                Arrays.equals(petStoreDTO.photoUrls, photoUrls) &&
                petStoreDTO.tags.equals(tags) &&
                petStoreDTO.status.equals(status);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(photoUrls);
        result = 31 * result + tags.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
