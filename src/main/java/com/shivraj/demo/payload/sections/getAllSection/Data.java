package com.shivraj.demo.payload.sections.getAllSection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private String course;

    private String created;

    private String district;

    private String grade;

    private String last_modified;

    private String name;

    private String period;

    private String school;

    private String section_number;

    private String sis_id;

    private List<String> students;

    private String subject;

    private String teacher;

    private List<String> teachers;

    private String term_id;

    private String id;

    public void setCourse(String course){
        this.course = course;
    }
    public String getCourse(){
        return this.course;
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
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setLast_modified(String last_modified){
        this.last_modified = last_modified;
    }
    public String getLast_modified(){
        return this.last_modified;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPeriod(String period){
        this.period = period;
    }
    public String getPeriod(){
        return this.period;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public String getSchool(){
        return this.school;
    }
    public void setSection_number(String section_number){
        this.section_number = section_number;
    }
    public String getSection_number(){
        return this.section_number;
    }
    public void setSis_id(String sis_id){
        this.sis_id = sis_id;
    }
    public String getSis_id(){
        return this.sis_id;
    }
    public void setStudents(List<String> students){
        this.students = students;
    }
    public List<String> getStudents(){
        return this.students;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getSubject(){
        return this.subject;
    }
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }
    public String getTeacher(){
        return this.teacher;
    }
    public void setTeachers(List<String> teachers){
        this.teachers = teachers;
    }
    public List<String> getTeachers(){
        return this.teachers;
    }
    public void setTerm_id(String term_id){
        this.term_id = term_id;
    }
    public String getTerm_id(){
        return this.term_id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

}
