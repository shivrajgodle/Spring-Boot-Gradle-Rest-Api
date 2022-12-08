package com.shivraj.demo.service;

import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.courses.getCoursesForId.GetCoursesForId;
import com.shivraj.demo.payload.courses.getDistrictForCourses.GetDistrictForCourse;
import com.shivraj.demo.payload.courses.getSchoolsForCourses.GetSchoolsForCourses;
import com.shivraj.demo.payload.courses.getSectionsForCourse.GetSectionsForCourse;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;

import java.io.IOException;

public interface CourseService {

    public AllCourses getAllCourses(String Token ,Integer limit,String starting_after) throws IOException;

    public GetCoursesForId getCoursesForId(String Token ,String id) throws IOException;

    public GetDistrictForCourse getDistrictForCourse(String Token ,String id) throws IOException;

    public GetSchoolsForCourses getSchoolsForCourse(String Token , String id , Integer limit, String starting_after) throws IOException;

    public GetSectionsForCourse getSectionsForCourse(String token , String id , Integer limit, String starting_after) throws IOException;
}
