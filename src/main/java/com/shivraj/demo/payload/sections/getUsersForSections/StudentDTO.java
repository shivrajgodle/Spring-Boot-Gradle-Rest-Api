package com.shivraj.demo.payload.sections.getUsersForSections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO {

    @JsonProperty("credentials")
    private CredentialsDTO credentials;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("enrollments")
    private List<?> enrollments;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("graduation_year")
    private String graduationYear;
    @JsonProperty("hispanic_ethnicity")
    private String hispanicEthnicity;
    @JsonProperty("location")
    private LocationDTO location;
    @JsonProperty("race")
    private String race;
    @JsonProperty("school")
    private String school;
    @JsonProperty("schools")
    private List<String> schools;
    @JsonProperty("sis_id")
    private String sisId;
    @JsonProperty("state_id")
    private String stateId;
    @JsonProperty("student_number")
    private String studentNumber;
    @JsonProperty("email")
    private String email;


    public CredentialsDTO getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialsDTO credentials) {
        this.credentials = credentials;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<?> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<?> enrollments) {
        this.enrollments = enrollments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getHispanicEthnicity() {
        return hispanicEthnicity;
    }

    public void setHispanicEthnicity(String hispanicEthnicity) {
        this.hispanicEthnicity = hispanicEthnicity;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
