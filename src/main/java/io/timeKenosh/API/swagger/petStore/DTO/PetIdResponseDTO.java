package io.timeKenosh.API.swagger.petStore.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PetIdResponseDTO {

    @JsonProperty("code")
    private int code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;

    public PetIdResponseDTO() {
    }

    public PetIdResponseDTO(int code, String type, String id) {
        this.code = code;
        this.type = type;
        this.message = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("{code:%d,type:%s,message:%s}", code, type, message);
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof PetIdResponseDTO)) {
            return false;
        }

        PetIdResponseDTO petIdResponseDTO = (PetIdResponseDTO) o;

        return petIdResponseDTO.code == code &&
                petIdResponseDTO.type.equals(type) &&
                petIdResponseDTO.message.equals(message);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + code;
        result = 31 * result + type.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}
