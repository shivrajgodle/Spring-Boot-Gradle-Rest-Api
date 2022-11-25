package com.shivraj.demo.service;

import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;

import java.io.IOException;

public interface CourseService {

    public AllCourses getAllCourses(String Token) throws IOException;
}
