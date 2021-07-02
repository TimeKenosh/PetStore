package timeKenosh.API.swagger.petStore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{id:%d,name:%s}", id, name);
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof CategoryDTO)) {
            return false;
        }

        CategoryDTO categoryDTO = (CategoryDTO) o;

        return categoryDTO.id == id &&
                categoryDTO.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
