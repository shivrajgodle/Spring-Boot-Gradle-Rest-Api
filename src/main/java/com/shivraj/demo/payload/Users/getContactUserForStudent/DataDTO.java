package com.shivraj.demo.payload.Users.getContactUserForStudent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {

    @JsonProperty("data")
    private NewDataDTO data;


    public NewDataDTO getData() {
        return data;
    }

    public void setData(NewDataDTO data) {
        this.data = data;
    }

}
