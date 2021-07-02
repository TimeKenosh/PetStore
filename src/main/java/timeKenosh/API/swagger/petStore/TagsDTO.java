package timeKenosh.API.swagger.petStore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagsDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    public TagsDTO(){}

    public TagsDTO(int id, String name) {
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
        if (!(o instanceof TagsDTO)) {
            return false;
        }

        TagsDTO tagsDTO = (TagsDTO) o;

        return tagsDTO.id == id &&
                tagsDTO.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        return result;
    }
}