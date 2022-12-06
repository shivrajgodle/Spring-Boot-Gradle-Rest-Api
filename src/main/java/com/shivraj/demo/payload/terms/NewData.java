package com.shivraj.demo.payload.terms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewData {
    private Data data;

    private String uri;

    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
    public void setUri(String uri){
        this.uri = uri;
    }
    public String getUri(){
        return this.uri;
    }
}
