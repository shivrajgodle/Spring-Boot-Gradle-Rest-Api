package com.shivraj.demo.payload.school.getSchoolById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {

    @JsonProperty("sis_id")
    private String sisId;
    @JsonProperty("created")
    private String created;
    @JsonProperty("district")
    private String district;
    @JsonProperty("name")
    private String name;
    @JsonProperty("principal")
    private PrincipalDTO principal;
    @JsonProperty("high_grade")
    private String highGrade;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("school_number")
    private String schoolNumber;
    @JsonProperty("state_id")
    private String stateId;
    @JsonProperty("last_modified")
    private String lastModified;
    @JsonProperty("location")
    private LocationDTO location;
    @JsonProperty("low_grade")
    private String lowGrade;
    @JsonProperty("id")
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
