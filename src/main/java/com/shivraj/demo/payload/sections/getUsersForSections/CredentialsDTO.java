package com.shivraj.demo.payload.sections.getUsersForSections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialsDTO {

    @JsonProperty("district_username")
    private String districtUsername;

    public String getDistrictUsername() {
        return districtUsername;
    }

    public void setDistrictUsername(String districtUsername) {
        this.districtUsername = districtUsername;
    }
}
