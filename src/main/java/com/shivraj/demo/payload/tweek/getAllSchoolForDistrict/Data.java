package com.shivraj.demo.payload.tweek.getAllSchoolForDistrict;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private String sisId;

    private String created;

    private String district;

    private String name;

    private PrincipalDTO principal;

    private String highGrade;

    private String phone;

    private String schoolNumber;

    private String stateId;

    private String lastModified;

    private LocationDTO location;

    private String lowGrade;

    private String id;

    public String getSisId() {
        return sisId;
    }

    public void setSisId(String sisId) {
        this.sisId = sisId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrincipalDTO getPrincipal() {
        return principal;
    }

    public void setPrincipal(PrincipalDTO principal) {
        this.principal = principal;
    }

    public String getHighGrade() {
        return highGrade;
    }

    public void setHighGrade(String highGrade) {
        this.highGrade = highGrade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public String getLowGrade() {
        return lowGrade;
    }

    public void setLowGrade(String lowGrade) {
        this.lowGrade = lowGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
