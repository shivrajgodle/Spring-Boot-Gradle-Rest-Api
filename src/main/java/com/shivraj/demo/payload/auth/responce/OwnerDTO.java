package com.shivraj.demo.payload.auth.responce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerDTO {
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;

    public OwnerDTO() {
        super();
    }

    public OwnerDTO(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
