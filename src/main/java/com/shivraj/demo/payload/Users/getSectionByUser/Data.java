package com.shivraj.demo.payload.Users.getSectionByUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Data {

    @JsonProperty("course")
    private String course;
    @JsonProperty("created")
    private String created;
    @JsonProperty("district")
    private String district;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("last_modified")
    private String lastModified;
    @JsonProperty("name")
    private String name;
    @JsonProperty("period")
    private String period;
    @JsonProperty("school")
    private String school;
    @JsonProperty("section_number")
    private String sectionNumber;
    @JsonProperty("sis_id")
    private String sisId;
    @JsonProperty("students")
    private List<String> students;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("teacher")
    private String teacher;
    @JsonProperty("teachers")
    private List<String> teachers;
    @JsonProperty("term_id")
    private String termId;
    @JsonProperty("id")
    private String id;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getSisId() {
        return sisId;
    }

    public void setSisId(String sisId) {
        this.sisId = sisId;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<String> teachers) {
        this.teachers = teachers;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
