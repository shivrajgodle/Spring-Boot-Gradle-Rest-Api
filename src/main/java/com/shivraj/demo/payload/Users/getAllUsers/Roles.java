package com.shivraj.demo.payload.Users.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Roles {
    private Student student;

    public void setStudent(Student student){
        this.student = student;
    }
    public Student getStudent(){
        return this.student;
    }
}
