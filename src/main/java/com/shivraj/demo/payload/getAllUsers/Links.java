package com.shivraj.demo.payload.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    private String rel;

    private String uri;

    public void setRel(String rel){
        this.rel = rel;
    }
    public String getRel(){
        return this.rel;
    }
    public void setUri(String uri){
        this.uri = uri;
    }
    public String getUri(){
        return this.uri;
    }
}
