package com.shivraj.demo.payload.Users.getSchoolForUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSchoolForUser {


    @JsonProperty("data")
    private List<NewDataDTO> data;

    public List<NewDataDTO> getData() {
        return data;
    }

    public void setData(List<NewDataDTO> data) {
        this.data = data;
    }
}
