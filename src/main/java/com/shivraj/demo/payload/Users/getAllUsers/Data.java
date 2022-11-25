package com.shivraj.demo.payload.Users.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private String created;

    private String district;

    private String email;

    private String last_modified;

    private Name name;

    private String id;

    private Roles roles;

    public void setCreated(String created){
        this.created = created;
    }
    public String getCreated(){
        return this.created;
    }
    public void setDistrict(String district){
        this.district = district;
    }
    public String getDistrict(){
        return this.district;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setLast_modified(String last_modified){
        this.last_modified = last_modified;
    }
    public String getLast_modified(){
        return this.last_modified;
    }
    public void setName(Name name){
        this.name = name;
    }
    public Name getName(){
        return this.name;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setRoles(Roles roles){
        this.roles = roles;
    }
    public Roles getRoles(){
        return this.roles;
    }
}
