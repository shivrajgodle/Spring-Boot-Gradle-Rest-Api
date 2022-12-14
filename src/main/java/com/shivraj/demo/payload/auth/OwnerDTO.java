package com.shivraj.demo.payload.auth;

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

    public String id() {
        return id;
    }

    public void setDistrict_id(String id) {
        this.id = id;
    }
}
