package com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinalSchool {


    @JsonProperty("data")
    private NewSchool data;
    @JsonProperty("message")
    private String message;
    @JsonProperty("status")
    private Integer status;


    public NewSchool getData() {
        return data;
    }

    public void setData(NewSchool data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
