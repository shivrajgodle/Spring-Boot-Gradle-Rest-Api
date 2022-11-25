package com.shivraj.demo.payload.school.getAllSchool;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private String sis_id;

    private String created;

    private String district;

    private String name;

    private Principal principal;

    private String high_grade;

    private String phone;

    private String school_number;

    private String state_id;

    private String last_modified;

    private Location location;

    private String low_grade;

    private String id;

    public void setSis_id(String sis_id){
        this.sis_id = sis_id;
    }
    public String getSis_id(){
        return this.sis_id;
    }
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
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    public Principal getPrincipal(){
        return this.principal;
    }
    public void setHigh_grade(String high_grade){
        this.high_grade = high_grade;
    }
    public String getHigh_grade(){
        return this.high_grade;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setSchool_number(String school_number){
        this.school_number = school_number;
    }
    public String getSchool_number(){
        return this.school_number;
    }
    public void setState_id(String state_id){
        this.state_id = state_id;
    }
    public String getState_id(){
        return this.state_id;
    }
    public void setLast_modified(String last_modified){
        this.last_modified = last_modified;
    }
    public String getLast_modified(){
        return this.last_modified;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
    public void setLow_grade(String low_grade){
        this.low_grade = low_grade;
    }
    public String getLow_grade(){
        return this.low_grade;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

}
