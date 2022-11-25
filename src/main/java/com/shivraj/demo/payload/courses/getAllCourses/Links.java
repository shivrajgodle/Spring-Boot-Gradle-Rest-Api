package com.shivraj.demo.payload.courses.getAllCourses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
