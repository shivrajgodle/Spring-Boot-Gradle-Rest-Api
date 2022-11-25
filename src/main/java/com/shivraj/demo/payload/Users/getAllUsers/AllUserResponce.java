package com.shivraj.demo.payload.Users.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllUserResponce {
    private List<AllUserData> data;
    private int limit;

    public AllUserResponce() {
        super();
    }

    public AllUserResponce(List<AllUserData> data, int limit) {
        this.data = data;
        this.limit = limit;
    }

    public List<AllUserData> getData() {
        return data;
    }

    public void setData(List<AllUserData> data) {
        this.data = data;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
