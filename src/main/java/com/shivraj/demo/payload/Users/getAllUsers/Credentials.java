package com.shivraj.demo.payload.Users.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Credentials {
    private String district_username;

    public void setDistrict_username(String district_username){
        this.district_username = district_username;
    }
    public String getDistrict_username(){
        return this.district_username;
    }
}
