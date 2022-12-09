package com.shivraj.demo.payload.Users.getUserById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shivraj.demo.payload.Users.getTeacherForStudent.TeacherDTO;
import com.shivraj.demo.payload.school.getUsersBySchool.StaffDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolesDTO {
    @JsonProperty("student")
    private StudentDTO student;

    @JsonProperty("teacher")
    private TeacherDTO teacher;

    @JsonProperty("staff")
    private StaffDTO staff;

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public StaffDTO getStaff() {
        return staff;
    }

    public void setStaff(StaffDTO staff) {
        this.staff = staff;
    }
}
