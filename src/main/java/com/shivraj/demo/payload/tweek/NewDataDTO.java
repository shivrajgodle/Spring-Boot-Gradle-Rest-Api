package com.shivraj.demo.payload.tweek;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewDataDTO {
    @JsonProperty("schools")
    private List<SchoolsDTO> schools;


    public List<SchoolsDTO> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolsDTO> schools) {
        this.schools = schools;
    }
}
