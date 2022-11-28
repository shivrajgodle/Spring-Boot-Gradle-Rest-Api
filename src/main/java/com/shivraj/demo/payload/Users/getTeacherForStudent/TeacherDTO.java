package com.shivraj.demo.payload.Users.getTeacherForStudent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherDTO {

    @JsonProperty("credentials")
    private CredentialsDTO credentials;
    @JsonProperty("ext")
    private ExtDTO ext;
    @JsonProperty("school")
    private String school;
    @JsonProperty("schools")
    private List<String> schools;
    @JsonProperty("sis_id")
    private String sisId;
    @JsonProperty("state_id")
    private String stateId;
    @JsonProperty("teacher_number")
    private String teacherNumber;
    @JsonProperty("title")
    private String title;
    @JsonProperty("legacy_id")
    private String legacyId;


    public CredentialsDTO getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialsDTO credentials) {
        this.credentials = credentials;
    }

    public ExtDTO getExt() {
        return ext;
    }

    public void setExt(ExtDTO ext) {
        this.ext = ext;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    public String getSisId() {
        return sisId;
    }

    public void setSisId(String sisId) {
        this.sisId = sisId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLegacyId() {
        return legacyId;
    }

    public void setLegacyId(String legacyId) {
        this.legacyId = legacyId;
    }
}
