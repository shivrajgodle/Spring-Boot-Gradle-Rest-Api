package com.shivraj.demo.payload.getAllUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private Credentials credentials;

    private String dob;

    private List<String> enrollments;

    private String gender;

    private String grade;

    private String graduation_year;

    private String hispanic_ethnicity;

    private Location location;

    private String race;

    private String school;

    private List<String> schools;

    private String sis_id;

    private String state_id;

    private String student_number;

    private String email;

    public void setCredentials(Credentials credentials){
        this.credentials = credentials;
    }
    public Credentials getCredentials(){
        return this.credentials;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    public String getDob(){
        return this.dob;
    }
    public void setEnrollments(List<String> enrollments){
        this.enrollments = enrollments;
    }
    public List<String> getEnrollments(){
        return this.enrollments;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setGraduation_year(String graduation_year){
        this.graduation_year = graduation_year;
    }
    public String getGraduation_year(){
        return this.graduation_year;
    }
    public void setHispanic_ethnicity(String hispanic_ethnicity){
        this.hispanic_ethnicity = hispanic_ethnicity;
    }
    public String getHispanic_ethnicity(){
        return this.hispanic_ethnicity;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
    public void setRace(String race){
        this.race = race;
    }
    public String getRace(){
        return this.race;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public String getSchool(){
        return this.school;
    }
    public void setSchools(List<String> schools){
        this.schools = schools;
    }
    public List<String> getSchools(){
        return this.schools;
    }
    public void setSis_id(String sis_id){
        this.sis_id = sis_id;
    }
    public String getSis_id(){
        return this.sis_id;
    }
    public void setState_id(String state_id){
        this.state_id = state_id;
    }
    public String getState_id(){
        return this.state_id;
    }
    public void setStudent_number(String student_number){
        this.student_number = student_number;
    }
    public String getStudent_number(){
        return this.student_number;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
}
