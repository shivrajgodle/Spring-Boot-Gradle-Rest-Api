package com.shivraj.demo.payload.Users.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewData {

    private Data data;



    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }

}
