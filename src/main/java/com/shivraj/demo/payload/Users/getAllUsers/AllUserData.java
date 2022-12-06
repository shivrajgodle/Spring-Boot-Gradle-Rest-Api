package com.shivraj.demo.payload.Users.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllUserData {


    private List<NewData> data;

    public List<NewData> getData() {
        return data;
    }

    public void setData(List<NewData> data) {
        this.data = data;
    }
}
