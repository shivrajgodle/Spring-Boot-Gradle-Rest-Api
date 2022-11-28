package com.shivraj.demo.payload.Users.getContactUserForStudent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDTO {

    @JsonProperty("phone")
    private String phone;
    @JsonProperty("phone_type")
    private String phoneType;
    @JsonProperty("sis_id")
    private String sisId;
    @JsonProperty("student_relationships")
    private List<StudentRelationshipsDTO> studentRelationships;
    @JsonProperty("legacy_id")
    private String legacyId;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getSisId() {
        return sisId;
    }

    public void setSisId(String sisId) {
        this.sisId = sisId;
    }

    public List<StudentRelationshipsDTO> getStudentRelationships() {
        return studentRelationships;
    }

    public void setStudentRelationships(List<StudentRelationshipsDTO> studentRelationships) {
        this.studentRelationships = studentRelationships;
    }

    public String getLegacyId() {
        return legacyId;
    }

    public void setLegacyId(String legacyId) {
        this.legacyId = legacyId;
    }
}
