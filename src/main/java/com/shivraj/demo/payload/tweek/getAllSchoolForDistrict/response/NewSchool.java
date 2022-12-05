package com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.NewData;


import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewSchool {
    private List<NewData> school;

    public List<NewData> getSchool() {
        return school;
    }

    public void setSchool(List<NewData> school) {
        this.school = school;
    }
}
