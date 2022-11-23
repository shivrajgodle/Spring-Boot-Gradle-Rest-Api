package com.shivraj.demo.payload.getSectionByUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.OffsetDateTime;
import java.util.Date;


public class Data {

    private String course;
    private Date created;
    private String district;
    private String grade;
    private Date last_modified;
    private String name;
    private String period;
    private String school;
    private String section_number;
    private String sis_id;
    private String[] students;
    private String subject;
    private String teacher;
    private String[] teachers;
    private String term_id;
    private String id;

    public Data() {
        super();
    }

    public Data(String course, Date created, String district, String grade, Date last_modified, String name, String period, String school, String section_number, String sis_id, String[] students, String subject, String teacher, String[] teachers, String term_id, String id) {
        this.course = course;
        this.created = created;
        this.district = district;
        this.grade = grade;
        this.last_modified = last_modified;
        this.name = name;
        this.period = period;
        this.school = school;
        this.section_number = section_number;
        this.sis_id = sis_id;
        this.students = students;
        this.subject = subject;
        this.teacher = teacher;
        this.teachers = teachers;
        this.term_id = term_id;
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
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

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
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

    public String getSection_number() {
        return section_number;
    }

    public void setSection_number(String section_number) {
        this.section_number = section_number;
    }

    public String getSis_id() {
        return sis_id;
    }

    public void setSis_id(String sis_id) {
        this.sis_id = sis_id;
    }

    public String[] getStudents() {
        return students;
    }

    public void setStudents(String[] students) {
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

    public String[] getTeachers() {
        return teachers;
    }

    public void setTeachers(String[] teachers) {
        this.teachers = teachers;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}