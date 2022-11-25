package com.shivraj.demo.payload.Users.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    private String first;

    private String last;

    private String middle;

    public void setFirst(String first){
        this.first = first;
    }
    public String getFirst(){
        return this.first;
    }
    public void setLast(String last){
        this.last = last;
    }
    public String getLast(){
        return this.last;
    }
    public void setMiddle(String middle){
        this.middle = middle;
    }
    public String getMiddle(){
        return this.middle;
    }

}
